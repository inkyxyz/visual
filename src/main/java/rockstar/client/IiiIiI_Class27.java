package rockstar.client;

import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.Reader;
import lombok.Generated;
import rockstar.client.IiiiII_Class29;

public final class IiiIiI_Class27 {
    public static IiiiII_Class29 I_method_c7ec7501(String string) {
        return IiiiII_Class29.I_method_f548a31a(JsonParser.parseString((String)string));
    }

    public static IiiiII_Class29 I_method_ef1a0efb(Reader reader) {
        return IiiiII_Class29.I_method_f548a31a(JsonParser.parseReader((Reader)reader));
    }

    public static IiiiII_Class29 I_method_1e56a3a0(JsonReader jsonReader) {
        return IiiiII_Class29.I_method_f548a31a(JsonParser.parseReader((JsonReader)jsonReader));
    }

    @Generated
    private IiiIiI_Class27() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

