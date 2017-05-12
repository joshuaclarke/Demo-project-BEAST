package core.IO;

/**
 * @author Rémi GIDON
 */
public class Parser {

	public static java.util.Map<String, String> parse(String msg) {
		System.out.println("Parser::parse parsing " + msg);
		org.json.JSONObject answerObject = new org.json.JSONObject(msg);
		java.util.Map<String, String> object = new java.util.WeakHashMap<>();
		object.put("event", String.valueOf(answerObject.get("event")));
		object.put("payload", String.valueOf(answerObject.get("payload")));
		object.put("answer", String.valueOf(answerObject.get("answer")));
		return object;
	}

}
