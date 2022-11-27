package drink;

final public class Customer {
    private String firstName;
    private String secondName;
    private int age;
    private Address address;
    static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer("", "", 30, Address.EMPTY_ADDRESS );
    static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("", "", 14, Address.EMPTY_ADDRESS);
    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
