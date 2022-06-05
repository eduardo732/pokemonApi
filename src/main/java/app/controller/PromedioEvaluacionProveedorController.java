//package controller;
//
//import cl.chilecompra.mserv.response.GenericResponse;
//import cl.chilecompra.mserv.response.Success;
//import cl.chilecompra.mserv.service.IListaContratoProveedorService;
//import cl.chilecompra.mserv.service.IPromedioEvaluacionProveedorService;
//import cl.chilecompra.mserv.vo.GetListaContratoProveedorVO;
//import cl.chilecompra.mserv.vo.GetPromedioEvaluacionProveedorVO;
//import lombok.extern.slf4j.Slf4j;
//import org.keycloak.KeycloakPrincipal;
//import org.keycloak.representations.AccessToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//@RestController
//@EnableAutoConfiguration
//@RequestMapping("/v1/comportamiento-contractual")
//public class PromedioEvaluacionProveedorController {
//
//	@Autowired
//	private IPromedioEvaluacionProveedorService iPromedioEvaluacionProveedorService;
//	@Autowired
//	private IListaContratoProveedorService iListaContratoProveedorService;
//
//	@GetMapping("/promedio/{rutProveedor}")
//	@CrossOrigin(value = "*", methods = RequestMethod.GET)
//	public ResponseEntity<GenericResponse<?>> getPromedioProveedorByRut(@PathVariable(value = "rutProveedor") String rutProveedor) {
//
//		/*
//		 * Inicializar objeto de respuesta estándar
//		 */
//		GenericResponse<GetPromedioEvaluacionProveedorVO> response = new GenericResponse<GetPromedioEvaluacionProveedorVO>();
//
//		/*
//		 * Inicializar objeto para contener los errores de validaciones de entrada
//		 */
//		ArrayList<Error> errores = new ArrayList<>();
//		Error error;
//
//		/*
//		 * Validar entrada "rutProveedor", este debe ser requerido
//		 */
//		if (rutProveedor == null || rutProveedor.isEmpty()) {
//			error = setErrors("400-1", "Se debe proporcionar un rut de proveedor valido");
//			errores.add(error);
//			log.error("En obtener el promedio por Rut - rut invalido");
//		}
//
//		/*
//		 * Validar si existen errores, de existir, se retorna la respuesta estándar con
//		 * la lista de errores, se debe conservar la estructura de Payload.
//		 */
//		if (errores.size() > 0) {
//			response.setErrores(errores);
//			response.setSuccess(Success.NOK);
//
//			return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.BAD_REQUEST);
//		}
//
//		Boolean existe = iPromedioEvaluacionProveedorService.existsByRut(rutProveedor);
//		GetPromedioEvaluacionProveedorVO getPromedioEvaluacionProveedorVO = null;
//		if (!existe) {
//			getPromedioEvaluacionProveedorVO = new GetPromedioEvaluacionProveedorVO(rutProveedor, 0, 0, "0%",0);
//			log.error("En obtener el promedio por Rut - proveedor sin contratos evaluados");
//		} else {
//			/*
//			 * Retorna el proveedor indicado
//			 */
//			getPromedioEvaluacionProveedorVO = iPromedioEvaluacionProveedorService.getByRut(rutProveedor);
//
//			if (getPromedioEvaluacionProveedorVO == null) {
//				response.setSuccess(Success.NOK);
//				log.error("En obtener el promedio por Rut - getPromedioEvaluacionContratoVO null");
//				return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.NOT_FOUND);
//			}
//		}
//
//		/*
//		 * En este punto se han obtenido satisfactoriamente el proveedor desde la base de
//		 * datos. Retornar success ok y en payload la información del pokemon.
//		 */
//		response.setSuccess(Success.OK);
//		response.setPayload(getPromedioEvaluacionProveedorVO);
//		log.info("En obtener el promedio por Rut - Obtiene el Promedio por Rut");
//		return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.OK);
//	}
//
//	@GetMapping("/lista-contratos/{rutProveedor}")
//	@CrossOrigin(value = "*", methods = RequestMethod.GET)
//	public ResponseEntity<GenericResponse<?>> getListaContratosProveedorByRut(@PathVariable(value = "rutProveedor") String rutProveedor) {
//
//		/*
//		 * Inicializar objeto de respuesta estándar
//		 */
//		GenericResponse<List<GetListaContratoProveedorVO>> response = new GenericResponse<List<GetListaContratoProveedorVO>>();
//
//		/*
//		 * Inicializar objeto para contener los errores de validaciones de entrada
//		 */
//		ArrayList<Error> errores = new ArrayList<>();
//		Error error;
//		/*
//		 * Validar entrada "rutProveedor", este debe ser requerido
//		 */
//		if (rutProveedor == null || rutProveedor.isEmpty()) {
//			error = setErrors("400-1", "Se debe proporcionar un rut de proveedor valido");
//			errores.add(error);
//			log.error("En obtener la lista de contratos por Rut - el rut es invalido");
//		}
//
//		/*
//		 * Validar si existen errores, de existir, se retorna la respuesta estándar con
//		 * la lista de errores, se debe conservar la estructura de Payload.
//		 */
//		if (errores.size() > 0) {
//			response.setErrores(errores);
//			response.setSuccess(Success.NOK);
//
//			return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.BAD_REQUEST);
//		}
//
//		/*
//		 * Retorna la lista de contratos
//		 */
//		List<GetListaContratoProveedorVO> listaContratoProveedor = iListaContratoProveedorService.getContratoProveedorByRut(rutProveedor);
//
//
//		/*
//		 * En este punto se han obtenido satisfactoriamente la lista desde la base de
//		 * datos. Retornar success ok y en payload la información del pokemon.
//		 */
//		response.setSuccess(Success.OK);
//		response.setPayload(listaContratoProveedor);
//		log.info("En obtener la lista de contratos por Rut - Se obtiene la lista de contratos por rut");
//		return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.OK);
//	}
//
//	@GetMapping("/lista-contratos-historico/{rutProveedor}")
//	@CrossOrigin(value = "*", methods = RequestMethod.GET)
//	public ResponseEntity<GenericResponse<?>> getListaContratosProveedorHistoricoByRut(@PathVariable(value = "rutProveedor") String rutProveedor) {
//
//		/*
//		 * Inicializar objeto de respuesta estándar
//		 */
//		GenericResponse<List<GetListaContratoProveedorVO>> response = new GenericResponse<List<GetListaContratoProveedorVO>>();
//
//		/*
//		 * Inicializar objeto para contener los errores de validaciones de entrada
//		 */
//		ArrayList<Error> errores = new ArrayList<>();
//		Error error;
//		/*
//		 * Validar entrada "rutProveedor", este debe ser requerido
//		 */
//		if (rutProveedor == null || rutProveedor.isEmpty()) {
//			error = setErrors("400-1", "Se debe proporcionar un rut de proveedor valido");
//			errores.add(error);
//			log.error("En obtener la lista de contratos historicos por Rut - el rut es invalido");
//		}
//
//		/*
//		 * Validar si existen errores, de existir, se retorna la respuesta estándar con
//		 * la lista de errores, se debe conservar la estructura de Payload.
//		 */
//		if (errores.size() > 0) {
//			response.setErrores(errores);
//			response.setSuccess(Success.NOK);
//
//			return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.BAD_REQUEST);
//		}
//
//		/*
//		 * Retorna la lista de contratos
//		 */
//		List<GetListaContratoProveedorVO> listaContratoProveedorHistorico = iListaContratoProveedorService.getContratoProveedorHistoricoByRut(rutProveedor);
//
//		/*
//		 * En este punto se han obtenido satisfactoriamente la lista desde la base de
//		 * datos. Retornar success ok y en payload la información del pokemon.
//		 */
//		response.setSuccess(Success.OK);
//		response.setPayload(listaContratoProveedorHistorico);
//		log.info("En obtener la lista de contratos historicos por Rut - Se obtiene la lista de contratos por rut");
//		return new ResponseEntity<GenericResponse<?>>(response, null, HttpStatus.OK);
//	}
//
//	@Bean(name = "PromedioEvaluacionProveedorController")
//	@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//	@SuppressWarnings({"rawtypes"})
//	public AccessToken getAccessToken() {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
//				.getRequest();
//		return ((KeycloakPrincipal) request.getUserPrincipal()).getKeycloakSecurityContext().getToken();
//	}
//
//	public Error setErrors(String code, String descripcion) {
//		Error error = new Error();
//		error.setCodigo(code);
//		error.setDescripcion(descripcion);
//		return error;
//	}
//}
