package io.gamepride.libgdxonhigh.network.packet;

import lombok.Data;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
@Data
public abstract class AbstractPacket<ID> implements Packet<ID> {

    protected ID id;

    public AbstractPacket() {
        id = getPacketID();
    }

    protected abstract ID getPacketID();
}
