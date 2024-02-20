package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Arret;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;

import java.util.ArrayList;
import java.util.List;

public interface IItineraireDao {

   public Itineraire addItineraire(Itineraire itineraire);
   public Itineraire addItineraire(int numeroLigne, Long idArretdepart, Long idArretArrivee, float distanceTotale);
   public void removeItineraire(Itineraire itineraire);
   public void removeItineraire(Long id);
   public void removeItineraire(int numeroLigne);
   public List<Itineraire> displayItineraires();
   public Itineraire findItineraire(Long id);
   public Itineraire findItineraire(int numeroLigne);
}
