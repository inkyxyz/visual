package rockstar.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pyrock.utility.render.ColorRGBA;

public class ClickBubbleEffect {
    private static class Spark {
        final float angle;
        final float speed;
        final float size;

        Spark(float angle, float speed, float size) {
            this.angle = angle;
            this.speed = speed;
            this.size = size;
        }
    }

    private static class Bubble {
        final float x;
        final float y;
        final long startTime;
        final float maxRadius;
        final float duration;
        final ColorRGBA color;
        final List<Spark> sparks = new ArrayList<>();

        Bubble(float x, float y, float maxRadius, ColorRGBA color) {
            this.x = x;
            this.y = y;
            this.startTime = System.currentTimeMillis();
            this.maxRadius = maxRadius;
            this.duration = 460.0F;
            this.color = color != null ? color : new ColorRGBA(171.0F, 254.0F, 255.0F, 255.0F);

            // Generate burst droplet sparks
            int sparkCount = 7;
            for (int i = 0; i < sparkCount; i++) {
                float angle = (float) (i * (Math.PI * 2.0 / sparkCount) + (Math.random() - 0.5) * 0.4);
                float speed = (float) (0.85 + Math.random() * 0.45);
                float size = (float) (1.2 + Math.random() * 1.5);
                this.sparks.add(new Spark(angle, speed, size));
            }
        }
    }

    private final List<Bubble> bubbles = new ArrayList<>();

    public void addBubble(float x, float y, ColorRGBA color) {
        if (this.bubbles.size() > 24) {
            this.bubbles.remove(0);
        }
        this.bubbles.add(new Bubble(x, y, 38.0F, color));
    }

    public void render(III context) {
        if (this.bubbles.isEmpty() || context == null) {
            return;
        }

        long now = System.currentTimeMillis();
        Iterator<Bubble> it = this.bubbles.iterator();

        while (it.hasNext()) {
            Bubble b = it.next();
            float elapsed = (float) (now - b.startTime);
            if (elapsed >= b.duration) {
                it.remove();
                continue;
            }

            float progress = Math.min(1.0F, elapsed / b.duration);
            // Ease-out cubic for realistic fluid expansion
            float ease = 1.0F - (float) Math.pow(1.0F - progress, 3.0);
            float currentRadius = Math.max(1.0F, b.maxRadius * ease);
            float alpha = (1.0F - progress);

            // 1. Soft inner fluid tint
            float fillAlpha = 45.0F * alpha * (1.0F - progress * 0.6F);
            context.drawRoundedRect(
                b.x - currentRadius,
                b.y - currentRadius,
                currentRadius * 2.0F,
                currentRadius * 2.0F,
                IIiii_Class8.I_method_893b2757(currentRadius),
                b.color.withAlpha(fillAlpha)
            );

            // 2. Diffuse neon glow bloom
            float glowAlpha = 70.0F * alpha * (1.0F - progress * 0.4F);
            context.drawBlurredRect(
                b.x - currentRadius,
                b.y - currentRadius,
                currentRadius * 2.0F,
                currentRadius * 2.0F,
                10.0F,
                IIiii_Class8.I_method_893b2757(currentRadius),
                b.color.withAlpha(glowAlpha)
            );

            // 3. Primary expanding liquid shockwave ring
            float ringThickness = Math.max(1.0F, 2.2F * (1.0F - progress * 0.6F));
            context.drawRoundedBorder(
                b.x - currentRadius,
                b.y - currentRadius,
                currentRadius * 2.0F,
                currentRadius * 2.0F,
                ringThickness,
                IIiii_Class8.I_method_893b2757(currentRadius),
                b.color.withAlpha(220.0F * alpha)
            );

            // 4. Inner specular highlight crest
            if (currentRadius > 8.0F) {
                float innerR = currentRadius * 0.68F;
                context.drawRoundedBorder(
                    b.x - innerR,
                    b.y - innerR,
                    innerR * 2.0F,
                    innerR * 2.0F,
                    1.0F,
                    IIiii_Class8.I_method_893b2757(innerR),
                    ColorRGBA.WHITE.withAlpha(120.0F * alpha)
                );
            }

            // 5. Radial bursting droplet sparks
            for (Spark sp : b.sparks) {
                float dist = currentRadius * 1.12F * sp.speed;
                float sx = b.x + (float) Math.cos(sp.angle) * dist;
                float sy = b.y + (float) Math.sin(sp.angle) * dist;
                float sparkAlpha = 230.0F * alpha * (1.0F - progress * 0.5F);

                context.drawRoundedRect(
                    sx - sp.size / 2.0F,
                    sy - sp.size / 2.0F,
                    sp.size,
                    sp.size,
                    IIiii_Class8.I_method_893b2757(sp.size / 2.0F),
                    b.color.withAlpha(sparkAlpha)
                );
            }
        }
    }
}
