package com.rappytv.nametagresizer.v1_12_2.mixins;

import com.rappytv.nametagresizer.event.NametagSizeEvent;
import net.labymod.api.Laby;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer {

  @Unique
  private static boolean sandbox$isPlayer;

  // TODO: Fix isPlayer boolean
//  @Inject(method = "renderNameTag", at = @At("HEAD"))
//  public void renderNameTag(T entity, Component component, PoseStack stack,
//      MultiBufferSource buffer, int light, CallbackInfo ci) {
//    sandbox$isPlayer = entity instanceof Player;
//  }

  @Redirect(method = "drawNameplate", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;scale(FFF)V"))
  private static void scale(float x, float y, float z) {
    NametagSizeEvent event = new NametagSizeEvent(sandbox$isPlayer, x, y, z);
    Laby.fireEvent(event);
    GlStateManager.scale(event.getX(), event.getY(), event.getZ());
  }
}
