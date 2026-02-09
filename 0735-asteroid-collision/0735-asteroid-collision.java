class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // Stack will store asteroids that are still alive
        // Positive → moving right
        // Negative → moving left
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {

            // Collision is possible ONLY when:
            // stack top is moving right (>0) AND current asteroid is moving left (<0)
            while (!st.isEmpty() && a < 0 && st.peek() > 0) {

                int top = st.peek(); // asteroid already in stack

                // Case 1: stack asteroid is smaller → it explodes
                if (top < -a) {
                    st.pop(); // remove smaller asteroid and continue checking

                    // Case 2: both are equal → both explode
                } else if (top == -a) {
                    st.pop(); // remove stack asteroid
                    a = 0; // mark current asteroid destroyed
                    break; // collision resolved

                    // Case 3: stack asteroid is bigger → current explodes
                } else {
                    a = 0; // current asteroid destroyed
                    break;
                }
            }

            // If current asteroid survived all collisions, push it
            if (a != 0) {
                st.push(a);
            }
        }

        // Stack now contains final state of asteroids
        // We must return them in original order
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop(); // pop gives reverse order
        }

        return result;
    }
}
