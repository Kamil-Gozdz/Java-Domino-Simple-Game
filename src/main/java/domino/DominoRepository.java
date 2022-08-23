package domino;

import java.util.ArrayList;
import java.util.List;

public interface DominoRepository {

    List<String> symbolGenerator();

    void shuffleSymbols(List<String> symbols);

    ArrayList<String> dealBricksForPlayerOne(List<String> symbols);

    ArrayList<String> dealBricksForPlayerTwo(List<String> symbols);

    String chooseBrickForPlayerOne(ArrayList<String> bricksForPlayerOne);

    String chooseBrickForPlayerTwo(ArrayList<String> bricksForPlayerTwo);

    String addingPlayerOneBrickToBoard(String chosenBrickFromPlayerOne, String board);

    String addingPlayerTwoBrickToBoard(String chosenBrickFromPlayerTwo, String board);

    String flipSymbolsPlayerOne(String chosenBrickFromPlayerOne);

    String flipSymbolsPlayerTwo(String chosenBrickFromPlayerTwo);

    void getBrickForPlayerOneFromStack(List<String> symbols, ArrayList<String> bricksForPlayerOne);

    void getBrickForPlayerTwoFromStack(List<String> symbols, ArrayList<String> bricksForPlayerTwo);

    boolean choosingActionPlayerOne(List<String> symbols, ArrayList<String> brickForPlayerOne);

    boolean choosingActionPlayerTwo(List<String> symbols, ArrayList<String> brickForPlayerTwo);
}
