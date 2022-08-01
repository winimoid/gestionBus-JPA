package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "enseignant")
public class Enseignant implements Serializable {  // Java bean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @JoinColumn(name = "matiere")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Matiere matiere;


    // Const
    public Enseignant(){

    }

    public Enseignant(String nom, String prenom, Matiere matiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
    }


    // Get/Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }


    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignant that = (Enseignant) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // ToStr

    @Override
    public String toString() {
        return "Enseignant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matiere=" + matiere +
                '}';
    }
}
