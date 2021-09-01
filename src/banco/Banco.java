
package banco;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Banco {

    public static int valDia(int mmm, int ddd) {
        if (mmm == 1 || mmm == 3 || mmm == 5 || mmm == 7 ||mmm == 8 || mmm == 10 || mmm == 12) {
            if (ddd >= 1 && ddd <= 31 ) {
                return 0;
            }
            else {
                return 1;
            }
        } else {
            if (mmm == 4 || mmm == 6 || mmm == 9 || mmm == 11) {
                if (ddd >= 1 && ddd <= 30 ) {
                    return 0;
                }
                else {
                    return 1;
                }    
            } else {
                if (ddd >= 1 && ddd <= 29 ) {
                   return 0;
                } else {
                    return 1;
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        // TODO code application logic here
        Scanner consola=new Scanner(System.in);
        consola.useDelimiter("\n");
        int opcion, plazo_cdt, month, day, year;
        Double interes_ahorro, val_interes_ahorro, interes_corriente, val_interes_corriente, interes_tarjeta, interes_cdt, intmensual_cdt, retorno_cdt, saldo_ahorro, saldo_corriente, sobre_corriente, val_interes_tarjeta, cupo_tarjeta, usado_tarjeta, monto_cdt;
        String documento, nombre, email, celular, direccion, fecha_ahorros, num_ahorros, fecha_corriente, num_corriente, fecha_apertura, fecha_vence, num_tarjeta, fecha_cdt, num_cdt;
        Date date1 = null, date2 = null;
        Cliente obj_cliente;
        CtaAhorros obj_ahorros;
        CtaCorriente obj_corriente;
        CDT obj_cdt;
        Tarjeta obj_tarjeta;
        
        fecha_vence = "";
        
        do{
            //Presentación del Menú
            System.out.println("     \n\nPROGRAMA BANCO");
            System.out.println("--------------------------");
            System.out.println("1. Datos del Cliente");
            System.out.println("2. Cuenta de Ahorros");
            System.out.println("3. Cuenta Corriente");
            System.out.println("4. CDT");
            System.out.println("5. Tarjeta de Crédito");
            System.out.println("6. Salir");
            System.out.println("Su Opción:\n");
            opcion=consola.nextInt();
            
            switch(opcion){
                case 1:{
                    System.out.println("  DATOS DEL CLIENTE");
                    System.out.println("---------------------");
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
                    
                    System.out.println("\nSe grabó el cliente - " + obj_cliente.getDocCliente());
                    System.out.println("\nPresione ENTER para continuar...\n");
                    consola.nextLine();
                    break;
                }
                case 2:{
                    System.out.println("    CUENTA DE AHORROS");
                    System.out.println("-----------------------");
                    
                    //Pedir el código de la cuenta de ahorros
                    System.out.println("Codigo de la cuenta ahorros:");
                    num_ahorros=consola.next();
                    consola.nextLine();
                    
                    //Pedir la fecha de apertura del producto. Valida mes, día, año.
                    month = 0; //Valida mes
                    while (month <= 0 || month >= 13) {
                        try {
                            System.out.println("\nFecha de apertura: MES (1-12):");
                            month = consola.nextInt();  
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    day = 0;
                    while (day <= 0 || day >= 32) {
                        try {
                            System.out.println("\nFecha de apertura: DIA (1-31):");
                            day = consola.nextInt();
                            if (valDia(month, day) == 1) {
                                System.out.println("Error: El día " + day + " no corresponde al mes " + month);
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    year = 2021;
                    
                    fecha_ahorros = month + "/" + day  + "/" + year;

                    System.out.println("Fecha de apertura: " + fecha_ahorros);
                    
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
                    System.out.println("\nValor intereses de la cuenta: $" + val_interes_ahorro);
                    System.out.println("\nPresione ENTER para continuar...\n");
                    consola.next();
                    break;
                }
                case 3:{
                    System.out.println("    CUENTA CORRIENTE");
                    System.out.println("------------------------\n");
                    System.out.println("Cuenta corriente número: ");
                    num_corriente=consola.next();
                    consola.nextLine();
                    
                    //Pedir la fecha de apertura del producto. Valida mes, día, año.
                    month = 0; //Valida mes
                    while (month <= 0 || month >= 13) {
                        try {
                            System.out.println("\nFecha de apertura: MES (1-12):");
                            month = consola.nextInt();  
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    day = 0;
                    while (day <= 0 || day >= 32) {
                        try {
                            System.out.println("\nFecha de apertura: DIA (1-31):");
                            day = consola.nextInt();
                            if (valDia(month, day) == 1) {
                                System.out.println("Error: El día " + day + " no corresponde al mes " + month);
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    year = 2021;
                    
                    fecha_corriente = month + "/" + day  + "/" + year;

                    System.out.println("Fecha de apertura: " + fecha_corriente);
                    
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
                        System.out.println("\nCuenta en sobregiro. Se cobrará un interés de $" + obj_corriente.getSobreCuenta() * 2/100 );
                        System.out.println("\nPresione ENTER para continuar...\n");
                        consola.next();
                        break;
                    }
                    System.out.println("Valor intereses de la cuenta: $" + val_interes_corriente);
                    System.out.println("\nPresione ENTER para continuar...\n");
                    consola.next();
                    break;
                }
                case 4: {
                    System.out.println("    C.D.T");
                    System.out.println("-------------");
                    System.out.println("\nCertificado número: ");
                    num_cdt=consola.next();
                    consola.nextLine();
                    
                    //Pedir la fecha de apertura del producto. Valida mes, día, año.
                    month = 0; //Valida mes
                    while (month <= 0 || month >= 13) {
                        try {
                            System.out.println("\nFecha de apertura: MES (1-12):");
                            month = consola.nextInt();  
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    day = 0;
                    while (day <= 0 || day >= 32) {
                        try {
                            System.out.println("\nFecha de apertura: DIA (1-31):");
                            day = consola.nextInt();
                            if (valDia(month, day) == 1) {
                                System.out.println("Error: El día " + day + " no corresponde al mes " + month);
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    year = 2021;
                    
                    fecha_cdt = month + "/" + day  + "/" + year;

                    System.out.println("Fecha de apertura del CDT: " + fecha_cdt);
                    /*System.out.println("Fecha CDT --mm/dd/aaaa--: ");
                    fecha_cdt=consola.next();
                    consola.nextLine();*/
                    
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
                    
                    System.out.println("Valor intereses mensual: $" + intmensual_cdt);
                    System.out.println("Valor de retorno por " + obj_cdt.getPlazoCDT() + " meses: $" + retorno_cdt);
                    System.out.println("\nPresione ENTER para continuar...\n");
                    consola.next();
                    break;
                }
                case 5: { 
                    System.out.println("    TARJETA DE CRÉDITO");
                    System.out.println("--------------------------\n");
                    System.out.println("Tarjeta número: ");
                    num_tarjeta=consola.next();
                    consola.nextLine();
                    
                    //Pedir la fecha de apertura del producto. Valida mes, día, año.
                    month = 0; //Valida mes
                    while (month <= 0 || month >= 13) {
                        try {
                            System.out.println("\nFecha de expedición: MES (1-12):");
                            month = consola.nextInt();  
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    day = 0;
                    while (day <= 0 || day >= 32) {
                        try {
                            System.out.println("\nFecha de expedición: DIA (1-31):");
                            day = consola.nextInt();
                            if (valDia(month, day) == 1) {
                                System.out.println("Error: El día " + day + " no corresponde al mes " + month);
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    year = 2021;
                    
                    SimpleDateFormat sdformat = new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        date1 = sdformat.parse(month + "/" + day  + "/" + year);
                    } catch (ParseException ex) {
                        
                    }
                    
                    fecha_apertura = month + "/" + day  + "/" + year;
                    
                    System.out.println("Fecha de expedición: " + fecha_apertura);
                    
                    
                    
                    /*System.out.println("Fecha Apertura --mm/dd/aaaa--: ");
                    fecha_apertura=consola.next();
                    consola.nextLine();*/
                    
                    //Pedir la fecha de vencimiento del producto. Valida mes, día, año.
                    int sw = 0;
                    while (sw == 0) {
                        month = 0; //Valida mes
                        while (month <= 0 || month >= 13) {
                            try {
                                System.out.println("\nFecha de vencimiento: MES (1-12):");
                                month = consola.nextInt();  
                            }
                            catch (InputMismatchException e) {
                                System.out.println("Error: Debe escribir un número." );
                                consola.nextLine();
                            }
                        }

                        day = 0;
                        while (day <= 0 || day >= 32) {
                            try {
                                System.out.println("\nFecha de vencimiento: DIA (1-31):");
                                day = consola.nextInt();
                                if (valDia(month, day) == 1) {
                                    System.out.println("Error: El día " + day + " no corresponde al mes " + month);
                                }
                            }
                            catch (InputMismatchException e) {
                                System.out.println("Error: Debe escribir un número." );
                                consola.nextLine();
                            }
                        }

                        year = 0;
                        while (year <= 0 || year >= 2100) {
                            try {
                                System.out.println("\nFecha de vencimiento: AÑO (2021-2100):");
                                year = consola.nextInt();
                            }
                            catch (InputMismatchException e) {
                                System.out.println("Error: Debe escribir un número." );
                                consola.nextLine();
                            }
                        }


                        try {
                            date2 = sdformat.parse(month + "/" + day  + "/" + year);
                        } catch (ParseException ex) {

                        }
                        fecha_vence = month + "/" + day  + "/" + year;
                        if (date2.before(date1)) {
                            //La fecha de vecnimiento es menor que la fecha de apertura
                            System.out.println("\nLa fecha de vencimiento " + fecha_vence + " no puede ser menor que la fecha de apertura");

                        } else {
                            sw = 1;
                            
                            System.out.println("\nFecha de vencimiento: " + fecha_vence);                        
                        }
                        
                    }

                    /*System.out.println("Fecha Vencimiento --mm/dd/aaaa--: ");
                    fecha_vence=consola.next();
                    consola.nextLine();*/
                    
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
                    System.out.println("\nValor intereses a pagar: $5" + val_interes_tarjeta);
                    System.out.println("\nPresione ENTER para continuar...\n");
                    consola.next();
                    break;
                }
            }
            
        } while(opcion!=6);
      }
    
  }
