package com.imc.rps;

import com.imc.rps.match.TwoPlayerRpsMatch;
import com.imc.rps.player.BotPlayer;
import com.imc.rps.player.HumanPlayer;
import com.imc.rps.player.Player;
import com.imc.rps.rules.TwoPlayerRpsRuleEngine;
import com.imc.rps.utils.InputOutputProvider;

import java.util.stream.IntStream;

public class RockPaperScissors {

  public static void start() {
    InputOutputProvider io = new InputOutputProvider();
    io.printWithNewLine("Welcome to the Game of (Rock/Paper/Scissors) xxxxx[;;;;;;;;;>");
    io.printWithNewLine("");

    Player humanPlayer = HumanPlayer.create(io);
    Player computerPlayer = BotPlayer.createWithName("ShaoKahn");

    TwoPlayerRpsMatch rpsMatch = TwoPlayerRpsMatch.builder()
        .firstPlayer(humanPlayer)
        .secondPlayer(computerPlayer)
        .ruleEngine(TwoPlayerRpsRuleEngine.getInstance())
        .build();

    io.printWithNewLine("");
    io.print("Enter number of rounds: ");
    Integer trials = io.getInt();

    IntStream.range(1, trials + 1).forEach(roundNumber -> {
      io.printWithNewLine("");
      io.printWithNewLine("Game #" + roundNumber + " of " + trials);
      rpsMatch.run(io);
    });
  }

}
