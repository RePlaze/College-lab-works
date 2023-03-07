package NEW.DZ;

public class HomeWork6 {
    // OOP music tools stuff

    // ✳️ --- класс для тестирования всех методов --- ✳️
    public static void main(String[] args) {
        //  ---  Создание объектов Instrument
        Instrument guitar = new Guitar( 6 );
        Instrument drum = new Drum( 22 );
        Instrument trumpet = new Trumpet( 3 );

        //  ---  Вызов метода play() для каждого инструмента
        guitar.play();
        drum.play();
        trumpet.play();

        //  ---  Создание объектов Game ---
        var snakesAndLadders = new SnakesAndLadders();
        var counterStrike = new CounterStrike();

        //  ---  Вызов методов для игры ---
        snakesAndLadders.start();
        snakesAndLadders.rollDice();
        println( "Игра \"Snake and Ladders\" закончена: " + snakesAndLadders.end() );

        //  ---  Вызов методов для игры CounterStrike ---
        counterStrike.start();
        counterStrike.move();
        counterStrike.shoot();
        println( "Игра \"Counter Strike\" закончена: " + counterStrike.end() );
    }

    abstract static class Instrument {
        public static final String KEY = "C Major";

        public abstract void play();
    }

    // ♻️ ---  класс Guitar --- ♻️
    static class Guitar extends Instrument {
        private final int numStrings;

        public Guitar(int numStrings) {
            this.numStrings = numStrings;
        }

        public int getNumStrings() {
            return numStrings;
        }

        public void play() {
            println( "Эта гитара играет, " + numStrings + " струнами." );
        }
    }

    // ♻️ ---  класс Drum --- ♻️
    static class Drum extends Instrument {
        private final int size;

        public Drum(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void play() {
            println( "Этот барабан размером " + size + "играет." );
        }
    }

    // ♻️ ---  класс Trumpet --- ♻️
    static class Trumpet extends Instrument {
        private final int diameter;

        public Trumpet(int diameter) {
            this.diameter = diameter;
        }

        public int getDiameter() {
            return diameter;
        }

        public void play() {
            println( "Эта труба, с диаметром " + diameter + "играет." );
        }
    }

    // ♻️ ---  интерфейс Game --- ♻️
    interface Game {
        void start();

        boolean end();
    }

    // ♻️ ---  интерфейс TableGame --- ♻️
    interface TableGame extends Game {
        void rollDice();
    }

    // ♻️ ---  интерфейс ComputerGame
    interface ComputerGame extends Game {
        void shoot();

        void move();
    }

    // ♻️ ---  класс SnakesAndLadders
    static class SnakesAndLadders implements TableGame {
        public void start() {
            println( "Игра \"Snake and Ladders\" началась." );
        }

        public boolean end() {
            println( "Игра \"Snake and Ladders\" закончена." );
            return true;
        }

        public void rollDice() {
            println( "Бросили кости в игре Snakes and Ladders." );
        }
    }

    // ♻️ ---  Класс CounterStrike --- ♻️
    static class CounterStrike implements ComputerGame {
        public void start() {
            println( "Игра Counter-Strike запущена." );
        }

        public boolean end() {
            println( "Игра Counter-Strike завершена." );
            return true;
        }

        public void shoot() {
            println( "Выстрел произведен в игре Counter-Strike." );
        }

        public void move() {
            println( "Передвижение в игре Counter-Strike." );
        }
    }

    // ♻️ ---  Класс House --- ♻️
    static class House {
        public void main(String[] args) {
            //  ---  Создание массива инструментов
            Instrument[] instruments = {
                    new Guitar( 6 ),
                    new Drum( 22 ),
                    new Trumpet( 3 )
            };
            //  ---  Цикл по инструментам и вызов метода play()
            for (Instrument instrument : instruments) {
                instrument.play();
            }
            //  ---  Создание игровых объектов
            TableGame tableGame = new SnakesAndLadders();
            ComputerGame computerGame = new CounterStrike();
            // ♻️ ---  Вызов методов игры
            tableGame.start();
            tableGame.rollDice();
            println( "Игра завершена: " + tableGame.end() );
            computerGame.start();
            computerGame.move();
            computerGame.shoot();
            println( "Игра завершена: " + computerGame.end() );
        }

        public static void println(Object string) {
            System.out.println( string );
        }

        public static void print(Object string) {
            System.out.print( string );
        }
    }
}
