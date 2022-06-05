package app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer idContrato;

    @Column(name= "Nombre")
    private String name;

    @Column(name= "Elemento")
    private String element;

    @Column(name= "Daño")
    private Integer damage;

    @Column(name= "Fecha")
    private String date;
}
