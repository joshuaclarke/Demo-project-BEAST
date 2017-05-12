package core.IO;

/** @author Rémi GIDON */
public class EventManager {

	public static void dispatch(String e) {
		
		java.util.Map<String, String> event = Parser.parse(e);
		
		switch (event.get("event")) {
		
		case "1":
			// smiley
			System.out.println("EventManager::dispatch - Answer for smiley with key (" 
								+ event.get("key")
								+ "): "
								+ event.get("answer"));
			break;
		
		case "2":
			// banner
			System.out.println("EventManager::dispatch - Answer for banner with key ("
								+ event.get("key")
								+ "): "
								+ event.get("answer"));
			break;
		
		case "3":
			// RPS
			System.out.println("EventManager::dispatch - Answer for RPS: "
								+ event.get("answer"));
			break;
		
		default:
			// ??
			System.out.println("EventManager::dispatch - Unknown event");
		}
	}

}
