//package mapper;
//
//import cl.chilecompra.mserv.entity.ListaContratoProveedor;
//import cl.chilecompra.mserv.vo.GetListaContratoProveedorVO;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ListaContratoProveedorMapper {
//
//    public static List<GetListaContratoProveedorVO> mapperListaContrato(
//            List<ListaContratoProveedor> listaContratoProveedor
//    ) {
//        List<GetListaContratoProveedorVO> getListaContratoProveedorVO = new ArrayList<>();
//
//        listaContratoProveedor.forEach(value -> {
//            getListaContratoProveedorVO.add(GetListaContratoProveedorVO.builder()
//                    .codigo(value.getCodigo())
//                    .nombreContrato(value.getNombreContrato())
//                    .fechaPublicacionNota(value.getFechaPublicacionNota())
//                    .notaContrato(value.getNotaContrato())
//                    .build());
//        });
//
//        return getListaContratoProveedorVO;
//    }
//}
