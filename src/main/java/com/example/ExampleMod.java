package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ExampleMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((DrawContext context, float tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || client.world == null) return;
            if (client.options.hudHidden) return;

            int fps = client.getCurrentFps();
            int ping = 0;
            if (client.getNetworkHandler() != null) {
                var entry = client.getNetworkHandler().getPlayerListEntry(client.player.getUuid());
                if (entry != null) ping = entry.getLatency();
            }
            
            double x = client.player.getX();
            double y = client.player.getY();
            double z = client.player.getZ();

            int yPos = 5;
            context.drawText(client.textRenderer, "§bMetaClient2", 5, yPos, 0xFFFFFF, true);
            yPos += 12;
            context.drawText(client.textRenderer, "§fFPS: §a" + fps, 5, yPos, 0xFFFFFF, true);
            yPos += 10;
            context.drawText(client.textRenderer, "§fPing: §a" + ping + "ms", 5, yPos, 0xFFFFFF, true);
            yPos += 10;
            context.drawText(client.textRenderer, "§fXYZ: §e" + (int)x + " " + (int)y + " " + (int)z, 5, yPos, 0xFFFFFF, true);
        });
        System.out.println("MetaClient2 HUD loaded!");
    }
                                                                          }
