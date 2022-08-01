package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.TypeEvaluation;

import java.util.List;

/**
 *
 * @author asus
 */
public interface ITypeEvaluationDao {

    public TypeEvaluation addTypeEvaluation(TypeEvaluation typeEvaluation);
    public TypeEvaluation addTypeEvaluation(String code, String libelle);
    public void removeTypeEvaluation(TypeEvaluation typeEvaluation);
    public void removeTypeEvaluation(Long id);
    public void removeTypeEvaluation(String codeTypeEvaluation);
    public List<TypeEvaluation> displayTypeEvaluation();
    public TypeEvaluation findTypeEvaluation(Long id);
    public TypeEvaluation findTypeEvaluation(String code);
}
