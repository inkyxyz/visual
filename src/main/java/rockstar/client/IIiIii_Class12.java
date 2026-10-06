package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Generated;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

public class IIiIii_Class12 {
    public static List<Nested1_e9eaef13> I_method_8847bf1e(Text text, int n) {
        ArrayList<Nested1_e9eaef13> arrayList = new ArrayList<Nested1_e9eaef13>();
        text.visit((style, string) -> {
            if (!string.isEmpty()) {
                int n2 = IIiIii_Class12.I_method_378fba5e(style, n);
                boolean bl = style.isBold();
                boolean bl2 = style.isItalic();
                boolean bl3 = style.isUnderlined();
                boolean bl4 = style.isStrikethrough();
                arrayList.add(new Nested1_e9eaef13(string, n2, bl, bl2, bl3, bl4));
            }
            return Optional.empty();
        }, Style.EMPTY);
        return arrayList;
    }

    private static int I_method_378fba5e(Style style, int n) {
        TextColor textColor = style.getColor();
        if (textColor != null) {
            return textColor.getRgb() | 0xFF000000;
        }
        return n;
    }

    public static class Nested1_e9eaef13 {
        public final String I_field_523beb0a;
        public final int I_field_49;
        public final boolean I_field_5a;
        public final boolean i_field_5a;
        public final boolean II_field_5a;
        public final boolean Ii_field_5a;

        @Generated
        public Nested1_e9eaef13(String string, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            this.I_field_523beb0a = string;
            this.I_field_49 = n;
            this.I_field_5a = bl;
            this.i_field_5a = bl2;
            this.II_field_5a = bl3;
            this.Ii_field_5a = bl4;
        }

        @Generated
        public String I_method_45a0aaf9() {
            return this.I_field_523beb0a;
        }

        @Generated
        public int I_method_b1a8887a() {
            return this.I_field_49;
        }

        @Generated
        public boolean I_method_b1a8888b() {
            return this.I_field_5a;
        }

        @Generated
        public boolean i_method_b1b7146b() {
            return this.i_field_5a;
        }

        @Generated
        public boolean II_method_83777fbe() {
            return this.II_field_5a;
        }

        @Generated
        public boolean Ii_method_83860b9e() {
            return this.Ii_field_5a;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Nested1_e9eaef13)) {
                return false;
            }
            Nested1_e9eaef13 nested1_e9eaef13 = (Nested1_e9eaef13)object;
            if (!nested1_e9eaef13.I_method_c5b404a7(this)) {
                return false;
            }
            if (this.I_method_b1a8887a() != nested1_e9eaef13.I_method_b1a8887a()) {
                return false;
            }
            if (this.I_method_b1a8888b() != nested1_e9eaef13.I_method_b1a8888b()) {
                return false;
            }
            if (this.i_method_b1b7146b() != nested1_e9eaef13.i_method_b1b7146b()) {
                return false;
            }
            if (this.II_method_83777fbe() != nested1_e9eaef13.II_method_83777fbe()) {
                return false;
            }
            if (this.Ii_method_83860b9e() != nested1_e9eaef13.Ii_method_83860b9e()) {
                return false;
            }
            String string = this.I_method_45a0aaf9();
            String string2 = nested1_e9eaef13.I_method_45a0aaf9();
            return !(string == null ? string2 != null : !string.equals(string2));
        }

        @Generated
        protected boolean I_method_c5b404a7(Object object) {
            return object instanceof Nested1_e9eaef13;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            n2 = n2 * 59 + this.I_method_b1a8887a();
            n2 = n2 * 59 + (this.I_method_b1a8888b() ? 79 : 97);
            n2 = n2 * 59 + (this.i_method_b1b7146b() ? 79 : 97);
            n2 = n2 * 59 + (this.II_method_83777fbe() ? 79 : 97);
            n2 = n2 * 59 + (this.Ii_method_83860b9e() ? 79 : 97);
            String string = this.I_method_45a0aaf9();
            n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
            return n2;
        }

        @Generated
        public String toString() {
            return "FormattedTextProcessor.TextSegment(text=" + this.I_method_45a0aaf9() + ", color=" + this.I_method_b1a8887a() + ", bold=" + this.I_method_b1a8888b() + ", italic=" + this.i_method_b1b7146b() + ", underlined=" + this.II_method_83777fbe() + ", strikethrough=" + this.Ii_method_83860b9e() + ")";
        }
    }
}

