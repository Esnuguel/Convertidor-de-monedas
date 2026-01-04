package com.convertidor;

public class Gui {

    Gui() {}

    public void mostrarOpciones() {
        System.out.println("""
                ***************************************
                Bienvendio al convertidor de monedas
                ***************************************

                1) Dólar a peso Argentino
                2) Peso Argentino a Dólar
                3) Dólar a Real brasileño
                4) Real brasileño a Dólar
                5) Dólar a peso Colombiano
                6) Peso Colombiano a Dólar
                7) Salir
                Eliga una opcion valida xfa :3
                """);
    }

    public void mostrarDespedida()
    {
        System.out.println("Gracias por usar el convertidor <3");
    }
}
