package JSONPOJO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "departure-date",
        "departure-time",
        "departure-point",
        "destination",
        "price",
        "passenger"
})
public class Flight {

    @JsonProperty("departure-date")
    private String departureDate;
    @JsonProperty("departure-time")
    private String departureTime;
    @JsonProperty("departure-point")
    private String departurePoint;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("passenger")
    private List<Passenger> passenger = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("departure-date")
    public String getDepartureDate() {
        return departureDate;
    }

    @JsonProperty("departure-date")
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @JsonProperty("departure-time")
    public String getDepartureTime() {
        return departureTime;
    }

    @JsonProperty("departure-time")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @JsonProperty("departure-point")
    public String getDeparturePoint() {
        return departurePoint;
    }

    @JsonProperty("departure-point")
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("passenger")
    public List<Passenger> getPassenger() {
        return passenger;
    }

    @JsonProperty("passenger")
    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getFlightDataString(){
        String result = String.format("%-19s %s %n", "Departure Date:", getDepartureDate())
                + String.format("%-19s %s %n", "Departure Time:", getDepartureTime())
                + String.format("%-19s %s %n", "Departure Point:", getDeparturePoint())
                + String.format("%-19s %s %n", "Destination :", getDestination())
                + String.format("%-19s %s %n", "Price:", getPrice());
//                + passenger.get(0).getPassengerDataString();

        for (int i = 0; i < passenger.size(); i++) {
            result = result + passenger.get(i).getPassengerDataString();
        }

        return result;
    }
}
