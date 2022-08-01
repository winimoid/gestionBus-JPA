/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Classe;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignant;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Matiere;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Niveau;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

/**
 *
 * @author asus
 */
public class ClasseDaoImpl implements IClasseDao{
    private final EntityManager manager ;
    
    public ClasseDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }
    
    @Override
    public Classe addClasse(Classe classe) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(classe);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return classe;
    }

    @Override
    public Classe addclasse(int numeroNiveau, String subdivision) {
        INiveauDao niveauDao = new NiveauDaoImpl();
        Niveau niveau = null;
        try {
            niveau = niveauDao.findNiveau(numeroNiveau);
        }
        catch (HibernateException exception){
            System.out.println("ERREUR : Une erreur s'est produite !");
            exception.printStackTrace();
        }
        Classe classe = new Classe(niveau, subdivision);
        addClasse(classe);

        return classe;
    }

    @Override
    public void removeClasse(Classe classe) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(classe);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeClasse(Long id) {
        Classe classe = findClasse(id);

        removeClasse(classe);
    }

    @Override
    public List<Classe> displayClasses() {
        List<Classe> classes = null;
        classes = manager.createQuery("SELECT c FROM Classe c", Classe.class)
                .getResultList();

        return classes;
    }

    @Override
    public Classe findClasse(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Classe classe = null;
        try {
            transaction.begin();
            classe = manager.find(Classe.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return classe;
    }

    @Override
    public Classe findClasse(int numeroNiveau, String subdivision) {
        Classe classe = (Classe) manager.createNativeQuery("SELECT * FROM classe WHERE classe.niveau = :niv AND classe.subdivision = :subd", Classe.class)
                .setParameter("niv", numeroNiveau)
                .setParameter("subd", subdivision)
                .getSingleResult();

        return classe;
    }

}
