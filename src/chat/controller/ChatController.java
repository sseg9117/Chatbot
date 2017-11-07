package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;

public class ChatController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatController()
	{
		chatbot = new Chatbot("Sheradon Segota");
		display = new PopupDisplay();
	}

	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}// updating belongs to the end of your while loop
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";  //Assigns a valid value to a variable that will be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}

} 