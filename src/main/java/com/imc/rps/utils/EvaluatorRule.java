package com.imc.rps.utils;

import com.imc.rps.model.Choice;

import java.util.function.Predicate;

public interface EvaluatorRule extends Predicate<Choice> {

  default boolean beats(Choice t) {
    return test(t);
  }

}
