package itp341.bhatia.shamit.a7.Model;

import java.io.Serializable;

public class Ticket implements Serializable{

    private String startingLocation;
    private String endingLocation;
    private String tripType;
    private String priorities;

    public Ticket(String startingLocation, String endingLocation, String tripType, String priorities) {
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.tripType = tripType;
        this.priorities = priorities;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getEndingLocation() {
        return endingLocation;
    }

    public void setEndingLocation(String endingLocation) {
        this.endingLocation = endingLocation;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getPriorities() {
        return priorities;
    }

    public void setPriorities(String priorities) {
        this.priorities = priorities;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "startingLocation='" + startingLocation + '\'' +
                ", endingLocation='" + endingLocation + '\'' +
                ", tripType='" + tripType + '\'' +
                ", priorities='" + priorities + '\'' +
                '}';
    }
}
