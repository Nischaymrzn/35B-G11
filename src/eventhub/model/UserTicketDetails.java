package eventhub.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class UserTicketDetails {

    private int userId;
    private String fullName;
    private String email;
    private String city;
    private String country;
    private String address;
    private int numberOfTickets;
    private double totalAmount;
    private String eventName;
    private int eventId;
    private int organizerId; // New field for organizer ID

    // Constructors
    public UserTicketDetails() {}

    public UserTicketDetails(int userId, String fullName, String email, String city, 
                             String country, String address, int numberOfTickets, 
                             double totalAmount, String eventName, int eventId, int organizerId) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.city = city;
        this.country = country;
        this.address = address;
        this.numberOfTickets = numberOfTickets;
        this.totalAmount = totalAmount;
        this.eventName = eventName;
        this.eventId = eventId;
        this.organizerId = organizerId; // Initialize organizer ID
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getNumberOfTickets() { return numberOfTickets; }
    public void setNumberOfTickets(int numberOfTickets) { this.numberOfTickets = numberOfTickets; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    public int getOrganizerId() { return organizerId; }
    public void setOrganizerId(int organizerId) { this.organizerId = organizerId; }
}


