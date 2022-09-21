package data.xml_serialization.model;

import logic.entity.Oven;

import java.util.List;

public class OvenModel extends Oven {
    public OvenModel() {
        super(0.0, 0.0, 0.0, 0);
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
        setMaxHeatTemperature(Double.parseDouble(res));

        param = input.get(offset+3);
        res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setMinHeatTemperature(Double.parseDouble(res));

        param = input.get(offset+4);
        res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setRegimes(Integer.parseInt(res));
    }

    /**
     * @return converts model to entity
     */
    public Oven toOven(){
        return new Oven(price, getMaxHeatTemperature(), getMinHeatTemperature(), getRegimes());
    }
}
