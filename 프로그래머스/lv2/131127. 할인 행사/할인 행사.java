import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Cart cart = new Cart();
        cart.initialize(want, number);
        
        for (int i=0; i<discount.length; i++) {
            cart.add(discount[i]);
        }
        
        return cart.answer;
    }
    
    class Cart {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int limit = 10;
        int answer = 0;
        
        public void initialize(String[] want, int[] number) {
            for (int i=0; i<want.length; i++) {
                map.put(want[i], number[i]);
            }
        }
        
        public void add(String s) {
            resize();
            
            if (!map.containsKey(s)) {
                queue.add(s);
            } else {
                queue.add(s);
                map.put(s, map.get(s)-1);
            }
            
            checkAnswer();
        }
        
        public void checkAnswer() {
            if (map.entrySet()
                .stream()
                .map(e -> e.getValue())
                .filter(e -> e > 0)
                .count()
                == 0L) answer++;
        }
        
        public void resize() {
            if (queue.size() < limit) return;
            
            String s = queue.poll();
            if (map.containsKey(s)) { map.put(s, map.get(s) + 1);}
        }
    }
}