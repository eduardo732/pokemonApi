package service;

import cl.chilecompra.mserv.vo.GetPromedioEvaluacionProveedorVO;

public interface IPromedioEvaluacionProveedorService {

    Boolean existsByRut(String rutProveedor);

    GetPromedioEvaluacionProveedorVO getByRut(String rutProveedor);
}
