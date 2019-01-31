package io.gamepride.libgdxonhigh.network;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public interface ConnectionProvider<T> {

    T connect(String host, int port);

    T connect(String host, int port, Object...args);

}
