package com.sargent.parser;

import java.io.File;

/*
   Interface for a parser and it can be implements for other parsing logic
*/
public interface Parser {
    void readJsonParser(File file);
    String writeJsonParser();
}
