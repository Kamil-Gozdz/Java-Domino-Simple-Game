package domino;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        System.out.println("  -----------------                            -------------------");
        System.out.println("  |       |       |                            |  *  *  |  *  *  |");
        System.out.println("  |   *   |   *   |     **DOMINO GAME**        |  *  *  |  *  *  |");
        System.out.println("  |       |       |                            |  *  *  |  *  *  |");
        System.out.println("  -----------------                            -------------------");

        String board = "";
        GameFunctions gf = new GameFunctions();
        System.out.println("Generating bricks...");
        List<String> symbols = gf.symbolGenerator();
        System.out.println("Shuffle bricks...");
        gf.shuffleSymbols(symbols);
        ArrayList<String> bricksForPlayerOne = gf.dealBricksForPlayerOne(symbols);
        ArrayList<String> bricksForPlayerTwo = gf.dealBricksForPlayerTwo(symbols);
        while ((bricksForPlayerOne.size() != 0 && bricksForPlayerTwo.size() != 0) || symbols.size() != 0) {
            if (!gf.choosingActionPlayerOne(symbols, bricksForPlayerOne)) {
                String chosenBrickFromPlayerOne = gf.chooseBrickForPlayerOne(bricksForPlayerOne);
                board = gf.addingPlayerOneBrickToBoard(board, chosenBrickFromPlayerOne);
            }
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(board);
            System.out.println("-----------------------------------------------------------------------");
            if (!gf.choosingActionPlayerTwo(symbols, bricksForPlayerTwo)) {
                String chosenBrickFromPlayerTwo = gf.chooseBrickForPlayerTwo(bricksForPlayerTwo);
                board = gf.addingPlayerTwoBrickToBoard(board, chosenBrickFromPlayerTwo);
            }
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(board);
            System.out.println("-----------------------------------------------------------------------");
        }
        if (bricksForPlayerOne.size() == bricksForPlayerTwo.size()) {
            System.out.println("It's a tie!");
        } else if (bricksForPlayerOne.size() > bricksForPlayerTwo.size()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
        if(bricksForPlayerOne.size() == 0 && bricksForPlayerTwo.size() != 0){
            System.out.println("Player 1 wins!");
        }else{
            System.out.println("Player 2 wins!");
        }
    }
}
