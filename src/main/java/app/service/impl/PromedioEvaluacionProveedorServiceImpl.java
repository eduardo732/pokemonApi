//package service.impl;
//
//import cl.chilecompra.mserv.mapper.PromedioEvaluacionProveedorMapper;
//import cl.chilecompra.mserv.repository.PromedioEvaluacionProveedorRepository;
//import cl.chilecompra.mserv.service.IPromedioEvaluacionProveedorService;
//import cl.chilecompra.mserv.vo.GetPromedioEvaluacionProveedorVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PromedioEvaluacionProveedorServiceImpl implements IPromedioEvaluacionProveedorService {
//
//    @Autowired
//    private PromedioEvaluacionProveedorRepository promedioEvaluacionProveedorRepository;
//
//    @Override
//    public Boolean existsByRut(String rutProveedor) {
//        return promedioEvaluacionProveedorRepository.existsByProveedorRut(rutProveedor);
//    }
//
//    @Override
//    public GetPromedioEvaluacionProveedorVO getByRut(String rutProveedor) {
//        return
//                PromedioEvaluacionProveedorMapper.mapperPromedio(promedioEvaluacionProveedorRepository.getByProveedorRut(rutProveedor));
//
//    }
//}
