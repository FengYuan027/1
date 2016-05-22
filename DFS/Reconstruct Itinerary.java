public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).add(ticket[1]);
        }
        List<String> itinerary = new ArrayList<String>();
        visit("JFK", map, itinerary);
        Collections.reverse(itinerary);
        return itinerary;
    }
    
    private void visit(String city, HashMap<String, PriorityQueue<String>> map, List<String> itinerary) {
        if (map.containsKey(city)) {
            while (!map.get(city).isEmpty()) {
                visit(map.get(city).poll(), map, itinerary);
            }
        }
        itinerary.add(city);
    }
}
