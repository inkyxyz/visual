package rockstar.client;

import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import rockstar.client.iIIIiI_Class35;
import rockstar.client.iIiiIiI_Class91;

public class iIiiiii_Class96
extends iIiiIiI_Class91 {
    public static final Map<Long, String> I_field_a567c40b = new HashMap<Long, String>();
    public static final Map<Long, String> i_field_a567c40b = new HashMap<Long, String>();
    private final long I_field_4a;

    public iIiiiii_Class96(iIIIiI_Class35 iIIIiI_Class352, long l) {
        super(iIIIiI_Class352, I_field_a567c40b.getOrDefault(l, String.valueOf(l)), i_field_a567c40b.getOrDefault(l, "An unknown error occurred"));
        this.I_field_4a = l;
    }

    @Generated
    public long I_method_10d6c53() {
        return this.I_field_4a;
    }

    static {
        I_field_a567c40b.put(2279407619L, "AM_E_XASD_UNEXPECTED");
        I_field_a567c40b.put(2279407620L, "AM_E_XASU_UNEXPECTED");
        I_field_a567c40b.put(2279407621L, "AM_E_XAST_UNEXPECTED");
        I_field_a567c40b.put(2279407622L, "AM_E_XSTS_UNEXPECTED");
        I_field_a567c40b.put(2279407623L, "AM_E_XDEVICE_UNEXPECTED");
        I_field_a567c40b.put(2279407624L, "AM_E_DEVMODE_NOT_AUTHORIZED");
        I_field_a567c40b.put(2279407625L, "AM_E_NOT_AUTHORIZED");
        I_field_a567c40b.put(2279407626L, "AM_E_FORBIDDEN");
        I_field_a567c40b.put(2279407627L, "AM_E_UNKNOWN_TARGET");
        I_field_a567c40b.put(2279407628L, "AM_E_NSAL_READ_FAILED");
        I_field_a567c40b.put(2279407629L, "AM_E_TITLE_NOT_AUTHENTICATED");
        I_field_a567c40b.put(2279407630L, "AM_E_TITLE_NOT_AUTHORIZED");
        I_field_a567c40b.put(2279407631L, "AM_E_DEVICE_NOT_AUTHENTICATED");
        I_field_a567c40b.put(2279407632L, "AM_E_INVALID_USER_INDEX");
        I_field_a567c40b.put(2148916224L, "XO_E_DEVMODE_NOT_AUTHORIZED");
        I_field_a567c40b.put(2148916225L, "XO_E_SYSTEM_UPDATE_REQUIRED");
        I_field_a567c40b.put(2148916226L, "XO_E_CONTENT_UPDATE_REQUIRED");
        I_field_a567c40b.put(2148916227L, "XO_E_ENFORCEMENT_BAN");
        I_field_a567c40b.put(2148916228L, "XO_E_THIRD_PARTY_BAN");
        I_field_a567c40b.put(2148916229L, "XO_E_ACCOUNT_PARENTALLY_RESTRICTED");
        I_field_a567c40b.put(2148916230L, "XO_E_DEVICE_SUBSCRIPTION_NOT_ACTIVATED");
        I_field_a567c40b.put(2148916232L, "XO_E_ACCOUNT_BILLING_MAINTENANCE_REQUIRED");
        I_field_a567c40b.put(2148916233L, "XO_E_ACCOUNT_CREATION_REQUIRED");
        I_field_a567c40b.put(2148916234L, "XO_E_ACCOUNT_TERMS_OF_USE_NOT_ACCEPTED");
        I_field_a567c40b.put(2148916235L, "XO_E_ACCOUNT_COUNTRY_NOT_AUTHORIZED");
        I_field_a567c40b.put(2148916236L, "XO_E_ACCOUNT_AGE_VERIFICATION_REQUIRED");
        I_field_a567c40b.put(2148916237L, "XO_E_ACCOUNT_CURFEW");
        I_field_a567c40b.put(2148916238L, "XO_E_ACCOUNT_ZEST_MAINTENANCE_REQUIRED");
        I_field_a567c40b.put(2148916239L, "XO_E_ACCOUNT_CSV_TRANSITION_REQUIRED");
        I_field_a567c40b.put(2148916240L, "XO_E_ACCOUNT_MAINTENANCE_REQUIRED");
        I_field_a567c40b.put(2148916241L, "XO_E_ACCOUNT_TYPE_NOT_ALLOWED");
        I_field_a567c40b.put(2148916242L, "XO_E_CONTENT_ISOLATION");
        I_field_a567c40b.put(2148916243L, "XO_E_ACCOUNT_NAME_CHANGE_REQUIRED");
        I_field_a567c40b.put(2148916244L, "XO_E_DEVICE_CHALLENGE_REQUIRED");
        I_field_a567c40b.put(2148916256L, "XO_E_EXPIRED_DEVICE_TOKEN");
        I_field_a567c40b.put(2148916257L, "XO_E_EXPIRED_TITLE_TOKEN");
        I_field_a567c40b.put(2148916258L, "XO_E_EXPIRED_USER_TOKEN");
        I_field_a567c40b.put(2148916259L, "XO_E_INVALID_DEVICE_TOKEN");
        I_field_a567c40b.put(2148916260L, "XO_E_INVALID_TITLE_TOKEN");
        I_field_a567c40b.put(2148916261L, "XO_E_INVALID_USER_TOKEN");
        i_field_a567c40b.put(2148916227L, "Your account was banned by Xbox for violating one or more Community Standards for Xbox.");
        i_field_a567c40b.put(2148916229L, "Your account is currently restricted and your guardian has not given you permission to play online. Login to https://account.microsoft.com/family/ and have your guardian change your permissions.");
        i_field_a567c40b.put(2148916233L, "Your account doesn't have an Xbox profile. Please create one at https://www.xbox.com/live");
        i_field_a567c40b.put(2148916234L, "Your account has not accepted Xbox's Terms of Service. Please login at https://www.xbox.com/live and accept them.");
        i_field_a567c40b.put(2148916235L, "Your account is from a country where Xbox Live is not available/banned.");
        i_field_a567c40b.put(2148916236L, "Your account requires proof of age. Please login to https://login.live.com/login.srf and provide proof of age.");
        i_field_a567c40b.put(2148916237L, "Your account has reached the its limit for playtime. Your account has been blocked from logging in.");
        i_field_a567c40b.put(2148916238L, "Your account is a child (under 18) and cannot proceed unless the account is added to a Family by an adult.");
    }
}

