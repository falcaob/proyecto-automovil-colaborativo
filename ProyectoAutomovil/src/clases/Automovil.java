package clases;

import java.util.Scanner;

public class Automovil {

	// ATRIBUTOS DE LA CLASE***************
	private String matricula; // matrícula del vehículo
	private String marca; // marca del vehículo
	private String color; // color del vehículo
	private int nAnyos; // antigüedad en años del vehículo
	double velocidad; // velocidad actual del vehículo
	private String tipoCombustible; // indica si el coche es gasolina o diesel
	private static double precioGasolina = 1.60; // atributo estático común a todos los coches
	private static double precioGasoil = 1.30; // atributo estático común a todos los coches

	// CONSTRUCTORES DE LA CLASE************************
	// Métodos que nos permiten construir objetos de la clase

	// Constructor por defecto
	public Automovil() {
	}

	// Constructor para nuevos automoviles de los que conozco la matrícula
	public Automovil(String matricula) {

		this.matricula = matricula;
	}

	// Constructor para nuevos automoviles
	// de los que conozco la matrícula y la marca
	public Automovil(String matricula, String marca) {

		this.matricula = matricula;
		this.marca = marca;
	}

	// Constructor para nuevos automoviles
	// de los que conozco todos los datos excepto el tipo de combustible
	public Automovil(String matricula, String marca, String color, int nAnyos, double velocidad) {
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
		this.nAnyos = nAnyos;
		this.velocidad = velocidad;
	}

	// Constructor para nuevo automovil del que conozco todos los datos
	// incluido el tipo de combustible

	public Automovil(String matricula, String marca, String color, int nAnyos, double velocidad,
			String tipoCombustible) {

		this(matricula, marca, color, nAnyos, velocidad);
		this.setTipoCombustible(tipoCombustible);

	}

	// GETTERS Y SETTERS***************************
	// Métodos que nos permiten obtener y establecer
	// los valores de los atributos

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNAnyos() {
		return this.nAnyos;
	}

	public void setNAnyos(int nAnyos) {
		this.nAnyos = nAnyos;
	}

	public double getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public String getTipoCombustible() {
		return this.tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		// Si tipoCombustible no es "Gasolina" ni es "Diesel" entonces
		// Escribir "No es un combustible correcto"
		// Si no
		// dar al atributo tipoCOmbustible el valor indicado

		if (tipoCombustible.equalsIgnoreCase("Gasolina") || tipoCombustible.equalsIgnoreCase("Gasoil"))
			this.tipoCombustible = tipoCombustible;
		else
			System.out.println("No es un combustible correcto");
	}

	public static void setPrecioGasolina(double precioGasolina) {
		Automovil.precioGasolina = precioGasolina;
	}

	public static double getPrecioGasolina() {
		return Automovil.precioGasolina;
	}

	public static void setPrecioGasoil(double precioGasoil) {
		Automovil.precioGasoil = precioGasoil;
	}

	public static double getprecioGasoil() {
		return Automovil.precioGasoil;
	}

	// MÉTODOS DE INSTANCIA***************************

	// Método que muestra los datos de un objeto de la clase Automovil
	public void mostrarAutomovil() {
		System.out.println("\nLos datos de este coche son:");
		System.out.println("Matrícula: " + this.getMatricula());
		System.out.println("Marca: " + this.getMarca());
		System.out.println("Color: " + this.getColor());
		System.out.println("Antigüedad: " + this.getNAnyos() + " años");
		System.out.println("Velocidad actual: " + this.getVelocidad() + " km/h");
		System.out.println("Tipo de combustible: " + this.getTipoCombustible());
	}

	// Método que arranca un coche
	// Un coche se puede arrancar siempre que su velocidad sea 0 km/h
	// Arrancar un coche significa ponerlo a 10 km/h
	public void arrancar() {
		if (this.getVelocidad() > 0) // Si el coche ya está arrancado
			System.out.println("No se puede volver a arrancar el coche");
		else
			this.setVelocidad(10);
	}

	// Método que acelara un automovil
	// un número determinado de km/h que le indicamos como argumento
	// Un coche que no esté arrancado (velocidad > 0) no puede ser acelerado
	public void acelerar(double aceleracion) {
		if (this.getVelocidad() > 0) // Si el coche ya está arrancado
			this.setVelocidad(this.getVelocidad() + aceleracion);
		else
			System.out.println("No se puede acelerar un coche que no se ha arrancado");
	}

	// Método que frena un automóvil
	// un número determinado de km/h que le indicamos como argumento
	// Un coche que no esté arrancado (velocidad > 0) no puede ser frenado
	public void frenar(double frenado) {
		if (this.getVelocidad() > 0) { // Si el coche ya está arrancado
			if (frenado > this.getVelocidad()) // Si quiero frenar más de la velocidad actual
				frenado = this.getVelocidad();
			this.setVelocidad(this.getVelocidad() - frenado);
		} else
			System.out.println("No se puede frenar un coche que no está en marcha");
	}

	// Método que me da el precio del litro de combustible que usa el coche
	public void precioCombustible() {
		if (this.getTipoCombustible().equalsIgnoreCase("Gasolina"))
			System.out.println("Precio Gasolina: " + Automovil.getPrecioGasolina() + " €/litro");
		else
			System.out.println("Precio Gasoil: " + Automovil.getprecioGasoil() + " €/litro");

	}

	// Método que me permite cambiar el precio del litro de combustible que usa el
	// coche
	public void cambiarPrecioCombustible() {

		Scanner sc = new Scanner(System.in);
		double nuevoPrecio;
		String tipoCombustible = this.getTipoCombustible();

		System.out.println("Dime el nuevo precio para " + tipoCombustible);
		nuevoPrecio = sc.nextDouble();

		if (tipoCombustible.equalsIgnoreCase("Gasolina"))
			Automovil.setPrecioGasolina(nuevoPrecio);
		else
			Automovil.setPrecioGasoil(nuevoPrecio);
	}

	// Método que nos calcula el consumo del coche (en euros) por cada 100km
	// En este caso, optamos por la estrategia de que el método nos devuelva
	// un valor double correspondiente al consumo del coche en euros
	public double calcularConsumoCoche() {

		double consumoEnEuros = 0;
		double litrosCada100;
		double precioLitroCombustible;
		String tipoCombustible = this.getTipoCombustible();
		Scanner sc = new Scanner(System.in);

		// vamos a pedirle al usuario que nos de información sobre el consumo
		// del coche por cada 100 km
		System.out.println("¿Cual es el consumo en litros por cada 100km?");
		litrosCada100 = sc.nextDouble();

		// Vamos a extraer el dato del precio/litro del combustible que usa el coche
		if (tipoCombustible.equalsIgnoreCase("Gasolina"))
			precioLitroCombustible = Automovil.getPrecioGasolina();
		else
			precioLitroCombustible = Automovil.getprecioGasoil();

		// Calculo el consumo
		consumoEnEuros = litrosCada100 * precioLitroCombustible;

		return consumoEnEuros;
	}

	/*
	 * // Método que pinta un coche del color que le indicamos public void
	 * pintarCoche(String color) { if (this.getColor() == color) {
	 * System.out.println("\nEl coche ya es de ese color.\nNo se va a pintar"); }
	 * else { this.setColor(color);
	 * System.out.println("\nHemos pintado el coche de " + color); } }
	 */

	// ------------------------------------------------------------------------------------
	// Método para modificar los datos del coche
	// Podemos elegir entre modificar uno o modificarlos todos
	public void modificarAutomovil() {

		Scanner sc = new Scanner(System.in);
		int opcion;

		do {

			InterfazUsuario.imprimirModificarDatos();
			System.out.println("\nIndica una opción (1-8):");
			opcion = sc.nextInt();

			switch (opcion) {

			case 1: // Modificar solo la matricula
				System.out.println("Introduce la nueva matricula:");
				String nuevaMatricula = sc.next();
				this.setMatricula(nuevaMatricula);
				System.out.println("La nueva matricula es: " + this.getMatricula());
				break;
			case 2: // Modificar solo la marca
				System.out.println("Introduce la nueva marca:");
				String nuevaMarca = sc.next();
				this.setMatricula(nuevaMarca);
				System.out.println("La nueva marca es: " + this.getMarca());
				break;
			case 3: // Modificar solo el color
				System.out.println("Introduce el nuevo color:");
				String nuevoColor = sc.next();
				this.setMatricula(nuevoColor);
				System.out.println("El nuevo color es: " + this.getColor());
				break;
			case 4: // Modificar solo la antigüedad
				System.out.println("Introduce la nueva antigüedad:");
				int nuevaAntiguedad = sc.nextInt();
				this.setNAnyos(nuevaAntiguedad);
				System.out.println("La nueva antigüeda es: " + this.getNAnyos());
				break;
			case 5: // Modificar solo la velocidad
				System.out.println("Introduce la nueva velocidad:");
				double nuevaVelocidad = sc.nextDouble();
				this.setVelocidad(nuevaVelocidad);
				System.out.println("La nueva velocidad es: " + this.getVelocidad());
				break;
			case 6: // Modificar solo el tipo de combustible
				System.out.println("Introduce el nuevo tipo de combustible:");
				String nuevoCombustible = sc.next();
				this.setTipoCombustible(nuevoCombustible);
				System.out.println("El nuevo tipo de combustible es:" + this.getTipoCombustible());
				break;
			case 7: // Modificar todos los datos
				System.out.println("Introduce los nuevos datos...");
				System.out.println("Nueva matricula:");
				String nuevaMatricula2 = sc.next();
				this.setMatricula(nuevaMatricula2);

				System.out.println("Nueva marca:");
				String nuevaMarca2 = sc.next();
				this.setMatricula(nuevaMarca2);

				System.out.println("Nuevo color:");
				String nuevoColor2 = sc.next();
				this.setMatricula(nuevoColor2);

				System.out.println("Nueva antigüedad:");
				int nuevaAntiguedad2 = sc.nextInt();
				this.setNAnyos(nuevaAntiguedad2);

				System.out.println("Nueva velocidad:");
				double nuevaVelocidad2 = sc.nextDouble();
				this.setVelocidad(nuevaVelocidad2);

				System.out.println("Nuevo tipo de combustible:");
				String nuevoCombustible2 = sc.next();
				this.setTipoCombustible(nuevoCombustible2);
			case 8: // Salir
				System.out.println("Has terminado de editar los nuevos datos.");
				break;
			default:
				System.out.println("Opción no válida");
				// InterfazUsuario.esperaIntro(sc);
				break;
			}

		} while (opcion != 8);
	}
	// ------------------------------------------------------------------------------------

	// MÉTODOS DE ESTÁTICOS***************************

	// Método que nos permite crear un nuevo objeto Automovil
	// con los datos que nos da el usuario
	public static Automovil crearAutomovil() {

		Scanner sc = new Scanner(System.in);
		Automovil nuevoAutomovil = new Automovil();

		System.out.println("Dame los datos del nuevo automovil:");
		System.out.println("Matrícula: ");
		nuevoAutomovil.setMatricula(sc.next());
		System.out.println("Marca: ");
		nuevoAutomovil.setMarca(sc.next());
		System.out.println("Color: ");
		nuevoAutomovil.setColor(sc.next());
		System.out.println("Antigüedad: ");
		nuevoAutomovil.setNAnyos(sc.nextInt());
		System.out.println("Velocidad actual: ");
		nuevoAutomovil.setVelocidad(sc.nextDouble());
		System.out.println("Tipo de combustible: ");
		nuevoAutomovil.setTipoCombustible(sc.next());

		return nuevoAutomovil;

		/*
		 * Automovil nuevoAutomovil = null;
		 * 
		 * System.out.println("Dame los datos del nuevo automovil:");
		 * System.out.println("Matrícula: "); String matricula = sc.next();
		 * System.out.println("Marca: "); String marca = sc.next();
		 * System.out.println("Color: "); String color = sc.next();
		 * System.out.println("Antigüedad: "); int nAnyos = sc.nextInt();
		 * System.out.println("Velocidad actual: "); double velocidad = sc.nextDouble();
		 * System.out.println("Tipo de combustible: "); String tipoCombustible =
		 * sc.next();
		 * 
		 * return nuevoAutomovil = new
		 * Automovil(matricula,marca,color,nAnyos,velocidad,tipoCombustible);
		 */

	}

	// Metodo que nos permite saber si existe un objeto Automovil
	public static boolean existeAutomovil(Automovil miAutomovil) {
		boolean existe = false;
		if (miAutomovil != null)
			existe = true;
		else
			System.out.println("Debes crear primero un automovil");
		return existe;
	}

	/*
	 * / Método que nos permite asignar un nuevo precio a la gasolina public void
	 * nuevoPrecioGasolina(double precioGasolina) {
	 * setPrecioGasolina(precioGasolina); }
	 * 
	 * // Método que nos permite mostrar el precio de la gasolina public double
	 * mostrarPrecioGasolina() { return getPrecioGasolina(); }
	 */

	// Metodo para eliminar un automovil

	// Primero se llama al objeto miAutomovil de la clase main, se pregunta al
	// usuario si se quiere
	// eliminar el objeto, en caso afirmartivo, se retorna a null la variable, y el
	// recolector la elimina.
	// En caso negativo, simplemente se retorna de nuevo la variable con sus valores
	// anteriores (no se modifica nada)
	// En un supuesto que no se escriba ninguna de las dos simplemente se le dice al
	// usuario que se introduzca una opción valida

	// ------------------------------------------------------------------------------------
	// Método que le da la opción al usuario de elimiar el automovil o arrepentise en el último momento y no borrarlo
	public static Automovil eliminarAutomovil(Automovil miAutomovil) {
		String eliminar;
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Desea eliminar el automovil actual? (Si o No)");

		eliminar = sc.nextLine();

		if (eliminar.equalsIgnoreCase("Si")) {

			System.out.println("El automovil ha sido eliminado");

			return null;

		} else if (eliminar.equalsIgnoreCase("No")) {

			System.out.println("No se ha eliminado el automovil");

			return miAutomovil;

		} else {
			System.out.println("Escriba una opcion valida (Si o No)");
		}
		return miAutomovil;
		}
	}
	// ------------------------------------------------------------------------------------
