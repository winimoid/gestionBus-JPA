package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "periode", uniqueConstraints =
    @UniqueConstraint(columnNames = "numero"))
public class Periode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "numero")
    private int numero;


    // Const
    public Periode(){

    }

    public Periode(String libelle, int numero) {
        this.libelle = libelle;
        this.numero = numero;
    }


    // Get/Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periode periode = (Periode) o;
        return id.equals(periode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // ToStr

    @Override
    public String toString() {
        return "Periode{" +
                "libelle='" + libelle + '\'' +
                ", numero=" + numero +
                '}';
    }
}
