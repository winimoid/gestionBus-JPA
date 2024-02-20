package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.HoraireTravail;

import java.util.List;

public interface IConducteurDao {

    public Conducteur addConducteur(Conducteur conducteur);
    public Conducteur addConducteur(String numeroPermis, String nom, String prenom, int age, int numeroTelephone, String adresse, float salaire, int experience, boolean dispo);
    public void removeConducteur(Conducteur conducteur);
    public void removeConducteur(Long id);
    public void removeConducteur(String numeroPermis);
    public List<Conducteur> displayConducteurs();
    public Conducteur findConducteur(Long id);
    public Conducteur findConducteur(String numeroPermis);
}
