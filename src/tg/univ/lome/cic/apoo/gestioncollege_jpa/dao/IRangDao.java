package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Rang;

import java.util.List;

/**
 *
 * @author asus
 */
public interface IRangDao {

    public Rang addRang(int matricule, double moyenne);
    public int getRang(int matricule, double moyenne);
    public List<Rang> displayRangs();
    public Rang findRang(Long id);
    public Rang findRang(int matricule);
}
