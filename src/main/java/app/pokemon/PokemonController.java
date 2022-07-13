package app.pokemon;

import app.helpers.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.helpers.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/pokemon")
public class PokemonController {

    private final IPokemonService iPokemonService;

	public PokemonController(IPokemonService iPokemonService) {
		this.iPokemonService = iPokemonService;
	}

	@GetMapping("/getPokemons")
    @CrossOrigin(value = "*", methods = RequestMethod.GET)
	public ResponseEntity<GenericResponse<?>> getPokemons() {

		/*
		 * Inicializar objeto de respuesta estándar
		 */
		GenericResponse<GetPokemonsVO> response = new GenericResponse<GetPokemonsVO>();

		/*
		 * Inicializar objeto para contener los errores de validaciones de entrada
		 */
		ArrayList<Error> errores = new ArrayList<>();
		Error error;


		/*
		 * Validar si existen errores, de existir, se retorna la respuesta estándar con
		 * la lista de errores, se debe conservar la estructura de Payload.
		 */
//		if (errores.size() > 0) {
//			response.setErrores(errores);
//			response.setSuccess(HttpStatus.CONFLICT);
//
//			return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.BAD_REQUEST);
//		}

		List<GetPokemonsVO> getPokemonsVOList = iPokemonService.getPokemons();

		if (getPokemonsVOList == null) {
			response.setSuccess(HttpStatus.OK);
			return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.OK);
		}

		/*
		 * En este punto se han obtenido satisfactoriamente el proveedor desde la base de
		 * datos. Retornar success ok y en payload la información del pokemon.
		 */
		response.setSuccess(HttpStatus.OK);
		response.setPayload(getPokemonsVOList);
		return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.OK);
	}

}

