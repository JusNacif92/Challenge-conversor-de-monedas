import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;


public class ConsultValores {
    Scanner lectura = new Scanner(System.in);
    private static final String API_KEY = "6d6c7fde96fbba12cc0e04da";
    public Moneda valoresMonedas(){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" +API_KEY+"/latest/USD");
        //System.out.println("DEBUG - URL: " + direccion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println("DEBUG - Respuesta API: " + response.body());

            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener tasas. Verifica:\n" +
                    "1. Tu conexión a internet\n" +
                    "2. Que la API KEY sea válida\n" +
                    "3. URL: " + direccion);
        }
    }

    public double conversionTasasDeCambio (Moneda moneda, String codigoMoneda, double cantidad){
        if(!moneda.conversion_rates().containsKey(codigoMoneda)){
            throw new IllegalArgumentException("Moneda no encontrada: "+codigoMoneda);
        }

        double tasa = moneda.conversion_rates().get(codigoMoneda);
        int opcion;
        System.out.println(" 1.- Convertir "+cantidad+" de USD a "+codigoMoneda);
        System.out.println(" 2.- Convertir "+cantidad+" de "+codigoMoneda+" a USD");
        opcion = lectura.nextInt();
        lectura.nextLine();
        switch(opcion){
            case 1:
                double monedaFinal = cantidad * tasa;;
                System.out.println("El resultado es: "+monedaFinal+" "+codigoMoneda);
                return monedaFinal;
            case 2:
                double monedaFinal2 = cantidad / tasa;;
                System.out.println("El resultado es: "+monedaFinal2+" USD");
                return  monedaFinal2;
            default:
                throw new IllegalArgumentException("Opcion no valida");
        }

    }

}
