package NEW.DZ;

import java.util.Scanner;

import static NEW.DZ.HomeWork5.println;

public class HomeWork5 {
    public static void main(String[] args) throws CharacterCreationError {

        // ♻️ OOP game with 3 Classes of players

        // ♻️ --- CREATE A TEST PLAYER (TERMINAL) --- ♻️

        var scanner = new Scanner( System.in );
        print( "Enter the name of the character you want to create as a tester: " );
        String name = scanner.nextLine();
        try {
            new Tester( name );
            println( "Tester created successfully!" );
        } catch (CharacterCreationError e) {
            println( "Error creating tester: " + e.getMessage() );
        }
        new Tester( name );
        println( "Choose a class to create: Wizard, Archer, or Player" );
        String className = scanner.nextLine();

        Player player = null;
        switch (className) {
            case "Wizard" -> player = new Wizard( "Test", 15, 500, 600, 150 );
            case "Archer" -> player = new Archer( "Test", 15, 450, 450, 150 );
            case "Player" -> player = new Player( "Test", 10, 900, 470 );
            default -> {
                println( "Invalid class name." );
                return;
            }
        }

        // ♻️ --- AVAILABLE FUNCTIONS FOR THIS CLASS --- ♻️

        player.getinfo();

        println( "\nAvailable functions:" );
        println( "- greet" );
        println( "- damage" );

        Scanner scanner2 = new Scanner( System.in );
        print( "Enter the function you want to call: " );
        String functionName = scanner2.nextLine();

        switch (functionName) {
            case "greet" -> player.greet();
            case "damage" -> player.damage();
            default -> {
                println( "Invalid function name." );
                return;
            }
        }

        new Tester( player.getnick() );
    }

    // ♻️ --- just visual for better read and write --- ♻️
    public static void println(Object string) {
        System.out.println( string );
    }

    public static void print(Object string) {
        System.out.print( string );
    }
}

// ♻️ --- PLAYER CLASS --- ♻️
class Player {
    private final int lvl;
    private String nick;
    private final int Gold_Coins;
    private final int health;

    public Player(String nick) {
        this.nick = nick;
        this.health = 100;
        this.lvl = 1;
        this.Gold_Coins = 175;
    }

    public Player(String nick, int lvl, int Gold_Coins, int health) {
        this.lvl = lvl;
        this.nick = nick;
        this.Gold_Coins = Gold_Coins;
        this.health = health;
    }

    // ♻️ --- SETTER \ GETTER --- ♻️
    public String getnick() {
        return nick;
    }

    public void setnick(String nick) {
        this.nick = nick;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return Gold_Coins;
    }

    public int getLvl() {
        return lvl;
    }

    public void getinfo() {
        println( "\n---Info---\n" );
        println( "Class: " + getClass().getSimpleName() + "" );
        println( "Player: " + getnick() );
        println( "Level: " + getLvl() );
        println( "Health: " + getHealth() );
        println( "Gold: " + getGold() );

        // ♻️ DIFFERENT STATS FOR EACH CLASS ♻️

        if (getClass().getSimpleName().equals( "Wizard" )) {
            println( "Mana: " + damage() );
            println( "Damage: " + getLvl() * 5 );
        } else if (getClass().getSimpleName().equals( "Archer" )) {
            println( "Mana: " + getLvl() * 5 );
            println( "Damage" + damage() );
        } else if (getClass().getSimpleName().equals( "Player" )) {
            println( "Mana: " + getLvl() * 5 );
            println( "Damage: " + getHealth() / getLvl() * 2 );
        }
        println( "" );
    }


    public void greet() {
        println( "Hello! I am " + nick + " level " + lvl );
    }

    public int damage() {
        return (int) Math.ceil( health * 0.2 );
    }

    public int damage(int amount) {
        return (int) Math.ceil( amount * 0.2 );
    }
}

// ♻️ --- WIZZARD CLASS --- ♻️
class Wizard extends Player {
    private final int mana;

    public Wizard(String nick, int lvl, int Gold_Coins, int health, int mana) {
        super( nick, lvl, Gold_Coins, health );
        this.mana = mana;
    }

    @Override
    public void greet() {
        println( "Greetings! I am " + getnick() + ", a level " + getLvl() + " wizard" );
    }

    @Override
    public int damage() {
        return (int) Math.ceil( mana * 0.23 * getLvl() );
    }

}
// ♻️ --- ARCHER CLASS --- ♻️

class Archer extends Player {
    private final int shootingSkill;

    public Archer(String nick, int lvl, int Gold_Coins, int health, int shootingSkill) {
        super( nick, lvl, Gold_Coins, health );
        this.shootingSkill = shootingSkill;
    }

    @Override
    public void greet() {
        println( "Greetings! I am " + getnick() + ", a level " + getLvl() + " archer" );
    }

    @Override
    public int damage() {
        return (int) Math.ceil( shootingSkill * 0.15 * getLvl() );
    }
}

// ♻️ --- CHECK FOR TESTER --- ♻️
class Tester extends Player {
    public Tester(String nick) throws CharacterCreationError {
        super( nick );
        if (!nick.equals( "Test" )) {
            throw new CharacterCreationError( "⚠️Only the Player 'Test' can be created as a Tester⚠️" );
        }
    }
}

// EXEPCION FOR TESTER ERROR
class CharacterCreationError extends Exception {
    public CharacterCreationError(String message) {
        super( message );
    }
}
