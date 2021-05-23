package servicelocator1.Implementations1;

import servicelocator1.Interfaces1.InterfaceB;
import servicelocator1.Interfaces1.InterfaceD;

public class ImplementationB1 implements InterfaceB {
    private InterfaceD d;
    public ImplementationB1(InterfaceD d){
        this.d = d;
    }
    public InterfaceD getD(){
        return d;
    }

}
