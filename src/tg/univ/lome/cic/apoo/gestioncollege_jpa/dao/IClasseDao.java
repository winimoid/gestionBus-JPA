/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import java.util.List;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Classe;

/**
 *
 * @author asus
 */
public interface IClasseDao {
    public Classe addClasse(Classe classe);
    public Classe addclasse(int numeroNiveau, String subdivision);
    public void removeClasse(Classe classe);
    public void removeClasse(Long id);
    public List<Classe> displayClasses();
    public Classe findClasse(Long id);
    public Classe findClasse(int numeroNiveau, String subdivision);
    
}
