package vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class GetListaContratoProveedorVO {

    private String codigo;
    private String nombreContrato;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime fechaPublicacionNota;
    private float notaContrato;

}
