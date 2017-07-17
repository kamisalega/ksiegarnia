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
            put("Dolnośląskie", "Dolnośląskie");
            put("Kujawsko-pomorskie", "Kujawsko-pomorskie");
            put("Lubelskie", "Lubelskie");
            put("Lubuskie", "Lubuskie");
            put("Łódzkie", "Łódzkie");
            put("Małopolskie", "Małopolskie");
            put("Mazowieckie", "Mazowieckie");
            put("Opolskie", "Opolskie");
            put("Podkarpackie", "Podkarpackie");
            put("Podlaskie", "Podlaskie");
            put("Pomorskie", "Pomorskie");
            put("Śląskie", "Śląskie");
            put("Świętokrzyskie", "Świętokrzyskie");
            put("Warmińsko-mazurskie", "Warmińsko-mazurskie");
            put("Wielkopolskie", "Wielkopolskie");
            put("Zachodniopomorskie", "Zachodniopomorskie");

        }

    };

    public final static List<String> listOfPLVoivodeshipsCode = new ArrayList<>(mapOfPLVoivodeship.keySet());
    public final static List<String> listOfPLVoivodeshipsName = new ArrayList<>(mapOfPLVoivodeship.values());


}
