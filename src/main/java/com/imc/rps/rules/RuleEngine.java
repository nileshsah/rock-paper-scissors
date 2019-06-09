package com.imc.rps.rules;

import com.imc.rps.model.Choice;
import com.imc.rps.utils.EvaluatorRule;

public interface RuleEngine {
  EvaluatorRule get(Choice c);
}
