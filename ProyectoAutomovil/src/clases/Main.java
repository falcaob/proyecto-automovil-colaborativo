package clases;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Automovil miAutomovil = null;
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		do {
			InterfazUsuario.imprimirMenu();
			System.out.println("\nIndica una opción (1-12):");
			opcion = sc.nextInt();
			
			switch (opcion) {
			
			case 1: //Crear un coche
				miAutomovil = Automovil.crearAutomovil();
				InterfazUsuario.esperaIntro(sc);
				break;
				
			case 2: //Mostrar datos del coche
				//Es lo mismo que if(Automovil.existeAutomovil(miAutomovil) == true)
				if(Automovil.existeAutomovil(miAutomovil))
					miAutomovil.mostrarAutomovil();
				InterfazUsuario.esperaIntro(sc);
				break;
				
			case 3: //Arrancar el coche
				if(Automovil.existeAutomovil(miAutomovil))
					miAutomovil.arrancar();
				InterfazUsuario.esperaIntro(sc);
				break;
			case 4: //Acelerar el coche
				if(Automovil.existeAutomovil(miAutomovil)) {
					double aceleracion;
					System.out.println("¿Cuanto quieres acelerar?");
					if((aceleracion = sc.nextDouble())>=50)
						System.out.println("Déjate de ir !!!!");
					else miAutomovil.acelerar(aceleracion);
				}		
				InterfazUsuario.esperaIntro(sc);
				break;
			case 5: //Frenar el coche
				if(Automovil.existeAutomovil(miAutomovil)) {
					double frenado;
					System.out.println("¿Cuanto quieres frenar?");
					frenado = sc.nextDouble();
					miAutomovil.frenar(frenado);
				}			
				InterfazUsuario.esperaIntro(sc);
				break;
			case 6: //Parar el coche
				//Entendemos por parar el coche poner su velocidad a 0
				//Por tanto, parar el coche va a ser equivalante a usar
				//el método frenar con la velocidad actual del coche como argumento
				if(Automovil.existeAutomovil(miAutomovil))
					miAutomovil.frenar(miAutomovil.getVelocidad());
				InterfazUsuario.esperaIntro(sc);
				break;
			case 7: //Mostrar el precio del combustible que usa el coche
				if(Automovil.existeAutomovil(miAutomovil))
					miAutomovil.precioCombustible();
				InterfazUsuario.esperaIntro(sc);
				break;
			case 8: //Modificar el precio del combustible que usa el coche
				if(Automovil.existeAutomovil(miAutomovil))
					miAutomovil.cambiarPrecioCombustible();
				InterfazUsuario.esperaIntro(sc);
				break;
			case 9: //Calcular el consumo en euros del coche por cada 100 km
				if(Automovil.existeAutomovil(miAutomovil)) 
					System.out.println("Este coche gasta cada 100 km un total de: "+miAutomovil.calcularConsumoCoche()+" euros");
				InterfazUsuario.esperaIntro(sc);
				break;
				
			//Nuevas opciones **************************************
			case 10: //Modificar los datos del coche
				if(Automovil.existeAutomovil(miAutomovil)) 
					miAutomovil.modificarAutomovil();
				InterfazUsuario.esperaIntro(sc);
				break;	
			case 11://Eliminar coche	
				if(Automovil.existeAutomovil(miAutomovil))
					miAutomovil = Automovil.eliminarAutomovil(miAutomovil);
				InterfazUsuario.esperaIntro(sc);
				break;
				
			case 12: //Salir
				System.out.println("Nos vamos");
				InterfazUsuario.esperaIntro(sc);
				break;
			default:
				System.out.println("Opción no válida");				
				InterfazUsuario.esperaIntro(sc);		
				break;
			}
			
		}while(opcion != 12);
		
	}

}
