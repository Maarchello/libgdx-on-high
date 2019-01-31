package io.gamepride.libgdxonhigh.core;

import com.badlogic.gdx.net.Socket;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public interface NetworkedRoot extends Root {

    Socket getSocket();

}
