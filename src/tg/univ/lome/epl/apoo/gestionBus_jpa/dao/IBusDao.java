/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Eleves/Interface.java to edit this template
 */
package tg.univ.lome.epl.apoo.gestionBus_jpa.dao;

import java.util.List;

import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Bus;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;

/**
 *
 * @author asus
 */
public interface IBusDao {
    public Bus addBus(Bus bus);
    public Bus addBus(int numeroBus, String modele, int capacite, int anneeFabrication, int kilometrage, String statut, boolean dispo, Conducteur conducteur, Itineraire itineraire);
    public Bus addBus(int numeroBus, String modele, int capacite, int anneeFabrication, int kilometrage, String statut, boolean dispo, String numeroPermisConducteur, Long idItineraire);
    public void removeBus(Bus bus);
    public void removeBus(Long id);
    public void removeBus(int numeroBus);
    public List<Bus> displayBus();
    public Bus findBus(Long id);
    public Bus findBus(int numeroBus);
}
