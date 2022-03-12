package com.revature;

import com.revature.ConnectionFactory;
import com.revature.Employee;
import com.revature.EmployeeDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.revature.ConnectionFactory.getConnection;

public class EmployeeDaoImpl implements EmployeeDao {
    Connection connection;

    public EmployeeDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }
    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String INSERT_USERS_SQL = "INSERT INTO staff" + "(name, salary, title) VALUES" + "(?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getTitle());
            preparedStatement.setInt(3, employee.getSalary());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
             String UPDATE_USERS_SQL = "update staff set name =?, salary=?, title=? where id=?";
            boolean rowUpdated;
            //get employee entity
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);{
                statement.setString(1,employee.getName());
                statement.setString(2,employee.getTitle());
                statement.setInt(3,employee.getSalary());
                statement.setInt(4,employee.getEmp_id());
                rowUpdated=statement.executeUpdate() > 0;
            }

    }

    @Override
    public void deleteEmployee(int id) {
            String DELETE_USERS_SQL = "delete from staff where id=?";
            boolean rowDeleted = false;
            try(Connection connection = getConnection();
                PreparedStatement stmnt = connection.prepareStatement(DELETE_USERS_SQL);) {
                stmnt.setInt(1, id);
                rowDeleted = stmnt.executeUpdate() >0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }




    @Override
    public List<Employee> getEmployees() throws SQLException {
       String SELECT_USERS_ALL = "select * from staff";
        List<Employee> emmployees = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_ALL);
        {
            //preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);

            ResultSet rs =preparedStatement.executeQuery();

            //commit
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String title = rs.getString("title");
                int salary = rs.getInt("salary");
                emmployees.add(new Employee(id,name,title,salary));
            }

        return null;
    }
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
       String SELECT_USERS_SQL = "select id, name, salary, title from staff where id=?";
        Employee employee1 = null;

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL);
            {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);

            ResultSet rs =preparedStatement.executeQuery();

            //commit
            while (rs.next()){
                String name = rs.getString("name");
                String title = rs.getString("title");
                int salary = rs.getInt("salary");
                employee1= new Employee(id,name,title,salary);
            }

        }
        return employee1;
    }
}
   /*








    //methods
    public void insertEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = connection.preparedStatement(INSERT_USERS_SQL);{
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getTitle());
            preparedStatement.setInt(3,employee.getSalary());
            preparedStatement.executeUpdate();
        }
    }
    //update metod
    public void updateEmployee(Employee employee) throws SQLException {


    }
    public void selectAllEmployee(Employee employee) throws SQLException {

    }
    //select user id
    public void getEmployee(int id){

    }
    public Employee selectEmployee(){


    }
    public boolean deleteEmployee(int id) {

}*/
