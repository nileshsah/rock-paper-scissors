package com.imc.rps.match;

import com.imc.rps.player.Player;
import com.imc.rps.utils.InputOutputProvider;

import java.util.Optional;

public interface RpsMatch {
  Optional<Player> run(InputOutputProvider io);
}
