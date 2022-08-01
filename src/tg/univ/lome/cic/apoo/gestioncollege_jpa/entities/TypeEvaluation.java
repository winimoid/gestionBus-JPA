package tg.univ.lome.cic.apoo.gestioncollege_jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "typeEvaluation", uniqueConstraints =
    @UniqueConstraint(columnNames = "code"))
public class TypeEvaluation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;


    // Constr
    public TypeEvaluation(){

    }

    public TypeEvaluation(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }


    // Get/Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    // Equ/Hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeEvaluation that = (TypeEvaluation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // ToStr

    @Override
    public String toString() {
        return "TypeEvaluation{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
