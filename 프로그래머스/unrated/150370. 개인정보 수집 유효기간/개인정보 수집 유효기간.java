import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Date todayDate = convert(today);
        Map<String, Integer> map = new HashMap<>();
        
        for (String t : terms) {
            String[] arr = t.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        List<Integer> answers = new ArrayList<>();
        int idx = 1;
        for (String p : privacies) {
            String[] arr = p.split(" ");
            String category = arr[1];
            Date prev = new Date(convert(arr[0]));
            Date curr = new Date(todayDate);
            
            curr.subtractDate(prev);
            
            if (curr.compareMonthTo(map.get(category)) >= 0) answers.add(idx);
                
            idx++;
        }
        
        return answers.stream()
            .sorted()
            .mapToInt(e -> e)
            .toArray();
    }
    
    private Date convert(String dateString) {
        String[] arr = dateString.split("\\.");
            
        Integer year = Integer.parseInt(arr[0]);
        Integer month = Integer.parseInt(arr[1]);
        Integer day = Integer.parseInt(arr[2]);
        
        return new Date(year, month, day);
    }
    
    class Date {
        Integer year;
        Integer month;
        Integer day;
        
        public Date(Integer year, Integer month, Integer day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        public Date(Date date) {
            this.year = date.year;
            this.month = date.month;
            this.day = date.day;
        }
        
        public Integer compareMonthTo(Integer num) {
            return (this.year * 12) + this.month - num + this.day / 28;
        }
        
        public void subtractDate(Date target) {
            subtractYear(target.year);
            subtractMonth(target.month);
            subtractDay(target.day);
        } 
        
        private void subtractYear(Integer num) {
            this.year -= num;
        }
        
        private void subtractMonth(Integer num) {
            if (this.month - num < 1) {
                this.year -= 1;
                num -= this.month;
                this.month = 12 - num;
            } else {
                this.month -= num;
            }
        }
        
        private void subtractDay(Integer num) {
            if (this.day - num < 1) {
                this.month -= 1;
                num -= this.day;
                this.day = 28 - num;
            } else {
                this.day -= num;
            }
        }
    }
}