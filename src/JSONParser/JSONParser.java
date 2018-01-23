package JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import JSONPOJO.*;

/**
 * Created by Empyreans on 22.12.2017.
 */
public class JSONParser {

    ObjectMapper mapper = new ObjectMapper();
    File file = new File("aviation.json");

    public Flight[] flights;

    public JSONParser(){
        parseJSON();
    }

    public void parseJSON(){
        try {
            flights = mapper.readValue(file, Flight[].class);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void printAllFlightData(){
        for (Flight flight: flights) {
            System.out.println(flight.getFlightDataString());
        }
    }

}

