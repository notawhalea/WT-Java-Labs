package data.xml_serialization;

import logic.entity.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLDAO {

    /**
     * метод поиска приборов по критериям
     * @return список приборов подходящих по заданным критериям
     */
    public Item[] load() {
        Item[] res = new Item[0];
        try {
            BufferedReader in = new BufferedReader(new FileReader("data.xml"));
            List<String> lines = new ArrayList<>();
            String next;
            while ((next=in.readLine())!=null)
                lines.add(next);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}