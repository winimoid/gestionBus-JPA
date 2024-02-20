package tg.univ.lome.epl.apoo.gestionBus_jpa.entities;

import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.JoursSemaine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "horairetravail")
public class HoraireTravail implements Serializable {  // Classe java bean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // le jour de la semaine pour lequel l'horaire est défini (par exemple, "Lundi", "Mardi", etc.)
    @Column(name = "joursemaine", length = 100)
    private JoursSemaine jourSemaine;

    // l'heure de début du service pour ce jour de la semaine (par exemple, une chaîne de caractères ou un objet LocalTime
    //@Column(name = "heuredebut")
    @Column(name = "heuredebut")
    private int heureDebut;

    @Column(name = "minutedebut")
    private int minuteDebut;

    @Column(name = "heurefin")
    private int heureFin;

    @Column(name = "minutefin")
    private int minuteFin;

    @JoinColumn(name = "conducteur")                            // MERGE au lieu de PERSIST pour eviter : javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist:
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Conducteur conducteur;


    // Constructeurs
    public HoraireTravail() {

    }

    public HoraireTravail(JoursSemaine jourSemaine, int heureDebut, int minuteDebut, int heureFin, int minuteFin, Conducteur conducteur) {
        this.jourSemaine = jourSemaine;
        this.heureDebut = heureDebut;
        this.minuteDebut = minuteDebut;
        this.heureFin = heureFin;
        this.minuteFin = minuteFin;
        this.conducteur = conducteur;
    }

    public HoraireTravail(JoursSemaine jourSemaine, Horaire heureDebut, Horaire heureFin, Conducteur conducteur) {
        this.jourSemaine = jourSemaine;
        this.heureDebut = heureDebut.getHeure();
        this.minuteDebut = heureDebut.getMinute();
        this.heureFin = heureFin.getHeure();
        this.minuteFin = heureFin.getMinute();
        this.conducteur = conducteur;
    }

    // Getter / Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JoursSemaine getJourSemaine() {
        return jourSemaine;
    }

    public void setJourSemaine(JoursSemaine jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    public Horaire getHeureDebut() {
        return convertToHoraire(heureDebut, minuteDebut);
    }

    public void setHeureDebut(Horaire heureDebut) {
        this.heureDebut = heureDebut.getHeure();
        this.minuteDebut = heureDebut.getMinute();
    }

    public Horaire getHeureFin() {
        return convertToHoraire(heureFin, minuteFin);
    }

    public void setHeureFin(Horaire heureFin) {
        this.heureFin = heureFin.getHeure();
        this.minuteFin = heureFin.getMinute();
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }
    // Equals / Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HoraireTravail that)) return false;
        return getHeureDebut() == that.getHeureDebut() && minuteDebut == that.minuteDebut && getHeureFin() == that.getHeureFin() && minuteFin == that.minuteFin && getJourSemaine() == that.getJourSemaine();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJourSemaine(), getHeureDebut(), minuteDebut, getHeureFin(), minuteFin);
    }

    // ToString


    @Override
    public String toString() {
        return "HoraireTravail{" +
                "id=" + id +
                ", jourSemaine=" + jourSemaine +
                ", heureDebut=" + heureDebut +
                ", minuteDebut=" + minuteDebut +
                ", heureFin=" + heureFin +
                ", minuteFin=" + minuteFin +
                ", conducteur=" + conducteur +
                '}';
    }

    // Conversion de types simples int en type Horaire
    private Horaire convertToHoraire(int heure, int minute) {
        return new Horaire(heure, minute);
    }
}
