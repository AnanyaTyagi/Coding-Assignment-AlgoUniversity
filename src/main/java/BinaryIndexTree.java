

public class BinaryIndexTree {

        private int[] tree;

        public BinaryIndexTree(int n) {
            tree = new int[n + 1];
        }

        public void update(int index, int diff) {
            int tid = index + 1;
            while (tid < tree.length) {
                tree[tid] += diff;
                tid += (tid & -tid);
            }
        }

        public int getSum(int index) {
            int tid = index + 1;
            int sum = 0;
            while (tid > 0) {
                sum += tree[tid];
                tid -= (tid & -tid);
            }
            return sum;
        }
    }

