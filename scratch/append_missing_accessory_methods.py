import re

file_path = r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\AccessoriesModule.java'

with open(file_path, 'r', encoding='utf-8') as f:
    code = f.read()

new_methods = """
    // 59. NEBULA CAPE: Ethereal flowing starlight cloak with cosmic dust particles
    private void renderNebulaCape(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int layers = 6;
        for (int l = 0; l < layers; l++) {
            float yTop = 0.38F - l * 0.14F;
            float yBot = yTop - 0.14F;
            float width = 0.22F + l * 0.035F;
            float wave = (float)Math.sin(t * 2.5F + l * 0.6F) * (0.02F + l * 0.015F);
            float zPos = -0.16F - (l * 0.035F) - wave;
            int alpha = (int)(220 * (1.0F - (l * 0.11F)));
            int col = (mainCol & 0x00FFFFFF) | (alpha << 24);
            draw3DBox(buf, mat, -width, yBot, zPos, width, yTop, zPos + 0.016F, col);
            if (l % 2 == 0) {
                draw3DBox(buf, mat, -width * 0.6F, yBot + 0.05F, zPos - 0.008F, -width * 0.6F + 0.025F, yBot + 0.075F, zPos + 0.02F, 0xFFFFFFFF);
                draw3DBox(buf, mat, width * 0.6F - 0.025F, yBot + 0.03F, zPos - 0.008F, width * 0.6F, yBot + 0.055F, zPos + 0.02F, accCol);
            }
        }
    }

    // 60. CELESTIAL AEGIS BACK: Massive rotating golden fortress shield with runic inlays
    private void renderCelestialAegisBack(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int gold = 0xFFFFD700;
        int darkBronze = 0xFF3D2E12;
        draw3DBox(buf, mat, -0.20F, 0.08F, -0.20F, 0.20F, 0.52F, -0.16F, darkBronze);
        draw3DBox(buf, mat, -0.16F, 0.12F, -0.21F, 0.16F, 0.48F, -0.17F, gold);
        draw3DBox(buf, mat, -0.22F, 0.44F, -0.22F, 0.22F, 0.54F, -0.17F, mainCol);
        draw3DBox(buf, mat, -0.14F, 0.00F, -0.22F, 0.14F, 0.10F, -0.17F, mainCol);
        float pulse = (float)Math.sin(t * 3.5F) * 0.015F;
        draw3DBox(buf, mat, -0.06F - pulse, 0.24F - pulse, -0.23F, 0.06F + pulse, 0.36F + pulse, -0.19F, accCol);
    }

    // 61. ARCANE RUNE CLOAK: Orbiting floating runic tablets linked by light arcs
    private void renderArcaneRuneCloak(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int tablets = 8;
        for (int i = 0; i < tablets; i++) {
            double angle = (Math.PI * 2.0 * i) / tablets + (t * 0.8F);
            float rx = (float)Math.cos(angle) * 0.36F;
            float rz = (float)Math.sin(angle) * 0.30F - 0.05F;
            float ry = 0.20F + (float)Math.sin(t * 2.0F + i) * 0.06F;
            draw3DBox(buf, mat, rx - 0.035F, ry - 0.055F, rz - 0.012F, rx + 0.035F, ry + 0.055F, rz + 0.012F, 0xFF1A1C28);
            draw3DBox(buf, mat, rx - 0.022F, ry - 0.035F, rz - 0.016F, rx + 0.022F, ry + 0.035F, rz + 0.016F, accCol);
        }
    }

    // 62. CYBER BATTERY PACK: Heavy sci-fi reactor core with animated pulsing LED fuel rods & exhaust vents
    private void renderCyberBatteryPack(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int chassis = 0xFF14171F;
        int titanium = 0xFF4A5265;
        draw3DBox(buf, mat, -0.18F, 0.10F, -0.24F, 0.18F, 0.46F, -0.16F, chassis);
        draw3DBox(buf, mat, -0.15F, 0.13F, -0.25F, 0.15F, 0.43F, -0.20F, titanium);
        for (int c = 0; c < 3; c++) {
            float cx = -0.10F + c * 0.10F;
            float fuelPulse = 0.5F + 0.5F * (float)Math.sin(t * 5.0F + c * 1.5F);
            int cellCol = (fuelPulse > 0.5F) ? accCol : mainCol;
            draw3DBox(buf, mat, cx - 0.025F, 0.16F, -0.27F, cx + 0.025F, 0.40F, -0.23F, cellCol);
        }
        draw3DBox(buf, mat, -0.16F, 0.46F, -0.22F, -0.06F, 0.52F, -0.18F, 0xFF0B0D12);
        draw3DBox(buf, mat, 0.06F, 0.46F, -0.22F, 0.16F, 0.52F, -0.18F, 0xFF0B0D12);
    }

    // 63. ASTRAL CONSTELLATION RIBS: Glowing cosmic ribcage armor
    private void renderAstralConstellationRibs(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int ribs = 5;
        for (int r = 0; r < ribs; r++) {
            float ry = 0.12F + r * 0.075F;
            float curve = 0.20F + (float)Math.sin(r * 0.7F) * 0.05F;
            float pulse = (float)Math.sin(t * 3.0F + r) * 0.01F;
            draw3DBox(buf, mat, -curve - pulse, ry, -0.14F, -0.04F, ry + 0.025F, 0.12F, mainCol);
            draw3DBox(buf, mat, -curve - pulse - 0.02F, ry - 0.01F, 0.02F, -curve - pulse + 0.01F, ry + 0.035F, 0.06F, 0xFFFFFFFF);
            draw3DBox(buf, mat, 0.04F, ry, -0.14F, curve + pulse, ry + 0.025F, 0.12F, mainCol);
            draw3DBox(buf, mat, curve + pulse - 0.01F, ry - 0.01F, 0.02F, curve + pulse + 0.02F, ry + 0.035F, 0.06F, 0xFFFFFFFF);
        }
        draw3DBox(buf, mat, -0.025F, 0.08F, -0.16F, 0.025F, 0.50F, -0.13F, accCol);
    }

    // 64. DRAGON BONE WINGS: Skeletal dragon rib wings with glowing marrow fire
    private void renderDragonBoneWings(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int boneCol = 0xFFEDE7D8;
        int darkBone = 0xFF5A4D3B;
        float flap = (float)Math.sin(t * 4.0F) * 0.06F;
        draw3DBox(buf, mat, -0.42F - flap, 0.30F, -0.18F, -0.06F, 0.36F, -0.14F, boneCol);
        draw3DBox(buf, mat, -0.62F - flap * 1.5F, 0.44F, -0.22F, -0.38F, 0.49F, -0.16F, boneCol);
        draw3DBox(buf, mat, -0.58F - flap * 1.4F, 0.16F, -0.20F, -0.36F, 0.20F, -0.15F, darkBone);
        draw3DBox(buf, mat, -0.46F - flap, 0.04F, -0.18F, -0.28F, 0.08F, -0.14F, darkBone);
        draw3DBox(buf, mat, -0.54F - flap * 1.2F, 0.32F, -0.19F, -0.18F, 0.34F, -0.17F, accCol);

        draw3DBox(buf, mat, 0.06F, 0.30F, -0.18F, 0.42F + flap, 0.36F, -0.14F, boneCol);
        draw3DBox(buf, mat, 0.38F, 0.44F, -0.22F, 0.62F + flap * 1.5F, 0.49F, -0.16F, boneCol);
        draw3DBox(buf, mat, 0.36F, 0.16F, -0.20F, 0.58F + flap * 1.4F, 0.20F, -0.15F, darkBone);
        draw3DBox(buf, mat, 0.28F, 0.04F, -0.18F, 0.46F + flap, 0.08F, -0.14F, darkBone);
        draw3DBox(buf, mat, 0.18F, 0.32F, -0.19F, 0.54F + flap * 1.2F, 0.34F, -0.17F, accCol);
    }

    // 58. QUANTUM SINGULARITY ORB: Miniature event-horizon black hole with spinning rings
    private void renderQuantumSingularityOrb(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.07F, 0.48F, -0.25F, 0.07F, 0.62F, -0.11F, 0xFF050508);
        draw3DBox(buf, mat, -0.05F, 0.50F, -0.23F, 0.05F, 0.60F, -0.13F, 0xFF000000);
        float r1 = 0.13F;
        float rPulse = (float)Math.sin(t * 4.0F) * 0.015F;
        draw3DBox(buf, mat, -r1 - rPulse, 0.54F, -r1 - 0.18F, r1 + rPulse, 0.56F, r1 - 0.18F, accCol);
        draw3DBox(buf, mat, -0.10F, 0.50F, -0.10F - 0.18F, 0.10F, 0.60F, 0.10F - 0.18F, mainCol);
    }

    // 97. PHOENIX CREST CROWN: Blazing multi-tiered crown plume with animated fire tips
    private void renderPhoenixCrestCrown(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int gold = 0xFFFFD700;
        int ruby = 0xFFFF2200;
        int amber = 0xFFFFB300;
        draw3DBox(buf, mat, -0.26F, 0.22F, -0.26F, 0.26F, 0.27F, 0.26F, gold);
        float flap1 = (float)Math.sin(t * 5.0F) * 0.03F;
        draw3DBox(buf, mat, -0.04F, 0.27F, -0.28F, 0.04F, 0.52F + flap1, -0.24F, ruby);
        draw3DBox(buf, mat, -0.02F, 0.50F + flap1, -0.27F, 0.02F, 0.60F + flap1 * 1.5F, -0.25F, amber);
        draw3DBox(buf, mat, -0.16F, 0.25F, -0.27F, -0.08F, 0.44F + flap1 * 0.7F, -0.24F, amber);
        draw3DBox(buf, mat, 0.08F, 0.25F, -0.27F, 0.16F, 0.44F + flap1 * 0.7F, -0.24F, amber);
    }

    // 98. CHRONO RELIC CLOCK: Floating ancient astrolabe timepiece with turning gears
    private void renderChronoRelicClock(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int brass = 0xFFC5A059;
        int darkBrass = 0xFF4A3B1F;
        int gold = 0xFFFFD700;
        float bob = (float)Math.sin(t * 2.5F) * 0.04F;
        draw3DBox(buf, mat, 0.35F, 0.25F + bob, -0.10F, 0.65F, 0.55F + bob, 0.00F, brass);
        draw3DBox(buf, mat, 0.38F, 0.28F + bob, -0.11F, 0.62F, 0.52F + bob, -0.01F, darkBrass);
        float hourA = t * 1.5F;
        float minA = t * 6.0F;
        float hx = (float)Math.cos(hourA) * 0.07F;
        float hy = (float)Math.sin(hourA) * 0.07F;
        draw3DBox(buf, mat, 0.50F, 0.40F + bob, -0.13F, 0.50F + hx, 0.40F + bob + hy, -0.09F, 0xFFFFFFFF);
        float mx = (float)Math.cos(minA) * 0.10F;
        float my = (float)Math.sin(minA) * 0.10F;
        draw3DBox(buf, mat, 0.50F, 0.40F + bob, -0.13F, 0.50F + mx, 0.40F + bob + my, -0.09F, accCol);
        float pend = (float)Math.sin(t * 3.0F) * 0.05F;
        draw3DBox(buf, mat, 0.49F + pend, 0.12F + bob, -0.06F, 0.51F + pend, 0.25F + bob, -0.04F, brass);
        draw3DBox(buf, mat, 0.47F + pend, 0.08F + bob, -0.07F, 0.53F + pend, 0.14F + bob, -0.03F, gold);
    }

    // 99. SPIRIT FOX LANTERN: Floating ethereal Japanese shinto lantern trailing spirit will-o-wisps
    private void renderSpiritFoxLantern(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int cedar = 0xFF5D2E16;
        int paper = 0xFFFFF5E6;
        float bob = (float)Math.sin(t * 2.0F) * 0.05F;
        draw3DBox(buf, mat, -0.58F, 0.48F + bob, 0.12F, -0.38F, 0.54F + bob, 0.32F, cedar);
        float flicker = 0.85F + 0.15F * (float)Math.sin(t * 12.0F);
        int glow = (accCol & 0x00FFFFFF) | ((int)(255 * flicker) << 24);
        draw3DBox(buf, mat, -0.55F, 0.30F + bob, 0.15F, -0.41F, 0.48F + bob, 0.29F, paper);
        draw3DBox(buf, mat, -0.52F, 0.34F + bob, 0.18F, -0.44F, 0.44F + bob, 0.26F, glow);
        draw3DBox(buf, mat, -0.57F, 0.26F + bob, 0.13F, -0.39F, 0.30F + bob, 0.31F, cedar);
        float o1x = -0.48F + (float)Math.cos(t * 3.0F) * 0.08F;
        float o1y = 0.20F + bob + (float)Math.sin(t * 3.0F) * 0.06F;
        draw3DBox(buf, mat, o1x - 0.02F, o1y - 0.02F, 0.22F - 0.02F, o1x + 0.02F, o1y + 0.02F, 0.22F + 0.02F, 0xFF00FFCC);
    }
"""

marker = "    public MultiSelectSetting getHeadSetting()"
if marker in code:
    code = code.replace(marker, new_methods + "\n" + marker)
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(code)
    print("Appended 10 new accessory render methods successfully!")
else:
    print("Could not find marker!")
