package entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class ListaContratoProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConId")
    private Integer idContrato;

    @Column(name= "ConCodigo")
    private String codigo;

    @Column(name = "ConNombreContrato")
    private String nombreContrato;

    @Column(name = "FechaPublicacion")
    private LocalDateTime fechaPublicacionNota;

    @Column(name = "NotaEvaluacion")
    private float notaContrato;

}
