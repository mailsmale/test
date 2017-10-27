package com.sbilorys.classes;

import com.sbilorys.interfaces.Encrypted;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Encrypted2 implements Encrypted {
    private final String text;
    public Encrypted2(String text){
        this.text=text;
    }
    public Encrypted2(InputStream input) throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true){
            int oneByte = input.read();
            if (oneByte<0) {
                break;
            }
            byteArrayOutputStream.write(oneByte);
        }
        this.text = new String(byteArrayOutputStream.toByteArray());
    }
    public String asString() throws IOException {
        byte[] inputByteText = text.getBytes();
        byte[] outBytesText = new byte[inputByteText.length];
        for(int i=0;i<inputByteText.length; i++) {
            outBytesText[i] = (byte)(inputByteText[i]+1);
        }
        return new String(outBytesText);
    }
}
