package xyz.bbear.leaf.im.demo;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * ByteBufDemo.
 *
 * @author xiongliu wu 2019-05-02 16:05
 */
public class ByteBufDemo {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(20,100);
        buf.writeBytes(new byte[]{'a','b','c'});
        print(buf);

        buf.readerIndex(2);
        print(buf);

        buf.writeBytes(new byte[]{'d','e','f'});
        buf.readerIndex(0);
        print(buf);
        buf.markReaderIndex();
        print(buf);
        buf.writerIndex(1);
        buf.writeBytes(new byte[]{'g','h'});
        print(buf);
        System.out.println("byte: "+buf.readByte());
        System.out.println("byte: "+buf.readByte());
        print(buf);

        buf.writeByte('w');
        buf.markWriterIndex();
        print(buf);

        buf.writeByte('x');
        buf.resetWriterIndex();
        print(buf);

    }

    private static void print(ByteBuf buf){
        if(buf == null) {
            return;
        }
        System.out.println("-------------");
        System.out.println("content:" + buf.toString(Charset.forName("utf-8")));
        System.out.println(buf.readableBytes());
        System.out.println("reader index: "+buf.readerIndex());
        System.out.println("write index: "+buf.writerIndex());
    }
}
