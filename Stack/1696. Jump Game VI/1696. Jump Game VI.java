//DP + stack
//first attemp: O(N^2), TLE

public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        
        LinkedList<Integer> dq = new LinkedList<>();
        dq.add(0);
        for (int i=1; i<nums.length; i++){
            int max = dp[dq.peek()];        
            dp[i] = max+nums[i];
            if (!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) dq.pollLast();           
            dq.offer(i);           
        }
        return dp[nums.length-1];
    }
