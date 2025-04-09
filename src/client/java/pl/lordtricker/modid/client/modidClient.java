package pl.lordtricker.modid.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import pl.lordtricker.modid.client.command.CommandRegistration;
import pl.lordtricker.modid.client.config.ModSettings;
import pl.lordtricker.modid.client.util.ColorUtils;
import pl.lordtricker.modid.client.util.Messages;

public class modidClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModSettings.load();

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            if (client.player != null) {
                String welcomeMsg = Messages.get("player.join");
                client.player.sendMessage(ColorUtils.translateColorCodes(welcomeMsg), false);
            }
        });

        CommandRegistration.registerCommands();
    }
}
