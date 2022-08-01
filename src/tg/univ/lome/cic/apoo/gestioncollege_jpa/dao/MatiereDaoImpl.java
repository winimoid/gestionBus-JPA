package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Matiere;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MatiereDaoImpl implements IMatiereDao{

    private final EntityManager manager;

    public MatiereDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Matiere addMatiere(Matiere matiere) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(matiere);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return matiere;
    }

    @Override
    public void removeMatiere(Matiere matiere) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(matiere);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeMatiere(Long id) {
        Matiere matiere = findMatiere(id);

        removeMatiere(matiere);
    }

    @Override
    public List<Matiere> displayMatieres() {
        List<Matiere> matieres = null;
        matieres = manager.createQuery("SELECT m FROM Matiere m", Matiere.class)
                .getResultList();  // requete en JPQL

        return matieres;
    }

    @Override
    public Matiere findMatiere(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Matiere matiere = null;
        try {
            transaction.begin();
            matiere = manager.find(Matiere.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return matiere;
    }

    @Override
    public Matiere findMatiere(String code) {
        Matiere matiere = manager.createQuery("SELECT m FROM Matiere m WHERE m.code = :cde", Matiere.class)
                .setParameter("cde", code)
                .getSingleResult();

        return matiere;
    }
}
