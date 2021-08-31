
package banco;


public abstract class Cuenta {

    private String numCuenta;
    private String fechCuenta;
    private double intCuenta;
    private double salCuenta;
    
    public void setNumCuenta(String numeroCta) {
        this.numCuenta = numeroCta;
    }
    
    public String getNumCuenta() {
        return this.numCuenta;
    }
    
    public void setFechCuenta(String fechaCta) {
        this.fechCuenta = fechaCta;
    }
    
    public String getFechCuenta() {
        return this.fechCuenta;
    }
    
    public void setIntCuenta(double interesCta) {
        this.intCuenta = interesCta;
    }
    
    public double getIntCuenta() {
        return this.intCuenta;
    }
    
    public void setSalCuenta(double saldoCta) {
        this.salCuenta = saldoCta;
    }
    
    public double getSalCuenta() {
        return this.salCuenta;
    }
    
    //Método abstracto
    public abstract double calcInteres();
    
    
}
