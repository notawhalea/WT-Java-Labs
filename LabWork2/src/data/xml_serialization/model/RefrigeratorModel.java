package data.xml_serialization.model;

import logic.entity.Refrigerator;

import java.util.List;

public class RefrigeratorModel extends Refrigerator {
    public RefrigeratorModel() {
        super(0.0, 0.0, 0.0, 0);
    }

    public void load(List<String> input, int offset){
        String param = input.get(offset+1);
        String res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setPrice(Double.parseDouble(res));

        param = input.get(offset+2);
        res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setMinTemperature(Double.parseDouble(res));

        param = input.get(offset+3);
        res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setMaxTemperature(Double.parseDouble(res));

        param = input.get(offset+4);
        res = param.substring(param.indexOf('>')+1, param.lastIndexOf('<'));
        setHeight(Integer.parseInt(res));
    }

    public Refrigerator toRefrigerator(){
        return new Refrigerator(price, getMinTemperature(), getMaxTemperature(), getHeight());
    }
}
