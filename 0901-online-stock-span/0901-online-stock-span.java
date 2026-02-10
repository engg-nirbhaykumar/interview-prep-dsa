class StockSpanner {

    // Pair class stores:
    // price → stock price of that day
    // span  → how many consecutive days (including this one)
    //         this price dominates
    static class Pair {
        private int price;
        private int span;

        public Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    // Stack maintains a decreasing sequence of prices
    // Top always has the nearest GREATER price than current
    private Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {

        // Minimum span is 1 (today itself)
        int span = 1;

        // While previous prices are <= current price,
        // they are part of the span and can be merged
        while (!st.isEmpty() && st.peek().price <= price) {

            // Add their span (span compression)
            span += st.pop().span;
        }

        // Push current price with its total span
        st.push(new Pair(price, span));

        return span;
    }
}
