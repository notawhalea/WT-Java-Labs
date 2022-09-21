package screen;

import data.xml_serialization.XMLDAO;
import logic.entity.Item;
import logic.entity.TeaPot;

import java.util.List;

public class Presenter {
    private final XMLDAO xmldao = new XMLDAO();
    private List<Item> items = null;

    public List<Item> getItems() {
        if (items == null)
            items = xmldao.load();
        return items;
    }

    public double calcSum(){
        double sum = 0.0;
        for (Item x: items)
            sum += x.getPrice();
        return sum;
    }

    public int countPots(){
        int count = 0;
        for (Item x: items)
            if (x instanceof TeaPot)
                count++;
        return count;
    }
}
