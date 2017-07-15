package pl.salega.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kamilsalega on 14.07.2017.
 */
public class PLConstants {
    public final static String PL = "PL";

    public final static Map<String, String> mapOfPLVoivodeship = new HashMap<String, String>() {
        {
            put("D", "Dolnośląskie");
            put("C", "Kujawsko-pomorskie");
            put("L", "Lubelskie");
            put("F", "Lubuskie");
            put("E", "Łódzkie");
            put("K", "Małopolskie");
            put("M", "Mazowieckie");
            put("O", "Opolskie");
            put("R", "Podkarpackie");
            put("B", "Podlaskie");
            put("G", "Pomorskie");
            put("S", "Śląskie");
            put("T", "Świętokrzyskie");
            put("N", "Warmińsko-mazurskie");
            put("P", "Wielkopolskie");
            put("Z", "Zachodniopomorskie");

        }

    };

    public final static List<String> listOfPLVoivodeshipsCode = new ArrayList<>(mapOfPLVoivodeship.keySet());
    public final static List<String> listOfPLVoivodeshipsName = new ArrayList<>(mapOfPLVoivodeship.values());


}
