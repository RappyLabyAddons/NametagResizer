package com.rappytv.nametagresizer.v26_1_2.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.rappytv.nametagresizer.api.event.NametagSizeEvent;
import com.rappytv.nametagresizer.api.misc.RenderStateAccessor;
import net.labymod.api.Laby;
import net.minecraft.client.renderer.feature.NameTagFeatureRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(NameTagFeatureRenderer.Storage.class)
public class MixinNameTagFeatureRendererStorage {

  @WrapOperation(method = "add", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"))
  private void modifyScale(PoseStack stack, float x, float y, float z, Operation<Void> original) {
    NametagSizeEvent event = new NametagSizeEvent(RenderStateAccessor.isPlayer(), x, y, z);
    Laby.fireEvent(event);
    stack.scale(event.getX(), event.getY(), event.getZ());
  }
}
