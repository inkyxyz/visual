package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientChunkManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.NotNull;
import pyrock.events.game.AncientDebrisEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.RegistryListSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIiiIIiIi_Class358;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="XRay", category=ModuleCategory.VISUALS, III_method_a89e5834="modules.descriptions.xray")
public class XRayModule
extends Module {
    private final Set<BlockPos> I_field_a56a8dc5 = ConcurrentHashMap.newKeySet();
    private RegistryListSetting I_field_ba20c66c;
    private static final Map<Block, ColorRGBA> I_field_a567c40b = new HashMap<Block, ColorRGBA>();
    private final Map<BlockPos, Long> i_field_a567c40b = new ConcurrentHashMap<BlockPos, Long>();
    private static final List<Block> I_field_7865b31 = List.of(Blocks.ANCIENT_DEBRIS, Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE, Blocks.NETHER_QUARTZ_ORE);
    private int I_field_49 = 0;
    private int i_field_49 = 0;
    private int II_field_49 = 0;
    private int Ii_field_49 = 0;
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> {
        if (XRayModule.I_field_3a9bda27.world == null || XRayModule.I_field_3a9bda27.player == null) {
            return;
        }
        MatrixStack matrixStack = render3DEvent.getMatrices();
        Camera camera = XRayModule.I_field_3a9bda27.gameRenderer.getCamera();
        Vec3d vec3d = camera.getPos();
        matrixStack.push();
        matrixStack.translate(-vec3d.getX(), -vec3d.getY(), -vec3d.getZ());
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.SRC_ALPHA, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE);
        RenderSystem.lineWidth((float)10.0f);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        double d = 999999.0;
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        for (BlockPos blockPos : this.I_field_a56a8dc5) {
            if (XRayModule.I_field_3a9bda27.player.squaredDistanceTo(blockPos.toCenterPos()) > d) continue;
            Box box = this.I_method_2f20eaad(blockPos);
            Block block = XRayModule.I_field_3a9bda27.world.getBlockState(blockPos).getBlock();
            if (block != Blocks.ANCIENT_DEBRIS && this.I_method_9084a19d(blockPos)) {
                block = Blocks.ANCIENT_DEBRIS;
            }
            iIiiIIiIi_Class358.i_method_5e35f7b9(render3DEvent.getMatrices(), bufferBuilder, box, this.I_method_7bd9743a(block).withAlpha(30.0f));
        }
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        matrixStack.pop();
    };
    private final IiIIIiII_Class69<WorldChangeEvent> i_field_3d936f41 = worldChangeEvent -> {
        this.I_field_a56a8dc5.clear();
        this.i_field_a567c40b.clear();
    };
    private final IiIIIiII_Class69<AncientDebrisEvent> II_field_3d936f41 = ancientDebrisEvent -> {
        if (!this.IiI_method_bba0ea63() || !this.I_field_ba20c66c.I_method_bcc5858f(Blocks.ANCIENT_DEBRIS)) {
            return;
        }
        long l = System.currentTimeMillis() + 12000L;
        for (BlockPos blockPos : ancientDebrisEvent.getPositions()) {
            BlockPos blockPos2 = blockPos.toImmutable();
            this.i_field_a567c40b.put(blockPos2, l);
            this.I_field_a56a8dc5.add(blockPos2);
        }
    };

    @Compile(obfuscation=4)
    private void IiI_method_bba0ea5f() {
        this.I_field_ba20c66c = new RegistryListSetting(this, "modules.settings.xray.big_block");
    }

    public XRayModule() {
        this.IiI_method_bba0ea5f();
        this.iiI_method_f23bfe3f();
    }

    public void I_method_216ef8a0(WorldChunk worldChunk) {
        if (XRayModule.I_field_3a9bda27.world == null || worldChunk == null) {
            return;
        }
        int n = worldChunk.getPos().getStartX();
        int n2 = worldChunk.getPos().getStartZ();
        for (int i = 0; i < 16; ++i) {
            for (int j = XRayModule.I_field_3a9bda27.world.getBottomY(); j < XRayModule.I_field_3a9bda27.world.getTopYInclusive(); ++j) {
                for (int k = 0; k < 16; ++k) {
                    BlockPos blockPos = new BlockPos(n + i, j, n2 + k);
                    BlockState blockState = worldChunk.getBlockState(blockPos);
                    if (blockState.isAir() || !this.I_method_3157f9cf(blockState.getBlock())) continue;
                    this.I_field_a56a8dc5.add(blockPos);
                }
            }
        }
    }

    @Override
    public void onEnable() {
        if (!IiiiiiiII_Class253.i_method_1cc4aa23()) {
            return;
        }
        this.iiI_method_f23bfe3f();
        this.I_field_a56a8dc5.clear();
        ClientChunkManager clientChunkManager = XRayModule.I_field_3a9bda27.world.getChunkManager();
        int n = XRayModule.I_field_3a9bda27.options != null ? (Integer)XRayModule.I_field_3a9bda27.options.getViewDistance().getValue() : 8;
        Runnable runnable = this.I_method_5f26730f(n, clientChunkManager);
        if (I_field_3a9bda27.isOnThread()) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
        } else {
            runnable.run();
        }
        super.onEnable();
    }

    @NotNull
    private Runnable I_method_5f26730f(int n, ClientChunkManager clientChunkManager) {
        int n2 = Math.max(1, n);
        int n3 = XRayModule.I_field_3a9bda27.player.getChunkPos().x;
        int n4 = XRayModule.I_field_3a9bda27.player.getChunkPos().z;
        Runnable runnable = () -> {
            for (int i = -n2; i <= n2; ++i) {
                for (int j = -n2; j <= n2; ++j) {
                    WorldChunk worldChunk = clientChunkManager.getChunk(n3 + i, n4 + j, ChunkStatus.FULL, false);
                    if (worldChunk == null) continue;
                    this.I_method_216ef8a0(worldChunk);
                }
            }
        };
        return runnable;
    }

    @Override
    public void onDisable() {
        this.I_field_a56a8dc5.clear();
        this.i_field_a567c40b.clear();
        this.I_field_49 = 0;
        this.i_field_49 = 0;
        this.II_field_49 = 0;
        this.Ii_field_49 = 0;
        super.onDisable();
    }

    @Override
    public void II_method_6642fd22() {
        this.iIi_method_f08799ff();
        this.iII_method_f0790e1f();
        this.Iii_method_bbaf763f();
        super.II_method_6642fd22();
    }

    private void Iii_method_bbaf763f() {
        this.I_field_a56a8dc5.removeIf(blockPos -> !this.i_method_bad8357d((BlockPos)blockPos));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void iII_method_f0790e1f() {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        Set<BlockPos> set = this.I_field_a56a8dc5;
        synchronized (set) {
            for (BlockPos blockPos : this.I_field_a56a8dc5) {
                Block block = XRayModule.I_field_3a9bda27.world.getBlockState(blockPos).getBlock();
                if (block == Blocks.DIAMOND_ORE && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.DIAMOND_ORE)) {
                    ++n;
                    continue;
                }
                if (block == Blocks.ANCIENT_DEBRIS) {
                    ++n2;
                    continue;
                }
                if (block == Blocks.GOLD_ORE && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.GOLD_ORE)) {
                    ++n3;
                    continue;
                }
                if (block != Blocks.LAPIS_ORE || !this.I_field_ba20c66c.I_method_bcc5858f(Blocks.LAPIS_ORE)) continue;
                ++n4;
            }
        }
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.II_field_49 = n3;
        this.Ii_field_49 = n4;
    }

    public boolean I_method_3157f9cf(Block block) {
        return this.I_field_ba20c66c.I_method_bcc5858f(block);
    }

    private ColorRGBA I_method_7bd9743a(Block block) {
        return I_field_a567c40b.getOrDefault(block, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
    }

    private boolean i_method_bad8357d(BlockPos blockPos) {
        if (XRayModule.I_field_3a9bda27.player == null || XRayModule.I_field_3a9bda27.options == null) {
            return false;
        }
        int n = (Integer)XRayModule.I_field_3a9bda27.options.getViewDistance().getValue();
        double d = (double)Math.max(1, n + 1) * 16.0;
        double d2 = d * d;
        return XRayModule.I_field_3a9bda27.player.squaredDistanceTo(Vec3d.ofCenter((Vec3i)blockPos)) <= d2;
    }

    public boolean IiI_method_bba0ea63() {
        if (XRayModule.I_field_3a9bda27.world == null) {
            return false;
        }
        if (XRayModule.I_field_3a9bda27.world.getRegistryKey() != World.NETHER) {
            return false;
        }
        return iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c) || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c);
    }

    public boolean I_method_9084a19d(BlockPos blockPos) {
        return this.i_field_a567c40b.containsKey(blockPos);
    }

    private void iIi_method_f08799ff() {
        if (this.i_field_a567c40b.isEmpty()) {
            return;
        }
        long l = System.currentTimeMillis();
        this.i_field_a567c40b.entrySet().removeIf(entry -> {
            if ((Long)entry.getValue() <= l) {
                this.I_field_a56a8dc5.remove(entry.getKey());
                return true;
            }
            return false;
        });
    }

    private Box I_method_2f20eaad(BlockPos blockPos) {
        BlockState blockState = XRayModule.I_field_3a9bda27.world.getBlockState(blockPos);
        VoxelShape voxelShape = blockState.getOutlineShape((BlockView)XRayModule.I_field_3a9bda27.world, blockPos);
        if (voxelShape.isEmpty()) {
            return new Box(0.0, 0.0, 0.0, 1.0, 1.0, 1.0).offset(blockPos);
        }
        return voxelShape.getBoundingBox().offset(blockPos);
    }

    private static void I_method_ee3d0a14(Block block, ColorRGBA colorRGBA) {
        I_field_a567c40b.put(block, colorRGBA);
    }

    private void iiI_method_f23bfe3f() {
        if (this.I_field_ba20c66c.I_method_608ed612() > 0) {
            return;
        }
        I_field_7865b31.forEach(this.I_field_ba20c66c::i_method_8a3a381);
    }

    private static boolean i_method_ce7101ef(Block block) {
        return block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE;
    }

    private static boolean II_method_7c17406c(Block block) {
        return block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.NETHER_GOLD_ORE;
    }

    private static boolean Ii_method_1930488c(Block block) {
        return block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE;
    }

    @Generated
    public Set<BlockPos> I_method_336cb38e() {
        return this.I_field_a56a8dc5;
    }

    @Generated
    public RegistryListSetting I_method_89f386b5() {
        return this.I_field_ba20c66c;
    }

    @Generated
    public int II_method_e4f62955() {
        return this.I_field_49;
    }

    @Generated
    public int Ii_method_e504b535() {
        return this.i_field_49;
    }

    @Generated
    public int iI_method_e6b91975() {
        return this.II_field_49;
    }

    @Generated
    public int ii_method_e6c7a555() {
        return this.Ii_field_49;
    }

    static {
        XRayModule.I_method_ee3d0a14(Blocks.ANCIENT_DEBRIS, new ColorRGBA(255.0f, 131.0f, 54.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DIAMOND_ORE, new ColorRGBA(121.0f, 54.0f, 255.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DEEPSLATE_DIAMOND_ORE, new ColorRGBA(145.0f, 92.0f, 255.0f));
        XRayModule.I_method_ee3d0a14(Blocks.EMERALD_ORE, new ColorRGBA(80.0f, 255.0f, 140.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DEEPSLATE_EMERALD_ORE, new ColorRGBA(64.0f, 214.0f, 119.0f));
        XRayModule.I_method_ee3d0a14(Blocks.GOLD_ORE, new ColorRGBA(255.0f, 215.0f, 0.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DEEPSLATE_GOLD_ORE, new ColorRGBA(255.0f, 191.0f, 0.0f));
        XRayModule.I_method_ee3d0a14(Blocks.NETHER_GOLD_ORE, new ColorRGBA(255.0f, 203.0f, 96.0f));
        XRayModule.I_method_ee3d0a14(Blocks.IRON_ORE, new ColorRGBA(210.0f, 210.0f, 210.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DEEPSLATE_IRON_ORE, new ColorRGBA(180.0f, 180.0f, 180.0f));
        XRayModule.I_method_ee3d0a14(Blocks.LAPIS_ORE, new ColorRGBA(0.0f, 71.0f, 179.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DEEPSLATE_LAPIS_ORE, new ColorRGBA(21.0f, 92.0f, 200.0f));
        XRayModule.I_method_ee3d0a14(Blocks.REDSTONE_ORE, new ColorRGBA(255.0f, 64.0f, 64.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DEEPSLATE_REDSTONE_ORE, new ColorRGBA(214.0f, 48.0f, 48.0f));
        XRayModule.I_method_ee3d0a14(Blocks.COPPER_ORE, new ColorRGBA(255.0f, 140.0f, 80.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DEEPSLATE_COPPER_ORE, new ColorRGBA(235.0f, 120.0f, 68.0f));
        XRayModule.I_method_ee3d0a14(Blocks.COAL_ORE, new ColorRGBA(84.0f, 84.0f, 84.0f));
        XRayModule.I_method_ee3d0a14(Blocks.DEEPSLATE_COAL_ORE, new ColorRGBA(64.0f, 64.0f, 64.0f));
        XRayModule.I_method_ee3d0a14(Blocks.NETHER_QUARTZ_ORE, new ColorRGBA(233.0f, 233.0f, 233.0f));
    }
}

