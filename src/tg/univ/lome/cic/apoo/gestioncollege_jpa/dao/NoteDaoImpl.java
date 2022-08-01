package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Eleve;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Evaluation;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Note;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author asus
 */
public class NoteDaoImpl implements INoteDao{

    private final EntityManager manager;

    public NoteDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Note addNote(Note note) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(note);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return note;
    }

    @Override
    public void addNote(long matricule, String codeTypeEvaluation, int numeroPeriode, String codeMatiere, String date, double valeurObtenue) {
        IEleveDao eleveDao = new EleveDaoImpl();
        IEvaluationDao evaluationDao = new EvaluationDaoImpl();

        List<Eleve> eleves = eleveDao.displayEleves();
        List<Evaluation> evaluations = evaluationDao.displayEvaluations();

        for (Eleve eleve : eleves) {
            if (eleve.getMatricule() == matricule) {
                for (Evaluation eval : evaluations) {
                    if (eval.getType().getCode().equals(codeTypeEvaluation) && eval.getPeriode().getNumero() == numeroPeriode) {
                        if (eval.getCours().getEnseignement().getMatiere().getCode().equals(codeMatiere)) {
                            if (eval.getCours().getEnseignement().getNiveau().getNumero() == eleve.getClasse()
                                    .getNiveau().getNumero()) {
                                if (eval.getCours().getClasse().getNiveau().getNumero() == eleve.getClasse().getNiveau()
                                        .getNumero()) {
                                    Note note = new Note(eleve, eval, valeurObtenue);
                                    addNote(note);
                                    break; // pour éviter de dupliquer des notes
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    @Override
    public void addBlocNote(long matricule, int numeroPeriode, String codeMatiere, String dateINT, String dateDST, String dateTP, String dateEX, double valeurINT, double valeurDST, double valeurTP, double valeurEX) {
        addNote(matricule, "INT", numeroPeriode, codeMatiere, dateINT, valeurINT);
        addNote(matricule, "DST", numeroPeriode, codeMatiere, dateDST, valeurDST);
        addNote(matricule, "TP", numeroPeriode, codeMatiere, dateTP, valeurTP);
        addNote(matricule, "EX", numeroPeriode, codeMatiere, dateEX, valeurEX);
    }

    @Override
    public void removeNote(Note note) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(note);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeNote(Long id) {
        Note note = findNote(id);

        removeNote(note);
    }

    @Override
    public List<Note> displayNotes() {
        List<Note> notes = null;
        notes = manager.createQuery("SELECT n FROM Note n", Note.class)
                .getResultList();

        return notes;
    }

    @Override
    public Note findNote(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Note note = null;

        try {
            transaction.begin();
            note = manager.find(Note.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return note;
    }

    @Override
    public double getMoyenne(double in, double dev, double tp, double ex) {  // methode renvoyant la moyenne par matiere
        double moyProvisoire = (in*0.2 + dev*0.3 + tp*0.1 + ex*0.4);
        moyGene[i] = moyProvisoire;
        i++;
        if(i>=matiereDao.displayMatieres().size()){
            i=0;
        }
        return moyProvisoire;
    }

    IMatiereDao matiereDao = new MatiereDaoImpl();
    IEleveDao eleveDao = new EleveDaoImpl();
    public double[] moyGene = new double[matiereDao.displayMatieres().size()]; // tableau stockant les moyennes
    public double[] moyPer = new double[eleveDao.displayEleves().size()]; // tableau stockant les moyennes
    private static int i = 0;  // variable permettant de controller les positions

    @Override
    public double getMoyenne() {
        double moyennePeriode = 0;
        for (double v : moyGene) {
            moyennePeriode += v;
        }
        moyennePeriode /= matiereDao.displayMatieres().size();

        moyPer[i] = moyennePeriode;
        i++;
        if(i>=eleveDao.displayEleves().size()){
            i=0;
        }

        return moyennePeriode;
    }
}
