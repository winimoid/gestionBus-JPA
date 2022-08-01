package tg.univ.lome.cic.apoo.gestioncollege_jpa.util;

import java.util.Arrays;
import java.util.List;

import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
class AnnotatedClassCollection {
    
    public static List<Class<?>> getAnnotatedClasses() {
        Class<?>[] classes = new Class<?>[]{
            Niveau.class,
                Classe.class,
            Eleve.class,
                Matiere.class,
                Periode.class,
                Enseignant.class,
                Enseignement.class,
                Cours.class,
                TypeEvaluation.class,
                Evaluation.class,
                Note.class,
                Rang.class,
                Bulletin.class
        };

        return Arrays.asList(classes);
    }

    private AnnotatedClassCollection() {
        throw new AssertionError("No need to instanciate this class ...");
    }
}
