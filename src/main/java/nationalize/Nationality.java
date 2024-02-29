package nationalize;

import com.google.gson.annotations.SerializedName;
import java.util.List;

@lombok.Data

public class Nationality {

    private long count;
    private String name;


    @SerializedName("country")
    private List<Country> countries;

    public Nationality(long count, String name, List<Country> countries) {
        this.count = count;
        this.name = name;
        this.countries = countries;
    }

    @Override
    public String toString() {
        if(count > 0){
            StringBuilder out = new StringBuilder();
            for(Country a:countries){
                out.append(a.getCountryId()).append(" ").append(a.getProbability() * 100).append("%\n");
            }
            return out.toString();
        }else return "Not Found";
    }

    @lombok.Data
    public static class Country {

        private String countryId;
        private float probability;

        public Country(String countryId, float probability) {
            this.countryId = countryId;
            this.probability = probability;
        }

    }

}
