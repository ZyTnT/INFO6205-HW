package edu.neu.coe.info6205.union_find;

public class WQU {

    private final int[] parent;   // parent[i] = parent of i
    private final int[] size;   // height[i] = height of subtree rooted at i
    private int count;  // number of components


    public WQU(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public int find(int p) {
        validate(p);
        int root = p;
        while (this.parent[root] != root) {
            root = this.parent[root];
        }
        return root;
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     * {@code false} otherwise
     * @throws IllegalArgumentException unless
     *                                  both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int p1 = find(p);
        int p2 = find(q);

        if (connected(p,q)){
            return;
        }

        if(this.size[p1] >= this.size[p2]) {
            this.parent[p2] = p1;
            this.size[p1] += this.size[p2];
        }
        else{
            this.parent[p1] = p2;
            this.size[p2] += this.size[p1];
        }
        count--;
    }


}
