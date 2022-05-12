package repository;

import cl.chilecompra.mserv.entity.ListaContratoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaContratoProveedorRepository extends JpaRepository<ListaContratoProveedor, Integer> {
    @Query(
            value= " SELECT DISTINCT   c.ConId, c.ConCodigo , c.ConNombreContrato , ec.FechaPublicacion, ec.NotaEvaluacion " +
                    " FROM DCCPProcurement.SGC.Contrato c WITH(NOLOCK) " +
                    " INNER JOIN DCCPProcurement.SGC.EvaluacionContrato ec WITH(NOLOCK) ON c.ConId = ec.IdContrato " +
                    " WHERE c.ConProveedorRut =:rutProveedor " +
                    " AND ec.Estado = 'EPU' " +
                    " AND CONVERT(DATE, ec.FechaPublicacion) <= CONVERT(DATE, GETDATE()) " +
                    " AND CONVERT(DATE, ec.FechaPublicacion) >= DATEADD(MONTH, -24, CONVERT(DATE, GETDATE())) " +
                    " UNION " +
                    " SELECT c.ConId, c.ConCodigo , c.ConNombreContrato , ec.FechaPublicacion, ec.NotaEvaluacion " +
                    " FROM DCCPProcurement.SGC.EvaluacionContrato ec WITH(NOLOCK) " +
                    " INNER JOIN DCCPProcurement.SGC.Contrato c WITH(NOLOCK) ON ec.IdContrato = c.ConId " +
                    " INNER JOIN DCCPProcurement.SGC.ContratoUtpIntegrantes cui on c.ConId = cui.IdContrato " +
                    " WHERE cui.Rut =:rutProveedor " +
                    " AND ec.Estado = 'EPU' " +
                    " AND CONVERT(DATE, ec.FechaPublicacion) <= CONVERT(DATE, GETDATE()) " +
                    " AND CONVERT(DATE, ec.FechaPublicacion) >= DATEADD(MONTH, -24, CONVERT(DATE, GETDATE())) "
            ,
            nativeQuery = true
    )
    List<ListaContratoProveedor> getContratosByRut(@Param("rutProveedor") String rutProveedor);

    @Query(
            value= " SELECT DISTINCT   c.ConId, c.ConCodigo , c.ConNombreContrato , ec.FechaPublicacion, ec.NotaEvaluacion " +
                    " FROM DCCPProcurement.SGC.Contrato c WITH(NOLOCK) " +
                    " INNER JOIN DCCPProcurement.SGC.EvaluacionContrato ec WITH(NOLOCK) ON c.ConId = ec.IdContrato " +
                    " WHERE c.ConProveedorRut =:rutProveedor " +
                    " AND ec.Estado = 'EPU' " +
                    " AND CONVERT(DATE, ec.FechaPublicacion) < DATEADD(MONTH, -24, CONVERT(DATE, GETDATE())) " +
                    " UNION " +
                    " SELECT c.ConId, c.ConCodigo , c.ConNombreContrato , ec.FechaPublicacion, ec.NotaEvaluacion " +
                    " FROM DCCPProcurement.SGC.EvaluacionContrato ec WITH(NOLOCK) " +
                    " INNER JOIN DCCPProcurement.SGC.Contrato c WITH(NOLOCK) ON ec.IdContrato = c.ConId " +
                    " INNER JOIN DCCPProcurement.SGC.ContratoUtpIntegrantes cui on c.ConId = cui.IdContrato " +
                    " WHERE cui.Rut =:rutProveedor " +
                    " AND ec.Estado = 'EPU' " +
                    " AND CONVERT(DATE, ec.FechaPublicacion) < DATEADD(MONTH, -24, CONVERT(DATE, GETDATE())) "
            ,
            nativeQuery = true
    )
    List<ListaContratoProveedor> getContratosHistoricosByRut(String rutProveedor);
}
