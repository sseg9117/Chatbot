package chat.controller;
/**
 * Basic runner class for all things.
 * @author sseg9117
 */
public class ChatRunner
{
	/**
	 * Starts everything
	 * @param args  UNSED
	 */
	public static void main (String [] args)
	{
		ChatbotController myapp = new ChatbotController();
		myapp.start();
	}
}
