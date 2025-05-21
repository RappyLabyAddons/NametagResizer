package com.rappytv.nametagresizer;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.property.ConfigProperty;

public class NametagResizerConfig extends AddonConfig {

  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SliderSetting(min = 1, max = 10)
  private final ConfigProperty<Integer> nametagSize = new ConfigProperty<>(4);

  @SwitchSetting
  private final ConfigProperty<Boolean> playersOnly = new ConfigProperty<>(true);

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<Integer> nametagSize() {
    return this.nametagSize;
  }

  public ConfigProperty<Boolean> playersOnly() {
    return this.playersOnly;
  }
}
