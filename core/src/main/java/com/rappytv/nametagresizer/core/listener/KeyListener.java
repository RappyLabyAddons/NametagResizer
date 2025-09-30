package com.rappytv.nametagresizer.core.listener;

import com.rappytv.nametagresizer.core.NametagResizerAddon;
import com.rappytv.nametagresizer.core.NametagResizerConfig;
import com.rappytv.nametagresizer.core.NametagResizerConfig.NametagSizeConfig;
import net.labymod.api.Laby;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.input.KeyEvent;
import net.labymod.api.event.client.input.KeyEvent.State;

public class KeyListener {

  private final NametagSizeConfig config;

  public KeyListener(NametagResizerAddon addon) {
    this.config = addon.configuration().nametagSizeConfig();
  }

  @Subscribe
  public void onKey(KeyEvent event) {
    if (event.state() == State.UNPRESSED) {
      return;
    }
    if (event.key() == this.config.increaseSizeKey().get()) {
      if (this.config.nametagSize().get() < NametagResizerConfig.SIZE_MAX) {
        this.config.nametagSize().set(this.config.nametagSize().get() + 1);
        Laby.references().minecraftSounds().playButtonPress();
      }
    } else if (event.key() == this.config.decreaseSizeKey().get()) {
      if (this.config.nametagSize().get() > NametagResizerConfig.SIZE_MIN) {
        this.config.nametagSize().set(this.config.nametagSize().get() - 1);
        Laby.references().minecraftSounds().playButtonPress();
      }
    }
  }
}
