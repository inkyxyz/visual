package rockstar.client;

import java.util.List;
import lombok.Generated;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class IIIIIiIi_Class6 {
    private double I_field_44;
    private double i_field_44;
    private double II_field_44;
    private float I_field_46;
    private float i_field_46;
    private float II_field_46 = 20.0f;
    private float Ii_field_46 = 20.0f;
    private int I_field_49 = 20;
    private int i_field_49 = 0;
    private boolean I_field_5a = false;
    private boolean i_field_5a = false;
    private boolean II_field_5a = true;
    private int II_field_49 = -1;
    private ItemStack[] I_field_6132843d = new ItemStack[46];
    private ItemStack[] i_field_6132843d = new ItemStack[4];
    private ItemStack I_field_f2735522 = ItemStack.EMPTY;
    private ItemStack i_field_f2735522 = ItemStack.EMPTY;
    private ItemStack[] II_field_6132843d = new ItemStack[128];
    private int Ii_field_49 = -1;
    private int iI_field_49;
    private String I_field_523beb0a = "";
    private float iI_field_46;
    private int ii_field_49;
    private int III_field_49;
    private boolean Ii_field_5a;
    private boolean iI_field_5a;
    private boolean ii_field_5a;
    private boolean III_field_5a;
    private float ii_field_46 = 0.05f;
    private float III_field_46 = 0.1f;
    private int IIi_field_49 = -1;
    private long I_field_4a = 0L;
    private double Ii_field_44;
    private double iI_field_44;
    private double ii_field_44;
    private float IIi_field_46;
    private float IiI_field_46;

    public IIIIIiIi_Class6() {
        int n;
        for (n = 0; n < this.I_field_6132843d.length; ++n) {
            this.I_field_6132843d[n] = ItemStack.EMPTY;
        }
        for (n = 0; n < this.i_field_6132843d.length; ++n) {
            this.i_field_6132843d[n] = ItemStack.EMPTY;
        }
        this.II_method_a4679455();
    }

    public Vec3d I_method_d573f06() {
        return new Vec3d(this.I_field_44, this.i_field_44, this.II_field_44);
    }

    public void I_method_f21a8072(double d, double d2, double d3) {
        this.I_field_44 = d;
        this.i_field_44 = d2;
        this.II_field_44 = d3;
        this.I_field_4a = System.currentTimeMillis();
    }

    public void I_method_e6c7f98c(float f, float f2) {
        this.I_field_46 = MathHelper.wrapDegrees((float)f);
        this.i_field_46 = MathHelper.clamp((float)f2, (float)-90.0f, (float)90.0f);
    }

    public ItemStack I_method_f82e14ac() {
        if (this.i_field_49 >= 0 && this.i_field_49 < 9 && this.i_field_49 < this.I_field_6132843d.length) {
            return this.I_field_6132843d[this.i_field_49];
        }
        return ItemStack.EMPTY;
    }

    public void I_method_5ff31f19(int n, ItemStack itemStack) {
        if (n >= 0 && n < this.I_field_6132843d.length) {
            this.I_field_6132843d[n] = itemStack != null ? itemStack : ItemStack.EMPTY;
        }
    }

    public void i_method_3b0b1739(int n, ItemStack itemStack) {
        if (n >= 36 && n <= 44) {
            this.I_method_5ff31f19(n - 36, itemStack);
            return;
        }
        if (n >= 9 && n <= 35) {
            this.I_method_5ff31f19(n, itemStack);
            return;
        }
        if (n >= 5 && n <= 8) {
            this.II_method_c95fc630(8 - n, itemStack);
            return;
        }
        if (n == 45) {
            this.I_field_f2735522 = itemStack == null ? ItemStack.EMPTY : itemStack;
        }
    }

    public void I_method_add1e97d(List<ItemStack> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); ++i) {
            this.i_method_3b0b1739(i, list.get(i));
        }
    }

    public void II_method_c95fc630(int n, ItemStack itemStack) {
        if (n >= 0 && n < this.i_field_6132843d.length) {
            this.i_field_6132843d[n] = itemStack != null ? itemStack : ItemStack.EMPTY;
        }
    }

    public void I_method_91c69b29(EquipmentSlot equipmentSlot, ItemStack itemStack) {
        if (equipmentSlot == null) {
            return;
        }
        ItemStack itemStack2 = itemStack == null ? ItemStack.EMPTY : itemStack;
        switch (equipmentSlot) {
            case MAINHAND: {
                this.I_method_5ff31f19(this.i_field_49, itemStack2);
                break;
            }
            case OFFHAND: {
                this.I_field_f2735522 = itemStack2;
                break;
            }
            case FEET: {
                this.II_method_c95fc630(0, itemStack2);
                break;
            }
            case LEGS: {
                this.II_method_c95fc630(1, itemStack2);
                break;
            }
            case CHEST: {
                this.II_method_c95fc630(2, itemStack2);
                break;
            }
            case HEAD: {
                this.II_method_c95fc630(3, itemStack2);
                break;
            }
        }
    }

    public void I_method_f2390814(float f, int n, int n2) {
        this.iI_field_46 = MathHelper.clamp((float)f, (float)0.0f, (float)1.0f);
        this.ii_field_49 = Math.max(0, n);
        this.III_field_49 = Math.max(0, n2);
    }

    public void I_method_7b63288c(boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2) {
        this.Ii_field_5a = bl;
        this.iI_field_5a = bl2;
        this.ii_field_5a = bl3;
        this.III_field_5a = bl4;
        this.ii_field_46 = Math.max(0.0f, f);
        this.III_field_46 = Math.max(0.0f, f2);
    }

    public void I_method_8dfcca01(int n, String string) {
        this.Ii_field_49 = n;
        this.iI_field_49 = 0;
        this.I_field_523beb0a = string == null ? "" : string;
        this.Ii_method_a4762035();
    }

    public void I_method_a4590ff7(int n) {
        if (this.Ii_field_49 == n || n < 0) {
            this.II_method_a4679455();
        }
    }

    public void I_method_996e96dd(int n, int n2, List<ItemStack> list) {
        if (n == 0) {
            return;
        }
        if (this.Ii_field_49 != n) {
            this.I_method_8dfcca01(n, this.I_field_523beb0a);
        }
        this.iI_field_49 = n2;
        this.Ii_method_a4762035();
        if (list == null) {
            return;
        }
        this.Iii_method_63023ed7(list.size());
        for (int i = 0; i < list.size(); ++i) {
            this.II_field_6132843d[i] = list.get(i) == null ? ItemStack.EMPTY : list.get(i);
        }
    }

    public void I_method_727a05b9(int n, int n2, int n3, ItemStack itemStack) {
        if (n == 0) {
            this.i_method_3b0b1739(n3, itemStack);
            return;
        }
        if (n3 < 0) {
            return;
        }
        if (this.Ii_field_49 != n) {
            this.I_method_8dfcca01(n, this.I_field_523beb0a);
        }
        this.iI_field_49 = n2;
        this.Iii_method_63023ed7(n3 + 1);
        this.II_field_6132843d[n3] = itemStack == null ? ItemStack.EMPTY : itemStack;
    }

    public ItemStack I_method_3609521(int n) {
        if (n < 0 || n >= this.II_field_6132843d.length) {
            return ItemStack.EMPTY;
        }
        return this.II_field_6132843d[n] == null ? ItemStack.EMPTY : this.II_field_6132843d[n];
    }

    public boolean I_method_6865f490() {
        return this.Ii_field_49 > 0;
    }

    public boolean i_method_68748070() {
        return this.II_field_46 <= 0.0f;
    }

    public boolean II_method_a4679459() {
        return this.I_field_44 != this.Ii_field_44 || this.i_field_44 != this.iI_field_44 || this.II_field_44 != this.ii_field_44;
    }

    public boolean Ii_method_a4762039() {
        return this.I_field_46 != this.IIi_field_46 || this.i_field_46 != this.IiI_field_46;
    }

    public void I_method_6865f48c() {
        this.Ii_field_44 = this.I_field_44;
        this.iI_field_44 = this.i_field_44;
        this.ii_field_44 = this.II_field_44;
        this.IIi_field_46 = this.I_field_46;
        this.IiI_field_46 = this.i_field_46;
    }

    public void i_method_6874806c() {
        int n;
        this.II_field_44 = 0.0;
        this.i_field_44 = 0.0;
        this.I_field_44 = 0.0;
        this.i_field_46 = 0.0f;
        this.I_field_46 = 0.0f;
        this.ii_field_44 = 0.0;
        this.iI_field_44 = 0.0;
        this.Ii_field_44 = 0.0;
        this.IiI_field_46 = 0.0f;
        this.IIi_field_46 = 0.0f;
        this.II_field_46 = 20.0f;
        this.Ii_field_46 = 20.0f;
        this.I_field_49 = 20;
        this.i_field_49 = 0;
        this.I_field_5a = false;
        this.i_field_5a = false;
        this.II_field_5a = true;
        this.II_field_49 = -1;
        this.iI_field_46 = 0.0f;
        this.ii_field_49 = 0;
        this.III_field_49 = 0;
        this.Ii_field_5a = false;
        this.iI_field_5a = false;
        this.ii_field_5a = false;
        this.III_field_5a = false;
        this.ii_field_46 = 0.05f;
        this.III_field_46 = 0.1f;
        this.IIi_field_49 = -1;
        for (n = 0; n < this.I_field_6132843d.length; ++n) {
            this.I_field_6132843d[n] = ItemStack.EMPTY;
        }
        for (n = 0; n < this.i_field_6132843d.length; ++n) {
            this.i_field_6132843d[n] = ItemStack.EMPTY;
        }
        this.I_field_f2735522 = ItemStack.EMPTY;
        this.i_field_f2735522 = ItemStack.EMPTY;
        this.II_method_a4679455();
    }

    private void II_method_a4679455() {
        this.Ii_field_49 = -1;
        this.iI_field_49 = 0;
        this.I_field_523beb0a = "";
        this.Ii_method_a4762035();
    }

    private void Ii_method_a4762035() {
        for (int i = 0; i < this.II_field_6132843d.length; ++i) {
            this.II_field_6132843d[i] = ItemStack.EMPTY;
        }
    }

    private void Iii_method_63023ed7(int n) {
        if (n <= this.II_field_6132843d.length) {
            return;
        }
        ItemStack[] itemStackArray = new ItemStack[n];
        System.arraycopy(this.II_field_6132843d, 0, itemStackArray, 0, this.II_field_6132843d.length);
        for (int i = this.II_field_6132843d.length; i < itemStackArray.length; ++i) {
            itemStackArray[i] = ItemStack.EMPTY;
        }
        this.II_field_6132843d = itemStackArray;
    }

    @Generated
    public double I_method_6865f47a() {
        return this.I_field_44;
    }

    @Generated
    public double i_method_6874805a() {
        return this.i_field_44;
    }

    @Generated
    public double II_method_a4679443() {
        return this.II_field_44;
    }

    @Generated
    public float I_method_6865f47c() {
        return this.I_field_46;
    }

    @Generated
    public float i_method_6874805c() {
        return this.i_field_46;
    }

    @Generated
    public float II_method_a4679445() {
        return this.II_field_46;
    }

    @Generated
    public float Ii_method_a4762025() {
        return this.Ii_field_46;
    }

    @Generated
    public int I_method_6865f47f() {
        return this.I_field_49;
    }

    @Generated
    public int i_method_6874805f() {
        return this.i_field_49;
    }

    @Generated
    public boolean iI_method_a62a8479() {
        return this.I_field_5a;
    }

    @Generated
    public boolean ii_method_a6391059() {
        return this.i_field_5a;
    }

    @Generated
    public boolean III_method_e899edb0() {
        return this.II_field_5a;
    }

    @Generated
    public int II_method_a4679448() {
        return this.II_field_49;
    }

    @Generated
    public ItemStack[] I_method_12cfb5f3() {
        return this.I_field_6132843d;
    }

    @Generated
    public ItemStack[] i_method_b6c839d3() {
        return this.i_field_6132843d;
    }

    @Generated
    public ItemStack i_method_b32594cc() {
        return this.I_field_f2735522;
    }

    @Generated
    public ItemStack II_method_adf79583() {
        return this.i_field_f2735522;
    }

    @Generated
    public ItemStack[] II_method_16364ffc() {
        return this.II_field_6132843d;
    }

    @Generated
    public int Ii_method_a4762028() {
        return this.Ii_field_49;
    }

    @Generated
    public int iI_method_a62a8468() {
        return this.iI_field_49;
    }

    @Generated
    public String I_method_a2c22994() {
        return this.I_field_523beb0a;
    }

    @Generated
    public float iI_method_a62a8465() {
        return this.iI_field_46;
    }

    @Generated
    public int ii_method_a6391048() {
        return this.ii_field_49;
    }

    @Generated
    public int III_method_e899ed9f() {
        return this.III_field_49;
    }

    @Generated
    public boolean IIi_method_e8a87990() {
        return this.Ii_field_5a;
    }

    @Generated
    public boolean IiI_method_ea5cddd0() {
        return this.iI_field_5a;
    }

    @Generated
    public boolean Iii_method_ea6b69b0() {
        return this.ii_field_5a;
    }

    @Generated
    public boolean iII_method_1f350190() {
        return this.III_field_5a;
    }

    @Generated
    public float ii_method_a6391045() {
        return this.ii_field_46;
    }

    @Generated
    public float III_method_e899ed9c() {
        return this.III_field_46;
    }

    @Generated
    public int IIi_method_e8a8797f() {
        return this.IIi_field_49;
    }

    @Generated
    public long I_method_6865f480() {
        return this.I_field_4a;
    }

    @Generated
    public double Ii_method_a4762023() {
        return this.Ii_field_44;
    }

    @Generated
    public double iI_method_a62a8463() {
        return this.iI_field_44;
    }

    @Generated
    public double ii_method_a6391043() {
        return this.ii_field_44;
    }

    @Generated
    public float IIi_method_e8a8797c() {
        return this.IIi_field_46;
    }

    @Generated
    public float IiI_method_ea5cddbc() {
        return this.IiI_field_46;
    }

    @Generated
    public void I_method_a458fd32(double d) {
        this.I_field_44 = d;
    }

    @Generated
    public void i_method_a61bed52(double d) {
        this.i_field_44 = d;
    }

    @Generated
    public void II_method_e88b5689(double d) {
        this.II_field_44 = d;
    }

    @Generated
    public void I_method_a45904b4(float f) {
        this.I_field_46 = f;
    }

    @Generated
    public void i_method_a61bf4d4(float f) {
        this.i_field_46 = f;
    }

    @Generated
    public void II_method_e88b5e0b(float f) {
        this.II_field_46 = f;
    }

    @Generated
    public void Ii_method_ea4e4e2b(float f) {
        this.Ii_field_46 = f;
    }

    @Generated
    public void i_method_a61c0017(int n) {
        this.I_field_49 = n;
    }

    @Generated
    public void II_method_e88b694e(int n) {
        this.i_field_49 = n;
    }

    @Generated
    public void I_method_a4594fc8(boolean bl) {
        this.I_field_5a = bl;
    }

    @Generated
    public void i_method_a61c3fe8(boolean bl) {
        this.i_field_5a = bl;
    }

    @Generated
    public void II_method_e88ba91f(boolean bl) {
        this.II_field_5a = bl;
    }

    @Generated
    public void Ii_method_ea4e596e(int n) {
        this.II_field_49 = n;
    }

    @Generated
    public void I_method_391e572b(ItemStack[] itemStackArray) {
        this.I_field_6132843d = itemStackArray;
    }

    @Generated
    public void i_method_14364f4b(ItemStack[] itemStackArray) {
        this.i_field_6132843d = itemStackArray;
    }

    @Generated
    public void I_method_4d590ee(ItemStack itemStack) {
        this.I_field_f2735522 = itemStack;
    }

    @Generated
    public void i_method_a8ce14ce(ItemStack itemStack) {
        this.i_field_f2735522 = itemStack;
    }

    @Generated
    public void II_method_a28afe42(ItemStack[] itemStackArray) {
        this.II_field_6132843d = itemStackArray;
    }

    @Generated
    public void iI_method_1f267d2e(int n) {
        this.Ii_field_49 = n;
    }

    @Generated
    public void ii_method_20e96d4e(int n) {
        this.iI_field_49 = n;
    }

    @Generated
    public void I_method_5a439356(String string) {
        this.I_field_523beb0a = string;
    }

    @Generated
    public void iI_method_1f2671eb(float f) {
        this.iI_field_46 = f;
    }

    @Generated
    public void III_method_2aa43ad7(int n) {
        this.ii_field_49 = n;
    }

    @Generated
    public void IIi_method_2c672af7(int n) {
        this.III_field_49 = n;
    }

    @Generated
    public void Ii_method_ea4e993f(boolean bl) {
        this.Ii_field_5a = bl;
    }

    @Generated
    public void iI_method_1f26bcff(boolean bl) {
        this.iI_field_5a = bl;
    }

    @Generated
    public void ii_method_20e9ad1f(boolean bl) {
        this.ii_field_5a = bl;
    }

    @Generated
    public void III_method_2aa47aa8(boolean bl) {
        this.III_field_5a = bl;
    }

    @Generated
    public void ii_method_20e9620b(float f) {
        this.ii_field_46 = f;
    }

    @Generated
    public void III_method_2aa42f94(float f) {
        this.III_field_46 = f;
    }

    @Generated
    public void IiI_method_613f4eb7(int n) {
        this.IIi_field_49 = n;
    }

    @Generated
    public void I_method_a45913b8(long l) {
        this.I_field_4a = l;
    }

    @Generated
    public void Ii_method_ea4e46a9(double d) {
        this.Ii_field_44 = d;
    }

    @Generated
    public void iI_method_1f266a69(double d) {
        this.iI_field_44 = d;
    }

    @Generated
    public void ii_method_20e95a89(double d) {
        this.ii_field_44 = d;
    }

    @Generated
    public void IIi_method_2c671fb4(float f) {
        this.IIi_field_46 = f;
    }

    @Generated
    public void IiI_method_613f4374(float f) {
        this.IiI_field_46 = f;
    }
}

