package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.*;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class BulletinDaoImpl implements IBulletinDao{

    private final EntityManager manager;

    public BulletinDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Bulletin printBulletin(Bulletin bulletin) {
        Bulletin bulletin1 = printBulletin(bulletin.getEleve(), bulletin.getPeriode());

        return bulletin1;
    }

    @Override
    public Bulletin printBulletin(Eleve eleve, Periode periode) {
        Bulletin bulletin = printBulletin(eleve.getMatricule(), periode.getNumero());

        return bulletin;
    }

    @Override
    public Bulletin printBulletin(Long idEleve, Long idPeriode) {
        Bulletin bulletin = manager.createQuery("SELECT b FROM Bulletin b WHERE b.eleve.id = :idEleve AND b.periode.id = :idPeriode", Bulletin.class)
                .setParameter("idEleve", idEleve)
                .setParameter("idPeriode", idPeriode)
                .getSingleResult();

        return bulletin;
    }

    @Override
    public Bulletin printBulletin(int matricule, int numeroPeriode) {
        IPeriodeDao periodeDao = new PeriodeDaoImpl();
        IEleveDao eleveDao = new EleveDaoImpl();
        INoteDao noteDao = new NoteDaoImpl();
        IRangDao rangDao = new RangDaoImpl();

        List<Periode> periodes = periodeDao.displayPeriodes();
        List<Eleve> eleves = eleveDao.displayEleves();
        List<Note> notes = noteDao.displayNotes();

        System.out.print("\n\t\t****************************************  BULLETIN ");
//        for(var periode : periodes){
//            if(periode.getNumero()==numeroPeriode){
//                System.out.print(periode);
//            }
//        }
        System.out.println(periodeDao.findPeriode(numeroPeriode));
        System.out.println("  ****************************************");

        Eleve eleve = eleveDao.findEleve(matricule);
//        for(Eleve eleve : eleves){
//            if(eleve.getMatricule()==matricule){
                System.out.print("\nNom : ");
                System.out.println(eleve.getNom());

                System.out.print("\nPrenoms : ");
                System.out.println(eleve.getPrenom());

                System.out.print("\nNumero Matricule : ");
                System.out.println(eleve.getMatricule());

                System.out.print("\nClasse : ");
//                System.out.println(Classe.returnClasse(eleve.getClasse()));
                System.out.println(eleve.getClasse().getNiveau().getLibelle()+eleve.getClasse().getSubdivision());
//            }
//        }

        System.out.println("");
        System.out.println("+------------------------------------------+------------------------------------------+--------------------+---------------------+--------------------+--------------------+---------------------+");
        System.out.println("|  CODE \t\t| INTITULE \t\t| INTERROG. \t| DEVOIR \t| TRAV. PRAT. \t| EXAMEN \t| MOYENNE       |");
        System.out.println("+------------------------------------------+------------------------------------------+--------------------+---------------------+--------------------+--------------------+---------------------+");

        for(int i=0; i<notes.size(); i+=4){
            Note note = notes.get(i);
            if(note.getEleve().getMatricule()==matricule){
                String formatage;
                formatage = displayNote(note, i);
                System.out.println(formatage);
                System.out.println("|------------------------------------------+------------------------------------------+--------------------+---------------------+--------------------+--------------------+---------------------|");
            }
        }

        System.out.print("|  MOYENNE GENERALE : ");
        double moyGene;
        moyGene = noteDao.getMoyenne();
        System.out.printf("%04.2f |", moyGene);

        rangDao.addRang(matricule, moyGene);

        int rang = rangDao.getRang(matricule, moyGene);
        System.out.printf("\t\t\t\t\t\t|  RANG : %der     |\n", rang);
        System.out.println("+------------------------------------------+\t\t\t\t\t\t+--------------------+\n");
        //System.out.println("\t\t\t\t\t\t\n+-----------------+");
        return null;
    }

    @Override
    public String displayNote(Note note, int i) {
        IPeriodeDao periodeDao = new PeriodeDaoImpl();
        IEleveDao eleveDao = new EleveDaoImpl();
        INoteDao noteDao = new NoteDaoImpl();

        List<Periode> periodes = periodeDao.displayPeriodes();
        List<Eleve> eleves = eleveDao.displayEleves();
        List<Note> notes = noteDao.displayNotes();

        double inter, dst, tp, exam, moy;
        inter = note.getValeurObtenue();
        dst = notes.get(i+1).getValeurObtenue();
        tp = notes.get(i+2).getValeurObtenue();
        exam = notes.get(i+3).getValeurObtenue();

        moy = noteDao.getMoyenne(inter, dst, tp, exam);

        String formatage = String.format("|  "+note.getEvaluation().getCours().getEnseignement().getMatiere().getCode()+"\t\t| "+note.getEvaluation().getCours().getEnseignement().getMatiere().getLibelle()+"\t\t| %04.2f\t| %04.2f\t| %04.2f\t| %04.2f\t| %04.2f   \t|", inter, dst, tp, exam, moy);

        return formatage;
    }
}
