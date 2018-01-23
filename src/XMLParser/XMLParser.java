package XMLParser; /**
 * Created by Empyreans on 22.12.2017.
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XMLParser {

    public XMLParser(String fileName){
        parseXML(fileName);
    }

    public void parseXML(String fileName){
        try {
            File xmlFile = new File("aviation.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList flightList = doc.getElementsByTagName("flight");

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            System.out.println("----------------------------");

            for (int i = 0; i < flightList.getLength(); i++){
                Node node = flightList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.printf("%-19s %s%n", "Flight-ID:", element.getAttribute("flightID"));
                    System.out.printf("%-19s %s%n", "Departure Date:", element.getElementsByTagName("departure-date").item(0).getTextContent());
                    System.out.printf("%-19s %s%n", "Departure Time:", element.getElementsByTagName("departure-time").item(0).getTextContent());
                    System.out.printf("%-19s %s%n", "Departure Point:", element.getElementsByTagName("departure-point").item(0).getTextContent());
                    System.out.printf("%-19s %s%n", "Destination:", element.getElementsByTagName("destination").item(0).getTextContent());
                    System.out.printf("%-19s %s%n", "Price:", element.getElementsByTagName("price").item(0).getTextContent());
                    System.out.printf("%-19s %n", "Passenger(s):");


                    for (int j = 0; j < element.getElementsByTagName("passenger").getLength(); j++){
                        String tempFirstName = element.getElementsByTagName("passenger").item(j).getFirstChild().getNextSibling().getTextContent();
                        String tempLastName = element.getElementsByTagName("passenger").item(j).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getTextContent();
                        System.out.printf("%-19s %s %s %n", " ", tempFirstName, tempLastName);
                    }
                }
                System.out.println("\n");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
