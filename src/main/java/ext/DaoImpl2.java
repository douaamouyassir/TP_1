package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("d1") //
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Web service");
        return 41;
    }
}