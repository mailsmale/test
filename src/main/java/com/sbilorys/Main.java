package com.sbilorys;

import com.sbilorys.classes.*;
import com.sbilorys.interfaces.Encrypted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Main {
    public static final Logger LOG = LoggerFactory.getLogger(Main.class.getSimpleName());
    public static void main(String[] args) throws IOException {
        Encrypted encrypted1 = new Encrypted1("Hello, world!");
        LOG.info(encrypted1.asString());
        LOG.info(new Encrypted2(new FileInputStream(new File("src/main/resources/text.txt"))).asString());
        LOG.info(new Encrypted3(new FileInputStream(new File("src/main/resources/text.txt"))).asString());
        new Encrypted4(new FileInputStream(new File("src/main/resources/text.txt"))).asString();
    }
}
