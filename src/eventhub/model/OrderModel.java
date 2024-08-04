package eventhub.model;

interface OrderModelInterface {
    public int getOrderId();
    public void setOrderId(int orderId);
    public int getTicketId();
    public void setTicketId(int ticketId);
    public String getFullName();
    public void setFullName(String fullName);
    public String getCountry();
    public void setCountry(String country);
    public String getCity();
    public void setCity(String city);
    public String getAddress();
    public void setAddress(String address);
    public String getZipCode();
    public void setZipCode(String zipCode);
}


public class OrderModel implements OrderModelInterface{
    private int orderId;
    private int ticketId;
    private String fullName;
    private String country;
    private String city;
    private String address;
    private String zipCode;

    public OrderModel(int orderId, int ticketId, String fullName, String country, String city, String address, String zipCode) {
        this.orderId = orderId;
        this.ticketId = ticketId;
        this.fullName = fullName;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
    }

    @Override
    public int getOrderId() {
        return orderId;
    }
    @Override
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    @Override
    public int getTicketId() {
        return ticketId;
    }
    @Override
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    @Override
    public String getFullName() {
        return fullName;
    }
    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public String getCountry() {
        return country;
    }
    @Override
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String getCity() {
        return city;
    }
    @Override
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String getZipCode() {
        return zipCode;
    }
    @Override
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
