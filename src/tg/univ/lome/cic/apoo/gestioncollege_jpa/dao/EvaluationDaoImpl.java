package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Cours;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Evaluation;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Periode;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.TypeEvaluation;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Objects;

public class EvaluationDaoImpl implements IEvaluationDao{

    private final EntityManager manager;

    public EvaluationDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Evaluation addEvaluation(Evaluation evaluation) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(evaluation);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return evaluation;
    }

    @Override
    public Evaluation addEvaluation(TypeEvaluation typeEvaluation, Periode periode, Cours cours, String date) {
        double poids = 0;
        if(null != typeEvaluation.getCode()) poids = switch (typeEvaluation.getCode()) {
            case "INT" -> 0.1;
            case "DST" -> 0.3;
            case "TP" -> 0.2;
            case "EX" -> 0.4;
            default -> 0.25;
        };
        Evaluation evaluation = new Evaluation(cours, periode, typeEvaluation, poids, date, 20);
        addEvaluation(evaluation);

        return evaluation;
    }

    @Override
    public void addEvaluation(Long idCours, int numPeriode, String codeType, String date) {

        ICoursDao coursDao = new CoursDaoImpl();
        IPeriodeDao periodeDao = new PeriodeDaoImpl();
        ITypeEvaluationDao typeEvaluationDao = new TypeEvaluationDaoImpl();

        Cours cours = coursDao.findCours(idCours);
        Periode periode = periodeDao.findPeriode(numPeriode);
        TypeEvaluation typeEvaluation = typeEvaluationDao.findTypeEvaluation(codeType);

        addEvaluation(typeEvaluation, periode, cours, date);
    }

    // Autre façon de faire :

    @Override
    public void addEvaluation(String codeTypeEvaluation, int numeroPeriode, int numeroNiveau, String subdivision) {
        String date = "31/12/2022";
        int bareme = 20;

        IPeriodeDao periodeDao = new PeriodeDaoImpl();
        ICoursDao coursDao = new CoursDaoImpl();
        ITypeEvaluationDao typeEvaluationDao = new TypeEvaluationDaoImpl();

        List<Periode> periodes = periodeDao.displayPeriodes();
        List<Cours> cours = coursDao.displayCours();
        List<TypeEvaluation> typeEvaluations = typeEvaluationDao.displayTypeEvaluation();

        for (Periode periode : periodes){
            for (Cours cours1 : cours){
                if(cours1.getEnseignement().getNiveau().getNumero()==numeroNiveau && cours1.getClasse().getSubdivision().equals(subdivision)) {
                    for (TypeEvaluation typeEvaluation : typeEvaluations) {
                        if(typeEvaluation.getCode() == null ? codeTypeEvaluation == null : typeEvaluation.getCode().equals(codeTypeEvaluation)) {
                            addEvaluation(cours1.getId(), periode.getNumero(), typeEvaluation.getCode(), date);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void makeEvaluations(String code) {
        IPeriodeDao periodeDao = new PeriodeDaoImpl();
        ITypeEvaluationDao typeEvaluationDao = new TypeEvaluationDaoImpl();
        ICoursDao coursDao = new CoursDaoImpl();

        for(Periode periode : periodeDao.displayPeriodes()){
            for(TypeEvaluation typeEvaluation : typeEvaluationDao.displayTypeEvaluation()){
                if (Objects.equals(typeEvaluation.getCode(), code)){
                    for(Cours cours : coursDao.displayCours()) {
                        //if(ty.equals(code)){
                        addEvaluation(typeEvaluation, periode, cours, "26/05/2022");
                        //} else {
                        //}
                    }
                }
            }
        }
    }

    @Override
    public void removeEvaluation(Evaluation evaluation) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(evaluation);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void removeAll() {
        IEvaluationDao evaluationDao = new EvaluationDaoImpl();

        for (int i = 500; i>0; i--){
            evaluationDao.removeEvaluation((long) i);
        }
    }

    @Override
    public void removeEvaluation(Long id) {
        Evaluation evaluation = findEvaluation(id);

        removeEvaluation(evaluation);
    }

    @Override
    public List<Evaluation> displayEvaluations() {
        List<Evaluation> evaluations = null;

        evaluations = manager.createQuery("SELECT e FROM Evaluation e", Evaluation.class)
                .getResultList();

        return evaluations;
    }

    @Override
    public Evaluation findEvaluation(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Evaluation evaluation = null;

        try {
            transaction.begin();
            evaluation = manager.find(Evaluation.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return evaluation;
    }
}
