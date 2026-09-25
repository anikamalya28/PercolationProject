import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] grid;
    private WeightedQuickUnionUF uf;
    private int n;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) throws IllegalArgumentException {
        if (n<=0) {throw new IllegalArgumentException("error");}
        this.n = n;

        grid = new boolean[n*n+2];
        //false is blocked

        uf = new WeightedQuickUnionUF(n*n+2);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) throws IllegalArgumentException {
        //if (n*(row-1)+col <= 0 || n*(row-1)+col >= n*n+1) {throw new IllegalArgumentException("error");}
        if (col <= 0 || row <= 0 || col > n || row > n) {throw new IllegalArgumentException("error");}
        grid[n*(row-1)+col] = true;
        if (0 < col-1 && col-1 <= n) {
            if (isOpen(row, col-1)) {uf.union(n*(row-1)+col, n*(row-1)+col-1);}
        };
        if (0 < row-1 && row-1 <= n) {
            if (isOpen(row-1, col)) {uf.union(n*(row-1)+col, n*(row-2)+col);}
        };
        if (0 < col+1 && col +1 <= n) {
            if (isOpen(row, col+1)) {uf.union(n*(row-1)+col, n*(row-1)+col+1);}
        };
        if (0 < row+1 && row+1 <= n) {
            if (isOpen(row+1, col)) {uf.union(n*(row-1)+col, n*(row)+col);}
        }; if (row == 1) {
            uf.union(n*(row-1)+col, 0);
        } if (row == n) {
            uf.union(n*(row-1)+col, n*n+1);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) throws IllegalArgumentException {
        if (col <= 0 || row <= 0 || col > n || row > n) {throw new IllegalArgumentException("error");}
        return grid[n*(row-1)+col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (col <= 0 || row <= 0 || col > n || row > n) {throw new IllegalArgumentException("error");}
            for (int x = 1; x <= col; x++) {
                if (uf.find(x) == uf.find(n * (row - 1) + col) && isOpen(1, x)) {
                    return true;
                }
            }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int sum = 0;
        for (boolean y : grid) {
            if (y) {
                sum += 1;
            }
        }
        return sum;
    }

    // does the system percolate?
    public boolean percolates() {
        if (uf.find(n*n+1) == uf.find(0)) {
            return true;
        }
        return false;
    }
/*
    // test client (optional)
    public static void main(String[] args)

 */
}


