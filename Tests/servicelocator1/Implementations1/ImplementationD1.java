package servicelocator1.Implementations1;

import servicelocator1.Interfaces1.InterfaceD;

public class ImplementationD1 implements InterfaceD {
    private int i;
    public ImplementationD1(int i){
        this.i = i;
    }
    public int getI(){
        return i;
    }
}
