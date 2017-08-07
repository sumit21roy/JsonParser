package com.sargent.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Utility class made as singleton to create a single instance
 */

public class Util {


    private static Util singleTonObject;

    private Util(){

    }

    /*
        Create an instance if its null otherwise it will use the existing instance
     */

    public static Util getInstance(){
        if(singleTonObject == null) {
            singleTonObject = new Util();
        }
        return singleTonObject;
    }

    /*
        Get the file path for the resource folder
     */

    public File getFile(String fileName) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = null;
        try {
            file = new File(classLoader.getResource(fileName).getFile());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(file.getAbsolutePath());
        return file;


    }

    /*
        @method : to replace all the commas from the string
     */

    public static String replaceCommaWithSpace(String scan, String regex, String replace) {
        StringBuffer sb = new StringBuffer();

        try {
            Pattern pt = Pattern.compile(regex);
            Matcher m = pt.matcher(scan);

            while (m.find()) {
                m.appendReplacement(sb, replace);
            }

            m.appendTail(sb);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return sb.toString();
        }
    }

    /*
        @method : read the config file prorperties to get the file output path
     */

    public  String readConfigFile () {
        Properties prop = new Properties();
        InputStream input = null;
        String outputPath = "";

        try {

            String filename = "config.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if(input==null){
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            outputPath =  prop.getProperty("outputFilePath");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return outputPath;
    }
}
