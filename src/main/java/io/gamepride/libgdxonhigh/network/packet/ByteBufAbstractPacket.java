package io.gamepride.libgdxonhigh.network.packet;

import io.netty.buffer.ByteBuf;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public abstract class ByteBufAbstractPacket extends AbstractPacket<ByteBuf, ByteBuf> {

    @Override
    public void read(ByteBuf data) {

    }

    @Override
    public ByteBuf write() {
        return null;
    }

    @Override
    protected int getPacketID() {
        return 0;
    }
}
