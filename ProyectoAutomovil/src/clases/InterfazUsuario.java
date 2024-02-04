package clases;

import java.util.Scanner;

public class InterfazUsuario {

	// Método que imprime el menú
	public static void imprimirMenu() {
		System.out.println("MENÚ DE OPCIONES");
		System.out.println("*******************************");
		System.out.println("1. Crear un coche");
		System.out.println("2. Mostrar coche");
		System.out.println("3. Arrancar el coche");
		System.out.println("4. Acelerar el coche");
		System.out.println("5. Frenar el coche");
		System.out.println("6. Parar el coche");
		System.out.println("7. Mostrar el precio del combustible que usa el coche");
		System.out.println("8. Modificar el precio del combustible que usa el coche");
		System.out.println("9. Calcular el consumo en euros del coche");
		System.out.println("10. Modificar datos coche");
		System.out.println("11. Eliminar coche");
		System.out.println("12. Salir");
	}

	// Método que espera hasta que se pulse Intro
	public static void esperaIntro(Scanner sc) {
		sc.nextLine();
		System.out.println("\nPulsa Enter para continuar ...");
		sc.nextLine();
	}
	
	//Metodo que pregunta al usuario para modificar los datos
    public static void imprimirModificarDatos() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSelecciona qué dato deseas modificar:");
        System.out.println("1. Matrícula");
        System.out.println("2. Marca");
        System.out.println("3. Color");
        System.out.println("4. Antigüedad");
        System.out.println("5. Velocidad actual");
        System.out.println("6. Tipo de combustible");
        System.out.println("7. Modificar todos los datos");
        System.out.println("8. Salir");
    }
	
}
