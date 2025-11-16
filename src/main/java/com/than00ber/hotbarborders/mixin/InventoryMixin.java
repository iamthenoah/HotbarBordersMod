package com.than00ber.hotbarborders.mixin;

import com.than00ber.hotbarborders.Configuration;
import net.minecraft.world.Container;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Inventory.class)
public abstract class InventoryMixin implements Container, Nameable {

    @Shadow public int selected;

    @Inject(method = "swapPaint", at = @At("HEAD"), cancellable = true)
    public void swapPaint(double direction, CallbackInfo callback) {
        if (Configuration.Client.getInstance().enableHotbarBorders()) {
            if ((direction < 0 && selected == 8) || (direction > 0 && selected == 0)) {
                callback.cancel();
            }
        }
    }
}
