package com.imc.rps.rules;

import com.imc.rps.model.Choice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoPlayerRpsRuleEngineTest {

  @Test
  public void testShouldValidateAllRulesExisits() {
    RuleEngine ruleEngine = TwoPlayerRpsRuleEngine.getInstance();
    for (Choice c : Choice.values()) {
      Assertions.assertNotNull(ruleEngine.get(c));
    }
  }

  @Test
  public void testShouldValidateCorrectRpsRules() {
    RuleEngine ruleEngine = TwoPlayerRpsRuleEngine.getInstance();

    Assertions.assertTrue(ruleEngine.get(Choice.ROCK).beats(Choice.SCISSORS));
    Assertions.assertFalse(ruleEngine.get(Choice.ROCK).beats(Choice.PAPER));
    Assertions.assertFalse(ruleEngine.get(Choice.ROCK).beats(Choice.ROCK));

    Assertions.assertTrue(ruleEngine.get(Choice.PAPER).beats(Choice.ROCK));
    Assertions.assertFalse(ruleEngine.get(Choice.PAPER).beats(Choice.SCISSORS));
    Assertions.assertFalse(ruleEngine.get(Choice.PAPER).beats(Choice.PAPER));

    Assertions.assertTrue(ruleEngine.get(Choice.SCISSORS).beats(Choice.PAPER));
    Assertions.assertFalse(ruleEngine.get(Choice.SCISSORS).beats(Choice.ROCK));
    Assertions.assertFalse(ruleEngine.get(Choice.SCISSORS).beats(Choice.SCISSORS));
  }


}
