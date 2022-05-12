package service;

import cl.chilecompra.mserv.vo.GetListaContratoProveedorVO;

import java.util.List;

public interface IListaContratoProveedorService {
    List<GetListaContratoProveedorVO> getContratoProveedorByRut(String rutProveedor);
    List<GetListaContratoProveedorVO> getContratoProveedorHistoricoByRut(String rutProveedor);
}
