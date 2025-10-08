package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao; // Couplage faible via l'interface

    // Setter pour l'injection des dépendances
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 2;
    }
}