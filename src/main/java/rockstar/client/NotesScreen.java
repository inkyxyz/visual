package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class NotesScreen extends ii_Class4 {

    private final Screen parentScreen;
    private NotesManager.Note selectedNote = null;

    private String editTitle = "";
    private String editContent = "";
    private String editCords = "";
    private boolean editingTitle = false;
    private boolean editingContent = false;

    private float listScroll = 0.0F;

    public NotesScreen(Screen parent) {
        this.parentScreen = parent;
        List<NotesManager.Note> notes = NotesManager.getNotes();
        if (!notes.isEmpty()) {
            selectNote(notes.get(0));
        }
    }

    public NotesScreen() {
        this(null);
    }

    private void selectNote(NotesManager.Note note) {
        this.selectedNote = note;
        if (note != null) {
            this.editTitle = note.title;
            this.editContent = note.content;
            this.editCords = note.cords != null ? note.cords : "";
        } else {
            this.editTitle = "";
            this.editContent = "";
            this.editCords = "";
        }
    }

    private void saveCurrentNote() {
        if (this.selectedNote != null) {
            NotesManager.updateNote(this.selectedNote.id, this.editTitle, this.editContent, this.editCords);
        }
    }

    private void insertPlayerCoordinates() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) {
            BlockPos pos = mc.player.getBlockPos();
            String dim = "Верхний мир";
            if (mc.world != null) {
                if (mc.world.getRegistryKey() == World.NETHER) dim = "Незер";
                else if (mc.world.getRegistryKey() == World.END) dim = "Энд";
            }
            String cordStr = String.format("X: %d, Y: %d, Z: %d | %s", pos.getX(), pos.getY(), pos.getZ(), dim);
            this.editCords = cordStr;

            String snippet = (this.editContent.isEmpty() ? "" : "\n") + "[📍 " + cordStr + "]";
            this.editContent += snippet;
            if (mc.keyboard != null) {
                mc.keyboard.setClipboard(cordStr);
            }
            saveCurrentNote();
        }
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
        IIiIIi_Class10 tinyFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.5F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
                tinyFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.8F);
            }
        } catch (Throwable ignored) {}

        // Main Frosted Glass Card
        float cardW = Math.min(580.0F, this.width - 40.0F);
        float cardH = Math.min(390.0F, this.height - 40.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(14.0F);

        custom.drawShadow(cardX, cardY, cardW, cardH, 20.0F, cRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
        custom.drawBlurredRect(cardX, cardY, cardW, cardH, 22.0F, 3.0F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F));
        custom.drawRoundedRect(cardX, cardY, cardW, cardH, cRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 125.0F));
        custom.drawRoundedBorder(cardX, cardY, cardW, cardH, 0.5F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

        // Header Title
        float hY = cardY + 12.0F;
        if (boldFont != null) {
            custom.drawText(boldFont, "📝 Заметки и Координаты Rockstar", cardX + 16.0F, hY + 1.0F, ColorRGBA.WHITE);
        }

        // Close Button [✕]
        float closeW = 24.0F;
        float closeX = cardX + cardW - closeW - 14.0F;
        float closeY = hY - 2.0F;
        boolean closeHov = (custom.I_method_b1c3e152() >= closeX && custom.I_method_b1c3e152() <= closeX + closeW && custom.i_method_b1d26d32() >= closeY && custom.i_method_b1d26d32() <= closeY + closeW);
        custom.drawRoundedRect(closeX, closeY, closeW, closeW, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(239.0F, 68.0F, 68.0F, closeHov ? 200.0F : 120.0F));
        custom.drawIcon("xmark", closeX + 7.0F, closeY + 7.0F, 10.0F, ColorRGBA.WHITE);

        // Divider
        float divY = cardY + 38.0F;
        custom.drawRect(cardX + 16.0F, divY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        // Layout Columns: Left (List, 180px) | Right (Editor)
        float listW = 180.0F;
        float listX = cardX + 16.0F;
        float bodyY = divY + 8.0F;
        float bodyH = cardH - 54.0F;

        // Button: "+ Новая заметка"
        float newBtnH = 26.0F;
        boolean newHov = (custom.I_method_b1c3e152() >= listX && custom.I_method_b1c3e152() <= listX + listW && custom.i_method_b1d26d32() >= bodyY && custom.i_method_b1d26d32() <= bodyY + newBtnH);
        custom.drawRoundedRect(listX, bodyY, listW, newBtnH, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(37.0F, 99.0F, 235.0F, newHov ? 240.0F : 190.0F));
        custom.drawRoundedBorder(listX, bodyY, listW, newBtnH, 0.5F, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        if (subFont != null) {
            custom.drawText(subFont, "+ Новая заметка", listX + 38.0F, bodyY + 7.0F, ColorRGBA.WHITE);
        }

        // Notes List Container
        float listItemsY = bodyY + newBtnH + 6.0F;
        float listItemsH = bodyH - newBtnH - 6.0F;
        custom.drawRoundedRect(listX, listItemsY, listW, listItemsH, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(12.0F, 16.0F, 24.0F, 110.0F));
        custom.drawRoundedBorder(listX, listItemsY, listW, listItemsH, 0.5F, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));

        List<NotesManager.Note> notes = NotesManager.getNotes();
        float itemY = listItemsY + 4.0F;
        float itemH = 40.0F;

        for (int i = 0; i < notes.size(); i++) {
            if (itemY + itemH > listItemsY + listItemsH) break;

            NotesManager.Note n = notes.get(i);
            boolean isSel = (this.selectedNote != null && this.selectedNote.id.equals(n.id));
            boolean itemHov = (custom.I_method_b1c3e152() >= listX + 4.0F && custom.I_method_b1c3e152() <= listX + listW - 4.0F && custom.i_method_b1d26d32() >= itemY && custom.i_method_b1d26d32() <= itemY + itemH);

            ColorRGBA bg = isSel ? new ColorRGBA(59.0F, 130.0F, 246.0F, 70.0F) : (itemHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 6.0F));
            custom.drawRoundedRect(listX + 4.0F, itemY, listW - 8.0F, itemH, IIiii_Class8.I_method_893b2757(6.0F), bg);
            if (isSel) {
                custom.drawRoundedBorder(listX + 4.0F, itemY, listW - 8.0F, itemH, 0.5F, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(59.0F, 130.0F, 246.0F, 140.0F));
            }

            // Note title
            if (subFont != null) {
                String t = n.title.isEmpty() ? "Без названия" : n.title;
                if (t.length() > 18) t = t.substring(0, 17) + "…";
                custom.drawText(subFont, t, listX + 10.0F, itemY + 6.0F, ColorRGBA.WHITE);
            }

            // Date & coords tag
            if (tinyFont != null) {
                String subInfo = n.getFormattedDate();
                if (n.cords != null && !n.cords.isEmpty()) subInfo += " • 📍";
                custom.drawText(tinyFont, subInfo, listX + 10.0F, itemY + 22.0F, new ColorRGBA(180.0F, 190.0F, 205.0F, 200.0F));
            }

            // Delete button [🗑]
            float delW = 16.0F;
            float delX = listX + listW - 8.0F - delW - 4.0F;
            float delY = itemY + 12.0F;
            boolean delHov = (custom.I_method_b1c3e152() >= delX && custom.I_method_b1c3e152() <= delX + delW && custom.i_method_b1d26d32() >= delY && custom.i_method_b1d26d32() <= delY + delW);
            if (delHov) {
                custom.drawRoundedRect(delX, delY, delW, delW, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(239.0F, 68.0F, 68.0F, 180.0F));
            }
            if (tinyFont != null) {
                custom.drawText(tinyFont, "✕", delX + 4.5F, delY + 3.5F, delHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
            }

            itemY += itemH + 4.0F;
        }

        // Right Editor Pane
        float editX = listX + listW + 12.0F;
        float editW = cardW - listW - 44.0F;

        if (this.selectedNote != null) {
            // Title Input Box
            float titleH = 26.0F;
            custom.drawRoundedRect(editX, bodyY, editW, titleH, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(12.0F, 16.0F, 24.0F, 140.0F));
            custom.drawRoundedBorder(editX, bodyY, editW, titleH, 0.5F, IIiii_Class8.I_method_893b2757(6.0F), this.editingTitle ? new ColorRGBA(59.0F, 130.0F, 246.0F, 180.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
            if (font != null) {
                String tDisp = this.editTitle.isEmpty() ? (this.editingTitle ? "" : "Заголовок заметки...") : this.editTitle;
                if (this.editingTitle && (System.currentTimeMillis() % 1000L < 500L)) tDisp += "|";
                ColorRGBA col = this.editTitle.isEmpty() ? new ColorRGBA(255.0F, 255.0F, 255.0F, 100.0F) : ColorRGBA.WHITE;
                custom.drawText(font, tDisp, editX + 10.0F, bodyY + 7.5F, col);
            }

            // Action toolbar: [📍 Вставить координаты] [💾 Сохранить]
            float tbY = bodyY + titleH + 6.0F;
            float cordBtnW = 145.0F;
            float btnH = 22.0F;
            boolean cordHov = (custom.I_method_b1c3e152() >= editX && custom.I_method_b1c3e152() <= editX + cordBtnW && custom.i_method_b1d26d32() >= tbY && custom.i_method_b1d26d32() <= tbY + btnH);
            custom.drawRoundedRect(editX, tbY, cordBtnW, btnH, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(16.0F, 185.0F, 129.0F, cordHov ? 230.0F : 170.0F));
            if (subFont != null) {
                custom.drawText(subFont, "📍 Вставить координаты", editX + 10.0F, tbY + 5.5F, ColorRGBA.WHITE);
            }

            float saveBtnW = 85.0F;
            float saveBtnX = editX + cordBtnW + 8.0F;
            boolean saveHov = (custom.I_method_b1c3e152() >= saveBtnX && custom.I_method_b1c3e152() <= saveBtnX + saveBtnW && custom.i_method_b1d26d32() >= tbY && custom.i_method_b1d26d32() <= tbY + btnH);
            custom.drawRoundedRect(saveBtnX, tbY, saveBtnW, btnH, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(59.0F, 130.0F, 246.0F, saveHov ? 230.0F : 170.0F));
            if (subFont != null) {
                custom.drawText(subFont, "💾 Сохранить", saveBtnX + 10.0F, tbY + 5.5F, ColorRGBA.WHITE);
            }

            // Coordinates chip if set
            if (this.editCords != null && !this.editCords.isEmpty() && tinyFont != null) {
                float chipX = saveBtnX + saveBtnW + 8.0F;
                float chipW = editW - (chipX - editX);
                if (chipW > 40.0F) {
                    custom.drawRoundedRect(chipX, tbY, chipW, btnH, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F));
                    String cShort = this.editCords;
                    if (cShort.length() > 24) cShort = cShort.substring(0, 23) + "…";
                    custom.drawText(tinyFont, cShort, chipX + 6.0F, tbY + 6.5F, new ColorRGBA(52.0F, 211.0F, 153.0F, 240.0F));
                }
            }

            // Multi-line Text Editor Box
            float textY = tbY + btnH + 6.0F;
            float textH = bodyH - (textY - bodyY);
            custom.drawRoundedRect(editX, textY, editW, textH, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(12.0F, 16.0F, 24.0F, 140.0F));
            custom.drawRoundedBorder(editX, textY, editW, textH, 0.5F, IIiii_Class8.I_method_893b2757(8.0F), this.editingContent ? new ColorRGBA(59.0F, 130.0F, 246.0F, 180.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

            if (subFont != null) {
                String[] lines = this.editContent.split("\n");
                float lineY = textY + 8.0F;
                for (int li = 0; li < lines.length; li++) {
                    if (lineY + 12.0F > textY + textH - 6.0F) break;
                    String lText = lines[li];
                    if (li == lines.length - 1 && this.editingContent && (System.currentTimeMillis() % 1000L < 500L)) {
                        lText += "|";
                    }
                    custom.drawText(subFont, lText, editX + 10.0F, lineY, ColorRGBA.WHITE);
                    lineY += 13.0F;
                }
                if (lines.length == 0 || this.editContent.isEmpty()) {
                    String emptyTip = this.editingContent ? "|" : "Начните вводить текст заметки...";
                    custom.drawText(subFont, emptyTip, editX + 10.0F, textY + 8.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 100.0F));
                }
            }
        } else {
            if (font != null) {
                custom.drawText(font, "Выберите заметку или создайте новую", editX + 20.0F, bodyY + 40.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
            }
        }
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        if (button != IiIII_Class9.I_field_2f4c8d6c) return;

        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;
        float cardW = Math.min(580.0F, this.width - 40.0F);
        float cardH = Math.min(390.0F, this.height - 40.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        float hY = cardY + 12.0F;

        // Close Button
        float closeW = 24.0F;
        float closeX = cardX + cardW - closeW - 14.0F;
        float closeY = hY - 2.0F;
        if (mouseX >= closeX && mouseX <= closeX + closeW && mouseY >= closeY && mouseY <= closeY + closeW) {
            saveCurrentNote();
            UISoundManager.playButtonClick();
            this.close();
            return;
        }

        float listW = 180.0F;
        float listX = cardX + 16.0F;
        float divY = cardY + 38.0F;
        float bodyY = divY + 8.0F;
        float bodyH = cardH - 54.0F;
        float newBtnH = 26.0F;

        // "+ Новая заметка" Click
        if (mouseX >= listX && mouseX <= listX + listW && mouseY >= bodyY && mouseY <= bodyY + newBtnH) {
            saveCurrentNote();
            UISoundManager.playButtonClick();
            NotesManager.Note newNote = NotesManager.createNote("Новая заметка", "", "");
            selectNote(newNote);
            this.editingTitle = true;
            this.editingContent = false;
            return;
        }

        // Notes List Items Click
        float listItemsY = bodyY + newBtnH + 6.0F;
        float listItemsH = bodyH - newBtnH - 6.0F;
        List<NotesManager.Note> notes = NotesManager.getNotes();
        float itemY = listItemsY + 4.0F;
        float itemH = 40.0F;

        for (int i = 0; i < notes.size(); i++) {
            if (itemY + itemH > listItemsY + listItemsH) break;
            NotesManager.Note n = notes.get(i);

            // Delete button
            float delW = 16.0F;
            float delX = listX + listW - 8.0F - delW - 4.0F;
            float delY = itemY + 12.0F;
            if (mouseX >= delX && mouseX <= delX + delW && mouseY >= delY && mouseY <= delY + delW) {
                UISoundManager.playButtonClick();
                NotesManager.deleteNote(n.id);
                if (this.selectedNote != null && this.selectedNote.id.equals(n.id)) {
                    List<NotesManager.Note> rem = NotesManager.getNotes();
                    selectNote(rem.isEmpty() ? null : rem.get(0));
                }
                return;
            }

            // Note Select
            if (mouseX >= listX + 4.0F && mouseX <= listX + listW - 4.0F && mouseY >= itemY && mouseY <= itemY + itemH) {
                saveCurrentNote();
                UISoundManager.playButtonClick();
                selectNote(n);
                this.editingTitle = false;
                this.editingContent = false;
                return;
            }

            itemY += itemH + 4.0F;
        }

        // Right Editor Pane Click Handlers
        float editX = listX + listW + 12.0F;
        float editW = cardW - listW - 44.0F;

        if (this.selectedNote != null) {
            float titleH = 26.0F;
            // Title Input Focus
            if (mouseX >= editX && mouseX <= editX + editW && mouseY >= bodyY && mouseY <= bodyY + titleH) {
                this.editingTitle = true;
                this.editingContent = false;
                return;
            }

            float tbY = bodyY + titleH + 6.0F;
            float cordBtnW = 145.0F;
            float btnH = 22.0F;

            // [📍 Вставить координаты] Click
            if (mouseX >= editX && mouseX <= editX + cordBtnW && mouseY >= tbY && mouseY <= tbY + btnH) {
                UISoundManager.playButtonClick();
                insertPlayerCoordinates();
                return;
            }

            // [💾 Сохранить] Click
            float saveBtnW = 85.0F;
            float saveBtnX = editX + cordBtnW + 8.0F;
            if (mouseX >= saveBtnX && mouseX <= saveBtnX + saveBtnW && mouseY >= tbY && mouseY <= tbY + btnH) {
                saveCurrentNote();
                UISoundManager.playButtonClick();
                this.editingTitle = false;
                this.editingContent = false;
                return;
            }

            // Content Area Focus
            float textY = tbY + btnH + 6.0F;
            float textH = bodyH - (textY - bodyY);
            if (mouseX >= editX && mouseX <= editX + editW && mouseY >= textY && mouseY <= textY + textH) {
                this.editingContent = true;
                this.editingTitle = false;
                return;
            }
        }

        this.editingTitle = false;
        this.editingContent = false;
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (chr >= 32 && chr != 127) {
            if (this.editingTitle) {
                this.editTitle += chr;
                saveCurrentNote();
                return true;
            } else if (this.editingContent) {
                this.editContent += chr;
                saveCurrentNote();
                return true;
            }
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        boolean isCtrlDown = Screen.hasControlDown() || (modifiers & GLFW.GLFW_MOD_CONTROL) != 0;
        if (isCtrlDown) {
            if (keyCode == GLFW.GLFW_KEY_V) {
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc != null && mc.keyboard != null) {
                    String clip = mc.keyboard.getClipboard();
                    if (clip != null && !clip.isEmpty()) {
                        if (this.editingTitle) {
                            this.editTitle += clip.replace("\r", "").replace("\n", "");
                        } else if (this.editingContent) {
                            this.editContent += clip.replace("\r", "");
                        }
                        saveCurrentNote();
                        return true;
                    }
                }
            } else if (keyCode == GLFW.GLFW_KEY_C) {
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc != null && mc.keyboard != null) {
                    if (this.editingTitle && !this.editTitle.isEmpty()) {
                        mc.keyboard.setClipboard(this.editTitle);
                        return true;
                    } else if (this.editingContent && !this.editContent.isEmpty()) {
                        mc.keyboard.setClipboard(this.editContent);
                        return true;
                    }
                }
            }
        }

        if (this.editingTitle) {
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !this.editTitle.isEmpty()) {
                this.editTitle = this.editTitle.substring(0, this.editTitle.length() - 1);
                saveCurrentNote();
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_TAB) {
                this.editingTitle = false;
                this.editingContent = true;
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                this.editingTitle = false;
                return true;
            }
        } else if (this.editingContent) {
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !this.editContent.isEmpty()) {
                this.editContent = this.editContent.substring(0, this.editContent.length() - 1);
                saveCurrentNote();
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                this.editContent += "\n";
                saveCurrentNote();
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                this.editingContent = false;
                return true;
            }
        }

        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            saveCurrentNote();
            this.close();
            return true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void close() {
        saveCurrentNote();
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            mc.setScreen(this.parentScreen);
        }
    }
}
