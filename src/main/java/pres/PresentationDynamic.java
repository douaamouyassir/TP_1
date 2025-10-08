package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationDynamic {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
            String metierClassName = scanner.nextLine();
            scanner.close();

            // Instanciation dynamique via reflection
            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

            // Injection via setter par reflection
            Method setDaoMethod = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDaoMethod.invoke(metier, dao);

            System.out.println("Résultat (instanciation dynamique) : " + metier.calcul());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}