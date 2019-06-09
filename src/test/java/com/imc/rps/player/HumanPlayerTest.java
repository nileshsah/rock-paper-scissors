package com.imc.rps.player;

import com.imc.rps.exception.InvalidChoiceException;
import com.imc.rps.exception.InvalidPlayerNameException;
import com.imc.rps.model.Choice;
import com.imc.rps.utils.InputOutputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HumanPlayerTest {

  @Mock
  private InputOutputProvider userInteraction;

  @Test
  public void testShouldCreateHumanPlayerWithValidName() {
    Player humanPlayer = newHumanPlayerWithName("BeingHuman");
    Assertions.assertEquals("BeingHuman", humanPlayer.getName());
  }

  @Test
  public void testShouldThrowExceptionForHumanPlayerWithInvalidName() {
    Mockito.when(userInteraction.getString()).thenReturn("");
    Assertions.assertThrows(InvalidPlayerNameException.class, () -> HumanPlayer.create(userInteraction));
  }

  @Test
  public void testShouldReturnValidChoiceForValidInput() {
    Player humanPlayer = newHumanPlayerWithName("Kano");

    Mockito.when(userInteraction.getString()).thenReturn("rock");
    Assertions.assertEquals(Choice.ROCK, humanPlayer.getChoice());

    Mockito.when(userInteraction.getString()).thenReturn("Paper");
    Assertions.assertEquals(Choice.PAPER, humanPlayer.getChoice());

    Mockito.when(userInteraction.getString()).thenReturn("ScissorS");
    Assertions.assertEquals(Choice.SCISSORS, humanPlayer.getChoice());
  }

  @Test
  public void testShouldThrowExceptionForHumanPlayerWithInvalidChoice() {
    Player humanPlayer = newHumanPlayerWithName("Kano");

    Mockito.when(userInteraction.getString()).thenReturn("Xsior");
    Assertions.assertThrows(InvalidChoiceException.class, () -> humanPlayer.getChoice());
  }

  private HumanPlayer newHumanPlayerWithName(String name) {
    Mockito.when(userInteraction.getString()).thenReturn(name);
    return HumanPlayer.create(userInteraction);
  }
}
