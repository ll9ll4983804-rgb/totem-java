package com.aokp.combathelper;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

import java.util.concurrent.ThreadLocalRandom;

public class CombatHelperClient implements ClientModInitializer {

    public static boolean elytraMaceSwitchEnabled = false;
    public static boolean autoMaceHitEnabled = false;
    public static boolean autoBlockEnabled = false;

    private static KeyMapping toggleElytraSwitchKey;
    private static KeyMapping toggleAutoMaceKey;
    private static KeyMapping toggleAutoBlockKey;

    private long nextActionTimeMs = 0L;

    @Override
    public void onInitializeClient() {
        toggleElytraSwitchKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.combathelper.elytra_mace_switch",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.combathelper.general"
        ));

        toggleAutoMaceKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.combathelper.auto_mace_hit",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.combathelper.general"
        ));

        toggleAutoBlockKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.combathelper.auto_block",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.combathelper.general"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
    }

    private void onClientTick(Minecraft client) {
        if (client.player == null || client.level == null) {
            return;
        }

        while (toggleElytraSwitchKey.consumeClick()) {
            elytraMaceSwitchEnabled = !elytraMaceSwitchEnabled;
        }
        while (toggleAutoMaceKey.consumeClick()) {
            autoMaceHitEnabled = !autoMaceHitEnabled;
        }
        while (toggleAutoBlockKey.consumeClick()) {
            autoBlockEnabled = !autoBlockEnabled;
        }

        long now = System.currentTimeMillis();
        if (now < nextActionTimeMs) {
            return;
        }

        if (elytraMaceSwitchEnabled) {
            handleElytraMaceSwitch(client);
        }
        if (autoMaceHitEnabled) {
            handleAutoMaceHit(client);
        }
        if (autoBlockEnabled) {
            handleAutoBlock(client);
        }

        // تأخير عشوائي بسيط لمحاكاة الاستجابة البشرية
        nextActionTimeMs = now + ThreadLocalRandom.current().nextInt(35, 80);
    }

    private void handleElytraMaceSwitch(Minecraft client) {
        // TODO: فحص حالة الطيران/السقوط، البحث عن أقرب لاعب ضمن المدى،
        // وتبديل slot الميس في الهوتبار بشكل تدريجي/طبيعي.
    }

    private void handleAutoMaceHit(Minecraft client) {
        // TODO: التحقق من مسك الميس، جاهزية الهجوم (Attack Cooldown)،
        // والضرب عند تحقق الشروط.
    }

    private void handleAutoBlock(Minecraft client) {
        // TODO: رصد التهديد القريب وتفعيل/إلغاء استخدام الدرع بحدود زمنية طبيعية.
    }
}
