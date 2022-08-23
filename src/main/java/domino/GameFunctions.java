package domino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameFunctions implements DominoService {

    Brick brick = new Brick();

    @Override
    public List<String> symbolGenerator() {
        List<String> symbols = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                brick.setSymbol("|" + i + "|" + j + "|");
                symbols.add(brick.getSymbol());
            }
        }
        return symbols;
    }

    @Override
    public void shuffleSymbols(List<String> symbols) {
        Collections.shuffle(symbols);
    }

    @Override
    public ArrayList<String> dealBricksForPlayerOne(List<String> symbols) {
        ArrayList<String> bricksForPlayerOne = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            bricksForPlayerOne.add(symbols.remove(i));
        }
        return bricksForPlayerOne;
    }

    @Override
    public ArrayList<String> dealBricksForPlayerTwo(List<String> symbols) {
        ArrayList<String> bricksForPlayerTwo = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            bricksForPlayerTwo.add(symbols.remove(i));
        }
        return bricksForPlayerTwo;
    }

    @Override
    public String chooseBrickForPlayerOne(ArrayList<String> bricksForPlayerOne) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 choose brick by typing number: ");
        System.out.println(bricksForPlayerOne);
        int index = scanner.nextInt();
        System.out.println("Player 1 choose " + bricksForPlayerOne.get(index));
        return bricksForPlayerOne.remove(index);

    }

    @Override
    public String chooseBrickForPlayerTwo(ArrayList<String> bricksForPlayerTwo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 choose brick by typing number: ");
        System.out.println(bricksForPlayerTwo);
        int index = scanner.nextInt();
        System.out.println("Player 1 choose " + bricksForPlayerTwo.get(index));
        return bricksForPlayerTwo.remove(index);
    }

    @Override
    public String addingPlayerOneBrickToBoard(String chosenBrickFromPlayerOne, String board) {
        int lastPosition = board.length() - 2;
        if (board.isBlank()) {
            System.out.println("Added " + chosenBrickFromPlayerOne + " to the board");
            return board + chosenBrickFromPlayerOne;
        }
        boolean brickMatcherZero = chosenBrickFromPlayerOne.charAt(1) == chosenBrickFromPlayerOne.charAt(3);
        boolean brickMatcherOne = chosenBrickFromPlayerOne.charAt(1) == board.charAt(1);
        boolean brickMatcherTwo = chosenBrickFromPlayerOne.charAt(3) == board.charAt(lastPosition);
        boolean brickMatcherThree = chosenBrickFromPlayerOne.charAt(1) == board.charAt(lastPosition);
        boolean brickMatcherFour = chosenBrickFromPlayerOne.charAt(3) == board.charAt(1);
        boolean brickMatcherFlipOne = flipSymbolsPlayerOne(chosenBrickFromPlayerOne).charAt(3) == board.charAt(1);
        boolean brickMatcherFlipTwo = flipSymbolsPlayerOne(chosenBrickFromPlayerOne).charAt(1) == board.charAt(lastPosition);
        if (brickMatcherZero) {
            if (brickMatcherOne) {
                System.out.println("Added " + chosenBrickFromPlayerOne + " to the board");
                return chosenBrickFromPlayerOne + board;
            } else if (brickMatcherThree) {
                System.out.println("Added " + chosenBrickFromPlayerOne + " to the board");
                return board + chosenBrickFromPlayerOne;
            }
        }
        if (brickMatcherOne || brickMatcherTwo) {
            System.out.println("Added " + chosenBrickFromPlayerOne + " to the board");
            String flippedSymbolPlayerOne = flipSymbolsPlayerOne(chosenBrickFromPlayerOne);
            if (brickMatcherFlipOne) {
                System.out.println("Added " + chosenBrickFromPlayerOne + " to the board");
                return flippedSymbolPlayerOne + board;
            } else if (brickMatcherFlipTwo) {
                System.out.println("Added " + chosenBrickFromPlayerOne + " to the board");
                return board + flippedSymbolPlayerOne;
            }
        }
        if (brickMatcherThree) {
            System.out.println("Added " + chosenBrickFromPlayerOne + " to the board");
            return board + chosenBrickFromPlayerOne;
        }
        if (brickMatcherFour) {
            System.out.println("Added " + chosenBrickFromPlayerOne + " to the board");
            return chosenBrickFromPlayerOne + board;
        }
        return board;
    }

    @Override
    public String addingPlayerTwoBrickToBoard(String chosenBrickFromPlayerTwo, String board) {
        int lastPosition = board.length() - 2;
        if (board.isBlank()) {
            System.out.println("Added " + chosenBrickFromPlayerTwo + " to the board");
            return board + chosenBrickFromPlayerTwo;
        }
        boolean brickMatcherZero = chosenBrickFromPlayerTwo.charAt(1) == chosenBrickFromPlayerTwo.charAt(3);
        boolean brickMatcherOne = chosenBrickFromPlayerTwo.charAt(1) == board.charAt(1);
        boolean brickMatcherTwo = chosenBrickFromPlayerTwo.charAt(3) == board.charAt(lastPosition);
        boolean brickMatcherThree = chosenBrickFromPlayerTwo.charAt(1) == board.charAt(lastPosition);
        boolean brickMatcherFour = chosenBrickFromPlayerTwo.charAt(3) == board.charAt(1);
        boolean brickMatcherFlipOne = flipSymbolsPlayerTwo(chosenBrickFromPlayerTwo).charAt(3) == board.charAt(1);
        boolean brickMatcherFlipTwo = flipSymbolsPlayerTwo(chosenBrickFromPlayerTwo).charAt(1) == board.charAt(lastPosition);
        if (brickMatcherZero) {
            if (brickMatcherOne) {
                System.out.println("Added " + chosenBrickFromPlayerTwo + " to the board");
                return chosenBrickFromPlayerTwo + board;
            } else if (brickMatcherThree) {
                System.out.println("Added " + chosenBrickFromPlayerTwo + " to the board");
                return board + chosenBrickFromPlayerTwo;
            }
        }
        if (brickMatcherOne || brickMatcherTwo) {
            System.out.println("Added " + chosenBrickFromPlayerTwo + " to the board");
            String flippedSymbolPlayerTwo = flipSymbolsPlayerTwo(chosenBrickFromPlayerTwo);
            if (brickMatcherFlipOne) {
                System.out.println("Added " + chosenBrickFromPlayerTwo + " to the board");
                return flippedSymbolPlayerTwo + board;
            } else if (brickMatcherFlipTwo) {
                System.out.println("Added " + chosenBrickFromPlayerTwo + " to the board");
                return board + flippedSymbolPlayerTwo;
            }
        }
        if (brickMatcherThree) {
            System.out.println("Added " + chosenBrickFromPlayerTwo + " to the board");
            return board + chosenBrickFromPlayerTwo;
        }
        if (brickMatcherFour) {
            System.out.println("Added " + chosenBrickFromPlayerTwo + " to the board");
            return chosenBrickFromPlayerTwo + board;
        }
        return board;
    }

    @Override
    public String flipSymbolsPlayerOne(String chosenBrickFromPlayerOne) {
        StringBuilder sb = new StringBuilder();
        sb.setCharAt(1, chosenBrickFromPlayerOne.charAt(3));
        sb.setCharAt(3, chosenBrickFromPlayerOne.charAt(1));
        return sb.toString();

    }

    @Override
    public String flipSymbolsPlayerTwo(String chosenBrickFromPlayerTwo) {
        StringBuilder sb = new StringBuilder();
        sb.setCharAt(1, chosenBrickFromPlayerTwo.charAt(3));
        sb.setCharAt(3, chosenBrickFromPlayerTwo.charAt(1));
        return sb.toString();
    }

    @Override
    public void getBrickForPlayerOneFromStack(List<String> symbols, ArrayList<String> bricksForPlayerOne) {
        if (symbols.isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("Getting new brick");
            bricksForPlayerOne.add(symbols.remove(0));
        }
    }

    @Override
    public void getBrickForPlayerTwoFromStack(List<String> symbols, ArrayList<String> bricksForPlayerTwo) {
        if (symbols.isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("Getting new brick");
            bricksForPlayerTwo.add(symbols.remove(0));
        }
    }

    @Override
    public boolean choosingActionPlayerOne(List<String> symbols, ArrayList<String> brickForPlayerOne) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println(brickForPlayerOne);
            System.out.println("Press [y] for get brick or [n] for continue: ");
            choice = scanner.next();
            switch (choice) {
                case "y":
                    getBrickForPlayerOneFromStack(symbols, brickForPlayerOne);
                    System.out.println(brickForPlayerOne);
                    return true;
                case "n":
                    break;
                default:
                    System.out.println("Please choose correct letter");
            }

        } while (!choice.equals("y") && !choice.equals("n"));
        return false;
    }

    @Override
    public boolean choosingActionPlayerTwo(List<String> symbols, ArrayList<String> brickForPlayerTwo) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println(brickForPlayerTwo);
            System.out.println("Press [y] for get brick or [n] for continue: ");
            choice = scanner.next();
            switch (choice) {
                case "y":
                    getBrickForPlayerTwoFromStack(symbols, brickForPlayerTwo);
                    System.out.println(brickForPlayerTwo);
                    return true;
                case "n":
                    break;
                default:
                    System.out.println("Please choose correct letter");
            }

        } while (!choice.equals("y") && !choice.equals("n"));
        return false;
    }
}
