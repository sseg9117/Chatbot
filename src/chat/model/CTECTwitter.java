package chat.model;

import chat.controller.ChatbotController;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;



public class CTECTwitter
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.setAppController(appController);
		this.setChatbotTwitter(TwitterFactory.getSingleton());
		
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			chatbotTwitter.updateStatus(textToTweet + "@ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			appController.HandleError(tweetError);
		}
		catch(Exception otherError)
		{
			
			appController.HandleError(otherError);
		}
	}

	public ChatbotController getAppController()
	{
		return appController;
	}

	public void setAppController(ChatbotController appController)
	{
		this.appController = appController;
	}

	public Twitter getChatbotTwitter()
	{
		return chatbotTwitter;
	}

	public void setChatbotTwitter(Twitter chatbotTwitter)
	{
		this.chatbotTwitter = chatbotTwitter;
	}
}
