package com.rappytv.nametagresizer.core;

import com.rappytv.nametagresizer.core.listener.KeyListener;
import com.rappytv.nametagresizer.core.listener.NametagSizeListener;
import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import net.labymod.api.revision.SimpleRevision;
import net.labymod.api.util.version.SemanticVersion;

@AddonMain
public class NametagResizerAddon extends LabyAddon<NametagResizerConfig> {

  @Override
  protected void preConfigurationLoad() {
    Laby.references().revisionRegistry().register(new SimpleRevision(
        "nametagresizer",
        new SemanticVersion("1.0.1"),
        "2025-09-30"
    ));
  }

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.registerListener(new KeyListener(this));
    this.registerListener(new NametagSizeListener(this));
  }

  @Override
  protected Class<? extends NametagResizerConfig> configurationClass() {
    return NametagResizerConfig.class;
  }
}
