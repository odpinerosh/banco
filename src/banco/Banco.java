
package banco;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args)
      {
        // TODO code application logic here
        Scanner consola=new Scanner(System.in);
        consola.useDelimiter("\n");
        int opcion, plazo_cdt;
        Double interes_ahorro, val_interes_ahorro, interes_corriente, val_interes_corriente, interes_tarjeta, interes_cdt, intmensual_cdt, retorno_cdt, saldo_ahorro, saldo_corriente, sobre_corriente, val_interes_tarjeta, cupo_tarjeta, usado_tarjeta, monto_cdt;
        String documento, nombre, email, celular, direccion, fecha_ahorros, num_ahorros, fecha_corriente, num_corriente, fecha_apertura, fecha_vence, num_tarjeta, fecha_cdt, num_cdt;
        Cliente obj_cliente;
        CtaAhorros obj_ahorros;
        CtaCorriente obj_corriente;
        CDT obj_cdt;
        Tarjeta obj_tarjeta;
        
        
        do{
            //Presentación del Menú
            System.out.println("     PROGRAMA BANCO");
            System.out.println("1. Datos del Cliente");
            System.out.println("2. Cuenta de Ahorros");
            System.out.println("3. Cuenta Corriente");
            System.out.println("4. CDT");
            System.out.println("5. Tarjeta de Crédito");
            System.out.println("6. Salir");
            System.out.println("Su Opción: ");
            opcion=consola.nextInt();
            
            switch(opcion){
                case 1:{
                    System.out.println("  DATOS DEL CLIENTE");
                    
                    System.out.println("Documento: ");
                    documento=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Nombre: ");
                    nombre=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Email: ");
                    email=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Celular: ");
                    celular=consola.next();
                    consola.nextLine();        
                    
                    System.out.println("Dirección: ");
                    direccion=consola.next();
                    consola.nextLine();
                    
                    //Creación del objeto
                    obj_cliente=new Cliente();
                    obj_cliente.setDocCliente(documento);
                    obj_cliente.setNomCliente(nombre);
                    obj_cliente.setEmailCliente(email);
                    obj_cliente.setCelCliente(celular);
                    obj_cliente.setDirCliente(direccion);
                    
                    System.out.println("Se grabó el cliente - " + obj_cliente.getDocCliente());
                    break;
                }
                case 2:{
                    System.out.println("    CUENTA DE AHORROS");
                    
                    System.out.println("Cuenta ahorros número: ");
                    num_ahorros=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Fecha mm/dd/aaaa: ");
                    fecha_ahorros=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Valor interés: ");
                    interes_ahorro=consola.nextDouble();
                    
                    System.out.println("Saldo: ");
                    saldo_ahorro=consola.nextDouble();
                    
                    //Creación del objeto
                    obj_ahorros=new CtaAhorros();
                    obj_ahorros.setNumCuenta(num_ahorros);
                    obj_ahorros.setFechCuenta(fecha_ahorros);
                    obj_ahorros.setIntCuenta(interes_ahorro);
                    obj_ahorros.setSalCuenta(saldo_ahorro);
                    
                    val_interes_ahorro=obj_ahorros.calcInteres();
                    System.out.println("Valor intereses de la cuenta: " + val_interes_ahorro);
                    break;
                }
                case 3:{
                    System.out.println("    CUENTA CORRIENTE");
                    System.out.println("Cuenta corriente número: ");
                    num_corriente=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Fecha mm/dd/aaaa: ");
                    fecha_corriente=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Valor interés: ");
                    interes_corriente=consola.nextDouble();
                    
                    System.out.println("Saldo: ");
                    saldo_corriente=consola.nextDouble();

                    System.out.println("Valor en sobregiro: ");
                    sobre_corriente=consola.nextDouble();                    
                    
                    //Creación del objeto
                    obj_corriente=new CtaCorriente();
                    obj_corriente.setNumCuenta(num_corriente);
                    obj_corriente.setFechCuenta(fecha_corriente);
                    obj_corriente.setIntCuenta(interes_corriente);
                    obj_corriente.setSalCuenta(saldo_corriente);
                    obj_corriente.setSobreCuenta(sobre_corriente);
                    val_interes_corriente=obj_corriente.calcInteres();
                    if(obj_corriente.getSobreCuenta() > 0) {
                        System.out.println("Cuenta en sobregiro. Se cobrará una interés de $" + obj_corriente.getSobreCuenta() * 2/100 );
                    }
                    System.out.println("Valor intereses de la cuenta: " + val_interes_corriente);
                    break;
                }
                case 4: {
                    System.out.println("    C.D.T");
                    System.out.println("Certificado número: ");
                    num_cdt=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Fecha CDT --mm/dd/aaaa--: ");
                    fecha_cdt=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Monto del CDT: ");
                    monto_cdt=consola.nextDouble();
                    
                    System.out.println("Plazo del CDT: ");
                    plazo_cdt=consola.nextInt();

                    System.out.println("Interés pactado: ");
                    interes_cdt=consola.nextDouble();
                    
                    //Creación del objeto
                    obj_cdt = new CDT();
                    obj_cdt.setNumCDT(num_cdt);
                    obj_cdt.setFechCDT(fecha_cdt);
                    obj_cdt.setMontoCDT(monto_cdt);
                    obj_cdt.setPlazoCDT(plazo_cdt);
                    obj_cdt.setIntCDT(interes_cdt);
                    
                    intmensual_cdt = obj_cdt.calc_int_mensual();
                    retorno_cdt = obj_cdt.calc_val_retorno();
                    
                    System.out.println("Valor intereses mensual: " + intmensual_cdt);
                    System.out.println("Valor de retorno por " + obj_cdt.getPlazoCDT() + " meses: " + retorno_cdt);
                    break;
                }
                case 5: { 
                    System.out.println("    Tarjeta de Crédito");
                    System.out.println("Tarjeta número: ");
                    num_tarjeta=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Fecha Apertura --mm/dd/aaaa--: ");
                    fecha_apertura=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Fecha Vencimiento --mm/dd/aaaa--: ");
                    fecha_vence=consola.next();
                    consola.nextLine();
                    
                    System.out.println("Interés: ");
                    interes_tarjeta = consola.nextDouble();
                    
                    System.out.println("Cupo asignado: ");
                    cupo_tarjeta = consola.nextDouble();
                    
                    System.out.println("Cupo utilizado: ");
                    usado_tarjeta = consola.nextDouble();
                    
                    obj_tarjeta = new Tarjeta();
                    obj_tarjeta.setNumCuenta(num_tarjeta);
                    obj_tarjeta.setFechCuenta(fecha_apertura);
                    obj_tarjeta.setFechaVence(fecha_vence);
                    obj_tarjeta.setSalCuenta(cupo_tarjeta);
                    obj_tarjeta.setCupoUsado(usado_tarjeta);
                    obj_tarjeta.setIntCuenta(interes_tarjeta);
                    
                    val_interes_tarjeta = obj_tarjeta.calcInteres();
                    System.out.println("Valor intereses a pagar: " + val_interes_tarjeta);
                    
                }
            }
            
        } while(opcion!=6);
      }
    
  }
