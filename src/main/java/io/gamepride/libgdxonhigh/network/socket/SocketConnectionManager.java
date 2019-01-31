package io.gamepride.libgdxonhigh.network.socket;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import io.gamepride.libgdxonhigh.network.ConnectionManager;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public class SocketConnectionManager implements ConnectionManager<Socket> {

    // TCP by default
    private final Protocol protocol;
    private Socket socket;

    public SocketConnectionManager() {
        this(Protocol.TCP);
    }

    public SocketConnectionManager(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public Socket connect(String host, int port) {
        return connect(host, port, new SocketHints());
    }

    @Override
    public Socket connect(String host, int port, Object... args) {
        SocketHints socketHints = getSocketHints(args);
        if (socket == null) {
            socket = Gdx.net.newClientSocket(protocol, host, port, socketHints);
        } else {
            socket.dispose();
            socket = Gdx.net.newClientSocket(protocol, host, port, socketHints);
        }

        return socket;
    }

    @Override
    public void disconnect() {
        socket.dispose();
    }

    @Override
    public Socket getConnection() {
        return socket;
    }

    private SocketHints getSocketHints(Object...args) {
        SocketHints socketHints;
        if (args[0] == null) {
            socketHints = new SocketHints();
        } else {
            socketHints = (SocketHints) args[0];
        }

        return socketHints;
    }
}
