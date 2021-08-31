
package banco;

public class CtaAhorros extends Cuenta {

    private double VI;
    
    @Override
    public double calcInteres() {
                
        this.VI = 0;
        
        this.VI = this.getIntCuenta() * this.getSalCuenta() / 100; 
        return this.VI;
        
    }
    
}