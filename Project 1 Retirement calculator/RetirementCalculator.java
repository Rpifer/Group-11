import java.util.Scanner;
//group members names
public class RetirementCalculator {
//Taks input from user (Years working, interest rates, years retired, required income, and Social Security)
//to calculate how much money must be saved per month to live on.
	
	public static void main(String[] args) {
		
		//Create a Scanner
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		//Prompt user to input the variables needed
		System.out.print("Enter the years to work: ");
		double yearsToWork = input.nextDouble();
		
		System.out.print("Enter the annual return before retirement (e.g., 0 to .2): ");
		double annualReturnPre = input.nextDouble();
		
		System.out.print("Enter the years retired: ");
		double yearsRetired = input.nextDouble();
		
		System.out.print("Enter the annual return after retirement (i.e., 0 to .03): ");
		double annualReturnPost = input.nextDouble();
		
		System.out.print("Enter the required income: ");
		double requiredIncome = input.nextDouble();
		
		System.out.print("Enter the Social Security ammount ");
		double socialSecurity = input.nextDouble();
		
		//Find the payment per month during retirement
		double payment = (requiredIncome - socialSecurity);
				
		//Find the monthly post-retirement interest rate
		double monthlyRatePost = (annualReturnPost/12);
		
		//Find the total months retired
		double monthsRetired = (yearsRetired * 12);
		
		//Find the total months worked
		double monthsWorked = (yearsToWork * 12);
		
		//Find the monthly pre-retirement interest rate
		double monthlyRatePre = (annualReturnPre/12);
		
		//Calculate the total needed to save for retirement
		double valueNeeded = ((payment * ((Math.pow((1 + monthlyRatePost), monthsRetired) - 1) 
				/ monthlyRatePost))/(Math.pow((1 + monthlyRatePost), monthsRetired)));
		
		
		//Calculate the amount needed to pay per month until retirement
		double monthlyPayment = (valueNeeded)/((Math.pow(1 + monthlyRatePre, monthsWorked) - 1)
				/ monthlyRatePre);
		
		//Print out message in the form of '$xxx.xx'
		System.out.print("\nThe amount needed to save per month is: $" + (int)(monthlyPayment * 100)/100.0);
	}
}
