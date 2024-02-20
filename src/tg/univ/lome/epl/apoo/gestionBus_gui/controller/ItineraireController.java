package tg.univ.lome.epl.apoo.gestionBus_gui.controller;

import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.ConducteurDaoImpl;
import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.IConducteurDao;
import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.IItineraireDao;
import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.ItineraireDaoImpl;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;

import java.util.List;

public class ItineraireController {

    public Itineraire[] displayItineraire() {

        IItineraireDao itineraireDao = new ItineraireDaoImpl();
        List<Itineraire> itineraires = itineraireDao.displayItineraires();

        return itineraires.toArray(new Itineraire[0]);
    }
}
