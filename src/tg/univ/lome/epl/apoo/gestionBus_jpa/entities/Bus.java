/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univ.lome.epl.apoo.gestionBus_jpa.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "bus", uniqueConstraints =
    @UniqueConstraint(columnNames = "numerobus"))
public class Bus implements Serializable { //classe java bean
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // numéro du bus (par exemple, une chaîne de caractères ou un identifiant unique
    @Column(name = "numerobus")
    private int numeroBus;

    // modèle ou type de bus (par exemple, une chaîne de caractères
    @Column(name = "modele", length = 100)
    private String modele;

    // capacité maximale de passagers du bus (par exemple, un entier
    @Column(name = "capacite")
    private int capacite;

    // année de fabrication du bus (par exemple, un entier
    @Column(name = "anneefabrication")
    private int anneeFabrication;

    // nombre de kilomètres parcourus par le bus (par exemple, un entier
    @Column(name = "kilometrage")
    private int kilometrage;

    // statut du bus (par exemple, en service (ES), hors service (HS), en réparation (ER), etc.
    @Column(name = "statut", length = 3)
    private String statut;

    // indique si le bus est disponible ou non (par exemple, un booléen
    @Column(name = "dispo")
    private boolean dispo;

    // conducteur du bus
    @JoinColumn(name = "conducteur")                            // MERGE au lieu de PERSIST pour eviter : javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist:
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})  //chargement de tous les conducteurs lors du chargement de la classe (Lazy = non, Iger = oui)
    private Conducteur conducteur;

    // itinéraires du bus
    @JoinColumn(name = "itineraire")                            // MERGE au lieu de PERSIST pour eviter : javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist:
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})  //chargement de tous les itineraires lors du chargement de la classe (Lazy = non, Iger = oui)
    private Itineraire itineraire;
    
    public Bus() {
    }

    public Bus(int numeroBus, String modele, int capacite, int anneeFabrication, int kilometrage, String statut, boolean dispo, Conducteur conducteur, Itineraire itineraire) {
        this.numeroBus = numeroBus;
        this.modele = modele;
        this.capacite = capacite;
        this.anneeFabrication = anneeFabrication;
        this.kilometrage = kilometrage;
        this.statut = statut;
        this.dispo = dispo;
        this.conducteur = conducteur;
        this.itineraire = itineraire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(int numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(int anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
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
        if (!(o instanceof Bus bus)) return false;
        return getNumeroBus() == bus.getNumeroBus() && getId().equals(bus.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumeroBus());
    }

    // ToString

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", numeroBus=" + numeroBus +
                ", modele='" + modele + '\'' +
                ", capacite=" + capacite +
                ", anneeFabrication=" + anneeFabrication +
                ", kilometrage=" + kilometrage +
                ", statut='" + statut + '\'' +
                ", dispo=" + dispo +
                ", conducteur=" + conducteur +
                ", itineraire=" + itineraire +
                '}';
    }
}
