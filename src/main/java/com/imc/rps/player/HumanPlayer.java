package com.imc.rps.player;

import com.imc.rps.model.Choice;
import com.imc.rps.utils.InputOutputProvider;

public class HumanPlayer extends Player {

  private final InputOutputProvider userInteractor;

  public static HumanPlayer create(InputOutputProvider userInteractor) {
    userInteractor.printWithNewLine("Ready Player (#One)?");
    userInteractor.print("Enter your name: ");
    String name = userInteractor.getString();
    return new HumanPlayer(name, userInteractor);
  }

  private HumanPlayer(String name, InputOutputProvider userInteractor) {
    super(name);
    this.userInteractor = userInteractor;
  }

  @Override
  public Choice getChoice() {
    userInteractor.print("Choose your move (Rock, Paper, Scissors): ");
    String userChoice = userInteractor.getString();
    return Choice.fromString(userChoice);
  }
}
