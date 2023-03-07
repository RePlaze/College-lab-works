package NEW.DZ;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HomeWork4 {

/*
 * Task number 1
 * You have a list stringList whose elements are strings.
 * It is necessary to write a correctedList() method that will create and return a new list,
 * containing all strings that do not contain uppercase letters (Capital).
 */

    /**
     * Task number 2
     * Ivana sorts her shopping cart in the store.
     * It is necessary to write the magSort() method, which will remove from the basket all products whose weight is more than 300.
     */

    public static void main(String[] args) {
        testFirstTask();
        testSecondTask();
    }

    public static List<String> correctedList(List<String> stringList) {
        return stringList.stream()
                .filter( s -> s.equals( s.toLowerCase() ) )
                .toList();
    }

    public static HashMap<String, Integer> magSort(HashMap<String, Integer> shopCart) {
        shopCart.entrySet().removeIf( entry -> entry.getValue() > 300 );
        return shopCart;
    }

    public static final List<String> STRING_LIST = Arrays.asList(
            "Onee",
            "tWo",
            "list",
            "windoWWW",
            "user authorization was successful",
            "this is A complex strUcture",
            "and who are the judges",
            "The ArrayList class supports dynamic arrays",
            "the arraylist class inherits from the abstractList class"
    );
    public static final List<String> STRING_LIST_CORRECT = Arrays.asList(
            "list",
            "user authorization was successful",
            "and who are the judges"
    );

    public static final HashMap<String, Integer> HASH_MAP = new HashMap<>();

    public static HashMap<String, Integer> setMagazine() {
        HASH_MAP.put( "яблоки", 300 );
        HASH_MAP.put( "груши", 456 );
        HASH_MAP.put( "лук", 80 );
        HASH_MAP.put( "свекла", 650 );
        HASH_MAP.put( "картошка", 1020 );
        HASH_MAP.put( "чеснок", 10 );
        HASH_MAP.put( "ягоды", 230 );
        return (HASH_MAP);
    }

    public static HashMap<String, Integer> HASH_MAP_CHECK = new HashMap<>();

    public static HashMap<String, Integer> setlungsCheck() {
        HASH_MAP_CHECK.put( "яблоки", 300 );
        HASH_MAP_CHECK.put( "лук", 80 );
        HASH_MAP_CHECK.put( "чеснок", 10 );
        HASH_MAP_CHECK.put( "ягоды", 230 );
        return (HASH_MAP_CHECK);
    }

    public static void testFirstTask() {
        System.out.println( "\nTests for correctedList()" );
        AntiCheat.run();
        printTestCase( 1, STRING_LIST_CORRECT.toString(), correctedList( STRING_LIST ).toString(), 60 );
    }

    public static void testSecondTask() {
        System.out.println( "\nTests for magSort()" );
        AntiCheat.run();
        printTestCase( 1, setlungsCheck().toString(), magSort( setMagazine() ).toString(), 40 );
    }

    public static class AntiCheat {
        public static void run() {
            List<String> antiCheatList = new ArrayList<>();
            antiCheatList.addAll( STRING_LIST );
            antiCheatList.addAll( STRING_LIST_CORRECT );
            antiCheatList.addAll( HomeWork4.setMagazine().keySet().stream().map( Object::toString ).toList() );
            antiCheatList.addAll( HomeWork4.setlungsCheck().values().stream().map( Object::toString ).toList() );
            antiCheatList.add( "" );
            calcHash( antiCheatList );
        }

        public static String bytesToHex(byte[] bytes) {
            char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
            char[] hexChars = new char[bytes.length * 2];
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = HEX_ARRAY[v >>> 4];
                hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
            }
            return new String( hexChars );
        }

        public static void calcHash(List<String> list) {
            String total = String.join( "", list );
            try {
                MessageDigest md = MessageDigest.getInstance( "MD5" );
                md.update( total.getBytes() );
                byte[] digest = md.digest();
                System.out.println( "AntiCheatCheck: " + bytesToHex( digest ) );
            } catch (NoSuchAlgorithmException ignored) {
            }
        }
    }

    public static String constLen(String str, int len) {
        StringBuilder sb = new StringBuilder( str );
        while (len-- - str.length() > 0) sb.append( " " );
        return sb.toString();
    }

    public static void printTestCase(int n, String exp, String act, int minLen) {
        Function<String, String> green = str -> "\u001B[34m" + str + "\u001B[0m";
        Function<String, String> yellow = str -> "\u001B[33m" + str + "\u001B[0m";
        System.out.println( "TEST CASE " + constLen( String.valueOf( n ), 4 ) );
        System.out.println( "Ожидание: " + yellow.apply( constLen( exp, minLen ) ) + "\nРеальность: " + green.apply( constLen( act, minLen ) ) );
        if (Objects.equals( exp, act )) {
            System.out.print( "TEST RESULT: ✅" );
        } else {
            System.out.print( "TEST RESULT: ❌" );
        }
        System.out.println();
    }
}
