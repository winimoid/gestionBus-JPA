package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "enseignement")
public class Enseignement implements Serializable {  // Java bean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "matiere")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Matiere matiere;

    @JoinColumn(name = "niveau")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Niveau niveau;

    @Column(name = "coefficient")
    private int coefficient;


    // Const
    public Enseignement(){

    }

    public Enseignement(Matiere matiere, Niveau niveau, int coefficient) {
        this.matiere = matiere;
        this.niveau = niveau;
        this.coefficient = coefficient;
    }


    // Get/Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }


    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignement that = (Enseignement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // ToStr

    @Override
    public String toString() {
        return "Enseignement{" +
                "matiere=" + matiere +
                ", niveau=" + niveau +
                ", coefficient=" + coefficient +
                '}';
    }
}
