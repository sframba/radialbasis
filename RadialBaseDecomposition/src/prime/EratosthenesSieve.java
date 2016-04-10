package prime;

import java.util.Arrays;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntIterable;
import it.unimi.dsi.fastutil.ints.IntList;

/**
 * Simple implementation of the Eratosthenes sieve to return all primes less
 * than or equal to N.<br>
 * It has a complexity of O(N*log(log(N)))
 */
public class EratosthenesSieve implements PrimeGenerator {

	private IntList primes = new IntArrayList();

	public EratosthenesSieve(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		// use the equation
		// (x+1)^2=x^2+(2(x+1)-1)
		// to speed up squares calculation
		int i2 = 1;
		for (int i = 2; (i2 += 2 * i - 1) <= n; i++) {
			if (prime[i]) {
				for (int j = i2; j <= n; j += i) {
					prime[j] = false;
				}
			}
		}

		for (int i = 0; i <= n; i++)
			if (prime[i])
				primes.add(i);
	}

	public IntIterable primes() {
		return primes;
	}

	public int numberOfPrimes() {
		return primes.size();
	}

	public int[] primesArray() {
		return primes.toIntArray();
	}

}
