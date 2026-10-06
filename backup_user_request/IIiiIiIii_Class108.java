package rockstar.client;

import jep.ClassEnquirer;

public final class IIiiIiIii_Class108
implements ClassEnquirer {
    private static final String PACKAGE = "pyrock";

    public boolean isJavaPackage(String string) {
        if (string == null) {
            return false;
        }
        return string.equals(PACKAGE) || string.startsWith("pyrock.") || string.equals("java") || string.equals("java.io");
    }

    public String[] getClassNames(String string) {
        return new String[0];
    }

    public String[] getSubPackages(String string) {
        return new String[0];
    }
}

