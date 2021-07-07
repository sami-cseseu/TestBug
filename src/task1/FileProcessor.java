package task1;
public class FileProcessor {
    
    public void processInsert(WebSession s)
    {
    	String userId = s.getRawParameter("userId", "");
        double salary = Double.parseDouble(s.getRawParameter("salary", ""));
        
        updateTaxReport(salary, userId);
    }
    
    public void  updateTaxReport(double salary, String userId) {
        Tax tax = new Tax();
        double calculateEssintialTax = tax.essentialTax();
        double tempSalry = salary - calculateEssintialTax;
        double govTax = tax.govTax(userId,tempSalry);
        
        double finalSalary = checkLimit(tempSalry - govTax);
        DatabaseFunction database = new DatabaseFunction();
        database.saveSalaryToDatabase(userId, finalSalary);
        saveInsurance(finalSalary, userId);
    }

    public void saveInsurance(double salary, String userId)
    {
    	double healthInsurance = (salary * 5) / 100;

    	DatabaseFunction database = new DatabaseFunction();

        database.saveInsuranceToDatabase(userId, healthInsurance);
    }
    
    public double checkLimit(Double finalSalary) {
        if(finalSalary < 2000.0) {
            return 2000.0;
        }
        
        return finalSalary;
    }
}