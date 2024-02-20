package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Arret;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.HibernateSessionFactory;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ItineraireDaoImpl implements IItineraireDao{

    private final EntityManager manager;

    public ItineraireDaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Itineraire addItineraire(Itineraire itineraire) {

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(itineraire);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return itineraire;
    }

    @Override
    public Itineraire addItineraire(int numeroLigne, Long idArretdepart, Long idArretArrivee, float distanceTotale) {

        Itineraire itineraire = new Itineraire(numeroLigne, idArretdepart, idArretArrivee, distanceTotale);

        return addItineraire(itineraire);
    }

    @Override
    public void removeItineraire(Itineraire itineraire) {

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(itineraire);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        System.out.println("Suppression de l'itineraire caractérisé par : " + itineraire);
    }

    @Override
    public void removeItineraire(Long id) {

        Itineraire itineraire = findItineraire(id);
        removeItineraire(itineraire);
    }

    @Override
    public void removeItineraire(int numeroLigne) {

        Itineraire itineraire = findItineraire(numeroLigne);
        removeItineraire(itineraire);
    }

    @Override
    public List<Itineraire> displayItineraires() {

        List<Itineraire> itineraires = null;
        itineraires = manager.createQuery("SELECT i FROM Itineraire i", Itineraire.class)
                .getResultList();

        return itineraires;
    }

    @Override
    public Itineraire findItineraire(Long id) {

        EntityTransaction transaction = manager.getTransaction();
        Itineraire itineraire = null;
        try {
            transaction.begin();
            itineraire = manager.find(Itineraire.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return itineraire;
    }

    @Override
    public Itineraire findItineraire(int numeroLigne) {

        return manager.createQuery("SELECT i FROM itineraire i WHERE i.numeroligne = :numligne", Itineraire.class)
                .setParameter("numligne", numeroLigne)
                .getSingleResult();
    }
}
