class CustomStack {

    List<Integer> st;
    int maxSize;

    public CustomStack(int maxSize) {
        st = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (st.size() < maxSize) {
            st.add(x);
        }
    }

    public int pop() {
        if (st.isEmpty()) {
            return -1;
        }

        return st.remove(st.size() - 1);
    }

    public void increment(int k, int val) {
        int count = Math.min(k, st.size());

        for (int i = 0; i < count; i++) {
            st.set(i, st.get(i) + val);
        }
    }
}