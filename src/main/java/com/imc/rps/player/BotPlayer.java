package com.imc.rps.player;

import com.imc.rps.model.Choice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BotPlayer extends Player {

  private static final List<Choice> choices = Collections.unmodifiableList(Arrays.asList(Choice.values()));

  private final Random randomNumberGenerator;

  public static BotPlayer createWithName(String name) {
    return create(name, Long.valueOf(LocalDateTime.now().getNano()));
  }

  public static BotPlayer create(String name, Long seed) {
    return new BotPlayer(name, seed);
  }

  @Override
  public Choice getChoice() {
    return choices.get(randomNumberGenerator.nextInt(choices.size()));
  }

  private BotPlayer(String playerName, Long seed) {
    super(playerName);
    this.randomNumberGenerator = new Random(seed);
  }
}
