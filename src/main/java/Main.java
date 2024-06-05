import java.sql.Connection;
import java.sql.SQLException;
import beans.*;
import daos.*;


public class Main {
	public static void main(String[] args) throws SQLException {
//		Employee employee=new Employee(1,123456,"sam","spade",3);
//		System.out.println(employee);
		Connection con= Database.getConnection();
		if (con!=null) {
			System.out.println("Database connection succesful");
		}
		
//		
		ProfileDAO profileDAO=new ProfileDAOImpl();
		Profile profile = profileDAO.get(1);
		System.out.println(profile);
		
//		ProfileDAO employeeDAO=new ProfileDAOImpl();
//		Profile employee = employeeDAO.get(7);
//		System.out.println(employee);
//		int result =employeeDAO.delete(employee);
//		System.out.println(result);
		
		ProfileDAO employeeDAO1=new ProfileDAOImpl();
		Profile employee1 = new Profile();
		employee1.setIdProfile(2);
        employee1.setNomProfile("axel");
        employee1.setEmailProfile("aubin@gmail.com");
        employee1.setPasswordProfile("password123");
		int result1 =employeeDAO1.update(employee1);
		System.out.println(result1);
		
		System.out.println(employeeDAO1.getAll());
		
		int result11=employeeDAO1.insert(employee1);
		System.out.println(result11);
	}
}
