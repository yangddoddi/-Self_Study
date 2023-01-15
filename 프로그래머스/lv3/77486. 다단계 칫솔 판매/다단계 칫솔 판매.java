import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Person> map = new HashMap<>();
        List<Person> persons = new ArrayList<>();
        
        for (int i=0; i<enroll.length; i++) {
            Person p = new Person(i, enroll[i]);
            map.put(enroll[i], p);
            persons.add(p);
        }
        
        for (int i=0; i<referral.length; i++) {
            if (referral[i].equals("-")) continue;
            persons.get(i).setReferral(map.get(referral[i]));
        }
        
        for (int i=0; i<seller.length; i++) {
            String s = seller[i];
            int a = amount[i];
            
            map.get(s).addAmount(a * 100);
        }
        
        int[] answers = new int[enroll.length];
        for (int i=0; i<persons.size(); i++) {
            answers[i] = persons.get(i).amount;
        }
        
        return answers;
    }
    
    class Person {
        int idx;
        int amount = 0;
        String name;
        Person referral;
        
        public Person(int idx, String name) {
            this.idx = idx;
            this.name = name;
        }
        
        public void addAmount(int amount) {            
            if (amount * 0.1 < 1) {
                this.amount += (int)amount;
                return;
            }
            
            int remaning = (int)(amount * 0.1);
            amount = amount - remaning;
            
            if (this.referral == null) { 
                this.amount += (int)(amount);
                return;
            }
            

            referral.addAmount(remaning);
            this.amount += (int)(amount);
        }
        
        public void setReferral(Person referral) {
            this.referral = referral;
        }
    }
}