/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa;

import tg.univ.lome.epl.apoo.gestionBus_gui.MainWindow;
import tg.univ.lome.epl.apoo.gestionBus_jpa.dao.*;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.*;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.Horaire;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.JoursSemaine;
import tg.univ.lome.epl.apoo.gestionBus_jpa.util.LimitedArrayList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("début du projet !");

        MainWindow mainWindow = new MainWindow();

        // Polices dispo sur ce pc
        System.out.println(Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));

        /*IBusDao busDao = new BusDaoImpl();
        IConducteurDao conducteurDao = new ConducteurDaoImpl();
        IItineraireDao itineraireDao = new ItineraireDaoImpl();
        IArretDao arretDao = new ArretDaoImpl();
        IHoraireTravailDao horaireTravailDao = new HoraireTravailDaoImpl();*/


        /* Conducteur conducteur3 = new Conducteur("86321749P7854", "BILL", "Toto Jean-Claude", 53, 96325478, "Tsévié - PIA", 120000, 7, true);
        conducteurDao.addConducteur(conducteur3);
        HoraireTravail horaireTravail1 = new HoraireTravail(JoursSemaine.Lundi, 5, 0, 20, 30, conducteurDao.findConducteur(1L));
        HoraireTravail horaireTravail2 = new HoraireTravail(JoursSemaine.Mardi, 7, 0, 20, 30, conducteur3);
        horaireTravailDao.addHoraireTravail(horaireTravail1);
        horaireTravailDao.addHoraireTravail(horaireTravail2); */

        //Horaire horairePassage1 = new Horaire(5, 50);
        // Arret pointDepart1 = new Arret("Zanguéra", 5, 30);
        // Arret pointArrivee1 = new Arret("Campus - Terminus", 6, 20);
        // arretDao.addArret(pointDepart1);
        // arretDao.addArret(pointArrivee1);

        //Itineraire itineraire1 = new Itineraire(15, 4L, 2L, 21.4);
        //itineraireDao.addItineraire(itineraire1);


        /*Arret arretIntermediaire1 = new Arret("Wessome - Rails", horairePassage1);
        arretDao.addArret(arretIntermediaire1);*/


        /*Bus bus = new Bus(1, "MAN SM 152", 60, 2015, 354, "ES", true, conducteurDao.findConducteur(1L), itineraireDao.findItineraire(1L));
        busDao.addBus(bus);*/

        /*Bus bus = new Bus(2, "IVECO 420", 60, 2013, 543, "ES", true, conducteurDao.findConducteur(2L), itineraireDao.findItineraire(1L));
        busDao.addBus(bus);*/
    }
    
}
