package tg.univ.lome.epl.apoo.gestionBus_jpa.entities;

import tg.univ.lome.epl.apoo.gestionBus_jpa.util.LimitedArrayList;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "conducteur", uniqueConstraints =
@UniqueConstraint(columnNames = "numeropermis"))
public class Conducteur implements Serializable {  // Java bean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // le numéro de permis de conduire du conducteur (par exemple, une chaîne de caractères)
    @Column(name = "numeropermis", length = 100)
    private String numeroPermis;

    // le nom du conducteur (par exemple, une chaîne de caractères)
    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "prenom", length = 100)
    private String prenom;

    // l'âge du conducteur (par exemple, un entier)
    @Column(name = "age")
    private int age;

    // le numéro de téléphone du conducteur
    @Column(name = "numerotelephone")
    private int numeroTelephone;

    // l'adresse du conducteur (par exemple, une chaîne de caractères)
    @Column(name = "adresse", length = 100)
    private String adresse;

    // le salaire du conducteur (par exemple, un nombre à virgule)
    @Column(name = "salaire")
    private float salaire;

    // l'expérience du conducteur en années (par exemple, un entier)
    @Column(name = "experience")
    private int experience;

    // indique si le conducteur est disponible ou non (par exemple, un booléen)
    @Column(name = "dispo")
    private boolean dispo;


    // Const
    public Conducteur(){

    }

    public Conducteur(String numeroPermis, String nom, String prenom, int age, int numeroTelephone, String adresse, float salaire, int experience, boolean dispo) {
        this.numeroPermis = numeroPermis;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.numeroTelephone = numeroTelephone;
        this.adresse = adresse;
        this.salaire = salaire;
        this.experience = experience;
        this.dispo = dispo;
    }

    // Get/Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(int numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }


    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conducteur that)) return false;
        return getId().equals(that.getId()) && getNumeroPermis().equals(that.getNumeroPermis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumeroPermis());
    }


    // ToStr

    @Override
    public String toString() {
        return "Conducteur{" +
                "id=" + id +
                ", numeroPermis='" + numeroPermis + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", numeroTelephone=" + numeroTelephone +
                ", adresse='" + adresse + '\'' +
                ", salaire=" + salaire +
                ", experience=" + experience +
                ", dispo=" + dispo +
                '}';
    }
}
