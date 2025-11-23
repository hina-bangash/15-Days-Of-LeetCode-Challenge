class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // will store indices
        
        for (int i = 0; i < n; i++) {
            // While current day is hotter than the day at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            
            // Push the current day's index
            stack.push(i);
        }
        
        // Remaining ones are already 0
        return answer;
    }
}
