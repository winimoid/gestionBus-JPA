package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Classe;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Cours;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignant;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignement;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CoursDaoImpl implements ICoursDao{

    private final EntityManager manager;

    public CoursDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Cours addCours(Cours cours) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(cours);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return cours;
    }

    @Override
    public Cours addCours(Long idEnseignement, Long idEnseignant, Long idClasse) {
        IEnseignementDao enseignementDao = new EnseignementDaoImpl();
        IEnseignantDao enseignantDao = new EnseignantDaoImpl();
        IClasseDao classeDao = new ClasseDaoImpl();

        Enseignement enseignement = enseignementDao.findEnseignement(idEnseignement);
        Enseignant enseignant = enseignantDao.findEnseignant(idEnseignant);
        Classe classe = classeDao.findClasse(idClasse);

        Cours cours = new Cours(enseignement, enseignant, classe);
        addCours(cours);

        return cours;
    }

    @Override
    public void addCours(Enseignant enseignant) {
        IClasseDao classeDao = new ClasseDaoImpl();
        IEnseignementDao enseignementDao = new EnseignementDaoImpl();

        List<Classe> classes = classeDao.displayClasses();
        List<Enseignement> enseignements = enseignementDao.displayEnseignement();

        for (Classe classe : classes){
            for (Enseignement enseignement : enseignements){
                Cours cours = new Cours(enseignement, enseignant, classe);
                addCours(cours);
            }
        }

    }

    @Override
    public void removeCours(Cours cours) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(cours);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeCours(Long id) {
        Cours cours = findCours(id);

        removeCours(cours);
    }

    @Override
    public List<Cours> displayCours() {
        List<Cours> cours = null;
        cours = manager.createQuery("SELECT c FROM Cours c", Cours.class)
                .getResultList();

        return cours;
    }

    @Override
    public Cours findCours(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.find(Cours.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return null;
    }
}
