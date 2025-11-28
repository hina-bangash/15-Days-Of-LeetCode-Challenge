import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build graph + indegree array
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int a = p[0]; // course to take later
            int b = p[1]; // prerequisite
            graph.get(b).add(a);
            indegree[a]++;
        }

        // Step 2: Start with all courses that have no prereqs
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int count = 0;

        // Step 3: Process the queue
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        // Step 4: If we processed all courses, no cycle
        return count == numCourses;
    }
}
