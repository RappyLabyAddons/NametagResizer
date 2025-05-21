package com.rappytv.nametagresizer.v1_12_2.mixins;

import com.rappytv.nametagresizer.event.NametagSizeEvent;
import net.labymod.api.Laby;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Render.class, priority = 1001)
public class MixinRender<T extends Entity> {

  @Unique
  private boolean nametagresizer$isPlayer = false;

  @Inject(method = "renderLivingLabel", at = @At("HEAD"))
  public void renderNameTag(T entity, String lvt_2_1_, double lvt_3_1_, double lvt_5_1_,
      double lvt_7_1_, int lvt_9_1_, CallbackInfo ci) {
    this.nametagresizer$isPlayer = entity instanceof EntityPlayer;
  }

  @SuppressWarnings("all")
  @Redirect(
      method = "renderLivingLabel",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;scale(FFF)V")
  )
  private void scale(float x, float y, float z) {
    NametagSizeEvent event = new NametagSizeEvent(this.nametagresizer$isPlayer, x, y, z);
    Laby.fireEvent(event);
    GlStateManager.scale(event.getX(), event.getY(), event.getZ());
  }
}
