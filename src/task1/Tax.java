package task1;
public class Tax{
	private final static double CHURCH_TAX = 20;

	public double essentialTax(){
		Table table = DatabaseORM.table("tax_essantial");
		double total = table.sum("amount"); 

		return total;
	}

	public double individualTax(String userId, double salary) {
		Table userTaxRateTable = DatabaseORM.table("user_tax_rate");
		double rate = userTaxRateTable.getRateOfId(userId);
		double incomeTax = (salary * rate) / 100;

		return incomeTax;

	}

	public double churchTax(double salary){
		if(salary > 1000){
			return CHURCH_TAX;
		}

		return 0;
	}

	public double govTax(String userId, double salary){
		double churchTax = churchTax(salary);
		double individualTex = individualTax(userId, salary);
		double taxSum = churchTax + individualTex;

		return taxSum;
	}
}