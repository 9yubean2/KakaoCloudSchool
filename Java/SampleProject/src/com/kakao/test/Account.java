package com.kakao.test;

public class Account {
	//fields
	private String accountHolder;
	private String accoutNumber;
	private long balance;
	
	//constructors
	Account(String accountHolder, String accoutNumber, long balance) {
		
		this.accountHolder = accountHolder;
		this.accoutNumber = accoutNumber;
		this.balance = balance;
	}
	
	//getter&setter methods
	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountNumber() {
		return accoutNumber;
	}

	public void setAccountNumber(String accoutNumber) {
		this.accoutNumber = accoutNumber;
	}

	public long getBalance() {
		System.out.println("잔액: "+balance+" 원");
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	//methods
	public void checkAccountInfo() {
		System.out.println("계좌: " + getAccountNumber() + " (예금주: " + getAccountHolder() + ")");
		getBalance();
	}
	
	public void doDeposit(long cash) {
		balance += cash;
		System.out.println(cash + " 원 입금합니다.");
		getBalance();
	}
	
	public void doWithdraw(long cash) {
		balance -= cash;
		System.out.println(cash + " 원 출금합니다.");
		getBalance();
	}
	
	//main
	public static void main(String[] args) {
		Account acc = new Account("홍길동","123-456789",10000);
		acc.checkAccountInfo();
		
		acc.doDeposit(20000);
		
		acc.doWithdraw(45000);
		
	}
}
