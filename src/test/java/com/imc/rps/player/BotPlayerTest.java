package com.imc.rps.player;

import com.imc.rps.exception.InvalidPlayerNameException;
import com.imc.rps.model.Choice;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BotPlayerTest  {

  @Test
  public void testShouldCreateBotPlayerWithValidName() {
    Player computerBot = BotPlayer.createWithName("validBotName1");
    Assertions.assertEquals("validBotName1", computerBot.getName());
  }

  @Test
  public void testShouldThrowExceptionWhenUsingInvalidName() {
    Assertions.assertThrows(InvalidPlayerNameException.class, () -> BotPlayer.createWithName("my-bot"));
  }

  @Test
  public void testShouldThrowExceptionWhenUsingEmptyName() {
    Assertions.assertThrows(InvalidPlayerNameException.class, () -> BotPlayer.createWithName(""));
  }

  @Test
  public void testShouldThrowExceptionWhenUsingNullName() {
    Assertions.assertThrows(InvalidPlayerNameException.class, () -> BotPlayer.createWithName(null));
  }

  @Test
  public void testShouldReturnValidChoice() {
    Player computerBot = BotPlayer.create("validBotName1", 0L);
    Assertions.assertEquals(Choice.ROCK, computerBot.getChoice());
    Assertions.assertEquals(Choice.PAPER, computerBot.getChoice());
    Assertions.assertEquals(Choice.PAPER, computerBot.getChoice());
    Assertions.assertEquals(Choice.SCISSORS, computerBot.getChoice());
  }


}
