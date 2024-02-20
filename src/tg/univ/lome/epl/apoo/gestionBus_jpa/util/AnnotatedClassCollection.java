package tg.univ.lome.epl.apoo.gestionBus_jpa.util;

import java.util.Arrays;
import java.util.List;

import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.*;

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
            Bus.class,
                Conducteur.class,
                Itineraire.class,
                Horaire.class,
                HoraireTravail.class,
                Arret.class
        };

        return Arrays.asList(classes);
    }

    private AnnotatedClassCollection() {
        throw new AssertionError("No need to instanciate this class ...");
    }
}
