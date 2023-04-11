package com.marketsimplified;

import org.json.*;
import java.sql.*;
import java.util.logging.Logger;
public class EmployeeDatabase
{
    final private Connection conn;
    final private PreparedStatement insertEmployeeStmt1;
    final private PreparedStatement insertEmployeeStmt2;
    final private PreparedStatement insertEmployeeStmt3;
    final private PreparedStatement updateEmployeeStmt1;
    final private PreparedStatement updateEmployeeStmt2;
    final private PreparedStatement updateEmployeeStmt3;
    final private PreparedStatement deleteEmployeeStmt1;
    final private PreparedStatement deleteEmployeeStmt2;
    final private PreparedStatement deleteEmployeeStmt3;
    private final Logger logger = Logger.getLogger("employeeDatabase");
    public EmployeeDatabase() throws SQLException
    {
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Samudralashanmuk123#");
            insertEmployeeStmt1 = conn.prepareStatement("INSERT INTO PermanentEmployee (id, name, age, salary, bonus) VALUES (?, ?, ?, ?, ?)");
            insertEmployeeStmt2 = conn.prepareStatement("INSERT INTO ContractEmployee (id, name, age, salary, contractPeriod) VALUES (?, ?, ?, ?, ?)");
            insertEmployeeStmt3 = conn.prepareStatement("INSERT INTO PartTimeEmployee (id, name, age, salary, hoursWorked) VALUES (?, ?, ?, ?, ?)");
            updateEmployeeStmt1 = conn.prepareStatement("UPDATE PermanentEmployee SET name = ?, age = ?, salary = ?, bonus = ? WHERE id = ?");
            updateEmployeeStmt2 = conn.prepareStatement("UPDATE ContractEmployee SET name = ?, age = ?, salary = ?, contractPeriod = ? WHERE id = ?");
            updateEmployeeStmt3 = conn.prepareStatement("UPDATE PartTimeEmployee SET name = ?, age = ?, salary = ?, hoursWorked = ? WHERE id = ?");
            deleteEmployeeStmt1 = conn.prepareStatement("DELETE FROM PermanentEmployee WHERE id = ?");
            deleteEmployeeStmt2 = conn.prepareStatement("DELETE FROM ContractEmployee WHERE id = ?");
            deleteEmployeeStmt3 = conn.prepareStatement("DELETE FROM PartTimeEmployee WHERE id = ?");

    }
    public void addEmployee(PermanentEmployee permanentEmployee) throws SQLException
    {
        try
        {
            insertEmployeeStmt1.setInt(1, permanentEmployee.getId());
            insertEmployeeStmt1.setString(2, permanentEmployee.getName());
            insertEmployeeStmt1.setInt(3, permanentEmployee.getAge());
            insertEmployeeStmt1.setInt(4, permanentEmployee.getSalary());
            insertEmployeeStmt1.setInt(5, permanentEmployee.getBonus());
            insertEmployeeStmt1.executeUpdate();
            logger.info("Employee added");


        }
        catch (Exception e)
        {
            logger.warning("Duplicate id found");
        }
    }
    public void addEmployee(ContractEmployee contractEmployee) throws SQLException
    {
        insertEmployeeStmt2.setInt(1, contractEmployee.getId());
        insertEmployeeStmt2.setString(2, contractEmployee.getName());
        insertEmployeeStmt2.setInt(3, contractEmployee.getAge());
        insertEmployeeStmt2.setInt(4, contractEmployee.getSalary());
        insertEmployeeStmt2.setInt(5,contractEmployee.getContractPeriod());
        insertEmployeeStmt2.executeUpdate();
        logger.info("Employee added");
    }
    public void addEmployee(PartTimeEmployee partTimeEmployee) throws SQLException
    {
        insertEmployeeStmt3.setInt(1, partTimeEmployee.getId());
        insertEmployeeStmt3.setString(2, partTimeEmployee.getName());
        insertEmployeeStmt3.setInt(3, partTimeEmployee.getAge());
        insertEmployeeStmt3.setInt(4, partTimeEmployee.getSalary());
        insertEmployeeStmt3.setInt(5,partTimeEmployee.getHoursWorked());
        insertEmployeeStmt3.executeUpdate();
        logger.info("Employee added");
    }
    public void updateEmployee(PermanentEmployee permanentEmployee) throws SQLException
    {
        updateEmployeeStmt1.setString(1, permanentEmployee.getName());
        updateEmployeeStmt1.setInt(2, permanentEmployee.getAge());
        updateEmployeeStmt1.setInt(3, permanentEmployee.getSalary());
        updateEmployeeStmt1.setInt(4, permanentEmployee.getBonus());
        updateEmployeeStmt1.setInt(5, permanentEmployee.getId());
        updateEmployeeStmt1.executeUpdate();
        logger.info("Employee updated");
    }
    public void updateEmployee(ContractEmployee contractEmployee) throws SQLException
    {
        updateEmployeeStmt2.setString(1, contractEmployee.getName());
        updateEmployeeStmt2.setInt(2, contractEmployee.getAge());
        updateEmployeeStmt2.setInt(3, contractEmployee.getSalary());
        updateEmployeeStmt2.setInt(4,contractEmployee.getContractPeriod());
        updateEmployeeStmt2.setInt(5, contractEmployee.getId());
        updateEmployeeStmt2.executeUpdate();
        logger.info("Employee updated");
    }
    public void updateEmployee(PartTimeEmployee partTimeEmployee) throws SQLException
    {
        updateEmployeeStmt3.setString(1, partTimeEmployee.getName());
        updateEmployeeStmt3.setInt(2, partTimeEmployee.getAge());
        updateEmployeeStmt3.setInt(3, partTimeEmployee.getSalary());
        updateEmployeeStmt3.setInt(4, partTimeEmployee.getHoursWorked());
        updateEmployeeStmt3.setInt(5, partTimeEmployee.getId());
        updateEmployeeStmt3.executeUpdate();
        logger.info("Employee updated");
    }
    public void deleteEmployee1(int id)
    {
        try {
            deleteEmployeeStmt1.setInt(1, id);
            int result = deleteEmployeeStmt1.executeUpdate();
            if(result>0){
                logger.info("Employee deleted");
            }
            else {
                logger.warning("Employee id not found");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteEmployee2(int id)
    {
        try {
            deleteEmployeeStmt2.setInt(1, id);
            int result = deleteEmployeeStmt2.executeUpdate();
            if(result>0){
                logger.info("Employee deleted");
            }
            else {
                logger.warning("Employee id not found");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteEmployee3(int id)
    {
        try
        {
        deleteEmployeeStmt3.setInt(1, id);
        int result = deleteEmployeeStmt3.executeUpdate();
            if(result>0){
                logger.info("Employee deleted");
            }
            else {
                logger.warning("Employee id not found");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void permanentJson() throws SQLException
    {
        String SELECT_EMPLOYEES_QUERY = "SELECT id, name, age, salary, bonus FROM PermanentEmployee";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_EMPLOYEES_QUERY);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("age", resultSet.getInt("age"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("bonus",resultSet.getInt("bonus"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
    }

    public void partTimeJson() throws SQLException
    {
        String SELECT_EMPLOYEES_QUERY = "SELECT id, name, age, salary, hoursWorked  FROM PartTimeEmployee";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_EMPLOYEES_QUERY);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("age", resultSet.getInt("age"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("hoursWorked",resultSet.getInt("hoursWorked"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
    }
    public void contractJson() throws SQLException {
        String SELECT_EMPLOYEES_QUERY = "SELECT id, name, age, salary, contractPeriod  FROM ContractEmployee";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_EMPLOYEES_QUERY);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("age", resultSet.getInt("age"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("contractPeriod",resultSet.getInt("contractPeriod"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
        conn.close();
    }

}
