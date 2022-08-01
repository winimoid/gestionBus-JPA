package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignant;

import java.util.List;

/**
 *
 * @author asus
 */
public interface IEnseignantDao {

    public Enseignant addEnseignant(Enseignant enseignant);
    public Enseignant addEnseignant(String nom, String prenom, String code);
    public void removeEnseignant(Enseignant enseignant);
    public void removeEnseignant(Long id);
    public List<Enseignant> displayEnseignant();
    public Enseignant findEnseignant(Long id);
}
