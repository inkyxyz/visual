package rockstar.client;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import javax.annotation.Nullable;
import rockstar.client.IIIIiIi_Class6;
import rockstar.client.IIIIiii_Class8;
import rockstar.client.iIIIiI_Class35;

public class IIIiIII_Class9
implements IIIIiii_Class8 {
    @Override
    public IIIIiIi_Class6 I_method_ef0329f6(iIIIiI_Class35 iIIIiI_Class352) {
        Long l;
        Optional<String> optional = iIIIiI_Class352.I_method_a5598def("Retry-After");
        if (optional.isPresent() && (l = this.I_method_91f4112c(optional.get())) != null && l > 0L) {
            return IIIIiIi_Class6.I_method_be1cd89b(l);
        }
        return IIIIiIi_Class6.I_field_f1a647ac;
    }

    @Nullable
    private Long I_method_91f4112c(String string) {
        try {
            Instant instant = Instant.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(string));
            return instant.toEpochMilli() - Instant.now().toEpochMilli();
        }
        catch (DateTimeParseException dateTimeParseException) {
            try {
                int n = Integer.parseInt(string);
                return (long)n * 1000L;
            }
            catch (NumberFormatException numberFormatException) {
                return null;
            }
        }
    }
}

