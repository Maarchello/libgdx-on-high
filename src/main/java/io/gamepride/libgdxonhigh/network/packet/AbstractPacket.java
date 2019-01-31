package io.gamepride.libgdxonhigh.network.packet;

import lombok.Data;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
@Data
public abstract class AbstractPacket<I, O> {

    private int id;

    public AbstractPacket() {
        id = getPacketID();
    }

    /**
     * todo
     * @param data
     */
    public abstract void read(I data);

    public abstract O write();

    protected abstract int getPacketID();
}
