import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import static edu.princeton.cs.algs4.StdRandom.uniformInt;

public class PercolationStats {
    private int n;
    private int trials;
    private double[] thresholds;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) throws IllegalArgumentException {
        if (n<=0) {throw new IllegalArgumentException("error");}
        if (trials<=0) {throw new IllegalArgumentException("error");}
        this.n = n;
        this.trials = trials;
        this.thresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation x = new Percolation(n);
            int tries = 0;
            while (!x.percolates()) {
                int row = uniformInt(1, n+1);
                int col = uniformInt(1, n+1);
                if (!x.isOpen(row, col)) {
                    x.open(row, col);
                    tries += 1;
                }
            }
            thresholds[i] = (double)tries/(n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(trials));
    }

    /* 
    // test client (see below)
    public static void main(String[] args)
*/
}
