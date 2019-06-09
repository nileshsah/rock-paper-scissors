package com.imc.rps.model;

import com.imc.rps.exception.InvalidChoiceException;
import org.apache.commons.lang3.StringUtils;

public enum Choice {
  ROCK, PAPER, SCISSORS;

  public static Choice fromString(String choice) {
    if (StringUtils.equalsIgnoreCase(ROCK.name(), choice)) {
      return ROCK;
    } else if(StringUtils.equalsIgnoreCase(PAPER.name(), choice)) {
      return PAPER;
    } else if(StringUtils.equalsIgnoreCase(SCISSORS.name(), choice)) {
      return SCISSORS;
    } else {
      throw new InvalidChoiceException("The choice " + choice + " doesn't match any available choices");
    }
  }
}
