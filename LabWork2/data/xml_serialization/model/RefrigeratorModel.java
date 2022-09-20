package data.xml_serialization.model;

import logic.entity.Oven;
import logic.entity.Refrigerator;

import java.util.List;

public class RefrigeratorModel extends Refrigerator {
    public RefrigeratorModel() {
        super(0.0, 0.0, 0.0, 0);
    }

    public void load(List<String> input, int offset){
        //todo
    }

    public Refrigerator toRefrigerator(){
        return new Refrigerator(price, getMinTemperature(), getMaxTemperature(), getHeight());
    }
}
