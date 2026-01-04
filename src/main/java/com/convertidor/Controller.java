package com.convertidor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;

public class Controller {
    private final String API_KEY="2025f9858e2091d0392409aa";
    private final String URL="https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/";

    public void convertidor(int opcion, double monto){
        switch (opcion) {
            case 1:
                System.out.println("El resultado de convertir " + monto + " dolares a pesos argentinos es: " + api("USD", "ARS", monto));
                break;
            case 2:
                System.out.println("El resultado de convertir " + monto + " pesos argentinos a dolares es: " + api("ARS", "USD", monto));
                break;
            case 3:
                System.out.println("El resultado de convertir " + monto + " dolares a reales brasileños es: " + api("USD", "BRL", monto));
                break;
            case 4:
                System.out.println("El resultado de convertir " + monto + " reales brasileños a dolares es: " + api("BRL", "USD", monto));
                break;
            case 5:
                System.out.println("El resultado de convertir " + monto + " dolares a pesos colombianos es: " + api("USD", "COP", monto));
                break;
            case 6:
                System.out.println("El resultado de convertir " + monto + " pesos colombianos a dolares es: " + api("COP", "USD", monto));
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    
    
    private double api(String monedaOrigen, String monedaDestino, double monto){
        String url = URL + monedaOrigen + "/" + monedaDestino+"/"+monto;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try{
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); 
            String json=response.body();

            Gson gson = new Gson();
            DtoCantidad dto=gson.fromJson(json, DtoCantidad.class);
            return dto.conversion_result();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

}
