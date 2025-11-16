package com.than00ber.hotbarborders;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public final class Configuration {

	private static final Pair<Client, ForgeConfigSpec> CLIENT = new ForgeConfigSpec.Builder().configure(Client::new);

	public static void init() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CLIENT.getValue());
	}

	public static class Client {

		public static Client getInstance() {
			return CLIENT.getKey();
		}

        private final ForgeConfigSpec.ConfigValue<Boolean> enableHotbarBorders;

        public Client(ForgeConfigSpec.Builder builder) {
            enableHotbarBorders = builder.define("enableHotbarBorders", true);
		}

        public boolean enableHotbarBorders() {
            return enableHotbarBorders.get();
        }
	}
}
