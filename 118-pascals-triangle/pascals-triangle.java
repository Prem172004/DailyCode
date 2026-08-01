class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0) return list;
        list.add(Arrays.asList(1));
        if(numRows == 1) return list;
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = list.get(i - 1);

            row.add(1);

            for(int j = 1; j < i; j++) {
                int sum = prev.get(j - 1) + prev.get(j);
                row.add(sum);
            }
            if(i > 0 ) row.add(1);
            list.add(row);
        }
            return list;
    }

}