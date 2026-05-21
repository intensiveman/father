package com.example.user.test;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String text = "This is a sentence. image.xml. Another one. photo.png. End.";
        String[] sentences = text.split("(?<!\\.(?:xml|png|pdf)\\b)(?<=[.!?;。；])\\s+");
        for (String sentence : sentences) {
            System.out.println("sentence = " + sentence);
        }
    }
}
