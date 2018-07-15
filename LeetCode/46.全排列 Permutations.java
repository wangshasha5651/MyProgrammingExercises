
/**
 * Given a collection of distinct integers, return all possible permutations.
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

public static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] nums)
    {
        int len = nums.length;
        if (len == 0)
        {
            return null;
        }
        else
        {
            res = perm(nums,0,len-1);
            return res;
        }
    }

    public ArrayList<ArrayList<Integer>> perm(int[] buf,int start,int end)
    {
        if (start == end)
        {
            ArrayList<Integer> tmplist = new ArrayList<Integer>();
            for (int i = 0;i < buf.length; i++)//递归终止条件
            {
                tmplist.add(buf[i]);
            }
            res.add(tmplist);
        }
        else
        {
            for (int i = start; i <= end; i++)
            {
                int temp = buf[start];
                buf[start] = buf[i];
                buf[i] = temp;
                //递归
                perm(buf,start+1,end);
                //还原成交换之前的组合
                temp = buf[start];
                buf[start] = buf[i];
                buf[i] = temp;
            }

        }
        return res;
    }