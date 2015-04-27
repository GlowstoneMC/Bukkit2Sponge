
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


    public DefaultShader( String inPrefix, String outPrefix) throws IOException
    {
        this.remapper = new RelocatorRemapper(inPrefix, outPrefix);

    }

    public byte[] getRemappedClass( byte[] is)
            throws IOException
    {

        ClassReader cr = new ClassReader( is );
        ClassWriter cw = new ClassWriter( cr, 0 );

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
        private final String inPrefix;
        private final String outPrefix;

        public RelocatorRemapper(String inPrefix, String outPrefix)
        {
            this.inPrefix = inPrefix;
            this.outPrefix = outPrefix;
        }

        @Override
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

                value = map( name );

                return value;
            }

            return super.mapValue( object );
        }

        @Override
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

