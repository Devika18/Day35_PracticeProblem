import java.sql.*;
import java.util.Scanner;

public class EmpPayrollService {
    GetConnection connection = new GetConnection();

    public void showAll() throws SQLException {
        Connection conn = connection.getConnection();
        String query = "SELECT * FROM employee_payroll";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            String salary = rs.getString(4);
            String startdate = rs.getString(5);
            String phone = rs.getString(6);
            String address = rs.getString(7);
            String dept = rs.getString(8);
            String basic = rs.getString(9);
            String deductions = rs.getString(10);
            String taxablepay = rs.getString(11);
            String incometax = rs.getString(12);
            String netpay = rs.getString(13);
            System.out.println("ID : "+ id + ", Name : "+ name + ", Gender : "+ gender + ", Salary : "+salary+
                    ", StartDate : " + startdate + ", Phone : "+phone+ ", Dept : " + dept);
        }

        connection.closeConnection();
    }

    public void updateBasePay() throws SQLException {
        PreparedStatement preparedStatement = null;
        Scanner sc = new Scanner(System.in);
        Connection conn = connection.getConnection();
        System.out.println("Enter the employee Name");
        String name = sc.next();
        System.out.println("Enter the new BasePay");
        double basepay = sc.nextDouble();
        String query = "update employee_payroll set basicpay=? where name=?";
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setDouble(1, basepay);
        preparedStatement.setString(2, name);
        int i = preparedStatement.executeUpdate();
        if(i > 0) {
            System.out.println("Employee updated successsfully");
        }

        preparedStatement.close();
        sc.close();
        connection.closeConnection();

    }
}
