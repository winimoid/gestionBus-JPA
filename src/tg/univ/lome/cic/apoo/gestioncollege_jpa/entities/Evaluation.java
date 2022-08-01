package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "evaluation")
public class Evaluation implements Serializable {  // Java bean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "cours")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Cours cours;

    @JoinColumn(name = "periode")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Periode periode;

    @JoinColumn(name = "type")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private TypeEvaluation type;

    @Column(name = "poids")
    private double poids;

    @Column(name = "date")
    private String date;

    @Column(name = "bareme")
    private int bareme;


    // Constr
    public Evaluation(){

    }

    public Evaluation(Cours cours, Periode periode, TypeEvaluation type, double poids, String date, int bareme) {
        this.cours = cours;
        this.periode = periode;
        this.type = type;
        this.poids = poids;
        this.date = date;
        this.bareme = bareme;
    }


    // Get/Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public TypeEvaluation getType() {
        return type;
    }

    public void setType(TypeEvaluation type) {
        this.type = type;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBareme() {
        return bareme;
    }

    public void setBareme(int bareme) {
        this.bareme = bareme;
    }


    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluation that = (Evaluation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // ToStr

    @Override
    public String toString() {
        return "Evaluation{" +
                "cours=" + cours +
                ", periode=" + periode +
                ", type=" + type +
                ", poids=" + poids +
                ", date='" + date + '\'' +
                ", bareme=" + bareme +
                '}';
    }
}
