package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");
    @Override
    public void onInitialize() {
        LOGGER.info("MetaClient Loaded!");
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                client.player.fallDistance = 0;
            }
        });
    }
}
