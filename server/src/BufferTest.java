import java.nio.ByteBuffer;
import java.util.Arrays;

public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        System.out.println(buffer.hasRemaining());
        buffer.putInt(12);

        byte[] b = buffer.array();
        byte[] a = Arrays.copyOf(b, b.length);
        for (int i = 0; i < b.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();

        ByteBuffer buffer1 = ByteBuffer.wrap(a);

        System.out.println(buffer1.hasRemaining());
        System.out.println(buffer1.getInt());
        System.out.println(buffer1.hasRemaining());
    }
}
