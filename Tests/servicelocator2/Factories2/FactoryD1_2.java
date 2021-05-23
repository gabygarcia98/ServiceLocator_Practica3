package servicelocator2.Factories2;

import servicelocator2.Implementations2.ImplementationD1;
import servicelocator2.Factory;
import servicelocator2.Interficies.InterfaceD;
import servicelocator2.LocatorError;
import servicelocator2.ServiceLocator;

public class FactoryD1_2 implements Factory<InterfaceD> {
    @Override
    public InterfaceD create(ServiceLocator sl) throws LocatorError {
        return new ImplementationD1(sl.getObject(Integer.class));
    }
}
