package Goldbach_conjecture;
import java.util.Scanner;

public class Prime_number_sum {
	
	static Scanner sc = new Scanner(System.in);
	
	public static boolean jePrvocislo(int cislo) {
		int divisors = 0;
		for (int i = 1; i <= cislo; i++) {
			boolean divisible = (cislo%i == 0);
			if (divisible == true) {
				divisors++;
			}
		}
		
		if(divisors == 2) {
			return true;
		}
		
		return false;
	}
	
	public static int jeSoucetPrvocisel (int cislo){
		
		for (int i = 2; i <= cislo / 2; i++) {
			if (jePrvocislo(i) && jePrvocislo(cislo - i)) {
				int vysledek = cislo - i;
				return vysledek;
			}
		}
		
		return 0;
	}
	
	public static int nactiPrirozeneCislo(Scanner sc){
		double n = 0;
		int cislo = 0;
		
		while(n <= 0) {
			System.out.println("Zadej prirozene cislo: ");
			n = sc.nextDouble();
		}
		
		if (isWhole(n)) {
			cislo = (int)n;
		}
		return cislo;
	}
	
	public static boolean isWhole(double n) {
		return (n%1 == 0);
	}
	
	public static void main(String[] args) {
		int cislo = nactiPrirozeneCislo(sc);

		int vysledek = jeSoucetPrvocisel(cislo);
		if (vysledek > 0) {
			System.out.println("Lze rozlozit: "+(cislo - vysledek)+ " + "+vysledek);
		}
		else {
			System.out.println("Nelze rozlozit.");
		}
	}
}
