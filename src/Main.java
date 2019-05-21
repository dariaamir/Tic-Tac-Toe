import java.util.*;

public class Main {

    private static boolean checkIfWins(String l, String[] a){
        if (((a[0].endsWith(l)) && (a[1].endsWith(l)) && (a[2].endsWith(l)))||
                ((a[3].endsWith(l)) && (a[4].endsWith(l)) && (a[5].endsWith(l)))||
                ((a[6].endsWith(l)) && (a[7].endsWith(l)) && (a[8].endsWith(l)))||
                ((a[0].endsWith(l)) && (a[3].endsWith(l)) && (a[6].endsWith(l)))||
                ((a[1].endsWith(l)) && (a[4].endsWith(l)) && (a[7].endsWith(l)))||
                ((a[2].endsWith(l)) && (a[5].endsWith(l)) && (a[8].endsWith(l)))||
                ((a[0].endsWith(l)) && (a[4].endsWith(l)) && (a[8].endsWith(l)))||
                ((a[2].endsWith(l)) && (a[4].endsWith(l)) && (a[6].endsWith(l)))
        ){
            return true;
        }
        else {return false;}
    }

    private static boolean checkInput(String inp, String [] gameField){
        boolean result = true;
        int c1 = 0;
        int c2 = 0;

        // not numbers
        try {
            String[] a = inp.split(" ");
            c1 = Integer.parseInt(a[0]);
            c2 = Integer.parseInt(a[1]);

            int intCoordinates = inputToCoordinates(inp);

        // out of range
            if ((c1 < 1) || (c1 > 3) || (c2 < 1) || (c2 > 3)){
                result = false;
                System.out.println("Coordinates should be from 1 to 3!");
            }

        // cell is occupied
            else if (! gameField[intCoordinates].equals(" ")){
                result = false;
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
        catch (NumberFormatException e) {
            result = false;
            System.out.println("You should enter numbers!");
        }
        return result;
    }

    public static int inputToCoordinates(String s) {
        switch (s) {
            case "1 3":
                return 0;
            case "2 3":
                return 1;
            case "3 3":
                return 2;
            case "1 2":
                return 3;
            case "2 2":
                return 4;
            case "3 2":
                return 5;
            case "1 1":
                return 6;
            case "2 1":
                return 7;
            case "3 1":
                return 8;
            default:
                return -1;
        }
    }

    public static String[] userMove(Scanner sc, String[] gameField){
        System.out.println("Enter the coordinates: ");
        String stringCoordinates = sc.nextLine();
        while (true){
            if (checkInput(stringCoordinates, gameField)){
                gameField[inputToCoordinates(stringCoordinates)] = "X";
                break;
            }
            else {
                System.out.println("Enter the coordinates: ");
                stringCoordinates = sc.nextLine();
            }
        }
        return gameField;
    }

    public static String[] easyComputerMove(String[] gameField){
        System.out.println("Making move level \"easy\"");
        Random r = new Random();
        while (true){
            int t = r.nextInt(9);
            if (gameField[t].equals(" ")){
                gameField[t] = "O";
                break;
            }
        }
        return gameField;
    }

    public static void printGameField (String[] gameField){
        System.out.format(
                "---------\n" +
                        "| %s %s %s |\n" +
                        "| %s %s %s |\n" +
                        "| %s %s %s |\n" +
                        "---------\n", gameField);
    }

    public static void readCommand(String command, Scanner sc){
        String[] commandArray = command.split(" ");
        if ((commandArray.length == 3) &&
                (commandArray[0].equals("start") &&
                        ((commandArray[1].equals("easy")) || (commandArray[1].equals("user"))) &&
                            ((commandArray[2].equals("easy")) || (commandArray[2].equals("user"))))) {
            startGame(sc, commandArray[1], commandArray[2]);

        }
        else {
            System.out.println("Bad parameters!");
        }
    }

    public static void startGame(Scanner sc, String user1, String user2){
        String[] gameField = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        printGameField(gameField);

        while (true) {
            userMove(sc, gameField);
            printGameField(gameField);
            if (checkIfWins("X", gameField)) {
                System.out.println("X wins");
                break;
            }
            easyComputerMove(gameField);
            printGameField(gameField);
            if (checkIfWins("O", gameField)) {
                System.out.println("O wins");
                break;
            }
        }

    }


    public static void main(String[] args) {

        System.out.print("Input command: ");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (! command.equals("exit")){
            readCommand(command, sc);
            System.out.print("Input command: ");
            command = sc.nextLine();
        }
    }


        // 1.3 2.3 3.3
        // 1.2 2.2 3.2
        // 1.1 2.1 3.1
}