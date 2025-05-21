package com.rappytv.nametagresizer.v1_20_6.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rappytv.nametagresizer.event.NametagSizeEvent;
import net.labymod.api.Laby;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer<T extends Entity> {

  @Unique
  private boolean sandbox$isPlayer;

  @Inject(method = "renderNameTag", at = @At("HEAD"))
  public void renderNameTag(T entity, Component component, PoseStack stack,
      MultiBufferSource bufferSource, int $$4, float $$5, CallbackInfo ci) {
    this.sandbox$isPlayer = entity instanceof Player;
  }

  @Redirect(method = "renderNameTag", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"))
  public void scale(PoseStack stack, float x, float y, float z) {
    NametagSizeEvent event = new NametagSizeEvent(this.sandbox$isPlayer, x, y, z);
    Laby.fireEvent(event);
    stack.scale(event.getX(), event.getY(), event.getZ());
  }
}
