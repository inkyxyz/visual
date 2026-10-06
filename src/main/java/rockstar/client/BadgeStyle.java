package rockstar.client;

import pyrock.utility.render.ColorRGBA;

public class BadgeStyle {
    public final String icon;
    public final ColorRGBA top;
    public final ColorRGBA bot;

    public BadgeStyle(String icon, ColorRGBA top, ColorRGBA bot) {
        this.icon = icon;
        this.top = top;
        this.bot = bot;
    }

    public static BadgeStyle getBadgeStyle(String lower) {
        if (lower.contains("join") || lower.contains("\u043f\u043e\u0434\u043a\u043b\u044e\u0447") || lower.contains("play") || lower.contains("\u0438\u0433\u0440\u0430\u0442\u044c") || lower.contains("\u0432\u043e\u0439\u0442\u0438") || lower.contains("\u0437\u0430\u0439\u0442\u0438")) {
            return new BadgeStyle("play", new ColorRGBA(52.0F, 199.0F, 89.0F, 255.0F), new ColorRGBA(36.0F, 155.0F, 65.0F, 255.0F));
        }
        if (lower.contains("add") || lower.contains("\u0434\u043e\u0431\u0430\u0432") || lower.contains("create") || lower.contains("\u0441\u043e\u0437\u0434\u0430\u0442") || lower.contains("\u043d\u043e\u0432") || lower.contains("new")) {
            return new BadgeStyle("plus", new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F), new ColorRGBA(90.0F, 200.0F, 250.0F, 255.0F));
        }
        if (lower.contains("video") || lower.contains("\u0433\u0440\u0430\u0444\u0438\u043a") || lower.contains("\u0432\u0438\u0434\u0435\u043e") || lower.contains("render") || lower.contains("view")) {
            return new BadgeStyle("category/visuals", new ColorRGBA(52.0F, 199.0F, 89.0F, 255.0F), new ColorRGBA(40.0F, 170.0F, 70.0F, 255.0F));
        }
        if (lower.contains("music") || lower.contains("sound") || lower.contains("\u0437\u0432\u0443\u043a") || lower.contains("\u043c\u0443\u0437\u044b\u043a") || lower.contains("\u0430\u0443\u0434\u0438\u043e")) {
            return new BadgeStyle("music", new ColorRGBA(255.0F, 149.0F, 0.0F, 255.0F), new ColorRGBA(255.0F, 59.0F, 48.0F, 255.0F));
        }
        if (lower.contains("skin") || lower.contains("\u0441\u043a\u0438\u043d") || lower.contains("\u0432\u043d\u0435\u0448\u043d") || lower.contains("player") || lower.contains("\u0438\u0433\u0440\u043e\u043a")) {
            return new BadgeStyle("hud/player", new ColorRGBA(88.0F, 86.0F, 214.0F, 255.0F), new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F));
        }
        if (lower.contains("control") || lower.contains("\u0443\u043f\u0440\u0430\u0432\u043b") || lower.contains("key") || lower.contains("\u043a\u043b\u0430\u0432\u0438\u0448") || lower.contains("mouse") || lower.contains("\u043c\u044b\u0448")) {
            return new BadgeStyle("keyboard", new ColorRGBA(175.0F, 82.0F, 222.0F, 255.0F), new ColorRGBA(88.0F, 86.0F, 214.0F, 255.0F));
        }
        if (lower.contains("resource") || lower.contains("\u043f\u0430\u043a\u0435\u0442") || lower.contains("\u0442\u0435\u043a\u0441\u0442\u0443\u0440") || lower.contains("pack")) {
            return new BadgeStyle("cube", new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F), new ColorRGBA(88.0F, 86.0F, 214.0F, 255.0F));
        }
        if (lower.contains("lang") || lower.contains("\u044f\u0437\u044b\u043a")) {
            return new BadgeStyle("language", new ColorRGBA(50.0F, 173.0F, 230.0F, 255.0F), new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F));
        }
        if (lower.contains("chat") || lower.contains("\u0447\u0430\u0442") || lower.contains("\u0441\u043e\u043e\u0431\u0449") || lower.contains("messag")) {
            return new BadgeStyle("menu/messager", new ColorRGBA(48.0F, 209.0F, 88.0F, 255.0F), new ColorRGBA(52.0F, 199.0F, 89.0F, 255.0F));
        }
        if (lower.contains("delete") || lower.contains("\u0443\u0434\u0430\u043b") || lower.contains("remove") || lower.contains("\u0441\u0431\u0440\u043e\u0441") || lower.contains("reset")) {
            return new BadgeStyle("trash", new ColorRGBA(255.0F, 69.0F, 58.0F, 255.0F), new ColorRGBA(215.0F, 0.0F, 21.0F, 255.0F));
        }
        if (lower.contains("edit") || lower.contains("\u043d\u0430\u0441\u0442\u0440\u043e") || lower.contains("setting") || lower.contains("\u0440\u0435\u0434\u0430\u043a\u0442") || lower.contains("\u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440") || lower.contains("\u0438\u0437\u043c\u0435\u043d")) {
            return new BadgeStyle("setting", new ColorRGBA(255.0F, 159.0F, 10.0F, 255.0F), new ColorRGBA(255.0F, 214.0F, 10.0F, 255.0F));
        }
        if (lower.contains("refresh") || lower.contains("\u043e\u0431\u043d\u043e\u0432") || lower.contains("reload")) {
            return new BadgeStyle("clean", new ColorRGBA(100.0F, 210.0F, 255.0F, 255.0F), new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F));
        }
        if (lower.contains("direct") || lower.contains("\u043f\u0440\u044f\u043c") || lower.contains("copy") || lower.contains("re-create") || lower.contains("\u043f\u0435\u0440\u0435\u0441\u043e\u0437\u0434") || lower.contains("\u0434\u0443\u0431\u043b\u0438\u0440")) {
            return new BadgeStyle("copy", new ColorRGBA(90.0F, 200.0F, 250.0F, 255.0F), new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F));
        }
        if (lower.contains("done") || lower.contains("\u0433\u043e\u0442\u043e\u0432") || lower.contains("apply") || lower.contains("\u043f\u0440\u0438\u043c\u0435\u043d") || lower.contains("save") || lower.contains("\u0441\u043e\u0445\u0440\u0430\u043d") || lower.contains("select") || lower.contains("\u0432\u044b\u0431\u0440")) {
            return new BadgeStyle("check", new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F), new ColorRGBA(88.0F, 86.0F, 214.0F, 255.0F));
        }
        if (lower.contains("cancel") || lower.contains("\u043e\u0442\u043c\u0435\u043d") || lower.contains("\u043d\u0430\u0437\u0430\u0434") || lower.contains("back") || lower.contains("\u0437\u0430\u043a\u0440\u044b\u0442") || lower.contains("leave") || lower.contains("close") || lower.contains("disconnect")) {
            return new BadgeStyle("back", new ColorRGBA(99.0F, 99.0F, 102.0F, 255.0F), new ColorRGBA(72.0F, 72.0F, 74.0F, 255.0F));
        }
        if (lower.contains("world") || lower.contains("\u043c\u0438\u0440") || lower.contains("\u0437\u0435\u043c\u043b") || lower.contains("\u0441\u0435\u0440\u0432\u0435\u0440") || lower.contains("server")) {
            return new BadgeStyle("hud/world", new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F), new ColorRGBA(52.0F, 199.0F, 89.0F, 255.0F));
        }
        if (lower.contains("info") || lower.contains("\u0438\u043d\u0444\u043e") || lower.contains("\u0441\u043f\u0440\u0430\u0432\u043a") || lower.contains("about") || lower.contains("accessib") || lower.contains("\u0432\u043e\u0437\u043c\u043e\u0436\u043d")) {
            return new BadgeStyle("info", new ColorRGBA(0.0F, 122.0F, 255.0F, 255.0F), new ColorRGBA(94.0F, 92.0F, 230.0F, 255.0F));
        }
        return new BadgeStyle("setting", new ColorRGBA(72.0F, 72.0F, 74.0F, 255.0F), new ColorRGBA(58.0F, 58.0F, 60.0F, 255.0F));
    }
}
