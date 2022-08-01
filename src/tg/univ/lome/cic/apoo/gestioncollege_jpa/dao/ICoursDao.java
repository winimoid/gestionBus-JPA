package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Cours;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignant;

import java.util.List;

/**
 *
 * @author asus
 */
public interface ICoursDao {

    public Cours addCours(Cours cours);
    public Cours addCours(Long idEnseignement, Long idEnseignant, Long idClasse);
    public void addCours(Enseignant enseignant);
    public void removeCours(Cours cours);
    public void removeCours(Long id);
    public List<Cours> displayCours();
    public Cours findCours(Long id);
}
