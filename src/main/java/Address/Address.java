package Address;

public class Address {
    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;

    public Address(String street, String streetNumber, String postalCode, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static class Builder{
        private Address address;
        public Builder() {
            address = new Address();
        }
        public Builder setStreet(String street) {
            this.address.setStreet(street);
            return this;
        }
        public Builder setStreetNumber(String streetNumber) {
            this.address.setStreetNumber(streetNumber);
            return this;


        }
        public Builder setPostalCode(String postalCode) {
            this.address.setStreetNumber(postalCode);
            return this;

        }
        public Builder setCity(String city) {
            this.address.setStreetNumber(city);
            return this;

        }
        public Address create(){
            return this.address;

        }

    }
}
