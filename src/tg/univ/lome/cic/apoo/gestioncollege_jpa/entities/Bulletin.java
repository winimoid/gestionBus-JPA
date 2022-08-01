package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wini
 */
@Entity
@Table(name = "bulletin")
public class Bulletin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "eleve")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Eleve eleve;

    @JoinColumn(name = "periode")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Periode periode;


    // Constr
    public Bulletin(){

    }

    public Bulletin(Eleve eleve, Periode periode) {
        this.eleve = eleve;
        this.periode = periode;
    }


    // Get/Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }


    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bulletin bulletin = (Bulletin) o;
        return Objects.equals(id, bulletin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // ToStr

    @Override
    public String toString() {
        return "Bulletin{" +
                "eleve=" + eleve +
                ", periode=" + periode +
                '}';
    }
}
