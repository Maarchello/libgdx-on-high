package io.gamepride.libgdxonhigh.network.packet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marat Kadzhaev
 * @since 31.01.2019
 */
public class PacketFactory<T extends AbstractPacket> {

    private static Map<Integer, Class> PACKETS = new HashMap<>();

    static {
//        PACKETS.put(0, AuthStep1S.class);
//        PACKETS.put(1, AuthStep2S.class);
//        PACKETS.put(2, AuthCheckS.class);
    }

    public AbstractPacket get(Integer id) {
        Class<T> packetClass = PACKETS.get(id);
        try {
            T packet = packetClass.newInstance();
            packet.setId(id);
            return packet;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

}
