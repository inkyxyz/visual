package rockstar.client;

import java.util.Collections;
import java.util.List;
import rockstar.client.IIiIIIIi_Class34;

@FunctionalInterface
public interface IIiIIIII_Class33 {
    public IIiIIIIi_Class34 validate(String var1);

    default public List<String> suggestions(String string) {
        return Collections.emptyList();
    }
}

