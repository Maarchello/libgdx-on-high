package io.gamepride.libgdxonhigh.network.packet;

/**
 * @author Marat Kadzhaev
 * @since 01.02.2019
 */
public interface IPacket<I, O, ID> {

    ID getId();

    void read(I input);

    O write();

}
