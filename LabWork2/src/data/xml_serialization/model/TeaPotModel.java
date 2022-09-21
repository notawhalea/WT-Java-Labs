package data.xml_serialization.model;

import logic.entity.TeaPot;

import java.util.List;

public class TeaPotModel extends TeaPot {
    public TeaPotModel() {
        super(0.0, 0.0, 0.0);
    }

    /**
     * @param input it's  a list with loaded strings
     * @param offset represents the first line of current object data
     */
    public void load(List<String> input, int offset){
        String param = input.get(offset+1);
        String res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setPrice(Double.parseDouble(res));

        param = input.get(offset+2);
        res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setCapacity(Double.parseDouble(res));

        param = input.get(offset+3);
        res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setVoltage(Double.parseDouble(res));
    }

    /**
     * @return converts model to entity
     */
    public TeaPot toTeaPot(){
        return new TeaPot(getPrice(), getCapacity(), getVoltage());
    }
}
