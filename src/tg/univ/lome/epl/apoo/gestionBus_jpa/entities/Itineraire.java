package tg.univ.lome.epl.apoo.gestionBus_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "itineraire", uniqueConstraints =
@UniqueConstraint(columnNames = "numeroligne"))
public class Itineraire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // le numéro de l'itineraire (par exemple, ligne 15, ligne 16)
    @Column(name = "numeroligne")
    private int numeroLigne;

    // un arret représentant le point de départ de l'itinéraire
    @Column(name = "pointdepart")
    private Long idArretdepart;

    // une chaîne de caractères représentant le point d'arrivée de l'itinéraire.
    @Column(name = "pointarrivee")
    private Long idArretArrivee;

    // un nombre à virgule représentant la distance totale de l'itinéraire
    @Column(name = "distancetotale")
    private double distanceTotale;

    // Ctors
    public Itineraire() {

    }

    public Itineraire(int numeroLigne, Long pointDepart, Long pointArrivee, double distanceTotale) {
        this.numeroLigne = numeroLigne;
        this.idArretdepart = pointDepart;
        this.idArretArrivee = pointArrivee;
        this.distanceTotale = distanceTotale;
    }

// Getters / Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroLigne() {
        return numeroLigne;
    }

    public void setNumeroLigne(int numeroLigne) {
        this.numeroLigne = numeroLigne;
    }

    public Long getIdArretdepart() {
        return idArretdepart;
    }

    public void setIdArretdepart(Long idArretdepart) {
        this.idArretdepart = idArretdepart;
    }

    public Long getIdArretArrivee() {
        return idArretArrivee;
    }

    public void setIdArretArrivee(Long idArretArrivee) {
        this.idArretArrivee = idArretArrivee;
    }

    public double getDistanceTotale() {
        return distanceTotale;
    }

    public void setDistanceTotale(double distanceTotale) {
        this.distanceTotale = distanceTotale;
    }

    // Equals / Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Itineraire that)) return false;
        return getNumeroLigne() == that.getNumeroLigne() && Double.compare(that.getDistanceTotale(), getDistanceTotale()) == 0 && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumeroLigne(), getDistanceTotale());
    }


    // TOString

    @Override
    public String toString() {
        return "Itineraire{" +
                "id=" + id +
                ", numeroLigne=" + numeroLigne +
                ", idArretdepart=" + idArretdepart +
                ", idArretArrivee=" + idArretArrivee +
                ", distanceTotale=" + distanceTotale +
                '}';
    }
}
