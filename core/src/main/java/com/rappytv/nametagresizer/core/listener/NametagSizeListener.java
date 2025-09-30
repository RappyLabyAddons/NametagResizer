package com.rappytv.nametagresizer.core.listener;

import com.rappytv.nametagresizer.api.event.NametagSizeEvent;
import com.rappytv.nametagresizer.core.NametagResizerAddon;
import com.rappytv.nametagresizer.core.NametagResizerConfig;
import net.labymod.api.event.Subscribe;

public class NametagSizeListener {

  private final NametagResizerConfig config;

  public NametagSizeListener(NametagResizerAddon addon) {
    this.config = addon.configuration();
  }

  @Subscribe
  public void onNametagSize(NametagSizeEvent event) {
    if(this.config.playersOnly().get() && !event.isPlayer()) {
      return;
    }
    float scaleFactor =
        0.5F + ((this.config.nametagSizeConfig().nametagSize().get() - 1) / 9.0F) * 1.5F;
    event.setX(event.getX() * scaleFactor);
    event.setY(event.getY() * scaleFactor);
    event.setZ(event.getZ() * scaleFactor);
  }

}
