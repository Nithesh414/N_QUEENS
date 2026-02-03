public class TopoSortNoCollections {

    static String[] nodes = {"A", "B", "C", "D", "E"};
    static int n = nodes.length;

    // adjacency matrix
    static int[][] graph = {
        // A  B  C  D  E
        { 0, 0, 0, 0, 1 }, // A
        { 1, 0, 0, 0, 1 }, // B
        { 1, 0, 0, 0, 1 }, // C
        { 0, 1, 1, 0, 1 }, // D
        { 0, 0, 0, 0, 0 }  // E
    };

    static boolean[] removed = new boolean[n];
    static String[] result = new String[n];
    static int resultIndex = 0;

    public static void main(String[] args) {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (!removed[i] && isSink(i)) {
                    result[resultIndex++] = nodes[i];
                    removeNode(i);
                    break;
                }
            }
        }

        // Print result
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    // Check if node has no outgoing edges
    static boolean isSink(int node) {
        for (int j = 0; j < n; j++) {
            if (graph[node][j] == 1) {
                return false;
            }
        }
        return true;
    }

    // Remove node (delete incoming edges)
    static void removeNode(int node) {
        removed[node] = true;
        for (int i = 0; i < n; i++) {
            graph[i][node] = 0;
        }
    }
}
