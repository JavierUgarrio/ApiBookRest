package com.company.books.backend.response;
import java.util.*;

public class ResponseRest {

	// Lista para guardar información adicional (metadata) como tipo, código y fecha.
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();
	
	// Método para obtener la lista de metadata.
	public ArrayList<HashMap<String, String>> getMetadata(){
		return metadata;
	}
	
	// Método para agregar un nuevo conjunto de datos (tipo, código y fecha) a la metadata.
	public void setMetadata(String tipo, String codigo, String date) {
		// Crear un mapa para guardar los datos.
		HashMap<String, String> mapa = new HashMap<String , String>();
		
		// Agregar los datos al mapa.
		mapa.put("tipo", tipo);
		mapa.put("codigo", codigo);
		mapa.put("dato", date);
		
		// Añadir el mapa con los datos a la lista de metadata.
		metadata.add(mapa);
	}
	
}
/*
 * 
		El objetivo de la clase ResponseRest es proporcionar una estructura para almacenar y gestionar información adicional (metadata) relacionada con las respuestas de una API o aplicación.

		Uso principal:
		Metadata: Esta clase guarda datos adicionales como tipo, código y fecha. Esta información podría ser útil para describir detalles sobre el estado de la respuesta, errores, advertencias, o cualquier dato contextual adicional.
		
		Por ejemplo:
		En una API, si una solicitud falla, podrías usar esta clase para incluir un mensaje de error (tipo), un código de error (codigo), y una marca temporal (dato).

		Ejemplo práctico:
		Supongamos que tu API responde a una solicitud de creación de un libro. La metadata podría incluir algo así:

					json
					Copiar código
					{
					  "metadata": [
					    {
					      "tipo": "éxito",
					      "codigo": "201",
					      "dato": "2024-11-22 10:00:00"
					    }
					  ]
					}
					Esto indica que la solicitud fue exitosa (éxito), con el código HTTP 201 (Creado), y la fecha en que ocurrió.

		En resumen, ResponseRest facilita incluir y estructurar información contextual que acompaña las respuestas de tu sistema, mejorando la claridad y el control sobre los datos devueltos.
  
 */
