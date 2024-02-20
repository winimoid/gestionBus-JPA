package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Bus;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BusDaoImpl implements IBusDao{

    private final EntityManager manager;

    public BusDaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Bus addBus(Bus bus) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(bus);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return bus;
    }

    @Override
    public Bus addBus(int numeroBus, String modele, int capacite, int anneeFabrication, int kilometrage, String statut, boolean dispo, Conducteur conducteur, Itineraire itineraire) {

        Bus bus = new Bus(numeroBus, modele, capacite,anneeFabrication, kilometrage, statut, dispo, conducteur, itineraire);
        addBus(bus);

        return bus;
    }

    @Override
    public Bus addBus(int numeroBus, String modele, int capacite, int anneeFabrication, int kilometrage, String statut, boolean dispo, String numeroPermisConducteur, Long idItineraire) {

        IConducteurDao conducteurDao = new ConducteurDaoImpl();
        IItineraireDao itineraireDao = new ItineraireDaoImpl();
        Conducteur conducteur = null;
        Itineraire itineraire = null;
        try {
            conducteur = conducteurDao.findConducteur(numeroPermisConducteur);
            itineraire = itineraireDao.findItineraire(idItineraire);
        }
        catch (HibernateException exception){
            System.out.println("ERREUR : Une erreur s'est produite !");
            exception.printStackTrace();
        }

        return addBus(numeroBus, modele, capacite, anneeFabrication, kilometrage, statut, dispo, conducteur, itineraire);
    }

    @Override
    public void removeBus(Bus bus) {

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(bus);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        System.out.println("Suppression du bus caractérisé par : " + bus);
    }

    @Override
    public void removeBus(Long id) {

        Bus bus = findBus(id);

        removeBus(bus);
    }

    @Override
    public void removeBus(int numeroBus) {

        Bus bus = findBus(numeroBus);

        removeBus(bus);

    }

    @Override
    public List<Bus> displayBus() {

        List<Bus> buses = null;
        buses = manager.createQuery("SELECT b FROM Bus b", Bus.class)
                .getResultList();

        return buses;
    }

    @Override
    public Bus findBus(Long id) {

        EntityTransaction transaction = manager.getTransaction();
        Bus bus = null;
        try {
            transaction.begin();
            bus = manager.find(Bus.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return bus;
    }

    @Override
    public Bus findBus(int numeroBus) {

        Bus bus = manager.createQuery("SELECT b FROM Bus b WHERE b.numerobus = :numbus", Bus.class)
                .setParameter("numbus", numeroBus)
                .getSingleResult();

        return bus;
    }
}
