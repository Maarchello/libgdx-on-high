package io.gamepride.libgdxonhigh.network.packet;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public abstract class ReadablePacket<I, ID> extends AbstractPacket<ID> {

    public abstract void read(I input);

}
