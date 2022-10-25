import java.util.*;
public class MazeRunner {
    public static void main(String[] args){
        Maze myMap = new Maze();
        intro();
        userMove();
    }
    public static void intro(){
        System.out.println("Welcome to Maze Runner!\nHere is your current position: ");
        Maze myMap = new Maze();
        myMap.printMap();
    }
    public static void userMove() {
        Maze myMap = new Maze();
        Scanner input = new Scanner(System.in);
        boolean x = !myMap.didIWin();
        int i = 1;
        while (x && i <= 100) {
            System.out.println("Where would you like to move? (R, L, U, D)");
            String where = input.next();
            if (where.equals("R") || where.equals("L") || where.equals("U") || where.equals("D")) {
                if (where.equals("R") && !myMap.canIMoveRight()) {
                    System.out.println("Sorry you've hit a wall.");
                    movesMessage(i);
                    i++;
                    continue;
                } else if (where.equals("R") && myMap.canIMoveRight()) {
                    navigatePit(where);
                    myMap.moveRight();
                    myMap.printMap();
                    movesMessage(i);
                    i++;
                    continue;
                }
                if (where.equals("L") && !myMap.canIMoveLeft()) {
                    System.out.println("Sorry you've hit a wall.");
                    movesMessage(i);
                    i++;
                    continue;
                } else if (where.equals("L") && myMap.canIMoveLeft()) {
                    navigatePit(where);
                    myMap.moveLeft();
                    myMap.printMap();
                    movesMessage(i);
                    i++;
                    continue;
                }
                if (where.equals("U") && !myMap.canIMoveUp()) {
                    System.out.println("Sorry you've hit a wall.");
                    movesMessage(i);
                    i++;
                    continue;
                } else if (where.equals("U") && myMap.canIMoveUp()) {
                    navigatePit(where);
                    myMap.moveRight();
                    myMap.printMap();
                    movesMessage(i);
                    i++;
                    continue;
                }
                if (where.equals("D") && !myMap.canIMoveDown()) {
                    System.out.println("Sorry you've hit a wall.");
                    movesMessage(i);
                    i++;
                    continue;
                } else if (where.equals("D") && myMap.canIMoveDown()) {
                    navigatePit(where);
                    myMap.moveDown();
                    myMap.printMap();
                    movesMessage(i);
                    i++;
                    continue;
                }
            } else {
                continue;
            }
        }
        if(x == true){
            System.out.println("Congratulations, you made it out alive! And you did it in " + i + " moves");
        }else{
            System.out.println("Sorry, but you didn't escape in time- you lose!");
        }
    }

    public static void movesMessage(int moves){
        if(moves == 50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        }
        else if(moves == 75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }
        else if(moves == 90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }
        else if(moves == 100){
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }
    }
    public static void navigatePit(String direction){
        Maze myMap = new Maze();
        if(myMap.isThereAPit(direction)){
            Scanner input = new Scanner(System.in);
            System.out.println("Watch out! There's a pit ahead, jump it?");
            String answer = input.next();

            if(answer.startsWith("Y")){
                myMap.jumpOverPit(direction);
            }
        }

    }
}

