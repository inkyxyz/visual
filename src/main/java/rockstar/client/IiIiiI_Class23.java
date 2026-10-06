package rockstar.client;

import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rockstar.client.IiIIii_Class20;

public final class IiIiiI_Class23 {
    private static final Pattern I_field_5fd3861f = Pattern.compile("viewBox\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern i_field_5fd3861f = Pattern.compile("<(path|rect|circle|ellipse|polygon|line)\\b([^>]*)>", 2);
    private static final Pattern II_field_5fd3861f = Pattern.compile("([a-zA-Z-]+)\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern Ii_field_5fd3861f = Pattern.compile("[-+]?(?:\\d*\\.\\d+|\\d+)(?:[eE][-+]?\\d+)?");
    private static final Pattern iI_field_5fd3861f = Pattern.compile("([MmLlHhVvCcSsQqTtAaZz])([^MmLlHhVvCcSsQqTtAaZz]*)");
    private static final Pattern ii_field_5fd3861f = Pattern.compile("<(defs|clipPath|mask|pattern|symbol|filter)\\b[\\s\\S]*?</\\1\\s*>", 2);
    private static final double I_field_44 = 0.890625;

    private IiIiiI_Class23() {
    }

    public static IiIIii_Class20 I_method_8219f141(String string) {
        Path2D.Double double_ = new Path2D.Double(1);
        Matcher matcher = i_field_5fd3861f.matcher(ii_field_5fd3861f.matcher(string).replaceAll(""));
        while (matcher.find()) {
            IiIiiI_Class23.I_method_8ad48caf(double_, matcher.group(1).toLowerCase(), IiIiiI_Class23.I_method_e40cc8cb(matcher.group(2)));
        }
        Area area = new Area(double_);
        Rectangle2D rectangle2D = area.getBounds2D();
        if (rectangle2D.isEmpty()) {
            return IiIIii_Class20.I_method_e96b4def(area, 1.0f);
        }
        double d = Math.max(rectangle2D.getWidth(), rectangle2D.getHeight());
        double d2 = 0.890625 / d;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(0.0, -2048.0);
        affineTransform.translate(1024.0, 1024.0);
        affineTransform.scale(2048.0 * d2, 2048.0 * d2);
        affineTransform.translate(-rectangle2D.getCenterX(), -rectangle2D.getCenterY());
        return IiIIii_Class20.I_method_e96b4def(affineTransform.createTransformedShape(area), 1.0f);
    }

    private static Map<String, String> I_method_e40cc8cb(String string) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Matcher matcher = II_field_5fd3861f.matcher(string);
        while (matcher.find()) {
            hashMap.put(matcher.group(1).toLowerCase(), matcher.group(2));
        }
        return hashMap;
    }

    private static void I_method_8ad48caf(Path2D.Double double_, String string, Map<String, String> map) {
        if ("none".equalsIgnoreCase(map.getOrDefault("fill", ""))) {
            return;
        }
        Path2D.Double double_2 = new Path2D.Double(1);
        switch (string) {
            case "path": {
                IiIiiI_Class23.I_method_8ffa6016(double_2, map.getOrDefault("d", ""));
                break;
            }
            case "rect": {
                double d = IiIiiI_Class23.I_method_4a922749(map, "x", 0.0);
                double d2 = IiIiiI_Class23.I_method_4a922749(map, "y", 0.0);
                double d3 = IiIiiI_Class23.I_method_4a922749(map, "width", 0.0);
                double d4 = IiIiiI_Class23.I_method_4a922749(map, "height", 0.0);
                double d5 = IiIiiI_Class23.I_method_4a922749(map, "rx", 0.0);
                double d6 = IiIiiI_Class23.I_method_4a922749(map, "ry", d5);
                if (d5 > 0.0 || d6 > 0.0) {
                    double_2.append(new RoundRectangle2D.Double(d, d2, d3, d4, Math.max(d5, d6) * 2.0, Math.max(d5, d6) * 2.0), false);
                    break;
                }
                double_2.append(new Rectangle2D.Double(d, d2, d3, d4), false);
                break;
            }
            case "circle": {
                double d = IiIiiI_Class23.I_method_4a922749(map, "r", 0.0);
                double_2.append(new Ellipse2D.Double(IiIiiI_Class23.I_method_4a922749(map, "cx", 0.0) - d, IiIiiI_Class23.I_method_4a922749(map, "cy", 0.0) - d, d * 2.0, d * 2.0), false);
                break;
            }
            case "ellipse": {
                double d = IiIiiI_Class23.I_method_4a922749(map, "rx", 0.0);
                double d7 = IiIiiI_Class23.I_method_4a922749(map, "ry", 0.0);
                double_2.append(new Ellipse2D.Double(IiIiiI_Class23.I_method_4a922749(map, "cx", 0.0) - d, IiIiiI_Class23.I_method_4a922749(map, "cy", 0.0) - d7, d * 2.0, d7 * 2.0), false);
                break;
            }
            case "polygon": {
                List<Double> list = IiIiiI_Class23.I_method_9d81ee71(map.getOrDefault("points", ""));
                int n = 0;
                while (n + 1 < list.size()) {
                    if (n == 0) {
                        double_2.moveTo(list.get(0), list.get(1));
                    } else {
                        double_2.lineTo(list.get(n), list.get(n + 1));
                    }
                    n += 2;
                }
                double_2.closePath();
                break;
            }
            case "line": {
                double_2.moveTo(IiIiiI_Class23.I_method_4a922749(map, "x1", 0.0), IiIiiI_Class23.I_method_4a922749(map, "y1", 0.0));
                double_2.lineTo(IiIiiI_Class23.I_method_4a922749(map, "x2", 0.0), IiIiiI_Class23.I_method_4a922749(map, "y2", 0.0));
                break;
            }
        }
        Object object = IiIiiI_Class23.I_method_5efbcfaf(map.get("transform"));
        double_.append(object == null ? double_2 : ((AffineTransform)object).createTransformedShape(double_2), false);
    }

    private static AffineTransform I_method_5efbcfaf(String string) {
        if (string == null || string.isBlank()) {
            return null;
        }
        AffineTransform affineTransform = new AffineTransform();
        Matcher matcher = Pattern.compile("([a-zA-Z]+)\\s*\\(([^)]*)\\)").matcher(string);
        while (matcher.find()) {
            List<Double> list = IiIiiI_Class23.I_method_9d81ee71(matcher.group(2));
            switch (matcher.group(1).toLowerCase()) {
                case "translate": {
                    affineTransform.translate(list.get(0), list.size() > 1 ? list.get(1) : 0.0);
                    break;
                }
                case "scale": {
                    affineTransform.scale(list.get(0), list.size() > 1 ? list.get(1) : list.get(0));
                    break;
                }
                case "rotate": {
                    if (list.size() >= 3) {
                        affineTransform.rotate(Math.toRadians(list.get(0)), list.get(1), list.get(2));
                        break;
                    }
                    affineTransform.rotate(Math.toRadians(list.get(0)));
                    break;
                }
                case "matrix": {
                    if (list.size() < 6) break;
                    affineTransform.concatenate(new AffineTransform(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)));
                    break;
                }
            }
        }
        return affineTransform;
    }

    private static double I_method_4a922749(Map<String, String> map, String string, double d) {
        String string2 = map.get(string);
        if (string2 == null) {
            return d;
        }
        List<Double> list = IiIiiI_Class23.I_method_9d81ee71(string2);
        return list.isEmpty() ? d : list.get(0);
    }

    private static List<Double> I_method_9d81ee71(String string) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        Matcher matcher = Ii_field_5fd3861f.matcher(string);
        while (matcher.find()) {
            arrayList.add(Double.parseDouble(matcher.group()));
        }
        return arrayList;
    }

    private static void I_method_8ffa6016(Path2D.Double double_, String string) {
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = 0.0;
        int n = 32;
        Matcher matcher = iI_field_5fd3861f.matcher(string);
        while (matcher.find()) {
            char c = matcher.group(1).charAt(0);
            List<Double> list = IiIiiI_Class23.I_method_9d81ee71(matcher.group(2));
            boolean bl = Character.isLowerCase(c);
            int n2 = Character.toUpperCase(c);
            int n3 = 0;
            do {
                switch (n2) {
                    case 77: {
                        if (list.size() < n3 + 2) break;
                        d = bl ? d + list.get(n3) : list.get(n3);
                        double d9 = d2 = bl ? d2 + list.get(n3 + 1) : list.get(n3 + 1);
                        if (n3 == 0) {
                            double_.moveTo(d, d2);
                            d3 = d;
                            d4 = d2;
                        } else {
                            double_.lineTo(d, d2);
                        }
                        n3 += 2;
                        break;
                    }
                    case 76: {
                        if (list.size() < n3 + 2) break;
                        d = bl ? d + list.get(n3) : list.get(n3);
                        d2 = bl ? d2 + list.get(n3 + 1) : list.get(n3 + 1);
                        double_.lineTo(d, d2);
                        n3 += 2;
                        break;
                    }
                    case 72: {
                        if (list.size() < n3 + 1) break;
                        d = bl ? d + list.get(n3) : list.get(n3);
                        double_.lineTo(d, d2);
                        ++n3;
                        break;
                    }
                    case 86: {
                        if (list.size() < n3 + 1) break;
                        d2 = bl ? d2 + list.get(n3) : list.get(n3);
                        double_.lineTo(d, d2);
                        ++n3;
                        break;
                    }
                    case 67: {
                        if (list.size() < n3 + 6) break;
                        double d10 = bl ? d + list.get(n3) : list.get(n3);
                        double d11 = bl ? d2 + list.get(n3 + 1) : list.get(n3 + 1);
                        double d12 = bl ? d + list.get(n3 + 2) : list.get(n3 + 2);
                        double d13 = bl ? d2 + list.get(n3 + 3) : list.get(n3 + 3);
                        d = bl ? d + list.get(n3 + 4) : list.get(n3 + 4);
                        d2 = bl ? d2 + list.get(n3 + 5) : list.get(n3 + 5);
                        double_.curveTo(d10, d11, d12, d13, d, d2);
                        d5 = d12;
                        d6 = d13;
                        n3 += 6;
                        break;
                    }
                    case 83: {
                        if (list.size() < n3 + 4) break;
                        boolean bl2 = n == 67 || n == 83;
                        double d14 = bl2 ? 2.0 * d - d5 : d;
                        double d15 = bl2 ? 2.0 * d2 - d6 : d2;
                        double d16 = bl ? d + list.get(n3) : list.get(n3);
                        double d17 = bl ? d2 + list.get(n3 + 1) : list.get(n3 + 1);
                        d = bl ? d + list.get(n3 + 2) : list.get(n3 + 2);
                        d2 = bl ? d2 + list.get(n3 + 3) : list.get(n3 + 3);
                        double_.curveTo(d14, d15, d16, d17, d, d2);
                        d5 = d16;
                        d6 = d17;
                        n3 += 4;
                        break;
                    }
                    case 81: {
                        if (list.size() < n3 + 4) break;
                        double d18 = bl ? d + list.get(n3) : list.get(n3);
                        double d11 = bl ? d2 + list.get(n3 + 1) : list.get(n3 + 1);
                        d = bl ? d + list.get(n3 + 2) : list.get(n3 + 2);
                        d2 = bl ? d2 + list.get(n3 + 3) : list.get(n3 + 3);
                        double_.quadTo(d18, d11, d, d2);
                        d7 = d18;
                        d8 = d11;
                        n3 += 4;
                        break;
                    }
                    case 84: {
                        if (list.size() < n3 + 2) break;
                        boolean bl3 = n == 81 || n == 84;
                        double d14 = bl3 ? 2.0 * d - d7 : d;
                        double d15 = bl3 ? 2.0 * d2 - d8 : d2;
                        d = bl ? d + list.get(n3) : list.get(n3);
                        d2 = bl ? d2 + list.get(n3 + 1) : list.get(n3 + 1);
                        double_.quadTo(d14, d15, d, d2);
                        d7 = d14;
                        d8 = d15;
                        n3 += 2;
                        break;
                    }
                    case 65: {
                        if (list.size() < n3 + 7) break;
                        double d19 = list.get(n3);
                        double d11 = list.get(n3 + 1);
                        double d12 = list.get(n3 + 2);
                        boolean bl4 = list.get(n3 + 3) != 0.0;
                        boolean bl5 = list.get(n3 + 4) != 0.0;
                        double d20 = bl ? d + list.get(n3 + 5) : list.get(n3 + 5);
                        double d21 = bl ? d2 + list.get(n3 + 6) : list.get(n3 + 6);
                        IiIiiI_Class23.I_method_e2c4a832(double_, d, d2, d19, d11, d12, bl4, bl5, d20, d21);
                        d = d20;
                        d2 = d21;
                        n3 += 7;
                        break;
                    }
                    case 90: {
                        double_.closePath();
                        d = d3;
                        d2 = d4;
                        n3 = list.size();
                        break;
                    }
                    default: {
                        n3 = list.size();
                    }
                }
                n = n2;
                if (n2 != 77) continue;
                n2 = 76;
            } while (n3 < list.size() && n2 != 90);
        }
    }

    private static void I_method_e2c4a832(Path2D.Double double_, double d, double d2, double d3, double d4, double d5, boolean bl, boolean bl2, double d6, double d7) {
        double d8;
        if (d3 == 0.0 || d4 == 0.0) {
            double_.lineTo(d6, d7);
            return;
        }
        double d9 = Math.toRadians(d5);
        double d10 = Math.cos(d9);
        double d11 = Math.sin(d9);
        double d12 = (d - d6) * 0.5;
        double d13 = (d2 - d7) * 0.5;
        double d14 = d10 * d12 + d11 * d13;
        double d15 = -d11 * d12 + d10 * d13;
        double d16 = d14 * d14 / ((d3 = Math.abs(d3)) * d3) + d15 * d15 / ((d4 = Math.abs(d4)) * d4);
        if (d16 > 1.0) {
            d8 = Math.sqrt(d16);
            d3 *= d8;
            d4 *= d8;
        }
        d8 = bl == bl2 ? -1.0 : 1.0;
        double d17 = d3 * d3 * d4 * d4 - d3 * d3 * d15 * d15 - d4 * d4 * d14 * d14;
        double d18 = d3 * d3 * d15 * d15 + d4 * d4 * d14 * d14;
        double d19 = d8 * Math.sqrt(Math.max(d17 / d18, 0.0));
        double d20 = d19 * d3 * d15 / d4;
        double d21 = -d19 * d4 * d14 / d3;
        double d22 = d10 * d20 - d11 * d21 + (d + d6) * 0.5;
        double d23 = d11 * d20 + d10 * d21 + (d2 + d7) * 0.5;
        double d24 = Math.atan2((d15 - d21) / d4, (d14 - d20) / d3);
        double d25 = Math.atan2((-d15 - d21) / d4, (-d14 - d20) / d3);
        double d26 = d25 - d24;
        if (!bl2 && d26 > 0.0) {
            d26 -= Math.PI * 2;
        }
        if (bl2 && d26 < 0.0) {
            d26 += Math.PI * 2;
        }
        Arc2D.Double double_2 = new Arc2D.Double(d22 - d3, d23 - d4, d3 * 2.0, d4 * 2.0, -Math.toDegrees(d24), -Math.toDegrees(d26), 0);
        AffineTransform affineTransform = AffineTransform.getRotateInstance(d9, d22, d23);
        double_.append(affineTransform.createTransformedShape(double_2), true);
    }
}

