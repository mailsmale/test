package com.sbilorys;

import com.sbilorys.classes.Encrypted1;
import com.sbilorys.interfaces.Encrypted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class Main {
    public static final Logger LOG = LoggerFactory.getLogger(Main.class.getSimpleName());
    public static void main(String[] args) throws IOException {
        Encrypted encrypted1 = new Encrypted1("Hello, world!");
        LOG.info(encrypted1.asString());
    }
}
