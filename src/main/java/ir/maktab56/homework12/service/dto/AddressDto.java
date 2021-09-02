package ir.maktab56.homework12.service.dto;

public class AddressDto {
    private String phoneNumber;

    private String state;

    private String city;

    private String postalAddress;

    private String postalCode;

    public AddressDto() {

    }

    public AddressDto(String phoneNumber, String state, String city, String postalAddress, String postalCode) {
        this.phoneNumber = phoneNumber;
        this.state = state;
        this.city = city;
        this.postalAddress = postalAddress;
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
