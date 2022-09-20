package data.xml_serialization.model;

import logic.entity.Oven;
import logic.entity.TeaPot;

import java.util.List;

public class TeaPotModel extends TeaPot {
    public TeaPotModel() {
        super(0.0, 0.0, 0.0);
    }

    public void load(List<String> input, int offset){
        //todo
    }

    public TeaPot toTeaPot(){
        return new TeaPot(getPrice(), getCapacity(), getVoltage());
    }
}
