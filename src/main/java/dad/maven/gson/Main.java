package dad.maven.gson;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		Persona p = new Persona();

		Scanner scanner = new Scanner(System.in);

		// Introducir nombre
		System.out.println("Nombre:");
		String nombre = scanner.nextLine();

		p.setNombre(nombre);

		// Introducir apellidos
		System.out.println("Apellidos:");
		String apellidos = scanner.nextLine();

		p.setApellidos(apellidos);

		// Introducir edad
		System.out.println("Edad:");
		int edad = scanner.nextInt();

		// Comprobar la validez de la edad
		if (edad > 0 && edad < 125) {
			p.setEdad(edad);
		} else {
			throw new Exception("La edad introducida es inválida.");
		}

		scanner.close();

		// Convertir Persona a JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(p);
		System.out.println(json);

	}

}
