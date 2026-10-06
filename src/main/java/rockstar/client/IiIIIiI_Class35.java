package rockstar.client;

import java.io.IOException;
import java.net.MalformedURLException;
import rockstar.client.IIIIIIi_Class2;
import rockstar.client.IIiiiII_Class29;
import rockstar.client.IIiiiIi_Class30;
import rockstar.client.IiIIiIi_Class38;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.iIIIiI_Class35;

public class IiIIIiI_Class35
extends IIIIIIi_Class2
implements IiIIiIi_Class38<IIiiiII_Class29> {
    public IiIIIiI_Class35(IIiiiIi_Class30 iIiiiIi_Class30) throws MalformedURLException {
        super("https://pc.realms.minecraft.net/worlds/v1/" + iIiiiIi_Class30.I_method_6e115853() + "/join/pc");
    }

    @Override
    public IIiiiII_Class29 I_method_b7becc11(iIIIiI_Class35 iIIIiI_Class352, IiiiIi_Class30 iiiiIi_Class30) throws IOException {
        return IIiiiII_Class29.I_method_f76e0596(iiiiIi_Class30);
    }
}

