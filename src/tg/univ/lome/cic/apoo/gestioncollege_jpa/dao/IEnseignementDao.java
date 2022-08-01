package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Enseignement;

import java.util.List;

/**
 *
 * @author asus
 */
public interface IEnseignementDao {

    public Enseignement addEnseignement(Enseignement enseignement);
    public Enseignement addEnseignement(String codeMatiere, int numeroNiveau, int coefficient);
    public  void addEnseignement();
    public void removeEnseignement(Enseignement enseignement);
    public void removeEnseignement(Long id);
    public List<Enseignement> displayEnseignement();
    public Enseignement findEnseignement(Long id);
}
