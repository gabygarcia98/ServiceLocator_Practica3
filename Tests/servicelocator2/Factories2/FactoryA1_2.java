package servicelocator2.Factories2;

import servicelocator2.Implementations2.*;
import servicelocator2.Factory;
import servicelocator2.Interficies.*;
import servicelocator2.LocatorError;
import servicelocator2.ServiceLocator;

public class FactoryA1_2 implements Factory<InterfaceA> {
    public InterfaceA create (ServiceLocator sl) throws LocatorError {
        InterfaceB b = sl.getObject(InterfaceB.class);
        InterfaceC c = sl.getObject(InterfaceC.class);
        return new ImplementationA1(b,c);
    }
}
