package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Periode;

import java.util.List;

/**
 *
 * @author asus
 */
public interface IPeriodeDao {
    public Periode addPeriode(Periode periode);
    public void removePeriode(Periode periode);
    public void removePeriode(Long id);
    public List<Periode> displayPeriodes();
    public Periode findPeriode(Long id);
    public Periode findPeriode(int numero);
}
