package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignant;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignement;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Matiere;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Niveau;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EnseignementDaoImpl implements IEnseignementDao{

    private  final EntityManager manager;

    public EnseignementDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Enseignement addEnseignement(Enseignement enseignement) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(enseignement);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return enseignement;
    }

    @Override
    public Enseignement addEnseignement(String codeMatiere, int numeroNiveau, int coefficient) {
        IMatiereDao matiereDao = new MatiereDaoImpl();
        INiveauDao niveauDao = new NiveauDaoImpl();

        Matiere matiere = null;
        Niveau niveau = null;

        try {
            matiere = matiereDao.findMatiere(codeMatiere);
            niveau = niveauDao.findNiveau(numeroNiveau);
        }
        catch (HibernateException exception){
            System.out.println("ERREUR : Une erreur s'est produite !");
            exception.printStackTrace();
        }
        Enseignement enseignement = new Enseignement(matiere, niveau, coefficient);
        addEnseignement(enseignement);

        return enseignement;
    }

    @Override
    public void addEnseignement() {
        int coefficient = 2;
        INiveauDao niveauDao = new NiveauDaoImpl();
        IMatiereDao matiereDao = new MatiereDaoImpl();

        List<Niveau> niveaux = niveauDao.displayNiveaux();
        List<Matiere> matieres = matiereDao.displayMatieres();

        for (Niveau niveau : niveaux){
            for (Matiere matiere : matieres){
                addEnseignement(matiere.getCode(), niveau.getNumero(), coefficient);
            }
        }
    }

    @Override
    public void removeEnseignement(Enseignement enseignement) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(enseignement);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeEnseignement(Long id) {
        Enseignement enseignement = findEnseignement(id);

        removeEnseignement(enseignement);
    }

    @Override
    public List<Enseignement> displayEnseignement() {
        List<Enseignement> enseignements = null;
        enseignements = manager.createQuery("SELECT e FROM Enseignement e", Enseignement.class)
                .getResultList();

        return enseignements;
    }

    @Override
    public Enseignement findEnseignement(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Enseignement enseignement = null;
        try {
            transaction.begin();
            enseignement = manager.find(Enseignement.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return enseignement;
    }
}
