//package service.impl;
//
//import cl.chilecompra.mserv.mapper.ListaContratoProveedorMapper;
//import cl.chilecompra.mserv.repository.ListaContratoProveedorRepository;
//import cl.chilecompra.mserv.service.IListaContratoProveedorService;
//import cl.chilecompra.mserv.vo.GetListaContratoProveedorVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ListaContratoProveedorServiceImpl implements IListaContratoProveedorService {
//
//    @Autowired
//    private ListaContratoProveedorRepository listaContratoProveedorRepository;
//
//    @Override
//    public List<GetListaContratoProveedorVO> getContratoProveedorByRut(String rutProveedor) {
//        return
//                ListaContratoProveedorMapper.mapperListaContrato(listaContratoProveedorRepository.getContratosByRut(rutProveedor));
//    }
//
//    @Override
//    public List<GetListaContratoProveedorVO> getContratoProveedorHistoricoByRut(String rutProveedor) {
//        return
//                ListaContratoProveedorMapper.mapperListaContrato(listaContratoProveedorRepository.getContratosHistoricosByRut(rutProveedor));
//    }
//}
