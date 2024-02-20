package tg.univ.lome.epl.apoo.gestionBus_jpa.util;

import javax.persistence.*;
import java.util.Objects;

public class Horaire {

    private int heure;

    private int minute;

    // constructeurs
    public Horaire() {

    }

    public Horaire(int heure, int minute) {
        this.heure = heure;
        this.minute = minute;
    }

    // Getters / Setters

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    // Equals / Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horaire horaire)) return false;
        return getHeure() == horaire.getHeure() && getMinute() == horaire.getMinute();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeure(), getMinute());
    }

    // ToString

    @Override
    public String toString() {
        return String.format("%02d:%02d", heure, minute);
    }
}
