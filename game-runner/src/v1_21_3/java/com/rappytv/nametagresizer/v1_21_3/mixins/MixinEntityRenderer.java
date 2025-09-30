package com.rappytv.nametagresizer.v1_21_3.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.rappytv.nametagresizer.api.event.NametagSizeEvent;
import net.labymod.api.Laby;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer<S extends EntityRenderState> {

  @Unique
  private boolean sandbox$isPlayer;

  @Inject(method = "renderNameTag", at = @At("HEAD"))
  public void renderNameTag(S state, Component component, PoseStack stack,
      MultiBufferSource bufferSource, int $$4, CallbackInfo ci) {
    this.sandbox$isPlayer = state instanceof PlayerRenderState;
  }

  @WrapOperation(method = "renderNameTag", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"))
  private void modifyScale(PoseStack stack, float x, float y, float z, Operation<Void> original) {
    NametagSizeEvent event = new NametagSizeEvent(this.sandbox$isPlayer, x, y, z);
    Laby.fireEvent(event);
    stack.scale(event.getX(), event.getY(), event.getZ());
  }
}
