package pyrock.classes;

import globals.client.Information;
import globals.client.auth.ProfileSync;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import net.minecraft.util.Identifier;
import rockstar.client.RockstarClient;
import rockstar.client.Module;
import ua.mintantileak.profile.Profile;
import ua.mintantileak.profile.Role;

public class PyProfile {
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ROOT);
    private static final String FOREVER = "\u041d\u0430\u0432\u0441\u0435\u0433\u0434\u0430";
    private static final long PERMANENT_MS = 94608000000L;

    public String username() {
        String string = Profile.getUsername();
        return string == null ? "" : string;
    }

    public int uid() {
        return Profile.getUid();
    }

    public String role() {
        Role role = Profile.getRole();
        return role == null ? "default" : role.name().toLowerCase(Locale.ROOT);
    }

    public boolean hasRole(String string) {
        return string != null && this.role().equalsIgnoreCase(string.trim());
    }

    public boolean staff() {
        Role role = Profile.getRole();
        return role == Role.ADMIN || role == Role.MODERATOR || role == Role.OWNER;
    }

    public boolean admin() {
        return Module.iI_method_af0a6819();
    }

    public boolean loaded() {
        return Module.ii_method_af18f3f9();
    }

    public String subscription() {
        String string = Profile.getSubscriptionEndDate();
        return string == null ? "" : string;
    }

    public boolean forever() {
        if (FOREVER.equalsIgnoreCase(this.subscription())) {
            return true;
        }
        long l = ProfileSync.subscriptionEnd();
        return l > 0L && l - System.currentTimeMillis() > 94608000000L;
    }

    public long subscriptionEnd() {
        long l = ProfileSync.subscriptionEnd();
        if (l > 0L) {
            return l;
        }
        String string = this.subscription();
        if (string.isBlank() || FOREVER.equalsIgnoreCase(string)) {
            return 0L;
        }
        try {
            return LocalDate.parse(string, DATE).plusDays(1L).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        }
        catch (Exception exception) {
            return 0L;
        }
    }

    public long subscriptionLeft() {
        long l = this.subscriptionEnd();
        if (l <= 0L) {
            return 0L;
        }
        return Math.max(0L, l - System.currentTimeMillis());
    }

    public int daysLeft() {
        long l = this.subscriptionLeft();
        if (this.subscriptionEnd() <= 0L) {
            return -1;
        }
        return (int)Duration.ofMillis(l).toDays();
    }

    public boolean expired() {
        long l = this.subscriptionEnd();
        return !this.forever() && l > 0L && l < System.currentTimeMillis();
    }

    public String avatarUrl() {
        String string = Profile.getAvatarUrl();
        return string == null ? "" : string;
    }

    public Identifier avatar() {
        try {
            return Information.getSelfAvatar();
        }
        catch (Throwable throwable) {
            return PyProfile.fallbackAvatar();
        }
    }

    public Identifier avatarOf(String string) {
        if (string == null || string.isBlank()) {
            return PyProfile.fallbackAvatar();
        }
        try {
            return Information.getAvatar(string);
        }
        catch (Throwable throwable) {
            return PyProfile.fallbackAvatar();
        }
    }

    private static Identifier fallbackAvatar() {
        return RockstarClient.id("rocknet/avatar.png");
    }

    public String clientName() {
        return "Rockstar";
    }

    public String clientVersion() {
        return "2.1";
    }
}

