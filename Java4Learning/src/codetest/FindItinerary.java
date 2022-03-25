package codetest;

/*
Deduce Departure and Destination from tickets
Input:
"Chennai" -> "Banglore"
"Bombay" -> "Delhi"
"Goa"    -> "Chennai"
"Delhi"  -> "Goa"

Output: 
Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore
*/

import java.util.HashMap;
import java.util.Map;

public class FindItinerary {

	public static void main(String[] args) {
		System.out.println("**************Find Itinerary from a given list of tickets******************");
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");
 
        ticketFinal(dataSet);
        System.out.println("********************************");
	}

	private static void ticketFinal(Map<String, String> dataSet)
	{
	/*
	1) Create a HashMap of given pair of tickets.  Let the created 
	   HashMap be 'dataset'. Every entry of 'dataset' is of the form 
	   "from->to" like "Chennai" -> "Banglore"

	2) Find the starting point of itinerary.
	     a) Create a reverse HashMap.  Let the reverse be 'reverseMap'
	        Entries of 'reverseMap' are of the form "to->form". 
	        Following is 'reverseMap' for above example.
	        "Banglore"-> "Chennai" 
	        "Delhi"   -> "Bombay" 
	        "Chennai" -> "Goa"
	        "Goa"     ->  "Delhi"
	 
	     b) Traverse 'dataset'.  For every key of dataset, check if it
	        is there in 'reverseMap'.  If a key is not present, then we 
	        found the starting point. In the above example, "Bombay" is
	        starting point.

	3) Start from above found starting point and traverse the 'dataset' 
	   to print itinerary.
	All of the above steps require O(n) time so overall time complexity is O(n).
	Below is Java implementation of above idea.
	*/
		System.out.println(" dataSet: "+ dataSet);
		
		Map<String, String> reverseDataSet 	= new HashMap<String, String>();
		
		// To fill reverse map, iterate through the given map
		for(Map.Entry<String, String> entry: dataSet.entrySet())
		{
			reverseDataSet.put(entry.getValue(), entry.getKey());
		}
		System.out.println(" Reverse dataSet: "+ reverseDataSet);
		
		// Find the starting point of itinerary
		String startingPoint = null;
		for(Map.Entry<String, String> entry: dataSet.entrySet())
		{
			if(!reverseDataSet.containsKey(entry.getKey()))
			{
				startingPoint = entry.getKey();
				break;
			}
		}

		// If we could not find a starting point, then something wrong
        // with input
        if (startingPoint == null)
        {
           System.out.println("Invalid Input");
           return;
        }
        
        // Once we have starting point, we simple need to go next, next
        // of next using given hash map
        String targetPoint = dataSet.get(startingPoint);
        StringBuilder finalTicket = new StringBuilder();
        while (targetPoint!=null)
        {
        	finalTicket.append(startingPoint + " -> "+ targetPoint + " , ");
        	startingPoint = targetPoint;
        	targetPoint = dataSet.get(targetPoint);
        }
        System.out.println("Final Ticket "+ finalTicket);
        System.out.println(finalTicket.substring(0,finalTicket.toString().trim().length()-1));
		
	}
}
