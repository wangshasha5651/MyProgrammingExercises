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