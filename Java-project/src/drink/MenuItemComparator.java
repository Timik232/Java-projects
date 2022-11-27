package drink;

import java.util.Comparator;

public class MenuItemComparator implements Comparator<MenuItem> {
    @Override
    public int compare(MenuItem o1, MenuItem o2) {
        return Integer.compare(o1.getCost(), o2.getCost());
    }
}

