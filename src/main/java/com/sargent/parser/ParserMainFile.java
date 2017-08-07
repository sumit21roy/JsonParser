package com.sargent.parser;

import java.io.File;

/*
    Main to execute method for  parse and write json file
 */

public class ParserMainFile {
    public static String inputFilePath = "input/userInfo.json";

    public static void main (String args[]) {
        Util singletonObject = Util.getInstance();
        File file = singletonObject.getFile(inputFilePath);
        Parser parser = new ParserImpl();
        parser.readJsonParser(file);
        parser.writeJsonParser();
    }
}
