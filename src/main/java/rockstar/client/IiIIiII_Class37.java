package rockstar.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import rockstar.client.IIIIIIi_Class2;
import rockstar.client.IIiiiIi_Class30;
import rockstar.client.IiIIiIi_Class38;
import rockstar.client.IiiiII_Class29;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;

public class IiIIiII_Class37
extends IIIIIIi_Class2
implements IiIIiIi_Class38<List<IIiiiIi_Class30>> {
    public IiIIiII_Class37(String string) throws MalformedURLException {
        super("https://" + string + "/worlds");
    }

    @Override
    public List<IIiiiIi_Class30> I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        ArrayList<IIiiiIi_Class30> arrayList = new ArrayList<IIiiiIi_Class30>();
        for (IiiiII_Class29 iiiiII_Class29 : iiiiIi_Class30.i_method_831a81a1("servers")) {
            arrayList.add(IIiiiIi_Class30.I_method_3adddd56(iiiiII_Class29.I_method_9b832f2b()));
        }
        return arrayList;
    }
}

