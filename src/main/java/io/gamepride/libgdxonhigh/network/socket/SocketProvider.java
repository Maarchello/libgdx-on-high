package io.gamepride.libgdxonhigh.network.socket;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import io.gamepride.libgdxonhigh.network.ConnectionProvider;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public class SocketProvider implements ConnectionProvider<Socket> {

    private final Protocol protocol;
    private Socket socket;

    public SocketProvider(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public Socket connect(String host, int port) {
        return connect(host, port, new SocketHints());
    }

    @Override
    public Socket connect(String host, int port, Object... args) {
        if (socket == null) {
            socket = Gdx.net.newClientSocket(protocol, host, port, (SocketHints) args[0]);
        }
        return null;
    }
}
