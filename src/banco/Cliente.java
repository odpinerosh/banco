
package banco;


public class Cliente {
    private String docCliente;
    private String nomCliente;
    private String emailCliente;
    private String celCliente;
    private String dirCliente;
    
    //iniciar los Getters y los Setters de la clase Cliente
    public void setDocCliente (String docu) {
        this.docCliente = docu;
    }
    
    public String getDocCliente () {
        return this.docCliente;
    }
    
    public void setNomCliente (String nombre) {
        this.nomCliente = nombre;
    }
    
    public String getNomCliente () {
        return this.nomCliente;
    }
    
    public void setEmailCliente (String correo) {
        this.emailCliente = correo;
    }
    
    public String getEmailCliente () {
        return this.emailCliente;
    }
    
    public void setCelCliente (String celular) {
        this.celCliente = celular;
    }
    
    public String getCelCliente () {
        return this.celCliente;
    }
    
    public void setDirCliente (String direc) {
        this.dirCliente = direc;
    }
    
    public String getDirCliente () {
        return dirCliente;
    }
    
}
