package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Bulletin;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Eleve;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Note;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Periode;

/**
 *
 * @author asus
 */
public interface IBulletinDao {

    public Bulletin printBulletin(Bulletin bulletin);
    public Bulletin printBulletin(Eleve eleve, Periode periode);
    public Bulletin printBulletin(Long idEleve, Long idPeriode);
    public Bulletin printBulletin(int matricule, int numeroPeriode);
    public String displayNote(Note note, int i);
}
