package com.sbilorys.classes;

import com.sbilorys.interfaces.Encrypted;
import org.cactoos.Scalar;
import org.cactoos.func.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Encrypted4 implements Encrypted {
    private final IoCheckedScalar<String> text;
    public Encrypted4(final InputStream inputStream){
        this(
                () -> {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true){
                        int oneByte = inputStream.read();
                        if (oneByte<0){
                            break;
                        }
                        byteArrayOutputStream.write(oneByte);
                    }
                    return new String(byteArrayOutputStream.toByteArray());

                }
        );
    }
    Encrypted4(final String txt){
        this(()-> txt);
    }
    Encrypted4(final Scalar<String> source){
        this.text = new IoCheckedScalar<>(new SyncScalar<>(new StickyScalar<>(source)));
    }
    @Override
    public String asString() throws IOException{
        final byte[] input= this.text.value().getBytes();
        final byte[] out = new byte[input.length];
        for(int i=0;i<input.length;i++){
            out[i] = (byte)(input[i] + 1);
        }
        return new String(out);
    }
}
