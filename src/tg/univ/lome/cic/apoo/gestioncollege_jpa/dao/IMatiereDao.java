package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Matiere;

import java.util.List;

/**
 *
 * @author asus
 */
public interface IMatiereDao {
    public Matiere addMatiere(Matiere matiere);
    public void removeMatiere(Matiere matiere);
    public void removeMatiere(Long id);
    public List<Matiere> displayMatieres();
    public Matiere findMatiere(Long id);
    public Matiere findMatiere(String code);
}
