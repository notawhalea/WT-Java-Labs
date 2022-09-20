package screen;

import data.xml_serialization.XMLDAO;
import logic.entity.Item;
import logic.entity.TeaPot;

public class Presenter {
    private XMLDAO xmldao = new XMLDAO();
    private Item[] items = null;

    public Item[] getItems() {
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
