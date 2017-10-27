package com.sbilorys.classes;

import com.sbilorys.interfaces.Encrypted;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Encrypted3 implements Encrypted {
    private String text;
    private final InputStream stream;
    public Encrypted3(String text){
        this.text=text;
        stream=null;
    }
    public Encrypted3(InputStream input) throws IOException{
        this.text=null;
        stream=input;
    }
    public String asString() throws IOException {
        if (null == text){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true){
                int oneByte = stream.read();
                if (oneByte<0) {
                    break;
                }
                byteArrayOutputStream.write(oneByte);
            }
            this.text = new String(byteArrayOutputStream.toByteArray());
        }
        byte[] inputByteText = text.getBytes();
        byte[] outBytesText = new byte[inputByteText.length];
        for(int i=0;i<inputByteText.length; i++) {
            outBytesText[i] = (byte)(inputByteText[i]+1);
        }
        return new String(outBytesText);
    }
}
