package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Arret;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.HibernateSessionFactory;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ArretDaoImpl implements IArretDao{

    private final EntityManager manager;

    public ArretDaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Arret addArret(Arret arret) {

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(arret);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return arret;
    }

    @Override
    public Arret addArret(String pointArret, int heurePassage, int minutePassage, Itineraire itineraire) {

        return addArret(new Arret(pointArret, heurePassage, minutePassage, itineraire));
    }

    @Override
    public Arret addArret(String pointArret, Horaire horairePassage, Itineraire itineraire) {

        return addArret(new Arret(pointArret, horairePassage, itineraire));
    }

    @Override
    public Arret addArret(String pointArret, int heurePassage, int minutePassage, Long idItineraire) {

        IItineraireDao itineraireDao = new ItineraireDaoImpl();

        return addArret(new Arret(pointArret, heurePassage, minutePassage, itineraireDao.findItineraire(idItineraire)));
    }

    @Override
    public Arret addArret(String pointArret, int heurePassage, int minutePassage, int numeroLigne) {

        IItineraireDao itineraireDao = new ItineraireDaoImpl();

        return addArret(new Arret(pointArret, heurePassage, minutePassage, itineraireDao.findItineraire(numeroLigne)));
    }

    @Override
    public void removeArret(Arret arret) {

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(arret);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        System.out.println("Suppression de l'arrêt caractérisé par : " + arret);
    }

    @Override
    public void removeArret(Long idArret) {

        removeArret(findArret(idArret));
    }

    @Override
    public void removeArret(String pointArret, int numeroLigne) {

        removeArret(findArret(pointArret,numeroLigne));
    }

    @Override
    public List<Arret> displayArrets() {

        List<Arret> arrets = null;
        arrets = manager.createQuery("SELECT a FROM Arret a", Arret.class)
                .getResultList();

        return arrets;
    }

    @Override
    public Arret findArret(Long id) {

        EntityTransaction transaction = manager.getTransaction();
        Arret arret = null;
        try {
            transaction.begin();
            arret = manager.find(Arret.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return arret;
    }

    @Override
    public Arret findArret(String pointArret, int numeroLigne) {

        IItineraireDao itineraireDao = new ItineraireDaoImpl();
        Itineraire itineraire = itineraireDao.findItineraire(numeroLigne);
        Long idItineraire = itineraire.getId();

        return manager.createQuery("SELECT a FROM arret a WHERE a.pointarret = :pointarret AND a.itineraire = iditin", Arret.class)
                .setParameter("pointarret", pointArret)
                .setParameter("iditin", idItineraire)
                .getSingleResult();
    }
}
