import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Empyreans on 22.12.2017.
 */
public class JSONParser {

    public JSONParser(String fileName){
        parseJSON(fileName);
    }

    public void parseJSON(String fileName){

        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;

            // einfache Datentypen
            String departureDate = (String) jsonObject.get("departure-date");
            String departureTime = (String) jsonObject.get("departure-time");
            String departurePoint = (String) jsonObject.get("departure-point");
            String destination = (String) jsonObject.get("destination");
            double price = (Double) jsonObject.get("price");

            // komplexer Datentyp
            JSONArray passengerList = (JSONArray) jsonObject.get("passenger");

            System.out.printf("%-19s %s %n", "Departure Date:", departureDate);
            System.out.printf("%-19s %s %n", "Departure Time:", departureTime);
            System.out.printf("%-19s %s %n", "Departure Point:", departurePoint);
            System.out.printf("%-19s %s %n", "Destination:", destination);
            System.out.printf("%-19s %.2f %s %n", "Price:", price, "€");

            for (int i = 0; i < passengerList.size(); i++){
                String passengerString = passengerList.get(i).toString();
                if (i == 0){
                    System.out.printf("%-19s %s %s %n", "Passenger(s):", extractFirstName(passengerString), extractLastName(passengerString));
                } else {
                    System.out.printf("%-19s %s %s %n", " ", extractFirstName(passengerString), extractLastName(passengerString));
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private String extractFirstName(String jsonString){
        int startIndexFirstName = jsonString.indexOf("first-name") + 13; // 13 is the number of chars away from the beginning of the array
        int endIndexFirstName = jsonString.indexOf("\"", startIndexFirstName);
        return jsonString.substring(startIndexFirstName, endIndexFirstName);
    }

    private String extractLastName(String jsonString){
        int startIndexLastName = jsonString.indexOf("last-name") + 12;
        int endIndexLastName = jsonString.indexOf("\"", startIndexLastName);
        return jsonString.substring(startIndexLastName, endIndexLastName);
    }
}

