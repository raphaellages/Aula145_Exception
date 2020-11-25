package Application;

import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = 8021;
		String holder = "Bob Brown";
		Double balance = 500.0, withDrawLimit = 300.0;
		Account acc = new Account(number, holder, balance, withDrawLimit);
		
		System.out.println(acc);
		while (acc.getBalance()>0) {
			System.out.print("Enter amout for withdraw: ");
			try {
				acc.withDraw(sc.nextDouble());
				}
			catch (DomainException e) {
				System.out.println(e.getMessage());
			}
			finally {
				System.out.println(acc);
			}
		}
		sc.close();
	}
		

}
