package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component // annotation pour les parties Spring
public class MetierImpl implements IMetier {
    private IDao dao;

    // Setter pour l'injection manuelle (instanciation statique)
    /*public void setDao(IDao dao) {
       // this.dao = dao;
    }*/

    @Autowired // Pour l'injection automatique par Spring
    @Qualifier("d")
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    @Override
    public double calcul() {
        double temp = dao.getData();
        return temp * 43 / 3;
    }
}