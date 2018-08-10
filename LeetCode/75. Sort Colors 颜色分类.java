// low记录最左边分区的末尾的下一位，mid记录中间分区的最后一位，high记录最后一个分区的最前面的前一位
    public void sortColors(int[] nums) {
        if(nums.length == 0)
            return;
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid <= high){
            switch (nums[mid]){
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }

    }
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }