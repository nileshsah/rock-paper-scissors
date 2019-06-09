package com.imc.rps.match;

import com.imc.rps.model.Choice;
import com.imc.rps.player.Player;
import com.imc.rps.rules.RuleEngine;
import com.imc.rps.utils.InputOutputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TwoPlayerRpsMatchTest {

  @Mock
  private Player firstPlayer;

  @Mock
  private Player secondPlayer;

  @Mock
  private RuleEngine ruleEngine;

  @Mock
  private InputOutputProvider io;

  @Test
  public void testShouldReturnFirstPlayerAsWinnerWhenFirstPlayerWins() {
    Mockito.when(firstPlayer.getChoice()).thenReturn(Choice.ROCK);
    Mockito.when(secondPlayer.getChoice()).thenReturn(Choice.SCISSORS);

    Mockito.when(ruleEngine.get(Mockito.eq(Choice.ROCK))).thenReturn((arg) -> true);

    Optional<Player> winner = newRpsMatch().run(io);

    Assertions.assertTrue(winner.isPresent());
    Assertions.assertEquals(firstPlayer, winner.get());
  }

  @Test
  public void testShouldReturnSecondPlayerAsWinnerWhenSecondPlayerWins() {
    Mockito.when(firstPlayer.getChoice()).thenReturn(Choice.ROCK);
    Mockito.when(secondPlayer.getChoice()).thenReturn(Choice.PAPER);

    Mockito.when(ruleEngine.get(Mockito.eq(Choice.ROCK))).thenReturn((arg) -> false);
    Mockito.when(ruleEngine.get(Mockito.eq(Choice.PAPER))).thenReturn((arg) -> true);

    Optional<Player> winner = newRpsMatch().run(io);

    Assertions.assertTrue(winner.isPresent());
    Assertions.assertEquals(secondPlayer, winner.get());
  }

  @Test
  public void testShouldReturnEmptyResultOnDraw() {
    Mockito.when(firstPlayer.getChoice()).thenReturn(Choice.ROCK);
    Mockito.when(secondPlayer.getChoice()).thenReturn(Choice.ROCK);

    Mockito.when(ruleEngine.get(Mockito.eq(Choice.ROCK))).thenReturn((arg) -> false);

    Optional<Player> winner = newRpsMatch().run(io);

    Assertions.assertFalse(winner.isPresent());
  }

  private TwoPlayerRpsMatch newRpsMatch() {
    return TwoPlayerRpsMatch.builder()
        .firstPlayer(firstPlayer)
        .secondPlayer(secondPlayer)
        .ruleEngine(ruleEngine)
        .build();
  }
}
