package com.imc.rps.rules;

import com.imc.rps.model.Choice;
import com.imc.rps.utils.WinningRule;

public interface RuleEngine {
  WinningRule get(Choice c);
}
