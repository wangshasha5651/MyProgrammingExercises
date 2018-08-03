/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

/*
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
*/

// 解法1：使用float型存储斜率（使用double不能通过，会有精度损失） 
import java.util.*;
public class Solution {
    public int maxPoints(Point[] points) {
        int len = points.length;
        if(len < 2)
            return len;
 
        int ret = 0;
        for(int i = 0; i < len; i++){
            int vlp = 0, dup = 1;
            Map<Float, Integer> map = new HashMap<>();
            Point a = points[i];
 
            for(int j = 0; j < len; j++){
                if(i == j) continue;
                Point b = points[j];
                if(a.x == b.x){
                    if(a.y == b.y) dup++;
                    else vlp++;
                } else {
                    float k = (float)(a.y - b.y)/(a.x - b.x);
                    if(map.get(k) == null) map.put(k,1);
                    else map.put(k, map.get(k)+1);
                }
            }
            int max = vlp;
            for(float k : map.keySet()){
                max = Math.max(max, map.get(k));
            }
            ret = Math.max(ret, max + dup);
        }
 
        return ret;
    }
 
}

// 解法2：使用分数来存储斜率（嵌套使用map）
public int maxPoints(Point[] points) {
        if(points == null){
            return 0;
        }
        if(points.length <= 2){
            return points.length;
        }

        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();

        int res = 0;
        int max = 0;
        int dup = 0;
        int len = points.length;
        
        // 注意i，j的边界
        for (int i = 0; i < len - 1; i++) {
            // 这里要清空map
            map.clear();
            max = 0;
            dup = 0; 
            // j从i+1开始，去掉(i,j)(j,i)重复的
            for (int j = i+1; j < len; j++) {
                // 计算横坐标和纵坐标之差
                int deltaX = points[j].x - points[i].x;
                int deltaY = points[j].y - points[i].y;
                if(deltaX == 0 && deltaY == 0){
                    dup ++;
                    continue;
                }
                // 由于直接用除法得到的double斜率会有精度损失，因此采用记录分数形式的斜率，因此需要把deltaX和deltaY化简，才能有效使用map
                // map采用的嵌套型，先找到deltaX，再根据deltaX找deltaY，这样可以有效存储分数的分子和分母
                int gcd = getGcd(deltaX, deltaY);
                if(gcd != 0){
                    deltaX = deltaX/gcd;
                    deltaY = deltaY/gcd;
                }
                if(map.containsKey(deltaX)){
                    if(map.get(deltaX).containsKey(deltaY)){
                        map.get(deltaX).put(deltaY, map.get(deltaX).get(deltaY)+1);
                    }else{
                        map.get(deltaX).put(deltaY,1);
                    }
                }else{
                    HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                    tmp.put(deltaY ,1);
                    map.put(deltaX, tmp);
                }
                max = Math.max(max, map.get(deltaX).get(deltaY));
            }
            res = Math.max(res, max + dup + 1);
        }
        return res;
    }
    // 使用欧几里得的“辗转相除法”计算最大公约数（思想：若a除以b余c，则gcd(a,b) = gcd(b,c) --->  gcd(a,b) = gcd(b, a%b)）
    private int getGcd(int x, int y){
        if(y == 0){
            return x;
        }
        return getGcd(y, x%y);
    }