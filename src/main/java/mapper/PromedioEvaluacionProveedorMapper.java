package mapper;

import cl.chilecompra.mserv.entity.PromedioEvaluacionProveedor;
import cl.chilecompra.mserv.vo.GetPromedioEvaluacionProveedorVO;

public class PromedioEvaluacionProveedorMapper {

    public static GetPromedioEvaluacionProveedorVO mapperPromedio(PromedioEvaluacionProveedor promedioEvaluacionContrato) {
        //cantidadContratos ---> 100%
        //cantidadNotas ----> X
        long porcentaje = (promedioEvaluacionContrato.getCantidadNotas() * 100) / promedioEvaluacionContrato.getCantidadContratos();
        String formateoPorcentaje = String.valueOf(porcentaje) + "%";
        return
            GetPromedioEvaluacionProveedorVO.builder()
                    .proveedorRut(promedioEvaluacionContrato.getProveedorRut())
                    .cantidadNotas(promedioEvaluacionContrato.getCantidadNotas())
                    .cantidadContratos(promedioEvaluacionContrato.getCantidadContratos())
                    .porcentajeEvaluado(formateoPorcentaje)
                    .promedio(promedioEvaluacionContrato.getPromedio())
                    .build();
    }


}
