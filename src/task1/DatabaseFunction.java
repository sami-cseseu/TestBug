package task1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.lang.model.element.Element;

public class DatabaseFunction{
    
    public Element saveSalaryToDatabase(String userId, Double salary)
    {
        ElementContainer ec = new ElementContainer();
        try
        {
            Table userIncome = DatabaseORM.table("user_income");

            ResultSet results = userIncome.update(userId, salary);

            if ((results != null) && (results.first() == true)){
                ResultSetMetaData resultsMetaData = results.getMetaData();
                ec.addElement(DatabaseUtilities.writeTable(results, resultsMetaData));
            }
        }  catch (Exception e){
            
        }

        return (Element) ec;
    }

    public Element saveInsuranceToDatabase(String userId, Double salary)
    {
        ElementContainer ec = new ElementContainer();
        try
        {
            Table userInsurance = DatabaseORM.table("userInsurance");

            ResultSet results = userInsurance.update(userId, salary);

            if ((results != null) && (results.first() == true)){
                ResultSetMetaData resultsMetaData = results.getMetaData();
                ec.addElement(DatabaseUtilities.writeTable(results, resultsMetaData));
            }
        }  catch (Exception e){
           
        }

        return (Element) ec;
    }
}