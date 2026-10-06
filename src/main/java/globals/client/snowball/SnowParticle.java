package globals.client.snowball;

import java.util.Random;
import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import rockstar.client.iIIiIIiIi_Class294;

public class SnowParticle
implements iIIiIIiIi_Class294 {
    private static final Random random = new Random();
    private static final double GRAVITY = 0.04;
    private static final double FRICTION = 0.98;
    private static final double BOUNCE = 0.3;
    private static final double PARTICLE_RADIUS = 0.05;
    private Vec3d position;
    private Vec3d prevPosition;
    private Vec3d velocity;
    private int age;
    private final int maxAge;
    private boolean alive = true;

    public SnowParticle(Vec3d vec3d, Vec3d vec3d2, double d) {
        this.position = vec3d;
        this.prevPosition = vec3d;
        double d2 = (random.nextDouble() - 0.5) * 0.3;
        double d3 = (random.nextDouble() - 0.5) * 0.3;
        double d4 = (random.nextDouble() - 0.5) * 0.3;
        this.velocity = vec3d2.multiply(0.5 + random.nextDouble() * 0.5).add(d2, d3 + 0.1, d4);
        this.maxAge = 60 + random.nextInt(40);
    }

    private boolean hasCollision(BlockPos blockPos) {
        if (SnowParticle.I_field_3a9bda27.world == null) {
            return false;
        }
        BlockState blockState = SnowParticle.I_field_3a9bda27.world.getBlockState(blockPos);
        VoxelShape voxelShape = blockState.getCollisionShape((BlockView)SnowParticle.I_field_3a9bda27.world, blockPos);
        return !voxelShape.isEmpty();
    }

    public void tick() {
        ++this.age;
        if (this.age >= this.maxAge) {
            this.alive = false;
            return;
        }
        this.prevPosition = this.position;
        this.velocity = this.velocity.add(0.0, -0.04, 0.0);
        this.velocity = this.velocity.multiply(0.98);
        double d = this.position.x + this.velocity.x;
        double d2 = this.position.y + this.velocity.y;
        double d3 = this.position.z + this.velocity.z;
        if (SnowParticle.I_field_3a9bda27.world != null) {
            BlockPos blockPos;
            BlockPos blockPos2;
            BlockPos blockPos3 = BlockPos.ofFloored((double)d, (double)(d2 - 0.05), (double)d3);
            if (this.velocity.y <= 0.0 && this.hasCollision(blockPos3)) {
                double d4;
                d2 = d4 = (double)blockPos3.getY() + 1.0 + 0.05;
                this.velocity = Math.abs(this.velocity.y) > 0.02 ? new Vec3d(this.velocity.x * 0.8, Math.abs(this.velocity.y) * 0.3, this.velocity.z * 0.8) : new Vec3d(this.velocity.x * 0.5, 0.0, this.velocity.z * 0.5);
            }
            BlockPos blockPos4 = BlockPos.ofFloored((double)d, (double)(d2 + 0.05), (double)d3);
            if (this.velocity.y > 0.0 && this.hasCollision(blockPos4)) {
                double d5;
                d2 = d5 = (double)blockPos4.getY() - 0.05;
                this.velocity = new Vec3d(this.velocity.x, -Math.abs(this.velocity.y) * 0.3, this.velocity.z);
            }
            if (this.hasCollision(blockPos2 = BlockPos.ofFloored((double)(d + Math.signum(this.velocity.x) * 0.05), (double)this.position.y, (double)this.position.z))) {
                d = this.position.x;
                this.velocity = new Vec3d(-this.velocity.x * 0.3, this.velocity.y, this.velocity.z);
            }
            if (this.hasCollision(blockPos = BlockPos.ofFloored((double)this.position.x, (double)this.position.y, (double)(d3 + Math.signum(this.velocity.z) * 0.05)))) {
                d3 = this.position.z;
                this.velocity = new Vec3d(this.velocity.x, this.velocity.y, -this.velocity.z * 0.3);
            }
        }
        this.position = new Vec3d(d, d2, d3);
    }

    public boolean shouldRemove() {
        return !this.alive;
    }

    public Vec3d getRenderPos(float f) {
        double d = this.prevPosition.getX() + (this.position.getX() - this.prevPosition.getX()) * (double)f;
        double d2 = this.prevPosition.getY() + (this.position.getY() - this.prevPosition.getY()) * (double)f;
        double d3 = this.prevPosition.getZ() + (this.position.getZ() - this.prevPosition.getZ()) * (double)f;
        return new Vec3d(d, d2, d3);
    }

    public float getAlpha() {
        float f = (float)this.age / (float)this.maxAge;
        if (f > 0.7f) {
            return 1.0f - (f - 0.7f) / 0.3f;
        }
        return 1.0f;
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
    public Vec3d getVelocity() {
        return this.velocity;
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
}

