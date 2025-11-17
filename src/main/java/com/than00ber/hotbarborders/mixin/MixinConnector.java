package com.than00ber.hotbarborders.mixin;

import com.than00ber.hotbarborders.HotbarBordersMod;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

@SuppressWarnings("ALL")
public class MixinConnector implements IMixinConnector {
    @Override
    public void connect() {
        Mixins.addConfiguration(HotbarBordersMod.MODID + ".mixin.json");
    }
}