/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "eleve", uniqueConstraints =
    @UniqueConstraint(columnNames = "matricule"))
public class Eleve implements Serializable { //classe java bean
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nom", length = 50)
    private String nom;
    
    @Column(name = "prenom", length = 50)
    private String prenom;
    
    @Column(name = "age")
    private int age;
    
    @Column(name = "matricule")
    private int matricule;

    @JoinColumn(name = "classe")                            // MERGE au lieu de PERSIST pour eviter : javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist:
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})  //chargement de tous les élèves lors du chargement de la classe (Lazy = non, Iger = oui)
    private Classe classe;
    
    public Eleve() {
    }

    public Eleve(String nom, String prenom, int age, int matricule, Classe classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.matricule = matricule;
        this.classe = classe;
    }

    
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getMatricule() {
        return matricule;
    }

    public int getAge() {
        return age;
    }

    public Classe getClasse() {
        return classe;
    }
    
    

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Eleve other = (Eleve) obj;
        return Objects.equals(this.id, other.id);
    }


    // ToStr

    @Override
    public String toString() {
        return "Eleve{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", matricule=" + matricule +
                ", classe=" + classe +
                '}';
    }
}
