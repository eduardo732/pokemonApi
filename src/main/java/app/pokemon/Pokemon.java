package app.pokemon;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Pokemon")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pokemon pokemon = (Pokemon) o;
        return idContrato != null && Objects.equals(idContrato, pokemon.idContrato);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
