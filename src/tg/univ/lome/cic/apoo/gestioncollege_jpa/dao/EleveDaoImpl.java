/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Classe;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Eleve;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

/**
 *
 * @author asus
 */
public class EleveDaoImpl implements IEleveDao{

    private final EntityManager manager ;
    
    public EleveDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    
    @Override
    public Eleve addEleve(Eleve eleve) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(eleve);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return eleve;
    }

    @Override
    public Eleve addEleve(String nom, String prenom, int age, int matricule, int numeroNiveau, String subdivision) {
        IClasseDao classeDao = new ClasseDaoImpl();
        Classe classe = classeDao.findClasse(numeroNiveau, subdivision);

        Eleve eleve = new Eleve(nom, prenom, age, matricule, classe);
        addEleve(eleve);

        return eleve;
    }

    @Override
    public void removeEleve(Eleve eleve) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(eleve);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeEleve(Long id) {
        Eleve eleve = findEleve(id);

        removeEleve(eleve);
    }

    @Override
    public List<Eleve> displayEleves() {
        List<Eleve> eleves = null;
        eleves = manager.createQuery("SELECT e FROM Eleve e", Eleve.class)
                .getResultList();

        return eleves;
    }

    @Override
    public Eleve findEleve(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Eleve eleve = null;
        try {
            transaction.begin();
            eleve = manager.find(Eleve.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return eleve;
    }

    @Override
    public Eleve findEleve(int matricule) {
        Eleve eleve = manager.createQuery("SELECT e FROM Eleve e WHERE e.matricule = :mtle", Eleve.class)
                .setParameter("mtle", matricule)
                .getSingleResult();

        return eleve;
    }

}
