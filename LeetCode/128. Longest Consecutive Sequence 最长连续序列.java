

public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }

        Iterator<Integer> it = set.iterator();

        int max = 1;
        int last = it.next();
        int now;
        int[] mylength = new int[len];
        mylength[0] = 1;
        int i = 1;
        while(it.hasNext()){
            now = it.next();
            if(now == last + 1){
                mylength[i] = mylength[i-1] + 1;
                if(mylength[i] > max){
                    max = mylength[i];
                }
                last = now;
            }else{
                mylength[i] = 1;
                last = now;
            }
            i++;
        }
        return max;
    }