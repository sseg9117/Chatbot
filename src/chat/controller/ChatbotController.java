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

	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
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
	public void showLennyMagic()
	{
		display.displayText("¯\\_(ツ)_/¯\nThis is shrug face");
		display.displayText("¯\\_(ツ)_/¯\nHe is my assistant");
		display.displayText("¯\\_(ツ)_/¯\nLet's make him disappear");
		display.displayText("━☆ﾟ.*･｡ﾟ¯\\_(ツ)_/¯\nLet's make him disappear.");
		display.displayText("━☆ﾟ.'･*ﾟ{･POOF.}\nLet's make him disappear.");
		display.displayText("\n");
		display.displayText("Where did he go?");
		display.displayText("✧･ﾟ: *✧･ﾟ:*¯\\_(ツ)_/¯*:･ﾟ✧*:･ﾟ✧\nABRACADABRA!");
		
	}
	public void showMovieMagic()
	{
		display.displayText("For my next trick think of a random two digit number.\nBe really paranoid about which number you choose because I can read your mind");
		display.displayText("Now let's make it more random\nThink of the sum of the two digits and subtract that from the original number to get a new number\n"
				+ "ie.\n42 is my number\n4 + 2 = 6\nSo I do 42 - 6 to get a new number");
		int randomIndex = (int) (Math.random() * chatbot.getMovieList().size());
		String theirMovie = chatbot.getMovieList().get(randomIndex).toString();
		//1st 50 movies
		String movies = "";
		for (int i = 1; i <= 50; i++)
		{
			if(i % 9 == 0)
			{
				movies += i + ". " + theirMovie + "\n";
			}
			else
			{
				randomIndex = (int) (Math.random() * chatbot.getMovieList().size());
				movies += i + ". " + chatbot.getMovieList().get(randomIndex).toString() + "\n";
			}
		}
		display.displayText("This is part 1 of a randomly generated list of movies \nIf your number is 1-50, find the one that corresponds to your new number\n" + movies);
		
		//2nd 50 movies
		movies = "";
		for (int i = 51; i <= 100; i++)
		{
			if(i % 9 == 0)
			{
				movies += i + ". " + theirMovie + "\n";
			}
			else
			{
				randomIndex = (int) (Math.random() * chatbot.getMovieList().size());
				movies += i + ". " + chatbot.getMovieList().get(randomIndex).toString() + "\n";
			}
		}
		display.displayText("This is part 2 of a randomly generated list of movies \nIf your number is 51-100, find the one that corresponds to your new number\n" + movies);
		display.displayText("I'm thinking...");
		display.displayText("I'm thinking really hard");
		display.displayText("Your movie was " + theirMovie);
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