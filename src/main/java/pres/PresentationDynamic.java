package pres;

import dao.IDao;
import metier.IMetier;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationDynamic {
    public static void main(String[] args) {
        try {
            InputStream is = PresentationDynamic.class.getResourceAsStream("/config.txt");
            if (is == null) {
                System.out.println("Fichier config.txt non trouvé dans resources.");
                return;
            }
            Scanner scanner = new Scanner(is);
            String daoClassName = scanner.nextLine();
            String metierClassName = scanner.nextLine();
            scanner.close();

            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

            Method setDaoMethod = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDaoMethod.invoke(metier, dao);

            System.out.println("RES=" + metier.calcul());
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}