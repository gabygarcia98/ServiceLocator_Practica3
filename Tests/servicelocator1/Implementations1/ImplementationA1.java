package servicelocator1.Implementations1;

import servicelocator1.Interfaces1.InterfaceA;
import servicelocator1.Interfaces1.InterfaceB;
import servicelocator1.Interfaces1.InterfaceC;

public class ImplementationA1 implements InterfaceA {

    private InterfaceB b;
    private InterfaceC c;
    public ImplementationA1(InterfaceB b, InterfaceC c){
        this.b = b;
        this.c = c;
    }
    public InterfaceB getB(){
        return b;
    }
    public InterfaceC getC(){
        return c;
    }
}
