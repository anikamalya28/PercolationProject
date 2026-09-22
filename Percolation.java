import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] grid;
    private WeightedQuickUnionUF uf;
    private int n;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) throws IllegalArgumentException {
        if (n<=0) {throw new IllegalArgumentException("error");}

        grid = new boolean[n*n+2];
        //false is blocked

        uf = new WeightedQuickUnionUF(n*n+2);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) throws IllegalArgumentException {
        if (row<=0 || col<=0 || row > n || col > n) {throw new IllegalArgumentException("error");}
        grid[n*(row-1)+col] = true;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) throws IllegalArgumentException {
        if (row<=0 || col<=0 || row > n || col > n) {throw new IllegalArgumentException("error");}
        return grid[n*(row-1)+col];
    }
/*
    // is the site (row, col) full?
    public boolean isFull(int row, int col)

    // returns the number of open sites
    public int numberOfOpenSites()

    // does the system percolate?
    public boolean percolates()

    // test client (optional)
    public static void main(String[] args)

 */
}


