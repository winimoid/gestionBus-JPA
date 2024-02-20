package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Arret;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;

import java.util.ArrayDeque;
import java.util.List;

public interface IArretDao {

    public Arret addArret(Arret arret);
    public Arret addArret(String pointArret, int heurePassage, int minutePassage, Itineraire itineraire);

    public Arret addArret(String pointArret, Horaire horairePassage, Itineraire itineraire);

    public Arret addArret(String pointArret, int heurePassage, int minutePassage, Long idItineraire);

    public Arret addArret(String pointArret, int heurePassage, int minutePassage, int numeroLigne);

    public void removeArret(Arret arret);

    public void removeArret(Long idArret);

    public void removeArret(String pointArret, int numeroLigne);

    public List<Arret> displayArrets();

    public Arret findArret(Long id);

    public Arret findArret(String pointArret, int numeroLigne);
}
