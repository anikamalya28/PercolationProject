import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import static edu.princeton.cs.algs4.StdRandom.uniformInt;

public class PercolationStats {
    private int n;
    private int trials;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) throws IllegalArgumentException {
        if (n<=0) {throw new IllegalArgumentException("error");}
        if (trials<=0) {throw new IllegalArgumentException("error");}
        this.n = n;
        this.trials = trials;

        for (int i = 0; i < trials; i++) {
            Percolation x = new Percolation(n);
            int tries = 0;
            while (!x.percolates()) {
                int k = uniformInt(1, n*n+1);
                if (!x.isOpen(((k-k%n)/k)+1,k%n)) {
                    x.open(((k-k%n)/k)+1,k%n);
                    tries += 1;
                }
            }
        }
    }
/*
    // sample mean of percolation threshold
    public double mean() {

    }

    // sample standard deviation of percolation threshold
    public double stddev()

    // low endpoint of 95% confidence interval
    public double confidenceLo()

    // high endpoint of 95% confidence interval
    public double confidenceHi()

    // test client (see below)
    public static void main(String[] args)
*/
}
