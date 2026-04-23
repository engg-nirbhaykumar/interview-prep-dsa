class Solution {
    int[] parent;
    int[] rank;

    // Find the ultimate parent (root) of node x
    // Path compression ensures future queries are faster
    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]); // compress path
    }

    // Union two nodes using union by rank
    // Keeps tree shallow for efficient operations
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        // If both belong to same component → no need to merge
        if (px == py)
            return;

        // Attach smaller tree under larger tree
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++; // increase rank if same height
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        parent = new int[n];
        rank = new int[n];

        // Initialize DSU
        // Each account is initially its own parent (separate component)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Map each email to the first account index where it appears
        Map<String, Integer> emailToIndex = new HashMap<>();

        // Traverse all accounts
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            // Start from j=1 because index 0 is the name
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                // If email seen for the first time → map it
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    // Same email found in another account → union them
                    union(i, emailToIndex.get(email));
                }
            }
        }

        // Group emails by their ultimate parent (component leader)
        Map<Integer, Set<String>> indexToEmails = new HashMap<>();

        for (String email : emailToIndex.keySet()) {
            int parentIndex = find(emailToIndex.get(email));

            // Create a new group if not present
            indexToEmails.putIfAbsent(parentIndex, new HashSet<>());

            // Add email to that group
            indexToEmails.get(parentIndex).add(email);
        }

        // Build final result
        List<List<String>> result = new ArrayList<>();

        for (int parentIndex : indexToEmails.keySet()) {
            // Convert set → list and sort emails
            List<String> emailList = new ArrayList<>(indexToEmails.get(parentIndex));
            Collections.sort(emailList);

            // Add account holder name at index 0
            emailList.add(0, accounts.get(parentIndex).get(0));

            result.add(emailList);
        }

        return result;
    }
}