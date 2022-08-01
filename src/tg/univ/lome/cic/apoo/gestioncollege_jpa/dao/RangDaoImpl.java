package tg.univ.lome.cic.apoo.gestioncollege_jpa.dao;

import org.hibernate.SessionFactory;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Eleve;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.entities.Rang;
import tg.univ.lome.cic.apoo.gestioncollege_jpa.util.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RangDaoImpl implements IRangDao{

    private final EntityManager manager;

    public RangDaoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Rang addRang(int matricule, double moyenne) {
        EntityTransaction transaction = manager.getTransaction();
        IEleveDao eleveDao = new EleveDaoImpl();

        Eleve eleve = eleveDao.findEleve(matricule);
        Rang rang = new Rang(eleve, moyenne);
        try {
            transaction.begin();
            manager.persist(rang);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }

        return rang;
    }

    @Override
    public int getRang(int matricule, double moyenne) {
        int taille = displayRangs().size();
        if(taille>1){
            double[] tabMoy = new double[displayRangs().size()];
            for(int cpt=0; cpt<displayRangs().size(); cpt++){
                tabMoy[cpt] = displayRangs().get(cpt).getMoyenne();
            }
            double temp;
            for(int i=0; i<tabMoy.length; i++){
                for(int j=i+1; j<tabMoy.length; j++){
                    if(tabMoy[i]<tabMoy[j]){
                        temp = tabMoy[i];
                        tabMoy[i] = tabMoy[j];
                        tabMoy[j] = temp;
                    }
                }
            }
            for(int k=0; k<tabMoy.length; k++){
                if(tabMoy[k]==moyenne){
                    return k+1;
                }
            }
        }
        if(taille==1){
            return 1;
        }

        return -1;
    }

    @Override
    public List<Rang> displayRangs() {
        List<Rang> rangs = null;
        rangs = manager.createQuery("SELECT r FROM Rang r", Rang.class)
                .getResultList();

        return rangs;
    }

    @Override
    public Rang findRang(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        Rang rang = null;
        try {
            transaction.begin();
            rang  = manager.find(Rang.class, id);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        return rang;
    }

    @Override
    public Rang findRang(int matricule) {
        Rang rang = manager.createQuery("SELECT r FROM Rang r WHERE r.matricule = :mtle", Rang.class)
                .setParameter("mtle", matricule)
                .getSingleResult();

        return rang;
    }
}
