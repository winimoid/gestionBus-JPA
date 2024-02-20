package tg.univ.lome.epl.apoo.gestionBus_jpa.util;

import java.util.ArrayList;

public class LimitedArrayList<E> extends ArrayList<E>{
    private ArrayList<E> arrayList;
    private int maxSize;

    public LimitedArrayList(int maxSize) {
        this.arrayList = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public LimitedArrayList() {
        this.arrayList = new ArrayList<>();
        this.maxSize = 7;
    }

    @Override
    public boolean add(E element) {
        if (arrayList.size() >= maxSize) {
            System.out.println("Taille maximale du LimitedArrayList atteinte !");
            return false; // Ne pas ajouter si le maximum est atteint
        }
        return arrayList.add(element);
    }

    //getters / setters

    public ArrayList<E> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
