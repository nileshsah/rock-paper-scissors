package com.imc.rps.rules;

import com.google.common.collect.ImmutableMap;
import com.imc.rps.exception.UndefinedRuleException;
import com.imc.rps.model.Choice;
import com.imc.rps.utils.WinningRule;

import java.util.Map;

public class TwoPlayerRpsRuleEngine implements RuleEngine{

  private final Map<Choice, WinningRule> winningRules;

  private static TwoPlayerRpsRuleEngine ruleEngine = new TwoPlayerRpsRuleEngine();

  public static TwoPlayerRpsRuleEngine getInstance() {
    return ruleEngine;
  }

  private TwoPlayerRpsRuleEngine() {
    this.winningRules = ImmutableMap.<Choice, WinningRule>of(
        Choice.ROCK, opponent -> opponent == Choice.SCISSORS,
        Choice.PAPER, opponent -> opponent == Choice.ROCK,
        Choice.SCISSORS, opponent -> opponent == Choice.PAPER
    );
  }

  @Override
  public WinningRule get(Choice choice) {
    if (!winningRules.containsKey(choice)) {
      throw new UndefinedRuleException("Undefined rule for choice " + choice.name());
    }
    return winningRules.get(choice);
  }

}
