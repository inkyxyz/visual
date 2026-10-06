import re

file_path = r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\AccessoriesModule.java'

with open(file_path, 'r', encoding='utf-8') as f:
    code = f.read()

# 1. Replace field declarations
old_fields = """    private MultiSelectSetting.Nested1_42856060 accEnergyShieldArm;
    private MultiSelectSetting.Nested1_42856060 accCyberTailMech;
    private MultiSelectSetting.Nested1_42856060 accTentaclePlumes;
    private MultiSelectSetting.Nested1_42856060 accSusanooArmor;
    private MultiSelectSetting.Nested1_42856060 accCyberKatanaBack;
    private MultiSelectSetting.Nested1_42856060 accKitsuneNineTails;
    private MultiSelectSetting.Nested1_42856060 accDragonSkullShoulder;
    private MultiSelectSetting.Nested1_42856060 accNeonCyberSpine;
    private MultiSelectSetting.Nested1_42856060 accDemonicGreatsword;
    private MultiSelectSetting.Nested1_42856060 accCyberGauntletRight;
    private MultiSelectSetting.Nested1_42856060 accCyberGauntletLeft;
    private MultiSelectSetting.Nested1_42856060 accFlameCestus;
    private MultiSelectSetting.Nested1_42856060 accShieldBracer;
    private MultiSelectSetting.Nested1_42856060 accHermesWingsBoots;
    private MultiSelectSetting.Nested1_42856060 accHoverBoots;
    private MultiSelectSetting.Nested1_42856060 accShadowGreaves;"""

new_fields = """    private MultiSelectSetting.Nested1_42856060 accNebulaCape;
    private MultiSelectSetting.Nested1_42856060 accCyberTailMech;
    private MultiSelectSetting.Nested1_42856060 accTentaclePlumes;
    private MultiSelectSetting.Nested1_42856060 accSusanooArmor;
    private MultiSelectSetting.Nested1_42856060 accCyberKatanaBack;
    private MultiSelectSetting.Nested1_42856060 accKitsuneNineTails;
    private MultiSelectSetting.Nested1_42856060 accDragonSkullShoulder;
    private MultiSelectSetting.Nested1_42856060 accNeonCyberSpine;
    private MultiSelectSetting.Nested1_42856060 accDemonicGreatsword;
    private MultiSelectSetting.Nested1_42856060 accCelestialAegisBack;
    private MultiSelectSetting.Nested1_42856060 accArcaneRuneCloak;
    private MultiSelectSetting.Nested1_42856060 accCyberBatteryPack;
    private MultiSelectSetting.Nested1_42856060 accAstralConstellationRibs;
    private MultiSelectSetting.Nested1_42856060 accDragonBoneWings;
    private MultiSelectSetting.Nested1_42856060 accQuantumSingularityOrb;
    private MultiSelectSetting.Nested1_42856060 accSpiritFoxLantern;"""

code = code.replace(old_fields, new_fields)

# Replace pet fields (accNekoPaws, accGigaDrillArm)
code = code.replace("    private MultiSelectSetting.Nested1_42856060 accNekoPaws;\n", "    private MultiSelectSetting.Nested1_42856060 accPhoenixCrestCrown;\n")
code = code.replace("    private MultiSelectSetting.Nested1_42856060 accGigaDrillArm;\n", "    private MultiSelectSetting.Nested1_42856060 accChronoRelicClock;\n")

# 2. Replace settings initializations
old_inits = """        this.accEnergyShieldArm = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "EnergyShield");
        this.accCyberTailMech = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "MechTail");
        this.accTentaclePlumes = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Tentacles");
        this.accSusanooArmor = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "SusanooArmor");
        this.accCyberKatanaBack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberKatanaBack");
        this.accKitsuneNineTails = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "KitsuneNineTails");
        this.accDragonSkullShoulder = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DragonShoulder");
        this.accNeonCyberSpine = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberSpine");
        this.accDemonicGreatsword = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DemonGreatsword");
        this.accCyberGauntletRight = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "GauntletR");
        this.accCyberGauntletLeft = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "GauntletL");
        this.accFlameCestus = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "FlameCestus");
        this.accShieldBracer = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "ShieldBracer");
        this.accHermesWingsBoots = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "HermesBoots");
        this.accHoverBoots = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "HoverBoots");
        this.accShadowGreaves = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "ShadowGreaves");"""

new_inits = """        this.accNebulaCape = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "NebulaCape");
        this.accCyberTailMech = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "MechTail");
        this.accTentaclePlumes = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "Tentacles");
        this.accSusanooArmor = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "SusanooArmor");
        this.accCyberKatanaBack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberKatanaBack");
        this.accKitsuneNineTails = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "KitsuneNineTails");
        this.accDragonSkullShoulder = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DragonShoulder");
        this.accNeonCyberSpine = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberSpine");
        this.accDemonicGreatsword = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DemonGreatsword");
        this.accCelestialAegisBack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CelestialAegis");
        this.accArcaneRuneCloak = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "RunicCloak");
        this.accCyberBatteryPack = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "CyberBattery");
        this.accAstralConstellationRibs = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "AstralRibs");
        this.accDragonBoneWings = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "DragonBoneWings");
        this.accQuantumSingularityOrb = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "QuantumOrb");
        this.accSpiritFoxLantern = new MultiSelectSetting.Nested1_42856060(this.bodySetting, "FoxLantern");"""

code = code.replace(old_inits, new_inits)
code = code.replace('        this.accNekoPaws = new MultiSelectSetting.Nested1_42856060(this.petSetting, "NekoPaws");\n', '        this.accPhoenixCrestCrown = new MultiSelectSetting.Nested1_42856060(this.headSetting, "PhoenixCrest");\n')
code = code.replace('        this.accGigaDrillArm = new MultiSelectSetting.Nested1_42856060(this.petSetting, "GigaDrillArm");\n', '        this.accChronoRelicClock = new MultiSelectSetting.Nested1_42856060(this.magicSetting, "ChronoRelic");\n')

# 3. Replace renders in onRender3D
old_render1 = """        if (this.accEnergyShieldArm.isSelected()) {
            m.push(); applyLeftArmAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderEnergyShieldArm(m, buffer, mainCol, accCol, time); m.pop();
        }"""
new_render1 = """        if (this.accNebulaCape.isSelected()) {
            m.push(); applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderNebulaCape(m, buffer, mainCol, accCol, time); m.pop();
        }"""
code = code.replace(old_render1, new_render1)

old_render2 = """        if (this.accCyberGauntletRight.isSelected()) {
            m.push(); applyRightArmAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderCyberGauntletRight(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberGauntletLeft.isSelected()) {
            m.push(); applyLeftArmAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderCyberGauntletLeft(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accFlameCestus.isSelected()) {
            m.push(); applyRightArmAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderFlameCestus(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accShieldBracer.isSelected()) {
            m.push(); applyLeftArmAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderShieldBracer(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accHermesWingsBoots.isSelected()) {
            m.push(); applyRightLegAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderHermesWingsBoots(m, buffer, mainCol, accCol, time); m.pop();
            m.push(); applyLeftLegAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderHermesWingsBoots(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accHoverBoots.isSelected()) {
            m.push(); applyRightLegAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderHoverBoots(m, buffer, mainCol, accCol, time); m.pop();
            m.push(); applyLeftLegAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderHoverBoots(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accShadowGreaves.isSelected()) {
            m.push(); applyRightLegAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderShadowGreaves(m, buffer, mainCol, accCol, time); m.pop();
            m.push(); applyLeftLegAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderShadowGreaves(m, buffer, mainCol, accCol, time); m.pop();
        }"""

new_render2 = """        if (this.accCelestialAegisBack.isSelected()) {
            m.push(); applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderCelestialAegisBack(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accArcaneRuneCloak.isSelected()) {
            m.push(); applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderArcaneRuneCloak(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accCyberBatteryPack.isSelected()) {
            m.push(); applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderCyberBatteryPack(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accAstralConstellationRibs.isSelected()) {
            m.push(); applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderAstralConstellationRibs(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accDragonBoneWings.isSelected()) {
            m.push(); applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderDragonBoneWings(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accQuantumSingularityOrb.isSelected()) {
            m.push(); applyTorsoAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderQuantumSingularityOrb(m, buffer, mainCol, accCol, time); m.pop();
        }
        if (this.accSpiritFoxLantern.isSelected()) {
            m.push(); applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderSpiritFoxLantern(m, buffer, mainCol, accCol, time); m.pop();
        }"""

code = code.replace(old_render2, new_render2)

old_render3 = """        if (this.accNekoPaws.isSelected()) {
            m.push(); applyRightArmAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderNekoPaws(m, buffer, mainCol, accCol, time); m.pop();
            m.push(); applyLeftArmAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderNekoPaws(m, buffer, mainCol, accCol, time); m.pop();
        }"""
new_render3 = """        if (this.accPhoenixCrestCrown.isSelected()) {
            m.push(); applyHeadAnchor(m, player, ix, iy, iz, headYaw, headPitch, bodyYaw, scale);
            renderPhoenixCrestCrown(m, buffer, mainCol, accCol, time); m.pop();
        }"""
code = code.replace(old_render3, new_render3)

old_render4 = """        if (this.accGigaDrillArm.isSelected()) {
            m.push(); applyRightArmAnchor(m, player, ix, iy, iz, bodyYaw, td, scale);
            renderGigaDrillArm(m, buffer, mainCol, accCol, time); m.pop();
        }"""
new_render4 = """        if (this.accChronoRelicClock.isSelected()) {
            m.push(); applyPetAnchor(m, player, ix, iy, iz, bodyYaw, scale);
            renderChronoRelicClock(m, buffer, mainCol, accCol, time); m.pop();
        }"""
code = code.replace(old_render4, new_render4)

# 4. Remove arm/leg anchor methods:
# applyRightArmAnchor, applyLeftArmAnchor, applyRightLegAnchor, applyLeftLegAnchor
anchor_regex = re.compile(r'    private void applyRightArmAnchor.*?    private void applyPetAnchor', re.DOTALL)
anchor_replacement = """    private void applyPetAnchor"""
code = anchor_regex.sub(anchor_replacement, code)

# 5. Remove old render methods for the 10 arm/leg items and replace with the 10 new high-detail render methods
old_render_methods = """    // 59. CYBER GAUNTLETS
    private void renderCyberGauntletRight(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.09F, -0.22F, -0.09F, 0.09F, 0.02F, 0.09F, mainCol);
        draw3DBox(buf, mat, -0.10F, -0.18F, -0.10F, 0.10F, -0.08F, 0.10F, accCol);
        draw3DBox(buf, mat, -0.06F, -0.25F, -0.06F, 0.06F, -0.22F, 0.06F, 0xFFFFFFFF);
    }
    private void renderCyberGauntletLeft(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        renderCyberGauntletRight(m, buf, mainCol, accCol, t);
    }

    // 60. FLAME CESTUS
    private void renderFlameCestus(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int fireRed = 0xFFFF3300;
        int fireGold = 0xFFFFCC00;
        draw3DBox(buf, mat, -0.10F, -0.24F, -0.10F, 0.10F, 0.00F, 0.10F, fireRed);
        draw3DBox(buf, mat, -0.11F, -0.16F, -0.11F, 0.11F, -0.10F, 0.11F, fireGold);
        float pulse = 0.02F * (float)Math.sin(t * 8.0);
        draw3DBox(buf, mat, -0.08F - pulse, -0.26F, -0.08F - pulse, 0.08F + pulse, -0.22F, 0.08F + pulse, 0xFFFFAA00);
    }

    // 61. SHIELD BRACER
    private void renderShieldBracer(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.09F, -0.20F, -0.09F, 0.09F, 0.00F, 0.09F, 0xFF2A2E3D);
        draw3DBox(buf, mat, -0.14F, -0.16F, -0.04F, -0.09F, 0.02F, 0.04F, accCol);
        draw3DBox(buf, mat, -0.15F, -0.10F, -0.02F, -0.13F, -0.04F, 0.02F, 0xFFFFFFFF);
    }

    // 62. HERMES WINGS BOOTS
    private void renderHermesWingsBoots(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int gold = 0xFFFFD700;
        draw3DBox(buf, mat, -0.08F, -0.26F, -0.08F, 0.08F, -0.10F, 0.08F, gold);
        float flap = (float)Math.sin(t * 10.0) * 0.06F;
        draw3DBox(buf, mat, 0.08F, -0.16F, -0.02F, 0.18F + flap, -0.10F, 0.02F, 0xFFFFFFFF);
        draw3DBox(buf, mat, 0.08F, -0.14F, -0.04F, 0.15F + flap * 0.7F, -0.08F, 0.00F, 0xFFEEEEEE);
    }

    // 63. HOVER BOOTS
    private void renderHoverBoots(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.085F, -0.28F, -0.085F, 0.085F, -0.12F, 0.085F, 0xFF1C222E);
        int glowCyan = 0xFF00F0FF;
        draw3DBox(buf, mat, -0.095F, -0.27F, -0.095F, 0.095F, -0.23F, 0.095F, glowCyan);
        float pulse = (float)Math.abs(Math.sin(t * 6.0)) * 0.02F;
        draw3DBox(buf, mat, -0.06F, -0.32F - pulse, -0.06F, 0.06F, -0.28F, 0.06F, 0x8800FFFF);
    }

    // 64. SHADOW GREAVES
    private void renderShadowGreaves(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int darkPurple = 0xFF18052B;
        int voidMagenta = 0xFF9900FF;
        draw3DBox(buf, mat, -0.085F, -0.28F, -0.085F, 0.085F, -0.05F, 0.085F, darkPurple);
        draw3DBox(buf, mat, -0.095F, -0.18F, -0.095F, 0.095F, -0.14F, 0.095F, voidMagenta);
        draw3DBox(buf, mat, -0.09F, -0.27F, 0.06F, 0.09F, -0.24F, 0.10F, voidMagenta);
    }"""

new_render_methods = """    // 59. NEBULA CAPE: Ethereal flowing starlight cloak with cosmic dust particles
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
            // Glowing star specks on cape
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
        // Central boss
        draw3DBox(buf, mat, -0.20F, 0.08F, -0.20F, 0.20F, 0.52F, -0.16F, darkBronze);
        draw3DBox(buf, mat, -0.16F, 0.12F, -0.21F, 0.16F, 0.48F, -0.17F, gold);
        // Beveled chevron trims
        draw3DBox(buf, mat, -0.22F, 0.44F, -0.22F, 0.22F, 0.54F, -0.17F, mainCol);
        draw3DBox(buf, mat, -0.14F, 0.00F, -0.22F, 0.14F, 0.10F, -0.17F, mainCol);
        // Glowing gem core
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
        // Main block
        draw3DBox(buf, mat, -0.18F, 0.10F, -0.24F, 0.18F, 0.46F, -0.16F, chassis);
        draw3DBox(buf, mat, -0.15F, 0.13F, -0.25F, 0.15F, 0.43F, -0.20F, titanium);
        // 3 Glowing energy fuel cells
        for (int c = 0; c < 3; c++) {
            float cx = -0.10F + c * 0.10F;
            float fuelPulse = 0.5F + 0.5F * (float)Math.sin(t * 5.0F + c * 1.5F);
            int cellCol = (fuelPulse > 0.5F) ? accCol : mainCol;
            draw3DBox(buf, mat, cx - 0.025F, 0.16F, -0.27F, cx + 0.025F, 0.40F, -0.23F, cellCol);
        }
        // Exhaust turbine nozzles
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
            // Left rib
            draw3DBox(buf, mat, -curve - pulse, ry, -0.14F, -0.04F, ry + 0.025F, 0.12F, mainCol);
            draw3DBox(buf, mat, -curve - pulse - 0.02F, ry - 0.01F, 0.02F, -curve - pulse + 0.01F, ry + 0.035F, 0.06F, 0xFFFFFFFF);
            // Right rib
            draw3DBox(buf, mat, 0.04F, ry, -0.14F, curve + pulse, ry + 0.025F, 0.12F, mainCol);
            draw3DBox(buf, mat, curve + pulse - 0.01F, ry - 0.01F, 0.02F, curve + pulse + 0.02F, ry + 0.035F, 0.06F, 0xFFFFFFFF);
        }
        // Glowing spine backbone
        draw3DBox(buf, mat, -0.025F, 0.08F, -0.16F, 0.025F, 0.50F, -0.13F, accCol);
    }

    // 64. DRAGON BONE WINGS: Skeletal dragon rib wings with glowing marrow fire
    private void renderDragonBoneWings(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int boneCol = 0xFFEDE7D8;
        int darkBone = 0xFF5A4D3B;
        float flap = (float)Math.sin(t * 4.0F) * 0.06F;
        // Left skeletal wing
        draw3DBox(buf, mat, -0.42F - flap, 0.30F, -0.18F, -0.06F, 0.36F, -0.14F, boneCol);
        draw3DBox(buf, mat, -0.62F - flap * 1.5F, 0.44F, -0.22F, -0.38F, 0.49F, -0.16F, boneCol);
        draw3DBox(buf, mat, -0.58F - flap * 1.4F, 0.16F, -0.20F, -0.36F, 0.20F, -0.15F, darkBone);
        draw3DBox(buf, mat, -0.46F - flap, 0.04F, -0.18F, -0.28F, 0.08F, -0.14F, darkBone);
        // Marrow fire glow
        draw3DBox(buf, mat, -0.54F - flap * 1.2F, 0.32F, -0.19F, -0.18F, 0.34F, -0.17F, accCol);
        // Right skeletal wing
        draw3DBox(buf, mat, 0.06F, 0.30F, -0.18F, 0.42F + flap, 0.36F, -0.14F, boneCol);
        draw3DBox(buf, mat, 0.38F, 0.44F, -0.22F, 0.62F + flap * 1.5F, 0.49F, -0.16F, boneCol);
        draw3DBox(buf, mat, 0.36F, 0.16F, -0.20F, 0.58F + flap * 1.4F, 0.20F, -0.15F, darkBone);
        draw3DBox(buf, mat, 0.28F, 0.04F, -0.18F, 0.46F + flap, 0.08F, -0.14F, darkBone);
        // Marrow fire glow
        draw3DBox(buf, mat, 0.18F, 0.32F, -0.19F, 0.54F + flap * 1.2F, 0.34F, -0.17F, accCol);
    }"""

code = code.replace(old_render_methods, new_render_methods)

# Replace renderEnergyShieldArm, renderNekoPaws, renderGigaDrillArm
old_solos = """    // 58. ENERGY SHIELD ARM
    private void renderEnergyShieldArm(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        float pulse = (float)Math.sin(t * 4.0) * 0.015F;
        int cyanShield = 0xAA00F5FF;
        int hexBorder = 0xFFFFFFFF;
        draw3DBox(buf, mat, -0.18F - pulse, -0.28F - pulse, -0.06F, -0.14F, 0.08F + pulse, 0.06F, cyanShield);
        draw3DBox(buf, mat, -0.19F, -0.22F, -0.04F, -0.16F, 0.02F, 0.04F, hexBorder);
        draw3DBox(buf, mat, -0.10F, -0.14F, -0.08F, 0.08F, -0.06F, 0.08F, 0xFF333344);
    }"""

new_solos = """    // 58. QUANTUM SINGULARITY ORB: Miniature event-horizon black hole with spinning rings
    private void renderQuantumSingularityOrb(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        // Central black hole core
        draw3DBox(buf, mat, -0.07F, 0.48F, -0.25F, 0.07F, 0.62F, -0.11F, 0xFF050508);
        draw3DBox(buf, mat, -0.05F, 0.50F, -0.23F, 0.05F, 0.60F, -0.13F, 0xFF000000);
        // Spinning accretion rings
        float r1 = 0.13F;
        float rPulse = (float)Math.sin(t * 4.0F) * 0.015F;
        draw3DBox(buf, mat, -r1 - rPulse, 0.54F, -r1 - 0.18F, r1 + rPulse, 0.56F, r1 - 0.18F, accCol);
        draw3DBox(buf, mat, -0.10F, 0.50F, -0.10F - 0.18F, 0.10F, 0.60F, 0.10F - 0.18F, mainCol);
    }"""

code = code.replace(old_solos, new_solos)

old_solos2 = """    // 97. NEKO PAWS
    private void renderNekoPaws(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int white = 0xFFFFFFFF;
        int pinkPad = 0xFFFF69B4;
        draw3DBox(buf, mat, -0.10F, -0.26F, -0.10F, 0.10F, -0.04F, 0.10F, white);
        draw3DBox(buf, mat, -0.06F, -0.27F, -0.06F, 0.06F, -0.25F, 0.06F, pinkPad);
        draw3DBox(buf, mat, -0.08F, -0.27F, -0.03F, -0.05F, -0.25F, 0.00F, pinkPad);
        draw3DBox(buf, mat, 0.05F, -0.27F, -0.03F, 0.08F, -0.25F, 0.00F, pinkPad);
        draw3DBox(buf, mat, -0.02F, -0.27F, 0.04F, 0.02F, -0.25F, 0.07F, pinkPad);
    }"""

new_solos2 = """    // 97. PHOENIX CREST CROWN: Blazing multi-tiered crown plume with animated fire tips
    private void renderPhoenixCrestCrown(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int gold = 0xFFFFD700;
        int ruby = 0xFFFF2200;
        int amber = 0xFFFFB300;
        // Circlet base
        draw3DBox(buf, mat, -0.26F, 0.22F, -0.26F, 0.26F, 0.27F, 0.26F, gold);
        // Central tall feather plume
        float flap1 = (float)Math.sin(t * 5.0F) * 0.03F;
        draw3DBox(buf, mat, -0.04F, 0.27F, -0.28F, 0.04F, 0.52F + flap1, -0.24F, ruby);
        draw3DBox(buf, mat, -0.02F, 0.50F + flap1, -0.27F, 0.02F, 0.60F + flap1 * 1.5F, -0.25F, amber);
        // Left & right side plumes
        draw3DBox(buf, mat, -0.16F, 0.25F, -0.27F, -0.08F, 0.44F + flap1 * 0.7F, -0.24F, amber);
        draw3DBox(buf, mat, 0.08F, 0.25F, -0.27F, 0.16F, 0.44F + flap1 * 0.7F, -0.24F, amber);
    }"""

code = code.replace(old_solos2, new_solos2)

old_solos3 = """    // 98. GIGA DRILL ARM
    private void renderGigaDrillArm(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int metal = 0xFF555566;
        int goldTip = 0xFFFFCC00;
        draw3DBox(buf, mat, -0.12F, -0.20F, -0.12F, 0.12F, 0.02F, 0.12F, metal);
        float spin = t * 25.0F;
        int tiers = 5;
        for (int i = 0; i < tiers; i++) {
            float r = 0.14F - (i * 0.025F);
            float y = -0.20F - (i * 0.07F);
            int col = (i % 2 == 0) ? goldTip : accCol;
            draw3DBox(buf, mat, -r, y - 0.06F, -r, r, y, r, col);
        }
    }"""

new_solos3 = """    // 98. CHRONO RELIC CLOCK: Floating ancient astrolabe timepiece with turning gears
    private void renderChronoRelicClock(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int brass = 0xFFC5A059;
        int darkBrass = 0xFF4A3B1F;
        float bob = (float)Math.sin(t * 2.5F) * 0.04F;
        // Outer gear frame
        draw3DBox(buf, mat, 0.35F, 0.25F + bob, -0.10F, 0.65F, 0.55F + bob, 0.00F, brass);
        draw3DBox(buf, mat, 0.38F, 0.28F + bob, -0.11F, 0.62F, 0.52F + bob, -0.01F, darkBrass);
        // Turning hour & minute clock hands
        float hourA = t * 1.5F;
        float minA = t * 6.0F;
        float hx = (float)Math.cos(hourA) * 0.07F;
        float hy = (float)Math.sin(hourA) * 0.07F;
        draw3DBox(buf, mat, 0.50F, 0.40F + bob, -0.13F, 0.50F + hx, 0.40F + bob + hy, -0.09F, 0xFFFFFFFF);
        float mx = (float)Math.cos(minA) * 0.10F;
        float my = (float)Math.sin(minA) * 0.10F;
        draw3DBox(buf, mat, 0.50F, 0.40F + bob, -0.13F, 0.50F + mx, 0.40F + bob + my, -0.09F, accCol);
        // Pendulum bob
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
        // Roof
        draw3DBox(buf, mat, -0.58F, 0.48F + bob, 0.12F, -0.38F, 0.54F + bob, 0.32F, cedar);
        // Paper lamp body with warm glow
        float flicker = 0.85F + 0.15F * (float)Math.sin(t * 12.0F);
        int glow = (accCol & 0x00FFFFFF) | ((int)(255 * flicker) << 24);
        draw3DBox(buf, mat, -0.55F, 0.30F + bob, 0.15F, -0.41F, 0.48F + bob, 0.29F, paper);
        draw3DBox(buf, mat, -0.52F, 0.34F + bob, 0.18F, -0.44F, 0.44F + bob, 0.26F, glow);
        // Base
        draw3DBox(buf, mat, -0.57F, 0.26F + bob, 0.13F, -0.39F, 0.30F + bob, 0.31F, cedar);
        // Floating will-o-wisp orbs
        float o1x = -0.48F + (float)Math.cos(t * 3.0F) * 0.08F;
        float o1y = 0.20F + bob + (float)Math.sin(t * 3.0F) * 0.06F;
        draw3DBox(buf, mat, o1x - 0.02F, o1y - 0.02F, 0.22F - 0.02F, o1x + 0.02F, o1y + 0.02F, 0.22F + 0.02F, 0xFF00FFCC);
    }"""

code = code.replace(old_solos3, new_solos3)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(code)

print("Accessories updated successfully!")
