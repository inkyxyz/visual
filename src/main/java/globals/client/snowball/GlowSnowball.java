package globals.client.snowball;

import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import rockstar.client.iIIiIIiIi_Class294;

public class GlowSnowball
implements iIIiIIiIi_Class294 {
    private Vec3d position;
    private Vec3d prevPosition;
    private final Vec3d direction;
    private final String authorNickname;
    private int age;
    private final int maxAge = 100;
    private boolean alive = true;
    private boolean hit = false;
    private boolean hitLocalPlayer = false;
    private boolean hitBlock = false;
    private Vec3d velocity;
    private static final double SPEED = 1.0;
    private static final double GRAVITY = 0.08;
    private static final double SIZE = 0.15;
    private static final int FADE_IN_TICKS = 5;

    public GlowSnowball(Vec3d vec3d, Vec3d vec3d2, String string) {
        this.position = vec3d;
        this.prevPosition = vec3d;
        this.velocity = this.direction = vec3d2.normalize().multiply(1.0);
        this.authorNickname = string;
    }

    private boolean hasCollision(BlockPos blockPos) {
        if (GlowSnowball.I_field_3a9bda27.world == null) {
            return false;
        }
        BlockState blockState = GlowSnowball.I_field_3a9bda27.world.getBlockState(blockPos);
        VoxelShape voxelShape = blockState.getCollisionShape((BlockView)GlowSnowball.I_field_3a9bda27.world, blockPos);
        return !voxelShape.isEmpty();
    }

    public void tick() {
        ++this.age;
        if (this.age >= 100) {
            this.alive = false;
            return;
        }
        this.prevPosition = this.position;
        this.velocity = this.velocity.add(0.0, -0.08, 0.0);
        Vec3d vec3d = this.position.add(this.velocity);
        BlockPos blockPos = BlockPos.ofFloored((Position)vec3d);
        if (this.hasCollision(blockPos)) {
            this.hitBlock = true;
            this.alive = false;
            return;
        }
        if (GlowSnowball.I_field_3a9bda27.world != null && !this.hit) {
            for (PlayerEntity playerEntity : GlowSnowball.I_field_3a9bda27.world.getPlayers()) {
                Box box;
                if (playerEntity.getName().getString().equals(this.authorNickname) && this.age <= 10 || !(box = playerEntity.getBoundingBox().expand(0.5)).raycast(this.position, vec3d).isPresent() && !box.contains(vec3d)) continue;
                this.hit = true;
                this.hitLocalPlayer = playerEntity == GlowSnowball.I_field_3a9bda27.player;
                this.alive = false;
                return;
            }
        }
        this.position = vec3d;
    }

    public boolean shouldRemove() {
        return !this.alive;
    }

    public boolean didHitPlayer() {
        return this.hit;
    }

    public boolean didHitLocalPlayer() {
        return this.hitLocalPlayer;
    }

    public boolean didHitBlock() {
        return this.hitBlock;
    }

    public float getAlpha() {
        if (this.age < 5) {
            return (float)this.age / 5.0f;
        }
        return 1.0f;
    }

    public boolean isInsideAuthor() {
        if (GlowSnowball.I_field_3a9bda27.player == null) {
            return false;
        }
        if (!GlowSnowball.I_field_3a9bda27.player.getName().getString().equals(this.authorNickname)) {
            return false;
        }
        return GlowSnowball.I_field_3a9bda27.player.getBoundingBox().expand(1.0).contains(this.position);
    }

    public Vec3d getRenderPos(float f) {
        double d = this.prevPosition.getX() + (this.position.getX() - this.prevPosition.getX()) * (double)f;
        double d2 = this.prevPosition.getY() + (this.position.getY() - this.prevPosition.getY()) * (double)f;
        double d3 = this.prevPosition.getZ() + (this.position.getZ() - this.prevPosition.getZ()) * (double)f;
        return new Vec3d(d, d2, d3);
    }

    public Box getRenderBox(float f) {
        Vec3d vec3d = this.getRenderPos(f);
        return new Box(vec3d.x - 0.15, vec3d.y - 0.15, vec3d.z - 0.15, vec3d.x + 0.15, vec3d.y + 0.15, vec3d.z + 0.15);
    }

    @Generated
    public Vec3d getPosition() {
        return this.position;
    }

    @Generated
    public Vec3d getPrevPosition() {
        return this.prevPosition;
    }

    @Generated
    public Vec3d getDirection() {
        return this.direction;
    }

    @Generated
    public String getAuthorNickname() {
        return this.authorNickname;
    }

    @Generated
    public int getAge() {
        return this.age;
    }

    @Generated
    public int getMaxAge() {
        return this.maxAge;
    }

    @Generated
    public boolean isAlive() {
        return this.alive;
    }

    @Generated
    public boolean isHit() {
        return this.hit;
    }

    @Generated
    public boolean isHitLocalPlayer() {
        return this.hitLocalPlayer;
    }

    @Generated
    public boolean isHitBlock() {
        return this.hitBlock;
    }

    @Generated
    public Vec3d getVelocity() {
        return this.velocity;
    }
}

