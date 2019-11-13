package dad.maven.gson;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** Esta clase es una copia de Main que contiene las expresiones
 * regulares que han sido eliminadas debido a un incorrecto
 * funcionamiento de la aplicación **/

public class Expr {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		Persona p = new Persona();

		Scanner scanner = new Scanner(System.in);

		// Pedir introducir nombre
		System.out.println("Nombre: ");
		String nombre = scanner.nextLine();

		// Expresión regular para comprobar la validez del nombre
		Pattern exprNombre = Pattern.compile("^([A-Z]{1}[a-zñáéíóú]+[\\s]*)+$");
		Matcher comprobarNombre = exprNombre.matcher(nombre);

		// Comprobar la validez del nombre
		if (comprobarNombre.matches()) {
			p.setNombre(nombre);
		} else {
			throw new Exception("El nombre introducido no es válido. Consulte su DNI para más información.");
		}

		// Pedir introducir apellidos
		System.out.println("Apellidos: ");
		String apellidos = scanner.nextLine();

		// Expresión regular para comprobar la validez de los apellidos
		Pattern exprApellidos = Pattern.compile("^([A-Z]{1}[a-zñáéíóú]+[\\s]*)+$");
		Matcher comprobarApellidos = exprApellidos.matcher(apellidos);

		// Comprobar la validez de los apellidos
		if (comprobarApellidos.matches()) {
			p.setApellidos(apellidos);
		} else {
			throw new Exception("Los apellidos introducidos no son válidos. Consulte su DNI para más información.");
		}

		// Pedir introducir edad
		System.out.println("Edad: ");
		int edad = scanner.nextInt();

		// Comprobar la validez de la edad
		if (edad > 0 && edad <= 100) {
			p.setEdad(edad);
		} else {
			throw new Exception(
					"La edad introducida es inválida. Compruebe que consta con el consentimiento de sus padres e inténtelo de nuevo.");
		}

		scanner.close();

		// Convertir Persona a JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(p);
		System.out.println(json);

	}

}