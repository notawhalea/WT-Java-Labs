package data.xml_serialization.model;

import logic.entity.Oven;

import java.util.List;

public class OvenModel extends Oven {
    public OvenModel() {
        super(0.0, 0.0, 0.0, 0);
    }

    public void load(List<String> input, int offset){
        //todo
    }

    public Oven toOven(){
        return new Oven(price, getMaxHeatTemperature(), getMinHeatTemperature(), getRegimes());
    }
}
