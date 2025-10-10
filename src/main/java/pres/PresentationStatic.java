package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationStatic {
    public static void main(String[] args) {
        // Instanciation statique (couplage faible via setter)
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(d);
        System.out.println("Résultat (instanciation statique) : " + metier.calcul());
    }
}