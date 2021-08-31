
package banco;


public class CtaCorriente extends Cuenta {
    private double sobregiro;

    public void setSobreCuenta(double sobreCta) {
        this.sobregiro = sobreCta;
    }
    
    public double getSobreCuenta() {
        return this.sobregiro;
    }
    
    @Override
    public double calcInteres() {
        double interesCuenta = 0;
        
        if (this.getSalCuenta() <= 0) {
            interesCuenta = 0;
        } else {
            interesCuenta = this.getSalCuenta() * this.getIntCuenta()/100;
        }
        
        
        return interesCuenta;
    }
}
