/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.dao.*;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.*;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        INiveauDao niveauDao = new NiveauDaoImpl();
        IClasseDao classeDao = new ClasseDaoImpl();
        IEleveDao eleveDao = new EleveDaoImpl();
        IEnseignantDao enseignantDao = new EnseignantDaoImpl();
        IMatiereDao matiereDao = new MatiereDaoImpl();
        IPeriodeDao periodeDao = new PeriodeDaoImpl();
        IEnseignementDao enseignementDao = new EnseignementDaoImpl();
        ICoursDao coursDao = new CoursDaoImpl();
        ITypeEvaluationDao typeEvaluationDao = new TypeEvaluationDaoImpl();
        IEvaluationDao evaluationDao = new EvaluationDaoImpl();
        INoteDao noteDao = new NoteDaoImpl();
        IRangDao rangDao = new RangDaoImpl();
        IBulletinDao bulletinDao = new BulletinDaoImpl();
//
//        Niveau niveau1 = new Niveau(1, "6e", "Classe de Sixieme");
//        niveauDao.addNiveau(niveau1);
//        Niveau niveau2 = new Niveau(2, "5e", "Classe de Cinqieme");
//        niveauDao.addNiveau(niveau2);
//        Niveau niveau3 = new Niveau(3, "4e", "Classe de Quatrieme");
//        niveauDao.addNiveau(niveau3);
//        Niveau niveau4 = new Niveau(4, "3e", "Classe de Troisieme");
//        niveauDao.addNiveau(niveau4);
//        System.out.println(niveauDao.findNiveau(1L));
//        niveauDao.displayNiveaux();
//        Niveau niveau8 = new Niveau(8, "8e", "Classe de Huitieme");
//        niveauDao.addNiveau(niveau8);
//        niveauDao.removeNiveau(niveau8);
//        niveauDao.removeNiveau(5L);
//        System.out.println(niveauDao.findNiveau(1));

//
//        Classe classe1 = new Classe(niveau1, "A");
//        classeDao.addClasse(classe1);
//        Classe classe2 = new Classe(niveau2, "B");
//        classeDao.addClasse(classe2);
//        Classe classe3 = new Classe(niveau3, "C");
//        classeDao.addClasse(classe3);
//        Classe classe4 = new Classe(niveau4, "A");
//        classeDao.addClasse(classe4);
//
//        Eleve eleve1 = new Eleve("WINIGAH", "Mhensa Moise", 11, 532147, classe1);
//        eleveDao.addEleve(eleve1);
//        Eleve eleve2 = new Eleve("HONVI", "Kokou Vivien", 12, 532456, classe2);
//        eleveDao.addEleve(eleve2);
//        Eleve eleve3 = new Eleve("AKPONO", "Koffi Sakomi", 13, 536649, classe3);
//        eleveDao.addEleve(eleve3);
//        Eleve eleve4 = new Eleve("KAPOMONVI", "Hodalo Sandra", 14, 521875, classe4);
//        eleveDao.addEleve(eleve4);
//        System.out.println(eleveDao.findEleve(532147));

//        enseignantDao.addEnseignant("AKAKPO", "David", "MTH");
//        enseignantDao.addEnseignant("DUNANT", "Henri", "ECM");
//        enseignantDao.addEnseignant("BLEWOU", "Afi Clarisse", "ANG");
//        enseignantDao.addEnseignant("DJITRI", "Koffi Samuel", "HG");
//        enseignantDao.addEnseignant("ADJEWODA", "Cecile Grace", "FRA");
//        enseignantDao.addEnseignant("LAWSON", "Kpekui", "SVT");
//        enseignantDao.addEnseignant("KPEGLO", "Marius", "SP");
//
//        Matiere matiere1 = new Matiere("FRA", "Francais");
//        matiereDao.addMatiere(matiere1);
//        Matiere matiere2 = new Matiere("MTH", "Mathematiques");
//        matiereDao.addMatiere(matiere2);
//        Matiere matiere3 = new Matiere("HG", "Histo-Geo");
//        matiereDao.addMatiere(matiere3);
//        Matiere matiere4 = new Matiere("SP", "Sciences Phy.");
//        matiereDao.addMatiere(matiere4);
//        Matiere matiere5 = new Matiere("SVT", "Sciences Nat.");
//        matiereDao.addMatiere(matiere5);
//        Matiere matiere6 = new Matiere("ANG", "Anglais");
//        matiereDao.addMatiere(matiere6);
//        Matiere matiere7 = new Matiere("ECM", "Educ. Civ.");
//        matiereDao.addMatiere(matiere7);
//        System.out.println(matiereDao.findMatiere("MTH"));
//
//        Periode periode1 = new Periode("Premier Trimestre", 1);
//        periodeDao.addPeriode(periode1);
//        Periode periode2 = new Periode("Deuxieme Trimestre", 2);
//        periodeDao.addPeriode(periode2);
//        Periode periode3 = new Periode("Troisieme Trimestre", 3);
//        periodeDao.addPeriode(periode3);
//        System.out.println(periodeDao.findPeriode(1));

//        enseignementDao.addEnseignement();
//        System.out.println(enseignementDao.displayEnseignement());
//
//        coursDao.addCours((Enseignant) null);
//        System.out.println(coursDao.displayCours());
//
//        TypeEvaluation typeEvaluation1 = new TypeEvaluation("INT", "Iterrogation Ecrite");
//        typeEvaluationDao.addTypeEvaluation(typeEvaluation1);
//        TypeEvaluation typeEvaluation2 = new TypeEvaluation("DST", "Devoir Sur Table");
//        typeEvaluationDao.addTypeEvaluation(typeEvaluation2);
//        TypeEvaluation typeEvaluation3 = new TypeEvaluation("TP", "Travaux Pratiques");
//        typeEvaluationDao.addTypeEvaluation(typeEvaluation3);
//        TypeEvaluation typeEvaluation4 = new TypeEvaluation("EX", "Examen");
//        typeEvaluationDao.addTypeEvaluation(typeEvaluation4);
//
//        evaluationDao.makeEvaluations("INT");
//        evaluationDao.makeEvaluations("DST");
//        evaluationDao.makeEvaluations("TP");
//        evaluationDao.makeEvaluations("EX");
//        System.out.println(evaluationDao.displayEvaluations());
//        System.out.println(evaluationDao.findEvaluation(1L));

        // notes de HONVI KOKOU VIVIEN
//        noteDao.addBlocNote(532456, 1, "ANG", "29/09/2021", "05/02/2022", "09/03/2022", "15/04/2022", 10, 15.75, 17.25, 14);
//
//        noteDao.addBlocNote(532456, 1, "FRA", "05/07/2022", "07/05/2022", "12/03/2022", "09/08/2022", 11, 16.75, 13.25, 12);
//
//        noteDao.addBlocNote(532456, 1, "HG", "17/11/2021", "04/04/2022", "30/05/2022", "25/02/2022", 18, 15.25, 11, 13.25);
//
//        noteDao.addBlocNote(532456, 1, "MTH", "08/02/2022", "06/07/2022", "10/07/2022", "15/08/2022", 13.5, 12, 10, 19.75);
//
//        noteDao.addBlocNote(532456, 1, "SP", "13/09/2021", "28/08/2022", "09/09/2022", "14/05/2022", 17, 14.75, 16.25, 15);
//
//        noteDao.addBlocNote(532456, 1, "SVT", "25/11/2021", "12/02/2022", "31/05/2022", "15/08/2022", 10, 15, 12.25, 14);
//
//        noteDao.addBlocNote(532456, 1, "ECM", "31/12/2021", "11/05/2022", "19/07/2022", "15/09/2022", 13, 17.25, 14, 14.50);


        // notes de KAPOMONVI SANDRA
//        noteDao.addBlocNote(521875, 2, "ANG", "29/09/2021", "05/02/2022", "09/03/2022", "15/04/2022", 03, 08.25, 07.25, 12);
//
//        noteDao.addBlocNote(521875, 2, "FRA", "05/07/2022", "07/05/2022", "12/03/2022", "09/08/2022", 13, 17.25, 14, 14.50);
//
//        noteDao.addBlocNote(521875, 2, "HG", "17/11/2021", "04/04/2022", "30/05/2022", "25/02/2022", 11, 16.25, 11.75, 10.25);
//
//        noteDao.addBlocNote(521875, 2, "MTH", "08/02/2022", "06/07/2022", "10/07/2022", "15/08/2022", 02.5, 10, 10, 07.75);
//
//        noteDao.addBlocNote(521875, 2, "SP", "13/09/2021", "28/08/2022", "09/09/2022", "14/05/2022", 12.5, 11.75, 10.25, 13.5);
//
//        noteDao.addBlocNote(521875, 2, "SVT", "25/11/2021", "12/02/2022", "31/05/2022", "15/08/2022", 10, 14, 09.25, 11.25);
//
//        noteDao.addBlocNote(521875, 2, "ECM", "31/12/2021", "11/05/2022", "19/07/2022", "15/09/2022", 12.25, 15.5, 14, 13);
//
//        bulletinDao.printBulletin(532456, 1);

        System.out.println(classeDao.findClasse(1, "A"));
    }
    
}
