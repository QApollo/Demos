public class OCAch4 {
	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount();
		System.out.println("Initial balance is " + myAccount.getBalance());
		
		System.out.println("Set balance to 3");
		myAccount.setBalance(3);
		System.out.println("New balance is " + myAccount.getBalance());
		
		System.out.println("Set balance to 2");
		myAccount.setBalance("2");
		System.out.println("New balance is " + myAccount.getBalance());
		
		System.out.println("Static field getBankGroupId is " + BankAccount.getBankGroupId());
		
		System.out.println("Add Funds ");
		myAccount.addFunds(1.0, 3.2, -1.5, 0, 3);
		System.out.println("New balance is " + myAccount.getBalance());
	}
}

class BankAccount {
	private double balance;
	protected static final int bankGroupId = 123;
	
	public double getBalance() {
		return this.balance;
	}
	
	public BankAccount() {   // the constructor
		this.balance = 10;
	}
	
	public BankAccount(double startBalance) {   // constructor overloading
		this.balance = startBalance;
	}
	
	public void setBalance(double newBalance) throws IllegalArgumentException {
		this.balance = Math.round(newBalance);
	}
	
	public void setBalance(String newBalance) {
		this.balance = Double.valueOf(newBalance);
	}
	
	public void addFunds(double... fundsAmount) {
		for (double fund : fundsAmount) {
			if (fund > 0) {
				this.balance += fund;
				
			}
		}
	}
	
	public static int getBankGroupId() {
		return bankGroupId;
	}
}