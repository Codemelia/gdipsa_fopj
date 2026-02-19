import java.util.Scanner;

public class IncomeTaxCalculator {

	private final static Scanner in = new Scanner(System.in);
	
	//these arrays is visible in all the static method,
	//so you can use them in your method implementation
	static int[] minIncomeArray = new int[]
		{ 20000, 30000, 40000, 80000,
		120000, 160000, 200000, 240000,
		280000,320000,500000,1000000 };
	static double[] taxRateArray = new double[]
		{ 0.02, 0.035, 0.07, 0.115,
		0.15, 0.18, 0.19, 0.195, 
		0.20, 0.22, 0.23, 0.24 };
	static int[] basePayableAmountArray = new int[]
		{ 0, 200, 550, 3350,
		7950, 13950, 21150, 28750, 
		3655, 44550, 84150, 199150 };
	
	public static void main(String[] args) {
		int annualIncome = askForIncome();
		int taxBracket = getTaxBracket(annualIncome);
		double taxPayable = calculateIncomeTax(annualIncome, taxBracket);
		printResult(annualIncome, taxPayable);
	}
	
	// MY CODE
	public static Integer askForIncome() {
		// prompt user for annual taxable income
		System.out.println(">>> Please enter your annual taxable income: ");
		
		// get user input and return it
		try {
			return in.nextInt();
		} catch (Exception ex) {
			return 0; // return 0 on invalid input
		}
		
	}
	
	public static Integer getTaxBracket(int income) {
		// store target index
		int index = -1;
		
		// loop thru minIncomeArray
		// find largest index where user income is larger than minIncome
		for (int i = minIncomeArray.length - 1; i >= 0; i--) {
			if (income > minIncomeArray[i]) {
				index = i;
				break; // exit loop
			}
		}
		
		return index;
	}
	
	public static Double calculateIncomeTax(int income, int index) {
		// handle no payable tax index
		if (index == -1) return 0.0;
		
		// retrieve values required to calc payable tax
		int minIncome = minIncomeArray[index];
		double taxRate = taxRateArray[index];
		int baseAmount = basePayableAmountArray[index];
		
		return ((income - minIncome) * taxRate) + baseAmount; // payable tax
	}
	
	public static void printResult(int income, double payTax) {
		System.out.printf("For taxable annual income of $%,d, the tax payable amount is $%,.2f", 
			income, payTax);
	}

}
