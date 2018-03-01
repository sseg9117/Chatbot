package chat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chat.controller.ChatbotController;
import chat.controller.IOController;
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
	private long totalWordCount;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.appController = appController;
		this.searchedTweets = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		this.totalWordCount = 0;
		
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
	
	public String getMostCommonWord(String username)
	{
		String mostCommon = "";
		
		collectTweets(username);
		turnStatusesToWords();
		totalWordCount = tweetedWords.size();
		
		return mostCommon;
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
	
	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchedTweets)
		{
			String tweetText = currentStatus.getText();
			String [] tweetWords = tweetText.split(" ");
			for(int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]).trim());
			}
		}
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"() {}^[]<>-";
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i))== -1)
			{
				scrubbedString += currentString.charAt(i);
			}		
		}
		return scrubbedString;
	}
	
	private String [] creaateIgnoredWordArray()
	{
		String [] boringWords;
		String fileText = IOController.loadFromFile(appController, " commonWords.txt");
		int wordCount = 0;
		
		Scanner wordScanner = new Scanner(fileText);
		
		while(wordScanner.hasNextLine())
		{
			wordScanner.nextLine();
			wordCount++;
		}
		
		boringWords = new String [wordCount];
		wordScanner.close();
		
		// Alternative file loading method
		// Uses the InputStream class
		// Notice the lack of try/catch
		
		wordScanner = new Scanner(this.getClass().getResourceAsStream("data/commonWords.txt"));
		for(int index=0; index < boringWords.length; index++)
		{
			boringWords[index] = wordScanner.nextLine();
		}
		wordScanner.close();
		return boringWords;
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

//	public String getMostCommonWord(String text)
//	{
//		String mostCommon = "";
//		
//		return mostCommon;
//	}
}
