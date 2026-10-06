import os

path = r'c:\Users\Admin-HP\Desktop\rockstar-client-src\src\main\java\rockstar\client\WorldModule.java'
with open(path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

new_lines = []
skip = False
for line in lines:
    if 'this.matrixRainSetting = new BooleanSetting' in line:
        skip = True
        continue
    if skip:
        if 'this.matrixGlowSetting = new BooleanSetting' in line:
            skip = False
        continue
    if 'private static final String MATRIX_CHARS' in line:
        skip = True
        continue
    if skip:
        if 'private void renderCosmicGalaxies' in line:
            skip = False
            new_lines.append(line)
        continue
    new_lines.append(line)

with open(path, 'w', encoding='utf-8') as f:
    f.writelines(new_lines)

print('Matrix rain removed successfully! Total lines:', len(new_lines))
