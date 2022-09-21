package data.xml_serialization;

import data.xml_serialization.model.OvenModel;
import data.xml_serialization.model.RefrigeratorModel;
import data.xml_serialization.model.TeaPotModel;
import logic.entity.Item;
import logic.entity.Oven;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * items loaded from file
 */
public class XMLDAO {

    /**
     * @return items loaded from file
     */
    public List<Item> load() {
        List<Item> res = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("data.xml"));
            List<String> lines = new ArrayList<>();
            String next;
            while ((next=in.readLine())!=null)
                lines.add(next);

            for (int i = 0; i< lines.size(); i++)
                switch (lines.get(i).substring(0,6)) {
                    case "    <O" -> {
                        OvenModel model = new OvenModel();
                        model.load(lines, i);
                        res.add(model.toOven());
                    }
                    case "    <R" -> {
                        RefrigeratorModel model1 = new RefrigeratorModel();
                        model1.load(lines, i);
                        res.add(model1.toRefrigerator());
                    }
                    case "    <T" -> {
                        TeaPotModel model2 = new TeaPotModel();
                        model2.load(lines, i);
                        res.add(model2.toTeaPot());
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}