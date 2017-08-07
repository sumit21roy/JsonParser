import com.sargent.parser.ParserImpl;
import com.sargent.parser.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;


public class ParserImplTest {

    private static String outputFilePath = "output/userInfoOutput.json";
    private static String inputFilePath = "input/userInfo.json";
    private static String expectedOutputWithoutCommas = "Lorem ipsum dolor sit amet duo cu meis latine atomorum  an perfecto mnesarchum mel. Ad nam agam legendos  ne facilisi perpetua mel. Cu nam duis iudico pertinacia  ad alterum suscipit vel  eos te cibo mutat. Sitan alia facer efficiantur. Ex vel porro fabellas dignissim  in facer dolorem deleniti eam.";

    private BufferedReader in = null;
    InputStream stream;
    FileInputStream inputStream;
    File file;
    ParserImpl parser = new ParserImpl();
    Util singleTonObject = Util.getInstance();

    @Before
    public void setUp() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        // Getting resource(File) from class loader
        File configFile=new File(classLoader.getResource(inputFilePath).getFile());

        inputStream = new FileInputStream(configFile);
        in = new BufferedReader(new InputStreamReader(inputStream));
    }

    @After
    public void tearDown() throws IOException {
        if (in != null)
        {
            in.close();
        }

        in = null;
    }

    public InputStream createInputStream(String filePath)
    {
        return getClass().getResourceAsStream(filePath);
    }

    public String getContent(String filePath) throws IOException
    {
        return getContent("utf-8", filePath);
    }

    public String getContent(String charSet, String filePath) throws IOException
    {
        InputStreamReader reader = new InputStreamReader(createInputStream(filePath),
                Charset.forName(charSet));
        char[] tmp = new char[4096];
        StringBuilder b = new StringBuilder();
        try
        {
            while (true)
            {
                int len = reader.read(tmp);
                if (len < 0)
                {
                    break;
                }
                b.append(tmp, 0, len);
            }
            reader.close();
        }
        finally
        {
            reader.close();
        }

        return b.toString();
    }



    @Test
    public void readJsonParser() throws Exception {
        in = new BufferedReader( new InputStreamReader(getClass().getResourceAsStream(inputFilePath)));
        String line = in.readLine();

        assertThat(line, notNullValue());
    }

    @Test
    public void writeJsonParser() throws IOException {
        file = singleTonObject.getFile(inputFilePath);
        parser.readJsonParser(file);
        Assert.assertEquals(getContent(outputFilePath), parser.writeJsonParser());
    }

    @Test
    public void testReadFileOutput() throws IOException {

        file = singleTonObject.getFile(outputFilePath);
        assertTrue(file.exists());

    }

    @Test
    public void testReadFileInput() throws IOException {
        file = singleTonObject.getFile(inputFilePath);
        assertTrue(file.exists());
    }

    @Test
    public void checkOutputFileJsonIsNotNull() throws IOException {
        String line = in.readLine();

        assertThat(line, notNullValue());
    }

    @Test
    public void checkForCommasInJsonText () throws Exception {
        file = singleTonObject.getFile(inputFilePath);
        parser.readJsonParser(file);
        assertEquals(expectedOutputWithoutCommas, parser.getOutputTextJson());
    }

}