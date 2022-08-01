package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Niveau;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author asus
 */
public class NiveauDaoImpl implements INiveauDao{

    private final EntityManager manager;

    public NiveauDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Niveau addNiveau(Niveau niveau) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(niveau);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return niveau;
    }

    @Override
    public void removeNiveau(Niveau niveau) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(niveau);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeNiveau(Long id) {
        Niveau niveau = findNiveau(id);

        removeNiveau(niveau);
    }

    @Override
    public List<Niveau> displayNiveaux() {
        List<Niveau> niveaux = null;
//        niveaux = manager.createNativeQuery("SELECT * FROM niveau", Niveau.class)
//              .getResultList();
        niveaux = manager.createQuery("SELECT n FROM Niveau n", Niveau.class)
                .getResultList();
        for(Niveau niveau : niveaux){
            System.out.println(niveau);
        }
        return niveaux;
    }

    @Override
    public Niveau findNiveau(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Niveau niveau = null;
        try {
            transaction.begin();
            niveau = manager.find(Niveau.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return niveau;
    }

    @Override
    public Niveau findNiveau(int numero) {
        Niveau niveau = manager.createQuery("SELECT n FROM Niveau n WHERE n.numero = :num", Niveau.class)  // requete en JPQL
                .setParameter("num", numero)
                .getSingleResult();

        return niveau;
    }
}
