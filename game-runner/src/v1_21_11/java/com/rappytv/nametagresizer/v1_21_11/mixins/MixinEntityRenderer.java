package com.rappytv.nametagresizer.v1_21_11.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rappytv.nametagresizer.v1_21_11.RenderStateAccessor;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer<S extends EntityRenderState> {

  @Inject(
      method = "submitNameTag",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/SubmitNodeCollector;submitNameTag(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/phys/Vec3;ILnet/minecraft/network/chat/Component;ZIDLnet/minecraft/client/renderer/state/CameraRenderState;)V")
  )
  public void submitNameTag(S state, PoseStack $$1, SubmitNodeCollector $$2, CameraRenderState $$3, CallbackInfo ci) {
    RenderStateAccessor.setPlayer(false);
  }
}
