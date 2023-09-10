package me.xap3y.DungeonKicker;

import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class SendClickableMsg {
    public static void send(String message, String command, String tooltip) {
        ChatComponentText chatComponent = new ChatComponentText(message);
        ChatStyle chatStyle = new ChatStyle();
        chatStyle.setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));

        ChatComponentTranslation tooltipComponent = new ChatComponentTranslation(tooltip);
        ChatStyle tooltipStyle = new ChatStyle();
        tooltipStyle.setColor(EnumChatFormatting.GRAY);
        tooltipComponent.setChatStyle(tooltipStyle);
        chatStyle.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, tooltipComponent));

        chatComponent.setChatStyle(chatStyle);
        Minecraft.getMinecraft().thePlayer.addChatMessage(chatComponent);
    }
}


