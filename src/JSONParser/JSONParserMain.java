package JSONParser;


import java.io.File;

/**
 * Created by Empyreans on 22.12.2017.
 */

// mit JSON kann ich nicht durchs Markup traversieren wie beim XMLParser.XMLParser

public class JSONParserMain {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        jsonParser.printAllFlightData();
    }
}
