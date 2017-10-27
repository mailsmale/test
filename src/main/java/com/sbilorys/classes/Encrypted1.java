package com.sbilorys.classes;

import com.sbilorys.interfaces.Encrypted;

public class Encrypted1 implements Encrypted {
    private final String text;
    public Encrypted1(final String text){
        this.text=text;
    }

    public String asString(){
        final byte[] in = this.text.getBytes();
        final byte[] out = new byte[in.length];
        for(int i = 0; i < in.length; i++){
            out[i] = (byte)(in[i] + 1);
        }
        return new String(out);
    }
}
