package chat.model;

import java.util.List;

import chat.controller.ChatbotController;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;



public class CTECTwitter
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	
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
	public void collectTweets(String username)
	{
		searchedTweets.clear();
		tweetedWords.clear();
		
		Paging statusPage = new Paging(1,100);
		int page = 1;
		long lastID = Long.MAX_VALUE;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			try
			{
				ResponseList<Status> listedTweets = chatbotTwitter.getUserTimeline(username, statusPage);
				for(Status current : listedTweets)
				{
					if(current.getId() < lastID)
					{
						searchedTweets.add(current);
						lastID = current.getId();
					}
				}
			}
			catch(TwitterException searchTweetError)
			{
				appController.HandleError(searchTweetError);
			}
			page++;
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

	public String getMostCommonWord(String text)
	{
		String mostCommon = "";
		
		return mostCommon;
	}
}
