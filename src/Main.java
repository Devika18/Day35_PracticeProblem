import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Service Database Program");
        EmpPayrollService service = new EmpPayrollService();
        try {
            service.updateBasePay();
            service.showAll();
            service.showByDate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}