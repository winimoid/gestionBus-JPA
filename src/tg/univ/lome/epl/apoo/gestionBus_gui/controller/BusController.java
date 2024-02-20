package tg.univ.lome.epl.apoo.gestionBus_gui.controller;

import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.BusDaoImpl;
import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.IBusDao;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Bus;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;

import java.util.List;

public class BusController {

    public String addBus(int numeroBus, String modele, int capacite, int anneeFabrication, int kilometrage, String statut, boolean dispo, String numeroPermisConducteur, Long idItineraire) {

        IBusDao busDao = new BusDaoImpl();
        busDao.addBus(numeroBus, modele, capacite, anneeFabrication, kilometrage, statut, dispo, numeroPermisConducteur, idItineraire);

        return "New Bus Added successfully !";
    }

    public String addBus(int numeroBus, String modele, int capacite, int anneeFabrication, int kilometrage, String statut, boolean dispo, Conducteur conducteur, Itineraire itineraire) {

        IBusDao busDao = new BusDaoImpl();
        busDao.addBus(numeroBus, modele, capacite, anneeFabrication, kilometrage, statut, dispo, conducteur, itineraire);

        return "New Bus Added successfully !";
    }

    public String findBus(int numeroBus) {

        IBusDao busDao = new BusDaoImpl();
        String busTrouve = "Pas de trouvé pour ce numéro de bus !";

        try {
            busTrouve = busDao.findBus(numeroBus).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return busTrouve;
    }

    public Bus[] displayBus() {

        IBusDao busDao = new BusDaoImpl();
        List<Bus> buses = busDao.displayBus();

        return buses.toArray(new Bus[0]);
    }
}
