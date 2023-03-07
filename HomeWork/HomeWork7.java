package NEW.DZ;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HomeWork7 {
    // #1 - comparing strings
    // #2 - prime numbers in the range
    // #3 - show city start with 'a' like -> Atlanta,Amsterdam
    public static void main(String[] args) {
        System.out.println( compareStrings( "Hello World!", "not Hello World!" ) );
        streamAPIrandom();
        Startwith();
    }

    //  --- #1 ---
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        // --- сравниваем символы в обеих строках ---
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt( i ) != s2.charAt( i ))
                return false;
        }
        return true;
    }

    //  --- #2 ---
    public static void streamAPIrandom() {
        var random = new Random();
        int count = (int) random.ints( 100, 0, 101 )
                .filter( n -> n % 2 != 0 )
                .count();
        System.out.println( "Количество нечетных чисел: " + count );
    }

    // --- #3 ---
    public static void Startwith() {
        // -- scanner ---
        var scanner = new Scanner(System.in);
        String x = scanner.next().toUpperCase();
        char firstLetter = x.charAt(0);

        // --- filter ---
        var filteredcities = cities().stream()
                .filter(city -> city.charAt(0) == firstLetter)
                .collect( Collectors.toList());

        System.out.println(filteredcities);
    }

    // --- foo ---
    public static ArrayList<String> cities() {
        var cities = new ArrayList<String>();
        cities.add( "Amsterdam" );
        cities.add( "Atlanta " );
        cities.add( "Barcelona" );
        cities.add( "Berlin" );
        cities.add( "Birmingham" );
        cities.add( "Boston" );
        cities.add( "Brussels" );
        cities.add( "Budapest" );
        cities.add( "Chicago" );
        cities.add( "Cologne" );
        cities.add( "Copenhagen" );
        cities.add( "Dallas" );
        cities.add( "Dublin" );
        cities.add( "Frankfurt" );
        cities.add( "Hamburg" );
        cities.add( "Helsinki" );
        cities.add( "Houston" );
        cities.add( "Istanbul" );
        cities.add( "Kiev" );
        cities.add( "Lisbon" );
        cities.add( "Liverpool" );
        cities.add( "London" );
        cities.add( "Los Angeles" );
        cities.add( "Madrid" );
        cities.add( "Manchester" );
        cities.add( "Miami" );
        cities.add( "Milan" );
        cities.add( "Moscow" );
        cities.add( "Munich" );
        cities.add( "Naples" );
        cities.add( "New York City" );
        cities.add( "Oslo" );
        cities.add( "Paris" );
        cities.add( "Philadelphia" );
        cities.add( "Prague" );
        cities.add( "Rome" );
        cities.add( "Saint Petersburg" );
        cities.add( "San Francisco" );
        cities.add( "Sofia" );
        cities.add( "Stockholm" );
        cities.add( "Stuttgart" );
        cities.add( "Toulouse" );
        cities.add( "Valencia" );
        cities.add( "Vienna" );
        cities.add( "Warsaw" );
        cities.add( "Washington, D.C." );
        cities.add( "Zurich" );

        return cities ;
    }
}