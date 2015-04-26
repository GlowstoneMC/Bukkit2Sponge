package io.github.deathcap.bukkit2sponge.plugin;

import com.google.common.io.ByteStreams;
import net.md_5.specialsource.Jar;
import net.md_5.specialsource.JarMapping;
import net.md_5.specialsource.JarRemapper;
import net.md_5.specialsource.SpecialSource;
import net.md_5.specialsource.repo.ClassRepo;
import net.md_5.specialsource.repo.JarRepo;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSigner;
import java.security.CodeSource;

public class ShinyClassLoader extends URLClassLoader {

    private JarMapping jarMapping;
    private JarRemapper jarRemapper;
    private ClassRepo classRepo;

    public ShinyClassLoader(URL[] urls, ClassLoader parent) throws IOException {
        super(urls, parent);

        this.jarMapping = new JarMapping();

        // Relocate Guava in loaded plugins to match our relocated bundled version, which is
        // guaranteed to be Guava 17 unlike the server platform's Guava (old versions are 10)
        this.jarMapping.packages.put("com/google/common", "io/github/deathcap/bukkit2sponge/libs/guava17/com/google/common");

        this.jarRemapper = new JarRemapper(this.jarMapping);

        File file = new File(urls[0].getFile());
        Jar jar = Jar.init(file);
        //this.classRepo = new NullClassRepo();
        this.classRepo = new JarRepo(jar);

        System.out.println("ShinyClassLoader init");
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass: " + name);

        String path = name.replace('.', '/').concat(".class");
        URL url = this.findResource(path);
        if (url == null) {
            throw new ClassNotFoundException("Unable to find class resource " + name + " at " + path);
        }

        InputStream stream = null;
        byte[] bytecode = null;
        try {
            stream = url.openStream();
            bytecode = ByteStreams.toByteArray(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ClassNotFoundException("Unable to open or read stream for class " + name + ": " + ex.getLocalizedMessage());
        }

        CodeSource codeSource = null;
        try {
            JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
            URL jarURL = jarURLConnection.getJarFileURL();
            codeSource = new CodeSource(jarURL, new CodeSigner[0]);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ClassNotFoundException("Unable to read code source for class " + name + ": " + ex.getLocalizedMessage());
        }

        byte[] remappedBytecode = this.jarRemapper.remapClassFile(bytecode, this.classRepo);

        Class<?> result = this.defineClass(name, remappedBytecode, 0, remappedBytecode.length, codeSource);
        if (result != null) {
            this.resolveClass(result);
        }

        return result;
    }

    private class NullClassRepo implements ClassRepo {
        @Override
        public final ClassNode findClass(String name) {
            return null;
        }
    }
}
