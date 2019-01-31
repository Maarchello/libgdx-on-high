package io.gamepride.libgdxonhigh.network.packet;

import io.gamepride.libgdxonhigh.network.Reader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
@Data
public class PacketReader implements Reader<InputStream, AbstractPacket> {

    @Override
    public AbstractPacket read(InputStream inputStream) {
        try {
            ByteBuf bb = Unpooled.directBuffer();
            int packetLength = getPacketLength(inputStream);
            byte[] data = new byte[packetLength];

            int count = 0;
            while (count < packetLength) {
                if (inputStream.available() > 0) {
                    data[count] = (byte) inputStream.read();
                    count++;
                }
            }

            bb.writeBytes(data);

            return read(bb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private AbstractPacket read(ByteBuf data) {
        int packetID = data.readInt();
        AbstractPacket packet = null; //PacketFactory.get(packetID);
        packet.read(data);
        return packet;
    }

    private int getPacketLength(InputStream inputStream) throws IOException {
        byte[] lengthBytes = new byte[4];
        inputStream.read(lengthBytes);

        return ByteBuffer.wrap(lengthBytes).getInt();
    }

}
