
// based on http://svn.apache.org/viewvc/maven/plugins/tags/maven-shade-plugin-2.3/src/main/java/org/apache/maven/plugins/shade/DefaultShader.java?revision=1590870&view=markup
// and http://svn.apache.org/viewvc/maven/plugins/tags/maven-shade-plugin-2.3/src/main/java/org/apache/maven/plugins/shade/relocation/SimpleRelocator.java?revision=1590870&view=co

package io.github.deathcap.bukkit2sponge.plugin;


/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;


public class DefaultShader
{
    private RelocatorRemapper remapper;

    private final static String com_google_common = new String(new char[] {'c','o','m','/','g','o','o','g','l','e','/','c','o','m','m','o','n',});

    private final static String inPrefix = com_google_common;
    private final static String outPrefix = "io/github/deathcap/bukkit2sponge/libs/guava17/";

    public DefaultShader( List<Relocator> relocators ) throws IOException
    {
        this.remapper = new RelocatorRemapper( relocators );

    }

    public byte[] getRemappedClass( byte[] is)
            throws IOException
    {

        ClassReader cr = new ClassReader( is );

        // We don't pass the ClassReader here. This forces the ClassWriter to rebuild the constant pool.
        // Copying the original constant pool should be avoided because it would keep references
        // to the original class names. This is not a problem at runtime (because these entries in the
        // constant pool are never used), but confuses some tools such as Felix' maven-bundle-plugin
        // that use the constant pool to determine the dependencies of a class.
        ClassWriter cw = new ClassWriter( 0 );

        //final String pkg = name.substring( 0, name.lastIndexOf( '/' ) + 1 );
        ClassVisitor cv = new RemappingClassAdapter( cw, remapper )
        {
            /*
            @Override
            public void visitSource( final String source, final String debug )
            {
                if ( source == null )
                {
                    super.visitSource( source, debug );
                }
                else
                {
                    final String fqSource = pkg + source;
                    final String mappedSource = remapper.map( fqSource );
                    final String filename = mappedSource.substring( mappedSource.lastIndexOf( '/' ) + 1 );
                    super.visitSource( filename, debug );
                }
            }
            */
        };

        try
        {
            cr.accept( cv, ClassReader.EXPAND_FRAMES );
        }
        catch ( Throwable ise )
        {
            throw new RuntimeException( ise ) ;
        }

        byte[] renamedClass = cw.toByteArray();

        return renamedClass;
    }

    /**
 * @author Jason van Zyl
 */

    public class RelocatorRemapper
            extends Remapper
    {

        private final Pattern classPattern = Pattern.compile( "(\\[*)?L(.+);" );

        List<Relocator> relocators;

        public RelocatorRemapper( List<Relocator> relocators )
        {
            this.relocators = relocators;
        }

        public boolean hasRelocators()
        {
            return !relocators.isEmpty();
        }

        public Object mapValue( Object object )
        {
            if ( object instanceof String )
            {
                String name = (String) object;
                String value = name;

                String prefix = "";
                String suffix = "";

                Matcher m = classPattern.matcher( name );
                if ( m.matches() )
                {
                    prefix = m.group( 1 ) + "L";
                    suffix = ";";
                    name = m.group( 2 );
                }

                for ( Relocator r : relocators )
                {
                    if ( r.canRelocateClass( name ) )
                    {
                        value = prefix + r.relocateClass( name ) + suffix;
                        break;
                    }
                    else if ( r.canRelocatePath( name ) )
                    {
                        value = prefix + r.relocatePath( name ) + suffix;
                        break;
                    }
                }

                return value;
            }

            return super.mapValue( object );
        }


        public String map( String name )
        {
            if (name.startsWith(inPrefix)) {
                return outPrefix + name;
            } else {
                return name;
            }
        }

    }

}
