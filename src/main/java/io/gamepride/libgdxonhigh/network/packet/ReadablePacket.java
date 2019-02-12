package io.gamepride.libgdxonhigh.network.packet;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public abstract class ReadablePacket<I> extends AbstractPacket {

    public abstract void read(I input);

}
