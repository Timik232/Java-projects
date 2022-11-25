package drink;

public class Address {
    private String cityName = "";
    private int zipCode = 0;
    private String streetName = "";
    private int buildingNumber = 0;
    private int apartmentNumber = 0;
    public static final Address EMPTY_ADDRESS = new Address("", 0, "", 0, 0);
    public Address(String cityName, int zipCode, String streetName, int buildingNumber, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
}
