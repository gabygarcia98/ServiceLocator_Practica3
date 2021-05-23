package servicelocator2.Factories2;

import servicelocator2.LocatorError;
import servicelocator2.ServiceLocator;
import servicelocator2.Implementations2.ImplementationC1;
import servicelocator2.Factory;
import servicelocator2.Interficies.InterfaceC;

public class FactoryC1_2 implements Factory<InterfaceC> {
    public ImplementationC1 create(ServiceLocator sl) throws LocatorError {
        String s =  sl.getObject(String.class);
        return new ImplementationC1(s);
    }

}
