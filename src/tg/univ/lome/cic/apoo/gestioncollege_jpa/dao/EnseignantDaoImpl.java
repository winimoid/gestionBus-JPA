package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NotFound;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignant;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Matiere;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EnseignantDaoImpl implements IEnseignantDao{

    private final EntityManager manager;

    public EnseignantDaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(enseignant);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return enseignant;
    }

    @Override
    public Enseignant addEnseignant(String nom, String prenom, String code) {
        IMatiereDao matiereDao = new MatiereDaoImpl();
        Matiere matiere = null;
        try {
            matiere = matiereDao.findMatiere(code);
        }
        catch (HibernateException exception){
            System.out.println("ERREUR : Une erreur s'est produite !");
            exception.printStackTrace();
        }
        Enseignant enseignant = new Enseignant(nom, prenom, matiere);
        addEnseignant(enseignant);

        return enseignant;
    }

    @Override
    public void removeEnseignant(Enseignant enseignant) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(enseignant);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeEnseignant(Long id) {
        Enseignant enseignant = findEnseignant(id);

        removeEnseignant(enseignant);
    }

    @Override
    public List<Enseignant> displayEnseignant() {
        List<Enseignant> enseignants = null;
        enseignants = manager.createQuery("SELECT e FROM Enseignant e", Enseignant.class)
                .getResultList();

        return enseignants;
    }

    @Override
    public Enseignant findEnseignant(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Enseignant enseignant = null;
        try {
            transaction.begin();
            enseignant = manager.find(Enseignant.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return enseignant;
    }
}
