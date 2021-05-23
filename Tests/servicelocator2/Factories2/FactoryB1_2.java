package servicelocator2.Factories2;

import servicelocator2.Factory;
import servicelocator2.Implementations2.ImplementationB1;
import servicelocator2.Interficies.InterfaceB;
import servicelocator2.Interficies.InterfaceD;
import servicelocator2.LocatorError;
import servicelocator2.ServiceLocator;

public class FactoryB1_2 implements Factory<InterfaceB> {
    public InterfaceB create(ServiceLocator sl) throws LocatorError {
        InterfaceD d = sl.getObject(InterfaceD.class);
        return new ImplementationB1(d);
    }
}
