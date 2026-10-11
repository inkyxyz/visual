package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class AIAssistantScreen extends ii_Class4 {

    private final Screen parentScreen;
    private String inputPrompt = "";
    private boolean isThinking = false;
    private float scrollOffset = 0.0F;

    private static final String[] QUICK_PROMPTS = {
        "Какая броня лучше против кристаллов?",
        "Как сварить зелье силы 2?",
        "Тактика PvP на мечах",
        "Топ чары на элитры и кирку",
        "Где найти незерит быстрее всего?"
    };

    public AIAssistantScreen(Screen parent) {
        this.parentScreen = parent;
    }

    public AIAssistantScreen() {
        this(null);
    }

    @Override
    public void render(III custom) {
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;

        // Dark frosted backdrop
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(10.0F, 14.0F, 22.0F, 185.0F));

        IIiIIi_Class10 font = null;
        IIiIIi_Class10 boldFont = null;
        IIiIIi_Class10 subFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.5F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
            }
        } catch (Throwable ignored) {}

        // Main Frosted Semi-Glass Container Card
        float cardW = Math.min(560.0F, this.width - 40.0F);
        float cardH = Math.min(380.0F, this.height - 40.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(14.0F);

        custom.drawShadow(cardX, cardY, cardW, cardH, 20.0F, cRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F));
        custom.drawBlurredRect(cardX, cardY, cardW, cardH, 22.0F, 3.0F, cRad, new ColorRGBA(59.0F, 130.0F, 246.0F, 28.0F));
        custom.drawRoundedRect(cardX, cardY, cardW, cardH, cRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 230.0F));
        custom.drawRoundedBorder(cardX, cardY, cardW, cardH, 1.2F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        // Header
        float hY = cardY + 12.0F;
        if (boldFont != null) {
            custom.drawText(boldFont, "✦ Gemini 3.5 Flash-Lite — ИИ Ассистент", cardX + 16.0F, hY + 1.0F, ColorRGBA.WHITE);
        }

        // Close Button [✕]
        float closeW = 24.0F;
        float closeX = cardX + cardW - closeW - 14.0F;
        float closeY = hY - 2.0F;
        boolean closeHov = (custom.I_method_b1c3e152() >= closeX && custom.I_method_b1c3e152() <= closeX + closeW && custom.i_method_b1d26d32() >= closeY && custom.i_method_b1d26d32() <= closeY + closeW);
        custom.drawRoundedRect(closeX, closeY, closeW, closeW, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(239.0F, 68.0F, 68.0F, closeHov ? 240.0F : 140.0F));
        if (font != null) {
            custom.drawText(font, "✕", closeX + 8.0F, closeY + 6.0F, ColorRGBA.WHITE);
        }

        // Clear Chat Button [🗑 Очистить]
        float clrW = 76.0F;
        float clrX = closeX - clrW - 8.0F;
        boolean clrHov = (custom.I_method_b1c3e152() >= clrX && custom.I_method_b1c3e152() <= clrX + clrW && custom.i_method_b1d26d32() >= closeY && custom.i_method_b1d26d32() <= closeY + closeW);
        custom.drawRoundedRect(clrX, closeY, clrW, closeW, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(55.0F, 65.0F, 81.0F, clrHov ? 240.0F : 180.0F));
        custom.drawRoundedBorder(clrX, closeY, clrW, closeW, 1.0F, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
        if (subFont != null) {
            custom.drawText(subFont, "🗑 Очистить", clrX + 8.0F, closeY + 7.5F, ColorRGBA.WHITE);
        }

        // Subtitle divider
        float divY = cardY + 38.0F;
        custom.drawRect(cardX + 16.0F, divY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        // Chat Area Bounds
        float chatX = cardX + 16.0F;
        float chatY = divY + 6.0F;
        float chatW = cardW - 32.0F;
        float chatH = cardH - 120.0F;

        // Render Chat History Bubbles
        List<AIAssistantService.ChatMessage> history = AIAssistantService.getHistory();
        float curY = chatY + 6.0F - this.scrollOffset;

        if (history.isEmpty()) {
            if (subFont != null) {
                String welcome = "Задайте любой вопрос об игре, тактиках или крафтах. Или выберите быстрый вопрос ниже:";
                custom.drawText(subFont, welcome, chatX + (chatW - subFont.I_method_2c375926(welcome)) / 2.0F, chatY + 30.0F, new ColorRGBA(160.0F, 175.0F, 205.0F, 200.0F));
            }

            // Quick Prompt Chips
            float qY = chatY + 56.0F;
            float qH = 22.0F;
            for (String q : QUICK_PROMPTS) {
                if (subFont != null) {
                    float qw = subFont.I_method_2c375926(q) + 16.0F;
                    float qx = chatX + (chatW - qw) / 2.0F;
                    boolean qHov = (custom.I_method_b1c3e152() >= qx && custom.I_method_b1c3e152() <= qx + qw && custom.i_method_b1d26d32() >= qY && custom.i_method_b1d26d32() <= qY + qH);
                    custom.drawRoundedRect(qx, qY, qw, qH, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(30.0F, 41.0F, 59.0F, qHov ? 255.0F : 190.0F));
                    custom.drawRoundedBorder(qx, qY, qw, qH, 1.0F, IIiii_Class8.I_method_893b2757(6.0F), qHov ? new ColorRGBA(59.0F, 130.0F, 246.0F, 230.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
                    custom.drawText(subFont, q, qx + 8.0F, qY + 6.5F, qHov ? ColorRGBA.WHITE : new ColorRGBA(200.0F, 215.0F, 240.0F, 220.0F));
                    qY += qH + 6.0F;
                }
            }
        } else {
            for (AIAssistantService.ChatMessage msg : history) {
                boolean isUser = msg.isUser();
                List<String> lines = wrapText(msg.text(), chatW - 60.0F, subFont);
                float bH = Math.max(24.0F, lines.size() * 11.0F + 12.0F);

                float bX = isUser ? (chatX + chatW - (chatW * 0.72F)) : chatX;
                float bW = chatW * 0.72F;

                if (curY + bH >= chatY && curY <= chatY + chatH) {
                    ColorRGBA bgCol = isUser ? new ColorRGBA(37.0F, 99.0F, 235.0F, 220.0F) : new ColorRGBA(30.0F, 41.0F, 59.0F, 215.0F);
                    IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(8.0F);
                    custom.drawRoundedRect(bX, curY, bW, bH, bRad, bgCol);
                    custom.drawRoundedBorder(bX, curY, bW, bH, 1.0F, bRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

                    if (subFont != null) {
                        float lineY = curY + 6.0F;
                        for (String l : lines) {
                            custom.drawText(subFont, l, bX + 8.0F, lineY, ColorRGBA.WHITE);
                            lineY += 11.0F;
                        }
                    }
                }
                curY += bH + 6.0F;
            }

            if (this.isThinking) {
                float thinkW = 140.0F;
                float thinkH = 22.0F;
                if (curY + thinkH >= chatY && curY <= chatY + chatH) {
                    custom.drawRoundedRect(chatX, curY, thinkW, thinkH, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(30.0F, 41.0F, 59.0F, 215.0F));
                    if (subFont != null) {
                        String dots = "...".substring(0, (int)(System.currentTimeMillis() / 350L % 4L));
                        custom.drawText(subFont, "ИИ думает" + dots, chatX + 8.0F, curY + 6.5F, new ColorRGBA(59.0F, 130.0F, 246.0F, 255.0F));
                    }
                }
            }
        }

        // --- BOTTOM INPUT BAR ---
        float inY = cardY + cardH - 42.0F;
        float inH = 30.0F;
        float sendW = 60.0F;
        float inW = cardW - 32.0F - sendW - 8.0F;
        float inX = cardX + 16.0F;

        IIiii_Class8 inRad = IIiii_Class8.I_method_893b2757(8.0F);
        custom.drawRoundedRect(inX, inY, inW, inH, inRad, new ColorRGBA(22.0F, 28.0F, 42.0F, 240.0F));
        custom.drawRoundedBorder(inX, inY, inW, inH, 1.2F, inRad, new ColorRGBA(59.0F, 130.0F, 246.0F, 160.0F));

        if (font != null) {
            String promptDisp = this.inputPrompt.isEmpty() ? "Задайте вопрос нейросети (Enter для отправки)..." : this.inputPrompt;
            if (System.currentTimeMillis() % 1000L < 500L) promptDisp += "|";
            ColorRGBA col = this.inputPrompt.isEmpty() ? new ColorRGBA(255.0F, 255.0F, 255.0F, 130.0F) : ColorRGBA.WHITE;
            custom.drawText(font, promptDisp, inX + 10.0F, inY + 9.5F, col);
        }

        // Send Button [▶]
        float sendX = inX + inW + 8.0F;
        boolean sendHov = (custom.I_method_b1c3e152() >= sendX && custom.I_method_b1c3e152() <= sendX + sendW && custom.i_method_b1d26d32() >= inY && custom.i_method_b1d26d32() <= inY + inH);
        custom.drawRoundedRect(sendX, inY, sendW, inH, inRad, new ColorRGBA(37.0F, 99.0F, 235.0F, sendHov ? 255.0F : 210.0F));
        custom.drawRoundedBorder(sendX, inY, sendW, inH, 1.0F, inRad, ColorRGBA.WHITE.withAlpha(sendHov ? 255.0F : 120.0F));
        if (font != null) {
            custom.drawText(font, "Отправить", sendX + 6.0F, inY + 9.5F, ColorRGBA.WHITE);
        }
    }

    private static List<String> wrapText(String text, float maxW, IIiIIi_Class10 font) {
        List<String> res = new ArrayList<>();
        if (font == null || text == null) {
            res.add(text != null ? text : "");
            return res;
        }
        String[] paragraphs = text.split("\n");
        for (String p : paragraphs) {
            String[] words = p.split(" ");
            StringBuilder line = new StringBuilder();
            for (String w : words) {
                String candidate = line.isEmpty() ? w : (line + " " + w);
                if (font.I_method_2c375926(candidate) > maxW && !line.isEmpty()) {
                    res.add(line.toString());
                    line = new StringBuilder(w);
                } else {
                    line = new StringBuilder(candidate);
                }
            }
            if (!line.isEmpty()) res.add(line.toString());
        }
        return res;
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        if (button != IiIII_Class9.I_field_2f4c8d6c) return;

        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;
        float cardW = Math.min(560.0F, this.width - 40.0F);
        float cardH = Math.min(380.0F, this.height - 40.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;

        // 1. Close Button
        float closeW = 24.0F;
        float closeX = cardX + cardW - closeW - 14.0F;
        float closeY = cardY + 10.0F;
        if (mouseX >= closeX && mouseX <= closeX + closeW && mouseY >= closeY && mouseY <= closeY + closeW) {
            UISoundManager.playButtonClick();
            this.close();
            return;
        }

        // 2. Clear Button
        float clrW = 76.0F;
        float clrX = closeX - clrW - 8.0F;
        if (mouseX >= clrX && mouseX <= clrX + clrW && mouseY >= closeY && mouseY <= closeY + closeW) {
            UISoundManager.playButtonClick();
            AIAssistantService.clearHistory();
            this.scrollOffset = 0.0F;
            return;
        }

        // 3. Quick Prompts Click
        if (AIAssistantService.getHistory().isEmpty()) {
            float chatX = cardX + 16.0F;
            float chatW = cardW - 32.0F;
            float qY = cardY + 100.0F;
            float qH = 22.0F;

            IIiIIi_Class10 subFont = null;
            try {
                if (IIiIiI_Class11.i_field_857c0621 != null) {
                    subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
                }
            } catch (Throwable ignored) {}

            for (String q : QUICK_PROMPTS) {
                if (subFont != null) {
                    float qw = subFont.I_method_2c375926(q) + 16.0F;
                    float qx = chatX + (chatW - qw) / 2.0F;
                    if (mouseX >= qx && mouseX <= qx + qw && mouseY >= qY && mouseY <= qY + qH) {
                        UISoundManager.playButtonClick();
                        sendPrompt(q);
                        return;
                    }
                    qY += qH + 6.0F;
                }
            }
        }

        // 4. Send Button Click
        float inY = cardY + cardH - 42.0F;
        float inH = 30.0F;
        float sendW = 60.0F;
        float sendX = cardX + cardW - 16.0F - sendW;
        if (mouseX >= sendX && mouseX <= sendX + sendW && mouseY >= inY && mouseY <= inY + inH) {
            if (!this.inputPrompt.trim().isEmpty() && !this.isThinking) {
                UISoundManager.playButtonClick();
                sendPrompt(this.inputPrompt.trim());
                this.inputPrompt = "";
            }
            return;
        }
    }

    private void sendPrompt(String text) {
        this.isThinking = true;
        this.scrollOffset = Math.max(0.0F, this.scrollOffset + 50.0F);
        AIAssistantService.sendMessageAsync(text, reply -> {
            this.isThinking = false;
        });
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        this.scrollOffset = Math.max(0.0F, this.scrollOffset - (float)verticalAmount * 18.0F);
        return true;
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (chr >= 32 && chr != 127) {
            this.inputPrompt += chr;
            return true;
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            this.close();
            return true;
        }
        if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !this.inputPrompt.isEmpty()) {
            this.inputPrompt = this.inputPrompt.substring(0, this.inputPrompt.length() - 1);
            return true;
        }
        if ((keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) && !this.inputPrompt.trim().isEmpty() && !this.isThinking) {
            UISoundManager.playButtonClick();
            sendPrompt(this.inputPrompt.trim());
            this.inputPrompt = "";
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(this.parentScreen);
        }
    }
}
