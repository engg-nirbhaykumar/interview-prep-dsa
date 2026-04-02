public class Codec {

    // ================= SERIALIZATION =================
    // Converts tree -> string using preorder traversal
    public String serialize(TreeNode root) {

        // StringBuilder is used for efficient string concatenation
        StringBuilder sb = new StringBuilder();

        // Start preorder traversal
        serializeHelper(root, sb);

        // Return final serialized string
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {

        // Base case: if node is null, mark it explicitly
        if (node == null) {
            sb.append("null,"); // Important to preserve structure
            return;
        }

        // Add current node value
        sb.append(node.val).append(",");

        // Recurse on left subtree
        serializeHelper(node.left, sb);

        // Recurse on right subtree
        serializeHelper(node.right, sb);
    }

    // ================= DESERIALIZATION =================
    // Converts string -> tree
    public TreeNode deserialize(String data) {

        // Split string into tokens
        String[] values = data.split(",");

        // Use queue to process nodes in order
        Queue<String> q = new LinkedList<>(Arrays.asList(values));

        // Start rebuilding tree
        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> q) {

        // Get next element
        String node = q.poll();

        // If null marker, return null node
        if (node.equals("null"))
            return null;

        // Create current node
        TreeNode root = new TreeNode(Integer.parseInt(node));

        // Rebuild left subtree
        root.left = deserializeHelper(q);

        // Rebuild right subtree
        root.right = deserializeHelper(q);

        return root;
    }
}