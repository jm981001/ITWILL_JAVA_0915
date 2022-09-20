package thread;

public class Ex4 {
	public static void main(String[] args) {
		Account account = new Account(100000);
		WithdrawThread iBanking = new WithdrawThread("인터넷 뱅킹", account, 20000);
		WithdrawThread mBanking = new WithdrawThread("인터넷 뱅킹", account, 20000);
		
		iBanking.start();
		mBanking.start();
		
	}
}
class Account{
	int balance;
	
	public Account(int balance) {
		this.balance=balance;
	}
	
	public int deposit(int amount) {
		balance += amount;
		return balance;
		
	}
	
	public synchronized int withdraw (int amount) {
		if(balance >= amount) {
			balance -= amount;
			
		}else {
			System.out.println("잔액이 부족하여 출금할 수 없습니다");
			amount = 0;
			
		}
		System.err.println("출금된 금액 : " + amount + ", 출금 후 잔액 " + balance);
		return amount;
	}
	
	
}

class WithdrawThread extends Thread {
	
	Account account;
	int amount;
	public WithdrawThread(String threadName, Account account, int amount) {
		super(threadName);
		this.account = account;
		this.amount = amount;
	}
	@Override
	public void run() {
		for(int i = 1; i <=6; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int money = account.withdraw(amount);
		}
	}
	
	
}