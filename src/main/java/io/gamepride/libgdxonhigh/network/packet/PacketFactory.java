package io.gamepride.libgdxonhigh.network.packet;

import io.gamepride.libgdxonhigh.network.annotation.PacketMeta;
import io.gamepride.libgdxonhigh.util.Assert;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public final class PacketFactory {

    private PacketFactory() {}

    private static Map<Integer, Class> PACKETS = new HashMap<>();

    public static <T> T get(Integer id, Class<T> type) {
        Assert.notNull(id);
        Assert.notNull(type);

        Class aClass = PACKETS.get(id);
        Object packet = null;
        try {
            packet = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return type.cast(packet);
    }

    public static void scanPackets(String packageName) {
        try {
            ClassLoader classLoader = PacketFactory.class.getClassLoader();

            String packagePath = packageName.replace('.', '/');
            URL urls = classLoader.getResource(packagePath);

            File folder = new File(urls.getPath());
            File[] classes = folder.listFiles();

            for (File aClass : classes) {
                int index = aClass.getName().indexOf(".");
                String className = aClass.getName().substring(0, index);
                String classNamePath = packageName + "." + className;

                Class<?> repoClass = Class.forName(classNamePath);
                PacketMeta annotation = repoClass.getAnnotation(PacketMeta.class);
                if (annotation != null) {
                    PACKETS.put(annotation.id(), repoClass);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
