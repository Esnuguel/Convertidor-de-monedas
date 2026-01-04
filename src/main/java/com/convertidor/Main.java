package com.convertidor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gui gui = new Gui();
        Controller controller = new Controller();
        int opcion=0;
        
        do{
            gui.mostrarOpciones();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if(opcion >= 1 && opcion < 7) {
                    System.out.println("Ingrese el monto a convertir");
                    try {
                        double monto = Double.parseDouble(scanner.nextLine());
                        controller.convertidor(opcion, monto);
                    }catch(Exception e) {
                        System.out.println("Ingrese un monto valido");
                    }
                }else if(opcion == 7) {
                    gui.mostrarDespedida();
                    break;
                }else {
                    System.out.println("Opcion no valida solo números del 1 al 7");
                }
            } catch (Exception e) {
                System.out.println("Ingrese un numero valido");
            }
        }while(opcion != 7);

    }
}