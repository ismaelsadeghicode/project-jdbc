import com.mapsa.database.CRUD;
import com.mapsa.database.DBConnection;
import com.mapsa.database.TableGenerate;
import com.mapsa.model.Customer;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Esmaeil Sadeghi, 8/5/20 2:47 PM
 */
public class App {

    public static void main(String[] args) throws IllegalAccessException {
//        DBConnection.getInstance().getConnection();

//        TableGenerate tableGenerate = new TableGenerate();
//        tableGenerate.create(new Customer());

        CRUD crud = new CRUD();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("ali");
        customer.setLastName("aliyari");
//        crud.save(customer);
        System.out.println(crud.save(customer));

    }
}
