package com.rappytv.nametagresizer.core;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.key.Key;
import net.labymod.api.client.gui.screen.widget.widgets.input.KeybindWidget.KeyBindSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.IntroducedIn;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.annotation.SpriteTexture;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingSection;

@SpriteTexture("settings")
public class NametagResizerConfig extends AddonConfig {

  public static final int SIZE_MIN = 1;
  public static final int SIZE_MAX = 10;

  @SpriteSlot
  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SpriteSlot(x = 1)
  @SwitchSetting
  private final ConfigProperty<Boolean> playersOnly = new ConfigProperty<>(true);

  @IntroducedIn(namespace = "nametagresizer", value = "1.0.1")
  @SpriteSlot(x = 2)
  private final NametagSizeConfig nametagSizeConfig = new NametagSizeConfig();

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<Boolean> playersOnly() {
    return this.playersOnly;
  }

  public NametagSizeConfig nametagSizeConfig() {
    return this.nametagSizeConfig;
  }

  public static class NametagSizeConfig extends Config {

    @ShowSettingInParent
    @SliderSetting(min = SIZE_MIN, max = SIZE_MAX)
    private final ConfigProperty<Integer> nametagSize = new ConfigProperty<>(4);

    @SettingSection("hotkeys")
    @IntroducedIn(namespace = "nametagresizer", value = "1.0.1")
    @SpriteSlot(x = 3)
    @KeyBindSetting
    private final ConfigProperty<Key> increaseSizeKey = new ConfigProperty<>(Key.PAGE_UP);

    @IntroducedIn(namespace = "nametagresizer", value = "1.0.1")
    @SpriteSlot(x = 4)
    @KeyBindSetting
    private final ConfigProperty<Key> decreaseSizeKey = new ConfigProperty<>(Key.PAGE_DOWN);

    public ConfigProperty<Integer> nametagSize() {
      return this.nametagSize;
    }

    public ConfigProperty<Key> increaseSizeKey() {
      return this.increaseSizeKey;
    }

    public ConfigProperty<Key> decreaseSizeKey() {
      return this.decreaseSizeKey;
    }

  }
}
