package drink;

import java.util.Comparator;

public class MenuItemComparator implements Comparator<MenuItem> {
    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
    @Override
    public int compare(MenuItem o1, MenuItem o2) {
        return compare(o1.getCost(), o2.getCost());
    }
}

