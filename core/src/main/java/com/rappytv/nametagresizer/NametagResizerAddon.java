package com.rappytv.nametagresizer;

import com.rappytv.nametagresizer.listener.NametagSizeListener;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class NametagResizerAddon extends LabyAddon<NametagResizerConfig> {

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.registerListener(new NametagSizeListener(this));
  }

  @Override
  protected Class<? extends NametagResizerConfig> configurationClass() {
    return NametagResizerConfig.class;
  }
}
