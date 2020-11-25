package model.entities;

import model.exception.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance, withDrawLimit;
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}
	public Integer getNumber() {
		return number;
	}
	public String getHolder() {
		return holder;
	}
	public Double getBalance() {
		return balance;
	}
	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}
	public void withDraw(Double amount) {
		if (amount>withDrawLimit) {
			throw new DomainException ("Withdraw Limit Exceeded");
		}
		else balance -= amount;
	}
	
	@Override
	public String toString() {
		return 	number
				+" "
				+holder
				+ " "
				+String.format("%.2f", balance)
				+" "
				+String.format("%.2f", withDrawLimit);
	}
}
