package tg.univ.lome.epl.apoo.gestionBus_gui.controller;

import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.BusDaoImpl;
import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.ConducteurDaoImpl;
import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.IBusDao;
import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.IConducteurDao;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Bus;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;

import java.util.List;

public class ConducteurController {

    public Conducteur[] displayConducteur() {

        IConducteurDao conducteurDao = new ConducteurDaoImpl();
        List<Conducteur> conducteurs = conducteurDao.displayConducteurs();

        return conducteurs.toArray(new Conducteur[0]);
    }
}
