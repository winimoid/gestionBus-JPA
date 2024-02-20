package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ConducteurDaoImpl implements IConducteurDao{

    private final EntityManager manager;

    public ConducteurDaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Conducteur addConducteur(Conducteur conducteur) {

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(conducteur);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return conducteur;
    }

    @Override
    public Conducteur addConducteur(String numeroPermis, String nom, String prenom, int age, int numeroTelephone, String adresse, float salaire, int experience, boolean dispo) {

        Conducteur conducteur = new Conducteur(numeroPermis, nom, prenom, age, numeroTelephone, adresse, salaire, experience, dispo);
        addConducteur(conducteur);

        return conducteur;
    }

    @Override
    public void removeConducteur(Conducteur conducteur) {

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(conducteur);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        System.out.println("Suppression du conducteur caractérisé par : " + conducteur);
    }

    @Override
    public void removeConducteur(Long id) {

        Conducteur conducteur = findConducteur(id);
        removeConducteur(conducteur);
    }

    @Override
    public void removeConducteur(String numeroPermis) {

        Conducteur conducteur = findConducteur(numeroPermis);
        removeConducteur(conducteur);
    }

    @Override
    public List<Conducteur> displayConducteurs() {

        List<Conducteur> conducteurs = null;
        conducteurs = manager.createQuery("SELECT c FROM Conducteur c", Conducteur.class)
                .getResultList();

        return conducteurs;
    }

    @Override
    public Conducteur findConducteur(Long id) {

        EntityTransaction transaction = manager.getTransaction();
        Conducteur conducteur = null;
        try {
            transaction.begin();
            conducteur = manager.find(Conducteur.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return conducteur;
    }

    @Override
    public Conducteur findConducteur(String numeroPermis) {

        return manager.createQuery("SELECT c FROM Conducteur c WHERE c.numeropermis = :numpermis", Conducteur.class)
                .setParameter("numpermis", numeroPermis)
                .getSingleResult();
    }
}
