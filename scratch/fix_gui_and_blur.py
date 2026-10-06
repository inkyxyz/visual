import re

file_path = r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\IiiIiIiiI_Class215.java'

with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

# 1. Replace "Agravity" on line 239 with "Rockstar"
for i in range(len(lines)):
    if '"Agravity"' in lines[i]:
        lines[i] = lines[i].replace('"Agravity"', '"Rockstar"')
        print(f"Replaced 'Agravity' with 'Rockstar' at line {i+1}")

# 2. Fix settings menu blur in i_method_f5052edf
# Find the method containing drawBackdropBlur
start_idx = -1
end_idx = -1
for i in range(len(lines)):
    if 'drawBackdropBlur' in lines[i]:
        # Search backwards for method header
        for j in range(i, max(0, i - 30), -1):
            if 'private void ' in lines[j]:
                start_idx = j
                break
        # Search forwards for method end
        for j in range(i, min(len(lines), i + 25)):
            if lines[j].strip() == '}':
                end_idx = j
                break
        break

if start_idx != -1 and end_idx != -1:
    print(f"Found settings backdrop method between lines {start_idx+1} and {end_idx+1}")
    # Replace body of method with clean sleek obsidian panel without blur
    new_method = [
        lines[start_idx], # private void ...
        "      if (!this.closing && this.I_field_75e36361 != null && this.i_field_b584628c != null) {\n",
        "         float var3 = var2.x() - 11.0F;\n",
        "         float var4 = var2.x() + var2.w() + 11.0F;\n",
        "         float var5 = var2.y() - 10.5F;\n",
        "         float var6 = var2.h() + 10.5F + 22.0F;\n",
        "         float bw = var4 - var3;\n",
        "         float bh = var6;\n",
        "         // Crystal clear dark obsidian glass with soft shadow and crisp border - NO BLUR\n",
        "         var1.drawShadow(var3, var5, bw, bh, 14.0F, IIiii_Class8.I_method_893b2757(7.0F), new ColorRGBA(0, 0, 0, 160));\n",
        "         var1.drawSquircle(var3, var5, bw, bh, 2.5F, IIiii_Class8.I_method_893b2757(7.0F), new ColorRGBA(15.0F, 17.0F, 22.0F, 240.0F));\n",
        "         var1.drawRoundedBorder(var3, var5, bw, bh, 1.0F, IIiii_Class8.I_method_893b2757(7.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 24.0F));\n",
        "      }\n",
        "   }\n"
    ]
    lines[start_idx:end_idx+1] = new_method
    print("Replaced settings backdrop method with crisp obsidian glass!")

with open(file_path, 'w', encoding='utf-8') as f:
    f.writelines(lines)

print("IiiIiIiiI_Class215.java updated successfully!")
