package com.rappytv.nametagresizer.listener;

import com.rappytv.nametagresizer.NametagResizerAddon;
import com.rappytv.nametagresizer.NametagResizerConfig;
import com.rappytv.nametagresizer.event.NametagSizeEvent;
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
    float scaleFactor = 0.5F + ((this.config.nametagSize().get() - 1) / 9.0F) * 1.5F;
    event.setX(event.getX() * scaleFactor);
    event.setY(event.getY() * scaleFactor);
    event.setZ(event.getZ() * scaleFactor);
  }

}
