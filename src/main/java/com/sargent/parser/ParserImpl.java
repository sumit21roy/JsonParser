package com.sargent.parser;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ParserImpl implements Parser {


    private static String jsonInString = "";

    public static String outputTextJson;
    UserDetailModel userDetailModel = new UserDetailModel();
    Util singleTonObject = Util.getInstance();


    /*
        @method: read the input json parser and set the values to the model
     */
    public  void readJsonParser(File file) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(file));

            JSONObject jsonObject = (JSONObject) obj;

            userDetailModel.setId((Long) jsonObject.get("id"));
            userDetailModel.setName((String) jsonObject.get("name"));

            userDetailModel.setLocation((String)jsonObject.get("location"));

            userDetailModel.setText((String) jsonObject.get("text"));

            if(userDetailModel.getText() != null && userDetailModel.getText() != "") {
                outputTextJson = Util.replaceCommaWithSpace(userDetailModel.getText(), ",", " ");
                userDetailModel.setModifiedText(outputTextJson);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*
        @method : create a file based on the value assigned in the properties file and
        write the parsed json into the file as an output.
     */

    public String writeJsonParser () {
        JsonFactory jsonFactory = new JsonFactory();
        FileOutputStream file = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonInString = mapper.writeValueAsString(userDetailModel);
            file = new FileOutputStream(new File(singleTonObject.readConfigFile()));
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetailModel);
            JsonGenerator jsonGen = jsonFactory.createJsonGenerator(file, JsonEncoding.UTF8);
            jsonGen.setCodec(new ObjectMapper());
            jsonGen.setPrettyPrinter(new DefaultPrettyPrinter());
            jsonGen.writeObject(userDetailModel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
        System.out.println("File Created");
        return jsonInString;
    }

    public String getOutputTextJson() {
        return outputTextJson;
    }
}

