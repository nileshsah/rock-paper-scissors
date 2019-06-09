package com.imc.rps.player;

import com.imc.rps.exception.InvalidPlayerNameException;
import com.imc.rps.model.Choice;
import org.apache.commons.lang3.StringUtils;

public abstract class Player {
  private final String playerName;

  public abstract Choice getChoice();

  public String getName() {
    return playerName;
  }

  protected Player(String name) throws InvalidPlayerNameException {
    verifyIfNameIsValid(name);
    this.playerName = name;
  }

  private static void verifyIfNameIsValid(String name) throws InvalidPlayerNameException {
    if (StringUtils.isEmpty(name) || !StringUtils.isAlphanumeric(name)) {
      throw new InvalidPlayerNameException("Player name cannot be empty and must contain only alphanumeric characters");
    }
  }
}
