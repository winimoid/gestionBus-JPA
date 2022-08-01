package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.TypeEvaluation;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TypeEvaluationDaoImpl implements ITypeEvaluationDao{

    private final EntityManager manager;

    public TypeEvaluationDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        manager = sessionFactory.createEntityManager();
    }

    @Override
    public TypeEvaluation addTypeEvaluation(TypeEvaluation typeEvaluation) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(typeEvaluation);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return typeEvaluation;
    }

    @Override
    public TypeEvaluation addTypeEvaluation(String code, String libelle) {
        TypeEvaluation typeEvaluation = new TypeEvaluation(code, libelle);
        addTypeEvaluation(typeEvaluation);

        return typeEvaluation;
    }

    @Override
    public void removeTypeEvaluation(TypeEvaluation typeEvaluation) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(typeEvaluation);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeTypeEvaluation(Long id) {
        TypeEvaluation typeEvaluation = findTypeEvaluation(id);

        removeTypeEvaluation(typeEvaluation);
    }

    @Override
    public void removeTypeEvaluation(String codeTypeEvaluation) {
        TypeEvaluation typeEvaluation = manager.createQuery("SELECT t FROM TypeEvaluation t WHERE code = :codeTypeEval", TypeEvaluation.class)
                .setParameter("codeTypeEval", codeTypeEvaluation)
                .getSingleResult();

        removeTypeEvaluation(typeEvaluation);
    }

    @Override
    public List<TypeEvaluation> displayTypeEvaluation() {
        List<TypeEvaluation> typeEvaluations;
        typeEvaluations = manager.createQuery("SELECT t FROM TypeEvaluation t", TypeEvaluation.class)
                .getResultList();

        return typeEvaluations;
    }

    @Override
    public TypeEvaluation findTypeEvaluation(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        TypeEvaluation typeEvaluation = null;
        try {
            transaction.begin();
            typeEvaluation = manager.find(TypeEvaluation.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return typeEvaluation;
    }

    @Override
    public TypeEvaluation findTypeEvaluation(String code) {
        TypeEvaluation typeEvaluation = manager.createQuery("SELECT t FROM TypeEvaluation t WHERE t.code = :cde", TypeEvaluation.class)
                .setParameter("cde", code)
                .getSingleResult();

        return typeEvaluation;
    }
}
