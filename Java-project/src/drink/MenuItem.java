package drink;

public class MenuItem {
    int cost;
    String name;
    String description;

    public MenuItem(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " со стоимостью: " + cost + " и описанием: " + description;
    }
}

