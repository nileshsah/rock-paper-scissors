package com.imc.rps.match;

import com.imc.rps.model.Choice;
import com.imc.rps.player.Player;
import com.imc.rps.rules.RuleEngine;
import com.imc.rps.utils.InputOutputProvider;
import lombok.Builder;

import java.util.Optional;

@Builder
public class TwoPlayerRpsMatch implements RpsMatch {

  private final Player firstPlayer;
  private final Player secondPlayer;
  private final RuleEngine ruleEngine;

  @Override
  public Optional<Player> run(InputOutputProvider io) {
    Choice firstPlayerChoice = firstPlayer.getChoice();
    Choice secondPlayerChoice = secondPlayer.getChoice();

    io.printWithNewLine(firstPlayer.getName() + " chooses " + firstPlayerChoice.name());
    io.printWithNewLine(secondPlayer.getName() + " chooses " + secondPlayerChoice.name());

    Optional<Player> roundWinner = Optional.empty();
    if (ruleEngine.get(firstPlayerChoice).beats(secondPlayerChoice)) {
      roundWinner = Optional.of(firstPlayer);
    } else if (ruleEngine.get(secondPlayerChoice).beats(firstPlayerChoice)) {
      roundWinner = Optional.of(secondPlayer);
    }

    if (roundWinner.isPresent()) {
      io.printWithNewLine("(Mortal Kombat voice) FATALITY! " + roundWinner.get().getName() + " WINS! ");
    } else {
      io.printWithNewLine("(Mario voice) It's a DRAW! ¯\\_(ツ)_/¯");
    }

    return roundWinner;
  }
}
