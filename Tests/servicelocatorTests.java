import Factories1.FactoryA1;
import Factories1.FactoryB1;
import Factories1.FactoryC1;
import Factories1.FactoryD1;
import Implementations1.ImplementationA1;
import Implementations1.ImplementationB1;
import Implementations1.ImplementationC1;
import Implementations1.ImplementationD1;
import Interfaces1.InterfaceA;
import Interfaces1.InterfaceB;
import Interfaces1.InterfaceC;
import Interfaces1.InterfaceD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import serviceLocator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class servicelocatorTests {

    private ServiceLocator simpleService;
    private ServiceLocator cachedService;

    private Factory factoryA = new FactoryA1();
    private Factory factoryB = new FactoryB1();
    private Factory factoryC = new FactoryC1();
    private Factory factoryD = new FactoryD1();

    private InterfaceA implementationA;
    private InterfaceB implementationB;
    private InterfaceC implementationC;
    private InterfaceD implementationD;

    @BeforeEach
    void init() throws LocatorError {
        simpleService = new SimpleServiceLocator();
        cachedService = new CachedServiceLocator();

        serviceInitialitzation(simpleService);
        serviceInitialitzation(cachedService);

        implementationC = new ImplementationC1("Agustin Tapia");
        implementationD = new ImplementationD1(5);
        implementationB = new ImplementationB1(implementationD);
        implementationA = new ImplementationA1(implementationB, implementationC);

    }
    private void serviceInitialitzation(ServiceLocator service) throws LocatorError{
        service.setConstant("Tornejos guanyats", 5);
        service.setConstant("jugador", "Agustin Tapia");

    }

    @Test
    void getObjectService() throws LocatorError{
        assertEquals("Agustin Tapia", simpleService.getObject("jugador"));
        assertEquals(5, simpleService.getObject("Tornejos guanyats"));

        

    }
}
