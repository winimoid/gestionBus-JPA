package tg.univ.lome.epl.apoo.gestionBus_jpa.entities;

import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "arret")
public class Arret implements Serializable { // classe Java bean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // une chaîne de caractères représentant un point d'arret
    @Column(name = "pointarret")
    private String pointArret;

    // horaire de passage du bus à l'arrêt
    @Column(name = "heurePassage")
    private int heurePassage;

    @Column(name = "minutePassage")
    private int minutePassage;

    @JoinColumn(name = "itineraire")                            // MERGE au lieu de PERSIST pour eviter : javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist:
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Itineraire itineraire;

    // Ctors
    public Arret() {

    }

    public Arret(String pointArret, int heurePassage, int minutePassage, Itineraire itineraire) {
        this.pointArret = pointArret;
        this.heurePassage = heurePassage;
        this.minutePassage = minutePassage;
        this.itineraire = itineraire;
    }

    public Arret(String pointArret, Horaire horairePassage, Itineraire itineraire) {
        this.pointArret = pointArret;
        this.heurePassage = horairePassage.getHeure();
        this.minutePassage = horairePassage.getMinute();
        this.itineraire = itineraire;
    }

    public Arret(String pointArret, int heurePassage, int minutePassage) {
        this.pointArret = pointArret;
        this.heurePassage = heurePassage;
        this.minutePassage = minutePassage;
        this.itineraire = null;
    }

    public Arret(String pointArret, Horaire horairePassage) {
        this.pointArret = pointArret;
        this.heurePassage = horairePassage.getHeure();
        this.minutePassage = horairePassage.getMinute();
        this.itineraire = null;
    }

    // Get /Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPointArret() {
        return pointArret;
    }

    public void setPointArret(String pointArret) {
        this.pointArret = pointArret;
    }

    public int getHeurePassage() {
        return heurePassage;
    }

    public void setHeurePassage(int heurePassage) {
        this.heurePassage = heurePassage;
    }

    public int getMinutePassage() {
        return minutePassage;
    }

    public void setMinutePassage(int minutePassage) {
        this.minutePassage = minutePassage;
    }

    public Horaire getHorairePassage() {
        return new Horaire(this.heurePassage, this.minutePassage);
    }

    public void setHorairePassage(Horaire horairePassage) {
        this.heurePassage = horairePassage.getHeure();
        this.minutePassage = horairePassage.getMinute();
    }

    public Itineraire getItineraire() {
        return itineraire;
    }

    public void setItineraire(Itineraire itineraire) {
        this.itineraire = itineraire;
    }
    // Equals / Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arret arret)) return false;
        return getId().equals(arret.getId()) && getPointArret().equals(arret.getPointArret()) && Objects.equals(getItineraire(), arret.getItineraire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPointArret(), getItineraire());
    }


    // ToString

    @Override
    public String toString() {
        return "Arret{" +
                "id=" + id +
                ", pointArret='" + pointArret + '\'' +
                ", heurePassage=" + heurePassage +
                ", minutePassage=" + minutePassage +
                ", itineraire=" + itineraire +
                '}';
    }
}
