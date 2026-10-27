package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;

public class MetaClientHUD implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null || mc.options.hideGui) return;
            if (mc.screen != null) return;

            int h = drawContext.guiHeight();
            int x = 10;
            int y = h - 70;
            InventoryScreen.renderEntityInInventoryFollowsMouse(
                drawContext, x, y, x+40, y+60, 30, 0.4f,
                (float)mc.mouseHandler.xpos(), (float)mc.mouseHandler.ypos(), mc.player
            );

            drawContext.drawString(mc.font, "MetaClient 1.0", 5, 5, 0xFFAA55FF, true);
            String coords = String.format("XYZ: %.0f / %.0f / %.0f", mc.player.getX(), mc.player.getY(), mc.player.getZ());
            drawContext.drawString(mc.font, coords, 5, 18, 0xFFFFFFFF, true);
            drawContext.drawString(mc.font, "FPS: " + mc.getFps(), 5, 28, 0xFFFFFFFF, true);
        });
    }
}
