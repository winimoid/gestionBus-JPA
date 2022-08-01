package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "niveau", uniqueConstraints =
    @UniqueConstraint(columnNames = "numero"))
public class Niveau implements Serializable { // java bean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;



    // Constructeurs
    public Niveau(){

    }

    public Niveau(int numero, String libelle, String description){
        this.libelle = libelle;
        this.numero = numero;
        this.description = description;
    }

    public Niveau(Niveau niveau){
        this.libelle = niveau.libelle;
        this.numero = niveau.numero;
        this.description = niveau.description;
    }



    // Get/Set

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Niveau niveau = (Niveau) o;
        return id == niveau.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Niveau{" +
                "id=" + id +
                ", numero=" + numero +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
