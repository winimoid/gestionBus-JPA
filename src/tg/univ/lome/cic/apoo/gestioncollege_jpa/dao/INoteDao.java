package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Note;

import java.util.List;

/**
 *
 * @author asus
 */
public interface INoteDao {

    public Note addNote(Note note);
    public void addNote(long matricule, String codeTypeEvaluation,
                               int numeroPeriode, String codeMatiere,
                               String date, double valeurObtenue);
    public void addBlocNote(long matricule, int numeroPeriode, String codeMatiere,
                                   String dateINT, String dateDST, String dateTP,
                                   String dateEX, double valeurINT, double valeurDST,
                                   double valeurTP, double valeurEX);
    public void removeNote(Note note);
    public void removeNote(Long id);
    public List<Note> displayNotes();
    public Note findNote(Long id);
    public double getMoyenne(double in, double dev, double tp, double ex);
    public double getMoyenne();
}
