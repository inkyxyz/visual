package rockstar.client;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.Generated;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.IIIiIii_Class12;

public class IIIiiII_Class13 {
    private String I_field_523beb0a;
    private String i_field_523beb0a;
    private int I_field_49 = -1;
    private String II_field_523beb0a;
    private String Ii_field_523beb0a;
    private String iI_field_523beb0a;
    private String ii_field_523beb0a;

    public static IIIiiII_Class13 I_method_5174935() {
        return new IIIiiII_Class13();
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public static IIIiiII_Class13 I_method_3f2a2b3f(String string) throws MalformedURLException {
        return IIIiiII_Class13.i_method_6e1bdf1f(string);
    }

    public static IIIiiII_Class13 i_method_6e1bdf1f(String string) throws MalformedURLException {
        return new IIIiiII_Class13(new URL(string));
    }

    public static IIIiiII_Class13 II_method_3a54c182(String string) throws IllegalArgumentException {
        return new IIIiiII_Class13(URI.create(string));
    }

    public static IIIiiII_Class13 I_method_79b3b74(URL uRL) {
        return new IIIiiII_Class13(uRL);
    }

    public static IIIiiII_Class13 I_method_35282557(URI uRI) {
        return new IIIiiII_Class13(uRI);
    }

    public IIIiiII_Class13() {
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public IIIiiII_Class13(String string) throws MalformedURLException {
        this(new URL(string));
    }

    public IIIiiII_Class13(URL uRL) {
        this.I_field_523beb0a = uRL.getProtocol();
        this.i_field_523beb0a = this.III_method_77441eb7(uRL.getHost());
        this.I_field_49 = uRL.getPort();
        this.II_field_523beb0a = this.III_method_77441eb7(uRL.getPath());
        this.Ii_field_523beb0a = this.III_method_77441eb7(uRL.getQuery());
        this.iI_field_523beb0a = this.III_method_77441eb7(uRL.getUserInfo());
        this.ii_field_523beb0a = this.III_method_77441eb7(uRL.getRef());
    }

    public IIIiiII_Class13(URI uRI) {
        this.I_field_523beb0a = this.III_method_77441eb7(uRI.getScheme());
        this.i_field_523beb0a = this.III_method_77441eb7(uRI.getHost());
        this.I_field_49 = uRI.getPort();
        this.II_field_523beb0a = this.III_method_77441eb7(uRI.getPath());
        this.Ii_field_523beb0a = this.III_method_77441eb7(uRI.getQuery());
        this.iI_field_523beb0a = this.III_method_77441eb7(uRI.getUserInfo());
        this.ii_field_523beb0a = this.III_method_77441eb7(uRI.getFragment());
    }

    public boolean I_method_ae4820a3() {
        return this.I_field_523beb0a != null;
    }

    public String I_method_46d145e1() {
        return this.I_field_523beb0a;
    }

    public String I_method_8703b17(String string) {
        return this.I_field_523beb0a == null ? string : this.I_field_523beb0a;
    }

    public IIIiiII_Class13 Ii_method_69467562(String string) {
        this.I_field_523beb0a = this.III_method_77441eb7(string);
        return this;
    }

    public boolean i_method_ae56ac83() {
        return this.i_field_523beb0a != null;
    }

    public String i_method_d9eff601() {
        return this.i_field_523beb0a;
    }

    public String i_method_288f2337(String string) {
        return this.i_field_523beb0a == null ? string : this.i_field_523beb0a;
    }

    public IIIiiII_Class13 iI_method_e99989a2(String string) {
        this.i_field_523beb0a = this.III_method_77441eb7(string);
        return this;
    }

    public boolean II_method_1acaeaa6() {
        return this.I_field_49 >= 0;
    }

    public int I_method_ae482092() {
        return this.I_field_49;
    }

    public int I_method_1abc6637(int n) {
        return this.I_field_49 < 0 ? n : this.I_field_49;
    }

    public IIIiiII_Class13 I_method_8d6e2fda(int n) {
        if (n > 65535) {
            throw new IllegalArgumentException("Port must not be greater than 65535");
        }
        this.I_field_49 = n;
        return this;
    }

    public boolean Ii_method_1ad97686() {
        return this.II_field_523beb0a != null;
    }

    public String II_method_98b1623e() {
        return this.II_field_523beb0a;
    }

    public String II_method_fbe6da34(String string) {
        return this.II_field_523beb0a == null ? string : this.II_field_523beb0a;
    }

    public IIIiiII_Class13 ii_method_188b3d82(String string) {
        this.II_field_523beb0a = this.III_method_77441eb7(string);
        return this;
    }

    public boolean iI_method_1c8ddac6() {
        return this.Ii_field_523beb0a != null;
    }

    public String Ii_method_2bd0125e() {
        return this.Ii_field_523beb0a;
    }

    public String Ii_method_1c05c254(String string) {
        return this.Ii_field_523beb0a;
    }

    public IIIiiII_Class13 III_method_a47cf39f(String string) {
        this.Ii_field_523beb0a = this.III_method_77441eb7(string);
        return this;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public Nested1_b9daa269 I_method_70c6d53d() {
        return new Nested1_b9daa269();
    }

    public Nested1_ed389a00 I_method_1c698690() {
        return new Nested1_ed389a00();
    }

    public boolean ii_method_1c9c66a6() {
        return this.iI_field_523beb0a != null;
    }

    public String iI_method_6968b61e() {
        return this.iI_field_523beb0a;
    }

    public String iI_method_dfa4f614(String string) {
        return this.iI_field_523beb0a == null ? string : this.iI_field_523beb0a;
    }

    public IIIiiII_Class13 IIi_method_d36ea77f(String string) {
        this.iI_field_523beb0a = this.III_method_77441eb7(string);
        return this;
    }

    public boolean III_method_3ea16103() {
        return this.ii_field_523beb0a != null;
    }

    public String ii_method_fc87663e() {
        return this.ii_field_523beb0a;
    }

    public String ii_method_ffc3de34(String string) {
        return this.ii_field_523beb0a == null ? string : this.ii_field_523beb0a;
    }

    public IIIiiII_Class13 IiI_method_53c1bbbf(String string) {
        this.ii_field_523beb0a = this.III_method_77441eb7(string);
        return this;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public String III_method_82d4d181() {
        return this.ii_method_fc87663e();
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public IIIiiII_Class13 Iii_method_82b36f9f(String string) {
        return this.IiI_method_53c1bbbf(string);
    }

    public URL I_method_56a838d6() throws MalformedURLException {
        return new URL(this.toString());
    }

    public URI I_method_56a83879() {
        return URI.create(this.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.I_field_523beb0a != null) {
            stringBuilder.append(this.I_field_523beb0a).append("://");
        }
        if (this.iI_field_523beb0a != null) {
            stringBuilder.append(this.iI_field_523beb0a).append("@");
        }
        if (this.i_field_523beb0a != null) {
            stringBuilder.append(this.i_field_523beb0a);
        }
        if (this.I_field_49 >= 0) {
            stringBuilder.append(":").append(this.I_field_49);
        }
        if (this.II_field_523beb0a != null) {
            if (!this.II_field_523beb0a.startsWith("/")) {
                stringBuilder.append("/");
            }
            stringBuilder.append(this.II_field_523beb0a);
        }
        if (this.Ii_field_523beb0a != null) {
            stringBuilder.append("?").append(this.Ii_field_523beb0a);
        }
        if (this.ii_field_523beb0a != null) {
            stringBuilder.append("#").append(this.ii_field_523beb0a);
        }
        return stringBuilder.toString();
    }

    private String III_method_77441eb7(String string) {
        return string == null || string.isEmpty() ? null : string;
    }

    public static class Nested1_ed3899e0 {
        private String I_field_523beb0a;
        @Nullable
        private String i_field_523beb0a;

        public Nested1_ed3899e0(String string) {
            this.I_field_523beb0a = string;
        }

        public Nested1_ed3899e0(String string, @Nullable String string2) {
            this.I_field_523beb0a = string;
            this.i_field_523beb0a = string2;
        }

        @Generated
        public String I_method_7aaa8e06() {
            return this.I_field_523beb0a;
        }

        @Nullable
        @Generated
        public String i_method_dc93e26() {
            return this.i_field_523beb0a;
        }

        @Generated
        public void I_method_7f67bd24(String string) {
            this.I_field_523beb0a = string;
        }

        @Generated
        public void i_method_501f1104(@Nullable String string) {
            this.i_field_523beb0a = string;
        }
    }

    public class Nested1_ed389a00 {
        private final List<Nested1_ed3899e0> I_field_7865b31 = new ArrayList<Nested1_ed3899e0>();

        public Nested1_ed389a00() {
            String string = IIIiiII_Class13.this.Ii_method_2bd0125e();
            if (string != null && !string.isEmpty()) {
                for (String string2 : string.split("&")) {
                    String[] stringArray = string2.split("=", 2);
                    if (stringArray.length == 2) {
                        this.I_field_7865b31.add(new Nested1_ed3899e0(IIIiIii_Class12.i_method_10d4f17(stringArray[0]), IIIiIii_Class12.i_method_10d4f17(stringArray[1])));
                        continue;
                    }
                    this.I_field_7865b31.add(new Nested1_ed3899e0(IIIiIii_Class12.i_method_10d4f17(stringArray[0])));
                }
            }
        }

        public List<String> I_method_afae90c3(String string) {
            return this.I_field_7865b31.stream().filter(nested1_ed3899e0 -> nested1_ed3899e0.I_method_7aaa8e06().equals(string)).map(Nested1_ed3899e0::i_method_dc93e26).filter(Objects::nonNull).collect(Collectors.toList());
        }

        public Optional<String> I_method_d9c92b41(String string) {
            return this.I_field_7865b31.stream().filter(nested1_ed3899e0 -> nested1_ed3899e0.I_method_7aaa8e06().equals(string)).map(Nested1_ed3899e0::i_method_dc93e26).filter(Objects::nonNull).findFirst();
        }

        public boolean I_method_ff999908(String string) {
            return this.I_field_7865b31.stream().anyMatch(nested1_ed3899e0 -> nested1_ed3899e0.I_method_7aaa8e06().equals(string));
        }

        public Nested1_ed389a00 I_method_d5b642ff(String string, @Nullable String string2) {
            this.I_field_7865b31.add(new Nested1_ed3899e0(string, string2));
            return this;
        }

        public Nested1_ed389a00 I_method_affabe98(Nested1_ed3899e0 nested1_ed3899e0) {
            this.I_field_7865b31.add(nested1_ed3899e0);
            return this;
        }

        public Nested1_ed389a00 I_method_ad9106b4(Iterable<Nested1_ed3899e0> iterable) {
            iterable.forEach(this.I_field_7865b31::add);
            return this;
        }

        public Nested1_ed389a00 I_method_d71f5ed7(Nested1_ed3899e0[] nested1_ed3899e0Array) {
            Collections.addAll(this.I_field_7865b31, nested1_ed3899e0Array);
            return this;
        }

        public Nested1_ed389a00 I_method_3c2cdd7c(Map<String, String> map) {
            map.forEach((string, string2) -> this.I_field_7865b31.add(new Nested1_ed3899e0((String)string, (String)string2)));
            return this;
        }

        public Nested1_ed389a00 i_method_1ba746df(String string, @Nullable String string2) {
            this.I_field_7865b31.removeIf(nested1_ed3899e0 -> nested1_ed3899e0.I_method_7aaa8e06().equals(string));
            this.I_field_7865b31.add(new Nested1_ed3899e0(string, string2));
            return this;
        }

        public Nested1_ed389a00 i_method_90452d9c(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.i_method_1ba746df(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Nested1_ed389a00 I_method_17509ab5(String string) {
            this.I_field_7865b31.removeIf(nested1_ed3899e0 -> nested1_ed3899e0.I_method_7aaa8e06().equals(string));
            return this;
        }

        public Nested1_ed389a00 I_method_292693eb() {
            this.I_field_7865b31.clear();
            return this;
        }

        public IIIiiII_Class13 I_method_e8ddf150() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Nested1_ed3899e0 nested1_ed3899e0 : this.I_field_7865b31) {
                stringBuilder.append(IIIiIii_Class12.I_method_e0ee66f7(nested1_ed3899e0.I_method_7aaa8e06()));
                if (nested1_ed3899e0.i_method_dc93e26() != null) {
                    stringBuilder.append("=").append(IIIiIii_Class12.I_method_e0ee66f7(nested1_ed3899e0.i_method_dc93e26()));
                }
                stringBuilder.append("&");
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            IIIiiII_Class13.this.III_method_a47cf39f(stringBuilder.toString());
            return IIIiiII_Class13.this;
        }

        @Generated
        public List<Nested1_ed3899e0> I_method_13183d4d() {
            return this.I_field_7865b31;
        }
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public class Nested1_b9daa269 {
        private final Map<String, String> I_field_a567c40b = new HashMap<String, String>();

        private Nested1_b9daa269() {
            String string = IIIiiII_Class13.this.Ii_method_2bd0125e();
            if (string != null && !string.isEmpty()) {
                for (String string2 : string.split("&")) {
                    String[] stringArray = string2.split("=", 2);
                    if (stringArray.length == 2) {
                        this.I_field_a567c40b.put(IIIiIii_Class12.i_method_10d4f17(stringArray[0]), IIIiIii_Class12.i_method_10d4f17(stringArray[1]));
                        continue;
                    }
                    this.I_field_a567c40b.put(IIIiIii_Class12.i_method_10d4f17(stringArray[0]), "");
                }
            }
        }

        public Map<String, String> I_method_1751366() {
            return Collections.unmodifiableMap(this.I_field_a567c40b);
        }

        public Optional<String> I_method_cf37a06a(String string) {
            return Optional.ofNullable(this.I_field_a567c40b.get(string));
        }

        public Nested1_b9daa269 I_method_3a38a97(String string, String string2) {
            this.I_field_a567c40b.put(string, string2);
            return this;
        }

        public Nested1_b9daa269 I_method_75b7b848(Map<String, String> map) {
            this.I_field_a567c40b.putAll(map);
            return this;
        }

        public Nested1_b9daa269 I_method_7fe181e1(String string) {
            this.I_field_a567c40b.remove(string);
            return this;
        }

        public boolean I_method_85d22a7f(String string) {
            return this.I_field_a567c40b.containsKey(string);
        }

        public IIIiiII_Class13 I_method_e3ab4d87() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : this.I_field_a567c40b.entrySet()) {
                stringBuilder.append(IIIiIii_Class12.I_method_e0ee66f7(entry.getKey())).append("=").append(IIIiIii_Class12.I_method_e0ee66f7(entry.getValue())).append("&");
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            IIIiiII_Class13.this.III_method_a47cf39f(stringBuilder.toString());
            return IIIiiII_Class13.this;
        }

        public IIIiiII_Class13 i_method_fdcc3967() {
            return IIIiiII_Class13.this;
        }
    }
}

