package io.gamepride.libgdxonhigh.network.packet;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public abstract class WritablePacket<O, ID> extends AbstractPacket<ID> {

    public abstract O write();

}