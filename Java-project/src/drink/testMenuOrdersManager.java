package drink;

public class testMenuOrdersManager {
    public static void main(String[] args) {

        Address address = new Address("Lytkarino", 1231244, "Lenina", 1, 1);
        Customer customer = new Customer("Ivan", "Ivanov", 18, address);
        System.out.println(customer.getFirstName());
        System.out.println(customer.getAddress().getCityName());
        TableOrdersManager table = new TableOrdersManager();
        Drink drink = new Drink( 0,"water", "usual",0.0,DrinkTypeEnum.WATER);
        TableOrder tableOrder = new TableOrder();
        tableOrder.add(drink);
        tableOrder.setCustomer(customer);
        Drink alco = new Drink( 200,"rum", "usual",20.0,DrinkTypeEnum.RUM);
        tableOrder.add(alco);
        table.add(tableOrder,1);
        System.out.println(table.itemsQuantity("rum"));
        System.out.println(table.itemsQuantity("gym"));
        System.out.println(tableOrder.costTotal());
    }
}
