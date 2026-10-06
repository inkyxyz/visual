package rockstar.client;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import rockstar.client.ModuleCategory;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface ModuleInfo {
    public String name();

    public ModuleCategory category();

    public int defaultKey() default -1;

    public boolean enabledByDefault() default false;

    public boolean iI_method_476ab839() default false;

    public boolean ii_method_47794419() default false;

    public String III_method_a89e5834() default "modules.descriptions.no_description";

    public boolean staffOnly() default false;
}

