package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.HoraireTravail;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.JoursSemaine;

import java.util.List;

public interface IHoraireTravailDao {

    public HoraireTravail addHoraireTravail(HoraireTravail horaireTravail);

    public HoraireTravail addHoraireTravail(JoursSemaine jourSemaine, int heureDebut, int minuteDebut, int heureFin, int minuteFin, Conducteur conducteur);

    public HoraireTravail addHoraireTravail(JoursSemaine jourSemaine, Horaire heureDebut, Horaire heureFin, Conducteur conducteur);

    public HoraireTravail addHoraireTravail(JoursSemaine jourSemaine, int heureDebut, int minuteDebut, int heureFin, int minuteFin, Long idConducteur);

    public HoraireTravail addHoraireTravail(JoursSemaine jourSemaine, int heureDebut, int minuteDebut, int heureFin, int minuteFin, String numeroPermis);

    public void removeHoraireTravail(HoraireTravail horaireTravail);

    public void removeHoraireTravail(Long id);

    public List<HoraireTravail> displayHorairesTravail();

    public HoraireTravail findHoraireTravail(Long id);
}
