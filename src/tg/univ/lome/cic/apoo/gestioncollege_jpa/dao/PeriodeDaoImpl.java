package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Periode;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PeriodeDaoImpl implements IPeriodeDao{

    private final EntityManager manager;

    public PeriodeDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Periode addPeriode(Periode periode) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(periode);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return periode;
    }

    @Override
    public void removePeriode(Periode periode) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(periode);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removePeriode(Long id) {
        Periode periode = findPeriode(id);

        removePeriode(periode);
    }

    @Override
    public List<Periode> displayPeriodes() {
        List<Periode> periodes = null;
        periodes = manager.createQuery("SELECT p FROM Periode p", Periode.class)
                .getResultList();

        return periodes;
    }

    @Override
    public Periode findPeriode(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Periode periode = null;

        try {
            transaction.begin();
            periode = manager.find(Periode.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return periode;
    }

    @Override
    public Periode findPeriode(int numero) {
        Periode periode = manager.createQuery("SELECT p FROM Periode p WHERE p.numero = :num", Periode.class)
                .setParameter("num", numero)
                .getSingleResult();

        return periode;
    }
}
