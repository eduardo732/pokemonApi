package entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PromedioEvaluacionProveedor")
public class PromedioEvaluacionProveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@Column(name = "ProveedorRut")
	private String proveedorRut;

	@Column(name = "EstaActivo")
	private Integer estaActivo;

	@Column(name = "FechaCreacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "CantidadNotas")
	private Integer cantidadNotas;

	@Column(name = "CantidadContratos")
	private Integer cantidadContratos;

	@Column(name = "PromedioNotasContrato")
	private float promedio;



}
