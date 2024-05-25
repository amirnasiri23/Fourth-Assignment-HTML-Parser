import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public static List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        sortedByName.sort(Comparator.comparing(Country::getName));
        return  sortedByName;
    }

    public static List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        sortedByPopulation.sort(Comparator.comparing(Country::getPopulation));
        Collections.reverse(sortedByPopulation);
        return sortedByPopulation;
    }

    public static List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        sortedByArea.sort(Comparator.comparing(Country::getArea));
        Collections.reverse(sortedByArea);
        return sortedByArea;
    }

    public static void setUp() throws IOException {

        //Parse the HTML file using Jsoup
        File htmlFile = new File("src/Resources/country-list.html");
        Document document = Jsoup.parse(htmlFile, "UTF-8");

        // Extract data from the HTML
        Elements countriesElems = document.select(".country");

        // Iterate through each country div to extract country data
        for (Element country : countriesElems) {
            String name = country.select(".country-name").text();
            String capital = country.select(".country-capital").text();
            String populationString = country.select(".country-population").text(); // must convert to int
            String areaString = country.select(".country-area").text(); // must convert to double

            int population = Integer.parseInt(populationString);
            double area = Double.parseDouble(areaString);

            Country countryObj = new Country(name, capital, population, area);
            countries.add(countryObj);
        }

    }

    public static void main(String[] args) throws IOException {
        //you can test your code here before you run the unit tests ;)
        setUp();
        List<Country> sort = sortByArea();
        for (Country country : sort) {
            System.out.println(country);
        }
    }
}
