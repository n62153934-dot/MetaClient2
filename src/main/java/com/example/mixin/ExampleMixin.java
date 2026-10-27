package com.example.mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "tick")
	private void onTick(CallbackInfo info) {
		Entity self = (Entity)(Object)this;
		self.fallDistance = 0;
	}
}
