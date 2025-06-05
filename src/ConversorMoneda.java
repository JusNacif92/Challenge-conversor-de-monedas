
import java.util.Scanner;

public class ConversorMoneda {
    public void  ConvertirMonedas () {
        Scanner lectura = new Scanner(System.in);
        int opcion;
        ConsultValores consulta = new ConsultValores();
        Moneda tasaCambiaria = consulta.valoresMonedas();
        do {
            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println(":\n");
            System.out.println("¿ Que moneda te gustaria consultar ?");
            System.out.println("----------------------------------");
            System.out.printf("%-10s  %10s\n", "1. BRL", "Brazil");
            System.out.printf("%-10s  %10s\n", "2. ARS", "Argentina");
            System.out.printf("%-10s  %10s\n", "3. MXN", "Mexico");
            System.out.printf("%-10s  %10s\n", "4. CNY", "China");
            System.out.println("5. Salir");
            System.out.println("Digita la opcion que te gustaria usar.");
            System.out.println("----------------------------------");

            opcion = lectura.nextInt();
            lectura.nextLine();
            double cantidad;

            switch (opcion) {
                case 1:
                    String codigoMoneda;
                    codigoMoneda = "BRL";
                    System.out.println("¿Que cantidad de Dinero necesitas?");
                    cantidad = lectura.nextDouble();
                    lectura.nextLine();
                    double resultado = consulta.conversionTasasDeCambio(tasaCambiaria, codigoMoneda, cantidad);
                    System.out.println(resultado);
                    break;
                case 2:
                    String codigoMoneda2;
                    codigoMoneda2 = "ARS";
                    System.out.println("¿Que cantidad de Dinero necesitas?");
                    cantidad = lectura.nextDouble();
                    lectura.nextLine();
                    double resultado2 = consulta.conversionTasasDeCambio(tasaCambiaria, codigoMoneda2, cantidad);
                    System.out.println(resultado2);
                    break;
                case 3:
                    String codigoMoneda3;
                    codigoMoneda3 = "MXN";
                    System.out.println("¿Que cantidad de Dinero necesitas?");
                    cantidad = lectura.nextDouble();
                    lectura.nextLine();
                    double resultado3 = consulta.conversionTasasDeCambio(tasaCambiaria, codigoMoneda3, cantidad);
                    System.out.println(resultado3);
                    break;
                case 4:
                    String codigoMoneda4;
                    codigoMoneda4 = "CNY";
                    System.out.println("¿Que cantidad de Dinero necesitas?");
                    cantidad = lectura.nextDouble();
                    lectura.nextLine();
                    double resultado4 = consulta.conversionTasasDeCambio(tasaCambiaria, codigoMoneda4, cantidad);
                    System.out.println(resultado4);
                    break;
                case 5:
                    System.out.println("Gracias, regresa pronto");
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (opcion != 5);
    }
}
