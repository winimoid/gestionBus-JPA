package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.HoraireTravail;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.HibernateSessionFactory;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.JoursSemaine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class HoraireTravailDaoImpl implements IHoraireTravailDao{

    private final EntityManager manager;

    public HoraireTravailDaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public HoraireTravail addHoraireTravail(HoraireTravail horaireTravail) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(horaireTravail);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        System.out.println("Enregistrement d'un nouvel Horaire de travail réussi !");

        return horaireTravail;
    }

    @Override
    public HoraireTravail addHoraireTravail(JoursSemaine jourSemaine, int heureDebut, int minuteDebut, int heureFin, int minuteFin, Conducteur conducteur) {

        return addHoraireTravail(new HoraireTravail(jourSemaine, heureDebut, minuteDebut, heureFin, minuteFin, conducteur));
    }

    @Override
    public HoraireTravail addHoraireTravail(JoursSemaine jourSemaine, Horaire heureDebut, Horaire heureFin, Conducteur conducteur) {

        return addHoraireTravail(jourSemaine, heureDebut.getHeure(),heureDebut.getMinute(), heureFin.getHeure(), heureFin.getMinute(), conducteur);
    }

    @Override
    public HoraireTravail addHoraireTravail(JoursSemaine jourSemaine, int heureDebut, int minuteDebut, int heureFin, int minuteFin, Long idConducteur) {

        IConducteurDao conducteurDao = new ConducteurDaoImpl();

        return addHoraireTravail(jourSemaine, heureDebut, minuteDebut, heureFin, minuteFin, conducteurDao.findConducteur(idConducteur));
    }

    @Override
    public HoraireTravail addHoraireTravail(JoursSemaine jourSemaine, int heureDebut, int minuteDebut, int heureFin, int minuteFin, String numeroPermis) {

        IConducteurDao conducteurDao = new ConducteurDaoImpl();

        return addHoraireTravail(jourSemaine, heureDebut, minuteDebut, heureFin, minuteFin, conducteurDao.findConducteur(numeroPermis));
    }

    @Override
    public void removeHoraireTravail(HoraireTravail horaireTravail) {

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(horaireTravail);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        System.out.println("Suppression de l'horaire de travail caractérisé par : " + horaireTravail);
    }

    @Override
    public void removeHoraireTravail(Long id) {

        removeHoraireTravail(findHoraireTravail(id));
    }

    @Override
    public List<HoraireTravail> displayHorairesTravail() {

        List<HoraireTravail> horairesTravail = null;
        horairesTravail = manager.createQuery("SELECT h FROM HoraireTravail h", HoraireTravail.class)
                .getResultList();

        return horairesTravail;
    }

    @Override
    public HoraireTravail findHoraireTravail(Long id) {

        EntityTransaction transaction = manager.getTransaction();
        HoraireTravail horaireTravail = null;
        try {
            transaction.begin();
            horaireTravail = manager.find(HoraireTravail.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return horaireTravail;
    }
}
