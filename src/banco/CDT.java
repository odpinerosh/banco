
package banco;


public class CDT {

    private String numCDT;
    private String fechCDT;
    private double intCDT, montoCDT, intMensualCDT, valRetorno;
    private int plazoCDT;
    
    public void setNumCDT(String numeroCDT) {
        this.numCDT = numeroCDT;
    }
    
    public String getNumCDT() {
        return this.numCDT;
    }
    
    public void setFechCDT(String fechaCDT) {
        this.fechCDT = fechaCDT;
    }
    
    public String getFechCDT() {
        return this.fechCDT;
    }
    
    public void setIntCDT(double interesCDT) {
        this.intCDT = interesCDT;
    }
    
    public double getIntCDT() {
        return this.intCDT;
    }
    
    public void setMontoCDT(double monCDT) {
        this.montoCDT = monCDT;
    }
    
    public double getMontoCDT() {
        return this.montoCDT;
    }

    public void setPlazoCDT(int plaCDT) {
        this.plazoCDT = plaCDT;
    }
    
    public double getPlazoCDT() {
        return this.plazoCDT;
    }
    
    public double calc_int_mensual() {
        intMensualCDT = 0;
        
        intMensualCDT = this.montoCDT * this.plazoCDT / 100;
        
        return intMensualCDT;
    }
    
    public double calc_val_retorno() {
        valRetorno = 0;
        
        valRetorno = this.intMensualCDT * this.plazoCDT;
        
        return valRetorno;
    }
    
    
}
