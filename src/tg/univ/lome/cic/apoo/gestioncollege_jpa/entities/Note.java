package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "note")
public class Note implements Serializable {  // Java bean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "eleve")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Eleve eleve;

    @JoinColumn(name = "evaluation")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Evaluation evaluation;

    @Column(name = "valeurObtenue")
    private double valeurObtenue;


    // Constr
    public Note(){

    }

    public Note(Eleve eleve, Evaluation evaluation, double valeurObtenue) {
        this.eleve = eleve;
        this.evaluation = evaluation;
        this.valeurObtenue = valeurObtenue;
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

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public double getValeurObtenue() {
        return valeurObtenue;
    }

    public void setValeurObtenue(double valeurObtenue) {
        this.valeurObtenue = valeurObtenue;
    }


    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // ToStr

    @Override
    public String toString() {
        return "Note{" +
                "eleve=" + eleve +
                ", evaluation=" + evaluation +
                ", valeurObtenue=" + valeurObtenue +
                '}';
    }
}
