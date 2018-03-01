package chat.controller;

import chat.model.CTECTwitter;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Sheradon Segota");
		myTwitter = new CTECTwitter(this);
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}

	public void start()
	{
		display.displayText("Welcome to Chatbot");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	} // updating belongs to the end of your while loop
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	public String useCheckers(String Text)
	{
		String response = "";
		
		if(chatbot.contentChecker(Text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(Text))
		{
			response += "";
		}
		if(chatbot.userNameChecker(Text))
		{
			response += "";
		}
		if(chatbot.shoppingListChecker(Text))
		{
			response += "";
		}
		if(chatbot.movieTitleChecker(Text))
		{
			response += "";
		}
		if(chatbot.movieGenreChecker(Text))
		{
			response += "";
		}
		return response;
	}

	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
//	
//	private String popupChat(String chat)
//	{
//		String chatbotSays = "";  //Assigns a valid value to a variable that will be returned for the method.
//		
//		chatbotSays += chatbot.processConversation(chat);
//		
//		return chatbotSays;
//	}

	public Object getChatbot()
	{
		return chatbot;
	}

	public Object getDisplay()
	{
		return display;
	}

	public Object getChatFrame()
	{
		return appFrame;
	}
	
	public void HandleError(Exception Error)
	{
		display.displayText(Error.getMessage());
	}
	
	public void sendTweet(String send)
	{
		
	}
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	
	public String search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
} 