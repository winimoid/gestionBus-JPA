/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Eleves/Interface.java to edit this template
 */
package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import java.util.List;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Eleve;

/**
 *
 * @author asus
 */
public interface IEleveDao {
    public Eleve addEleve(Eleve eleve);
    public Eleve addEleve(String nom, String prenom, int age, int matricule, int numeroNiveau, String subdivision);

    public void removeEleve(Eleve eleve);
    public void removeEleve(Long id);
    public List<Eleve> displayEleves();
    public Eleve findEleve(Long id);
    public Eleve findEleve(int matricule);
}
