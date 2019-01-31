package io.gamepride.libgdxonhigh.network;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public interface Reader<I, O> {

    O read(I input);

}
