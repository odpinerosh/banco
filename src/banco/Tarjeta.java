package banco;

public class Tarjeta extends Cuenta {
    private String fecha_vence;
    private Double cupo_usado, VI;
    
    public void setFechaVence(String fechavence) {
        this.fecha_vence = fechavence;
    } 
    
    public String getFechaVence() {
        return this.fecha_vence;
    }
    
    public void setCupoUsado(Double cupusado) {
        this.cupo_usado = cupusado;
    } 
    
    public Double getCupoUsado() {
        return this.cupo_usado;
    }
    
    
    @Override
    public double calcInteres() {
                
        this.VI = getIntCuenta() * getCupoUsado() / 100; 
        return this.VI;
        
    }
}
