package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Niveau;

import java.util.List;

/**
 *
 * @author asus
 */
public interface INiveauDao {
    public Niveau addNiveau(Niveau niveau);
    public void removeNiveau(Niveau niveau);
    public void removeNiveau(Long id);
    public List<Niveau> displayNiveaux();
    public Niveau findNiveau(Long id);
    public  Niveau findNiveau(int numero);
}
