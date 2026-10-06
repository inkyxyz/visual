import os
import re

source_path = r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\AccessoriesModule.java'
with open(source_path, 'r', encoding='utf-8') as f:
    orig = f.read()

lines = orig.split('\n')
# Lines 976 to 4182
body_lines = lines[976:4182]
content = '\n'.join(body_lines)

# Replace private void render... with public static void render...
content = re.sub(r'private\s+void\s+(render[A-Za-z0-9_]+)', r'public static void \1', content)
content = re.sub(r'private\s+static\s+', r'public static ', content)

header = """package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;

public class AccessoryRenderHelper {

    public static final Identifier TEX_SHURIKEN = RockstarClient.id("textures/accessories/shuriken.png");

    public static void applyHeadAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float headYaw, float headPitch, float bodyYaw, float scale, float yOffset) {
        double headX = ix;
        double headY = iy + player.getEyeHeight(player.getPose()) - 0.10;
        double headZ = iz;
        if (player.isSneaking()) {
            headX -= Math.sin(Math.toRadians(bodyYaw)) * 0.16;
            headZ += Math.cos(Math.toRadians(bodyYaw)) * 0.16;
            headY -= 0.04;
        }
        m.translate(headX, headY, headZ);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - headYaw));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-headPitch));
        m.translate(0.0, 0.18 + yOffset, 0.0);
        m.scale(scale, scale, scale);
    }

    public static void applyFaceAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float headYaw, float headPitch, float bodyYaw, float scale, float yOffset) {
        double headX = ix;
        double headY = iy + player.getEyeHeight(player.getPose()) - 0.10;
        double headZ = iz;
        if (player.isSneaking()) {
            headX -= Math.sin(Math.toRadians(bodyYaw)) * 0.16;
            headZ += Math.cos(Math.toRadians(bodyYaw)) * 0.16;
            headY -= 0.04;
        }
        m.translate(headX, headY, headZ);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - headYaw));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-headPitch));
        m.translate(0.0, 0.02 + yOffset, 0.0);
        m.scale(scale, scale, scale);
    }

    public static void applyTorsoAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float bodyYaw, float scale, float yOffset) {
        float torsoHeight = player.getHeight() * 0.58F;
        m.translate(ix, iy + torsoHeight, iz);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - bodyYaw));
        if (player.isSneaking()) {
            m.translate(0.0, -0.16, 0.22);
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(28.0F));
        }
        m.translate(0.0, yOffset, 0.0);
        m.scale(scale, scale, scale);
    }

    public static void applyOrbitAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float bodyYaw, float scale, float radius, float yOffset) {
        float waistHeight = player.getHeight() * 0.45F;
        m.translate(ix, iy + waistHeight, iz);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - bodyYaw));
        if (player.isSneaking()) {
            m.translate(0.0, -0.10, 0.12);
        }
        m.translate(0.0, yOffset, 0.0);
        m.scale(scale * radius, scale, scale * radius);
    }

    public static void applyPetAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float bodyYaw, float scale, float dist, float yOffset) {
        float shoulderHeight = player.getHeight() * 0.65F;
        m.translate(ix, iy + shoulderHeight, iz);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - bodyYaw));
        m.translate(-0.35 * (dist - 1.0), yOffset, -0.20 * (dist - 1.0));
        m.scale(scale, scale, scale);
    }
"""

footer = "\n}\n"

target_path = r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\AccessoryRenderHelper.java'
with open(target_path, 'w', encoding='utf-8') as f:
    f.write(header + content + footer)

print(f"Generated {target_path} successfully!")
