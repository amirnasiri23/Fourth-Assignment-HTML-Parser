import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        sortedByName.sort(Comparator.comparing(Country::getName));
        return  sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        sortedByPopulation.sort(Comparator.comparing(Country::getPopulation));
        Collections.reverse(sortedByPopulation);
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        sortedByArea.sort(Comparator.comparing(Country::getArea));
        Collections.reverse(sortedByArea);
        return sortedByArea;
    }

    public static void setUp() throws IOException {

        //Parse the HTML file using Jsoup
        File htmlFile = new File("D:/usb/ap/assignment/a4/Fourth-Assignment-HTML-Parser/src/Resources/country-list.html");
        Document document = Jsoup.parse(htmlFile, "UTF-8");

        System.out.println(document.title());

        // Extract data from the HTML
        //TODO

        // Iterate through each country div to extract country data
        //TODO
    }

    public static void main(String[] args) throws IOException {
        //you can test your code here before you run the unit tests ;)
        setUp();
    }
}
