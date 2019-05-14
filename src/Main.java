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

    private static boolean checkEmpty(String[] a){
        boolean res = false;
        for (String element : a) {
            if (element.equals(" ")) {
                res = true;
                break;
            }
        }
        return  res;
    }

    private static boolean countImpossibleDifference(String[] a){
        int countX = 0;
        int countO = 0;
        for (String el: a){
            if (el.equals("X")){countX ++;}
            else if (el.equals("O")){countO ++;}
        }

        if (Math.abs(countO - countX) > 1){return true;}
        else {return false;}

    }

    private static void checkWinner(String[] a){
        boolean xwins = checkIfWins("X", a);
        boolean owins = checkIfWins("O", a);
        boolean empty = checkEmpty(a);
        boolean impossibleDiff = countImpossibleDifference(a);

        if (impossibleDiff) {
            System.out.println("Impossible");
        }
        else if (!xwins && !owins && empty){
            System.out.println("Game not finished");
        }
        else if (!xwins && !owins && !empty){
            System.out.println("Draw");
        }
        else if (xwins && !owins){
            System.out.println("X wins");
        }
        else if (!xwins && owins){
            System.out.println("O wins");
        }
        else if (xwins && owins){
            System.out.println("Impossible");
        }
    }

    private static boolean checkInput(String inp){
        boolean result = true;
        int c1 = 0;
        int c2 = 0;

        // not numbers
        try {
            c1 = Integer.parseInt(inp.split("")[0]);
            c2 = Integer.parseInt(inp.split("")[0]);

        // out of range
            if ((c1 < 1) || (c1 > 3) || (c2 < 1) || (c2 > 3)){
                result = false;
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
        catch (NumberFormatException e) {
            result = false;
            System.out.println("You should enter numbers!");
        }





        return result;
    }

    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().replace("\"", "");
        String[] gameField = userInput.split("");


        System.out.format(
                "---------\n" +
                        "| %s %s %s |\n" +
                        "| %s %s %s |\n" +
                        "| %s %s %s |\n" +
                        "---------\n", gameField);
        //checkWinner(a);

        System.out.println("Enter the coordinates: ");
        String coordinates = sc.nextLine();

        // 1.3 2.3 3.3
        // 1.2 2.2 3.2
        // 1.1 2.1 3.1

        if (checkInput(coordinates)){
            switch (coordinates){
                case "1 3":
                    gameField[0] = "X";
                    break;
                case "2 3":
                    gameField[1] = "X";
                    break;
                case "3 3":
                    gameField[2] = "X";
                    break;
                case "1 2":
                    gameField[3] = "X";
                    break;
                case "2 2":
                    gameField[4] = "X";
                    break;
                case "3 2":
                    gameField[5] = "X";
                    break;
                case "1 1":
                    gameField[6] = "X";
                    break;
                case "2 1":
                    gameField[7] = "X";
                    break;
                case "3 1":
                    gameField[8] = "X";
                    break;
            }

            System.out.format(
                    "---------\n" +
                            "| %s %s %s |\n" +
                            "| %s %s %s |\n" +
                            "| %s %s %s |\n" +
                            "---------\n", gameField);
        };

    }
}