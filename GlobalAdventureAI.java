import java.util.*;

class TravelData {
    ArrayList<String> destinations;
    ArrayList<String> adventures;
    int costPerDay;

    TravelData(ArrayList<String> d, ArrayList<String> a, int cost) {
        destinations = d;
        adventures = a;
        costPerDay = cost;
    }
}

public class GlobalAdventureAI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------- HASHING (CO: Hashing Techniques) --------
        HashMap<String, TravelData> travelDB = new HashMap<>();

        travelDB.put("japan",
                new TravelData(
                        new ArrayList<>(Arrays.asList("Tokyo", "Kyoto", "Hokkaido", "Osaka")),
                        new ArrayList<>(Arrays.asList("Summit Mt. Fuji", "Mario Kart Street Racing", "Onsen Retreat",
                                "Robot Cafe Tour")),
                        200));

        travelDB.put("iceland",
                new TravelData(
                        new ArrayList<>(Arrays.asList("Reykjavík", "Vík", "Akureyri")),
                        new ArrayList<>(Arrays.asList("Northern Lights Chase", "Blue Lagoon Soak",
                                "Glacier Trekking", "Black Sand Beach Photo Ops")),
                        250));

        travelDB.put("peru",
                new TravelData(
                        new ArrayList<>(Arrays.asList("Cusco", "Lima", "Sacred Valley")),
                        new ArrayList<>(Arrays.asList("Machu Picchu Sunrise Hike", "Amazon Jungle Safari",
                                "Sandboarding in Huacachina")),
                        120));

        travelDB.put("italy",
                new TravelData(
                        new ArrayList<>(Arrays.asList("Rome", "Florence", "Amalfi Coast", "Venice")),
                        new ArrayList<>(Arrays.asList("Colosseum Underground Tour", "Pasta Making in Tuscany",
                                "Gondola Serenade")),
                        180));

        // -------- USER INPUT --------
        System.out.println("GLOBAL ADVENTURE AI TRAVEL PLANNER\n");

        System.out.print("Enter Country: ");
        String country = sc.nextLine().toLowerCase();

        System.out.print("Enter Travel Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Duration (Days): ");
        int duration = sc.nextInt();

        // -------- SEARCHING (CO: Searching Algorithms) --------
        TravelData data = travelDB.get(country);

        if (data == null) {
            data = new TravelData(
                    new ArrayList<>(Arrays.asList("Capital City", "Coastal Region", "Mountain Highlands")),
                    new ArrayList<>(Arrays.asList("Local Food Tour", "Hidden Landmark Hike", "Sunset Viewing")),
                    150);
        }

        // -------- BUDGET CALCULATION --------
        int budget = data.costPerDay * duration;

        System.out.println("\n--- TRAVEL META INFO ---");
        System.out.println("Weather: 22°C Typical");
        System.out.println("Estimated Budget: $" + budget);
        System.out.println("Season: Adventure\n");

        // -------- QUEUE IMPLEMENTATION (CO: Queues) --------
        Queue<String> itinerary = new LinkedList<>();

        for (int i = 1; i <= duration; i++) {

            String dest = data.destinations.get(i % data.destinations.size());
            String adv = data.adventures.get(i % data.adventures.size());

            String dayPlan = "Day " + i + ": Explore " + dest +
                    "\nPrimary Adventure: " + adv +
                    "\nDetails: Experience the culture of " + dest +
                    " on " + date + "\n";

            itinerary.add(dayPlan);
        }

        // -------- DISPLAY ITINERARY --------
        System.out.println("------ TRAVEL ITINERARY ------\n");

        while (!itinerary.isEmpty()) {
            System.out.println(itinerary.remove());
        }

        sc.close();
    }
}