package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Cours;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Evaluation;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Periode;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.TypeEvaluation;

import java.util.List;

/**
 *
 * @author asus
 */
public interface IEvaluationDao {

    public Evaluation addEvaluation(Evaluation evaluation);
    public Evaluation addEvaluation(TypeEvaluation typeEvaluation, Periode periode, Cours cours, String date);
    public void addEvaluation(Long idCours, int numPeriode, String codeType, String date);
    public void addEvaluation(String codeTypeEvaluation, int numeroPeriode, int numeroNiveau, String subdivision);
    public void makeEvaluations(String code);
    public void removeEvaluation(Evaluation evaluation);
    public void removeAll();
    public void removeEvaluation(Long id);
    public List<Evaluation> displayEvaluations();
    public Evaluation findEvaluation(Long id);
}
