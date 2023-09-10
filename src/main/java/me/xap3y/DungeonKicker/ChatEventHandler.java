package me.xap3y.DungeonKicker;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

import static me.xap3y.DungeonKicker.SendClickableMsg.send;
public class ChatEventHandler {
    static String playerName = "null";
    @SubscribeEvent
    public void onChatMessage(ClientChatReceivedEvent event) {
        String message = event.message.getUnformattedText();
        if (message.contains("joined the dungeon group!")) {
            int index = message.indexOf("joined the dungeon group! (");

            if (index != -1) {
                playerName = message.substring(0, index);
                playerName = playerName.replace("Party Finder > ", "");
            }

            if (!Objects.equals(playerName, Minecraft.getMinecraft().thePlayer.getName())) {
                event.setCanceled(true);
                send(event.message.getFormattedText() + ChatFormatting.RED + " (KICK)", "/party kick " + playerName, ChatFormatting.GRAY + "Click to kick");
            }
        }

    }
}