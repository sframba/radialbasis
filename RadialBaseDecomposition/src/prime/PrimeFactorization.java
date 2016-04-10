package prime;

/**
 * Class used to manipulate numbers in the form of prime factorizations
 */
public class PrimeFactorization {
	private int[] factorization;

	public PrimeFactorization(int n) {
		this.factorization = new int[n];
	}

	public PrimeFactorization multAssign(PrimeFactorization other) {
		for (int i = 0; i < factorization.length; i++)
			this.factorization[i] += other.factorization[i];
		return this;
	}

	public PrimeFactorization divAssign(PrimeFactorization other) {
		for (int i = 0; i < factorization.length; i++)
			this.factorization[i] -= other.factorization[i];
		return this;
	}

	public PrimeFactorization mult(PrimeFactorization other) {
		int n = factorization.length;
		PrimeFactorization result = new PrimeFactorization(n);
		for (int i = 0; i < factorization.length; i++)
			result.factorization[i] = this.factorization[n] + other.factorization[i];
		return result;
	}

	public PrimeFactorization div(PrimeFactorization other) {
		int n = factorization.length;
		PrimeFactorization result = new PrimeFactorization(n);
		for (int i = 0; i < factorization.length; i++)
			result.factorization[i] = this.factorization[n] - other.factorization[i];
		return result;
	}

	public PrimeFactorization lcd(PrimeFactorization other) {
		int n = factorization.length;
		PrimeFactorization result = new PrimeFactorization(n);
		for (int i = 0; i < factorization.length; i++)
			result.factorization[i] = Math.min(this.factorization[n], other.factorization[i]);
		return result;
	}

}
