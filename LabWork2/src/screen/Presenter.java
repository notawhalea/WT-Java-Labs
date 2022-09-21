package screen;

import data.xml_serialization.XMLDAO;
import logic.entity.Item;
import logic.entity.TeaPot;

import java.util.List;

/**
 * manages current app state
 */
public class Presenter {
    private final XMLDAO xmldao = new XMLDAO();
    private List<Item> items = null;

    /**
     * @return list of items
     */
    public List<Item> getItems() {
        if (items == null)
            items = xmldao.load();
        return items;
    }

    /**
     * @return sum of elements
     */
    public double calcSum(){
        double sum = 0.0;
        for (Item x: items)
            sum += x.getPrice();
        return sum;
    }

    /**
     * @return counts
     */
    public int countPots(){
        int count = 0;
        for (Item x: items)
            if (x instanceof TeaPot)
                count++;
        return count;
    }
}
