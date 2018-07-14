/**
 * Given a list of words and an integer k, return the top k frequent words in the list.
 *
 * Given
 * [
 *     "yes", "lint", "code",
 *     "yes", "code", "baby",
 *     "you", "baby", "chrome",
 *     "safari", "lint", "code",
 *     "body", "lint", "code"
 * ]
 * for k = 3, return ["code", "lint", "baby"].
 *
 * for k = 4, return ["code", "lint", "baby", "yes"],
 *
 * Challenge
 * Do it in O(nlogk) time and O(n) extra space.
 */


public class Solution {
    class Type {
        String word;
        int count;
        public Type(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if (words == null || words.length == 0) {
            return words;
        }
        if (k == 0) {
            return new String[]{};
        }
        Comparator<Type> cmp = new Comparator<Type>() {
            public int compare(Type a, Type b) {
                if (a.count != b.count) {
                    return a.count - b.count;
                } else {
                    return b.word.compareTo(a.word);
                }
            }
        };
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String str : words){
            if(map.containsKey(str)){
                map.put(str, map.get(str)+1);
            }else{
                map.put(str, 1);
            }
        }

        Queue<Type> heap = new PriorityQueue<Type>(k, cmp);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            Type element = new Type(entry.getKey(), entry.getValue());
            heap.offer(element);
            if(heap.size() > k){
                heap.poll();
            }
        }
        String[] res = new String[k--];
        while(!heap.isEmpty()){
            res[k--] = heap.poll().word;
        }
        return res;
    }
}