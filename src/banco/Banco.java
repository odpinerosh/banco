
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
        int opcion, plazo_cdt, month, day, year, flag;
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
            System.out.println("Su Opción:");
            opcion=consola.nextInt();
            
            switch(opcion){
                case 1:{
                    System.out.println("  \nDATOS DEL CLIENTE");
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
                    System.out.println("    \nCUENTA DE AHORROS");
                    System.out.println("-----------------------");
                    
                    //Pedir el código de la cuenta de ahorros
                    System.out.println("Codigo de la cuenta ahorros:");
                    num_ahorros=consola.next();
                    consola.nextLine();
                    
                    //Pedir la fecha de apertura del producto. Valida mes, día, año.
                    month = 0; //Valida mes
                    while (month <= 0 || month >= 13) {
                        try {
                            System.out.println("\nMes de apertura (1-12):");
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
                            System.out.println("\nDía de apertura (1-31):");
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
                    
                    interes_ahorro = null;
                    flag = 0;
                    while (flag == 0) {
                        try {
                            System.out.println("\nValor interés (mayor a cero): ");
                            interes_ahorro=consola.nextDouble();
                            if(interes_ahorro > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + interes_ahorro + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    saldo_ahorro = null;
                    flag = 0;
                    
                    while (flag == 0) {
                        try {
                            System.out.println("\nSaldo: ");
                            saldo_ahorro=consola.nextDouble();
                            if(saldo_ahorro >= 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + saldo_ahorro + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    
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
                    System.out.println("\n    CUENTA CORRIENTE");
                    System.out.println("------------------------\n");
                    System.out.println("Cuenta corriente número: ");
                    num_corriente=consola.next();
                    consola.nextLine();
                    
                    //Pedir la fecha de apertura del producto. Valida mes, día, año.
                    month = 0; //Valida mes
                    while (month <= 0 || month >= 13) {
                        try {
                            System.out.println("\nMes de apertura (1-12):");
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
                            System.out.println("\nDía de apertura (1-31):");
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
                    
                    interes_corriente = null;
                    flag = 0;
                    while (flag == 0) {
                        try {
                            System.out.println("\nValor interés (mayor a cero): ");
                            interes_corriente=consola.nextDouble();
                            if(interes_corriente > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + interes_corriente + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    flag = 0;
                    saldo_corriente = null;
                    while (flag == 0) {
                        try {
                            System.out.println("\nSaldo de la cuenta (mayor a cero): ");
                            saldo_corriente=consola.nextDouble();
                            if(saldo_corriente > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + saldo_corriente + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }                    

                    flag = 0;
                    sobre_corriente = null;
                    while (flag == 0) {
                        try {
                            System.out.println("\nValor en sobregiro (mayor o igual a cero): ");
                            sobre_corriente=consola.nextDouble();
                            if(sobre_corriente >= 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + sobre_corriente + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }                    
                    
                    //Creación del objeto
                    obj_corriente=new CtaCorriente();
                    obj_corriente.setNumCuenta(num_corriente);
                    obj_corriente.setFechCuenta(fecha_corriente);
                    obj_corriente.setIntCuenta(interes_corriente);
                    obj_corriente.setSalCuenta(saldo_corriente);
                    obj_corriente.setSobreCuenta(sobre_corriente);
                    val_interes_corriente=obj_corriente.calcInteres();
                    if(obj_corriente.getSobreCuenta() > 0) {
                        System.out.println("\nCUENTA EN SOBREGIRO. Se cobrará 2% de interés. Debe al Banco $" + obj_corriente.getSobreCuenta() * 2/100 );
                        System.out.println("\nPresione ENTER para continuar...\n");
                        consola.next();
                        break;
                    }
                    System.out.println("\nValor intereses de la cuenta: $" + val_interes_corriente);
                    System.out.println("\nPresione ENTER para continuar...\n");
                    consola.next();
                    break;
                }
                case 4: {
                    System.out.println("\n    C.D.T");
                    System.out.println("-------------");
                    System.out.println("Certificado número: ");
                    num_cdt=consola.next();
                    consola.nextLine();
                    
                    //Pedir la fecha de apertura del producto. Valida mes, día, año.
                    month = 0; //Valida mes
                    while (month <= 0 || month >= 13) {
                        try {
                            System.out.println("\nMes de apertura (1-12):");
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
                            System.out.println("\nDía de apertura (1-31):");
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
                    
                    flag = 0;
                    monto_cdt = null;
                    while (flag == 0) {
                        try {
                            System.out.println("\nMonto del CDT (mayor que cero): ");
                            monto_cdt=consola.nextDouble();
                            if(monto_cdt > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + monto_cdt + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }                    
                    
                    flag = 0;
                    plazo_cdt = 0;
                    while (flag == 0) {
                        try {
                            System.out.println("\nPlazo del CDT (mayor que cero): ");
                            plazo_cdt=consola.nextInt();
                            if(plazo_cdt > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + plazo_cdt + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    flag = 0;
                    interes_cdt = null;
                    while (flag == 0) {
                        try {
                            System.out.println("\nTasa de interés pactada (mayor que cero): ");
                            interes_cdt=consola.nextDouble();
                            if(interes_cdt > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + interes_cdt + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }                  
                    
                    //Creación del objeto
                    obj_cdt = new CDT();
                    obj_cdt.setNumCDT(num_cdt);
                    obj_cdt.setFechCDT(fecha_cdt);
                    obj_cdt.setMontoCDT(monto_cdt);
                    obj_cdt.setPlazoCDT(plazo_cdt);
                    obj_cdt.setIntCDT(interes_cdt);
                    
                    intmensual_cdt = obj_cdt.calc_int_mensual();
                    retorno_cdt = obj_cdt.calc_val_retorno();
                    
                    System.out.println("\nValor intereses mensual: $" + intmensual_cdt);
                    System.out.println("Valor de retorno por " + obj_cdt.getPlazoCDT() + " meses: $" + retorno_cdt);
                    System.out.println("\nPresione ENTER para continuar...\n");
                    consola.next();
                    break;
                }
                
                case 5: { 
                    System.out.println("\n    TARJETA DE CRÉDITO");
                    System.out.println("--------------------------\n");
                    System.out.println("Tarjeta número: ");
                    num_tarjeta=consola.next();
                    consola.nextLine();
                    
                    //Pedir la fecha de apertura del producto. Valida mes, día, año.
                    month = 0; //Valida mes
                    while (month <= 0 || month >= 13) {
                        try {
                            System.out.println("\nMes de expedición (1-12):");
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
                            System.out.println("\nDía de expedición (1-31):");
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
                    while (year < 2000 || year >= 2022) {
                        try {
                            System.out.println("\nAño de Expedición: (2000-2021):");
                            year = consola.nextInt();
                            if(year < 2000 || year >= 2022) {
                                System.out.println("El Año de vencimiento debe estar en el rango 2000 a 2021");
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }

                    
                    SimpleDateFormat sdformat = new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        date1 = sdformat.parse(month + "/" + day  + "/" + year);
                    } catch (ParseException ex) {
                        
                    }
                    
                    fecha_apertura = month + "/" + day  + "/" + year;
                    
                    System.out.println("Fecha de expedición: " + fecha_apertura);
                    
                    //Pedir la fecha de vencimiento del producto. Valida mes, día, año.
                    int sw = 0;
                    while (sw == 0) {
                        month = 0; //Valida mes
                        while (month <= 0 || month >= 13) {
                            try {
                                System.out.println("\nMes de vencimiento (1-12):");
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
                                System.out.println("\nDía de vencimiento (1-31):");
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
                                System.out.println("\nAño de vencimiento: (2021-2100):");
                                year = consola.nextInt();
                                if (year < 2021 || year >= 2100) {
                                    System.out.println("El Año de vencimiento debe estar en el rango 2021 a 2100");
                                    consola.nextLine();
                                }
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
                    
                    flag = 0;
                    interes_tarjeta = null;
                    while (flag == 0) {
                        try {
                            System.out.println("\nTasa de Interés (mayor que cero): ");
                            interes_tarjeta=consola.nextDouble();
                            if(interes_tarjeta > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + interes_tarjeta + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }                  
                    
                    flag = 0;
                    cupo_tarjeta = null;
                    while (flag == 0) {
                        try {
                            System.out.println("\nCupo asignado (mayor que cero): ");
                            cupo_tarjeta=consola.nextDouble();
                            if(cupo_tarjeta > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + cupo_tarjeta + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
                    flag = 0;
                    usado_tarjeta = null;
                    while (flag == 0) {
                        try {
                            System.out.println("\nCupo utilizado (mayor que cero): ");
                            usado_tarjeta=consola.nextDouble();
                            if(usado_tarjeta > 0) {
                                flag = 1;
                            } else {
                                System.out.println("Error: " + usado_tarjeta + " no es un valor válido" );
                                consola.nextLine();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Error: Debe escribir un número." );
                            consola.nextLine();
                        }
                    }
                    
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
