package core.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import core.exceptions.PythonIOError;

/** 
 * @author Rémi GIDON
 */
public class IO {

	public static BufferedReader inp;
	public static BufferedWriter out;
	private static boolean open = false;
	private static ArrayList<Callbackable<String>> callbacks;
	private static Thread listenerThread;
	private static Queue<String> eventQueue;
	private static boolean waiting;

	public static boolean connect() throws PythonIOError {
		try {
			System.out.println("Io::connect - Opening connection");
			Process p = Runtime.getRuntime().exec("python C:\\Users\\Josh\\Desktop\\src\\py\\java_io.py");
			inp = new BufferedReader(new InputStreamReader(p.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			callbacks = new ArrayList<>();
			open = true;
			eventQueue = new LinkedList<>();
			waiting = false;
			return true;
		} catch (IOException e) {
			open = false;
			throw new PythonIOError("[connect]");
		}
	}

	public static boolean close() throws PythonIOError {
		try {
			if (!open)
				return false;
			System.out.println("Io::close - Closing connection");
			stopListening();
			inp.close();
			out.close();
			open = false;
			waiting = false;
			eventQueue.clear();
			return true;
		} catch (IOException e) {
			open = true;
			stopListening();
			throw new PythonIOError("[close]");
		}
	}

	public static void send(String msg) throws PythonIOError {
		System.out.println("Io::send - User wishes to send: " + msg);
		addToQueue(msg);
	}

	private static void addToQueue(String msg) {

		if (waiting) {
			System.out.println("Io::addToQueue - Waiting for an answer. Pushing message to queue : " + msg);
			// waiting for an answer
			eventQueue.add(msg);
		} else {
			if (eventQueue.size() > 0) {
				System.out.println("Io::addToQueue - Sending next message in queue : " + msg);
				eventQueue.add(msg);
				sendMessage(eventQueue.remove());
			} else {
				System.out.println("Io::addToQueue - Queue is empty. Sending : " + msg);
				sendMessage(msg);
			}
		}
	}

	private static void updateQueue() {
		System.out.println("Io::updateQueue - Updating...");
		waiting = false;
		if (eventQueue.size() > 0) {
			String msg = eventQueue.remove();
			System.out.println("Io::updateQueue - Sending next message in queue : " + msg);
			sendMessage(msg);
		} else {
			System.out.println("Io::updateQueue - No more messages to send. No longer listening");
			stopListening();
		}
	}

	private static void sendMessage(String msg) {
		System.out.println("Io::sendMessage - Sending: " + msg);
		try {
			waiting = true;
			out.write(msg + "\n");
//			out.flush();
			startListening();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void listen(Callbackable<String> function) {
		System.out.println("Io::listen - Adding a new listener");
		callbacks.add(function);
	}

	private static void startListening() {
		System.out.println("Io::startListening - Begin listening for an answer");
		IO.listenerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				String answer = null;
				try {
					while (answer == null) {
						System.out.println("Io::startListening[listenerThread] - Waiting for buffer...");
						Thread.sleep(100);
						if (inp.ready() == false)
							continue;
						answer = inp.readLine();
					}
					System.out.println("Io::startListening[listenerThread] - Received an answer: " + answer);
					applyListeners(answer);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		IO.listenerThread.start();
	}

	@SuppressWarnings("deprecation")
	private static void stopListening() {
		System.out.println("Io::stopListening - No longer listening for an answer");
		if (listenerThread != null)
			listenerThread.stop();
		listenerThread = null;
	}

	private static void applyListeners(String msg) {
		System.out.println("Io::applyListeners - Applying listeners (" + callbacks.size() + ")");
		for (Callbackable<String> c : callbacks)
			c.call(msg);
		updateQueue();
	}

	@Deprecated
	public static String pipe(String msg) throws PythonIOError {

		try {
			out.write(msg + "\n");
			out.flush();
			return IO.get();
		} catch (IOException e) {
			throw new PythonIOError("[pipe]");
		}

	}

	@Deprecated
	public static String get() throws PythonIOError {
		try {
			String answer;
			while (!inp.ready()) {
				continue;
			}
			do {
				answer = inp.readLine();
			} while (answer == null);
			return answer;
		} catch (IOException e) {
			throw new PythonIOError("[get]");
		}
	}

}
