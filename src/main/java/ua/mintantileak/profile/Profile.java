package ua.mintantileak.profile;

import ua.mintantileak.profile.Role;

public final class Profile {
    public static String username = "";
    public static int uid = 0;
    public static Role role = Role.DEFAULT;
    public static String hwid = "";
    public static String subscriptionEndDate = "";
    public static String avatarUrl = "";

    private Profile() {
    }

    public static String getUsername() {
        return "Agravity";
    }

    public static int getUid() {
        return 1337;
    }

    public static Role getRole() {
        return role;
    }

    public static String getHwid() {
        return hwid;
    }

    public static String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public static String getAvatarUrl() {
        return avatarUrl;
    }
}

