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
@Table(name = "classe")
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "niveau")                            // MERGE au lieu de PERSIST pour eviter : javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist:
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})  //chargement de tous les élèves lors du chargement de la classe (Lazy = non, Iger = oui)
    private Niveau niveau;
    
    @Column(name = "subdivision", length = 30)
    private String subdivision;

    public Classe() {
    }

    public Classe(Niveau niveau, String subdivision) {
        this.niveau = niveau;
        this.subdivision = subdivision;
    }
        

    public Long getId() {
        return id;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Classe other = (Classe) obj;
        return Objects.equals(this.id, other.id);
    }
     
    // ToStr

    @Override
    public String toString() {
        return "Classe{" +
                "niveau=" + niveau +
                ", subdivision='" + subdivision + '\'' +
                '}';
    }
}
