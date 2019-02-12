package io.gamepride.libgdxonhigh.network.packet;

import lombok.Data;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
@Data
public abstract class AbstractPacket implements Packet {

    protected int id;
    protected int status;

    public AbstractPacket() {
        id = getPacketID();
    }

    protected abstract int getPacketID();
}
