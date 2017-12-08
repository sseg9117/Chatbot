package chat.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String username;
	private String content;
	private String intro;
	private String [] questions;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.username = username;
		this.intro = null;
		this.currentTime = null;
		this.questions = new String [10];
		this.content = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		this.currentTime = LocalTime.now();
		/**
		 * this is all the things initialized
		 */
		buildVerbs();
		buildShoppingList();
		buildMovieList();
		buildQuestions();
		buildCuteAnimals();
		getCurrentTime();
		buildChatbotResponse();
		

	}
	/**
	 * this builds the verb list
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
	}
	/**
	 * this builds the movie list
	 */
	private void buildMovieList()
	{
		
		new Movie("Star Wars");
		new Movie("21 Jump Street");
		new Movie("Hidden Figures");
		new Movie("Pirates of the Caribbean");
		new Movie("Spider Man");
		
		movieList.add(new Movie("Star Wars"));
		movieList.add(new Movie("21 Jump Street"));
		movieList.add(new Movie("Hidden Figures"));
		movieList.add(new Movie("Pirates of the Caribbean"));
		movieList.add(new Movie("Spider Man"));
	}
	/**
	 * this builds the shopping list
	 */
	private void buildShoppingList()
	{
		shoppingList.add("protein");
		shoppingList.add("snacks");
		shoppingList.add("veggies");
	}
	/**
	 * this builds the cute animal list
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("floofer");
		cuteAnimalMemes.add("puppy");
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What do you want to eat/";
		questions[2] = "What is your favorite color?";
		questions[3] = "Who is your favorite animal?";
		questions[4] = "What is your favorite movie?";
		questions[5] = "What is your favorite food?";
		questions[6] = "What is the name of your faviorte tv actor";
		questions[7] = "Have you ever done bad things";
		questions[8] = "Why are you not cool?";
		questions[9] = "Do you eat people?";
	}
	/**
	 * Builds the Chatbot's topics array
	 */
	/**
	 * takes user text input and processes it and returns a string, and combines user in and chatbot string into one string and returns it.
	 * @param input User supplied text.
	 * @return Combined user input and chatbot response. 
	 */
	public String processConversation(String input)
	
	{
		String chatbotResponse = "";
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "you said: " + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	/**
	 * building a random response from using the chatbot's sentence part arrays.
	 * @return the random response of the chatbot.
	 */
	private String buildChatbotResponse()
	{
		String response ="I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".";
		
		random = (int) (Math.random() * questions.length);
		response += questions [random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a greate movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)// We will never use this
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		
		return response;
	
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length()> 2) 
		{
			validLength = true;
		}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		input.equals(input.toUpperCase());
//		if (input.contains("<") && input.indexOf("<") < input.indexOf(">"))
//		{
//			String tag = input.substring(input.indexOf("<"), input.indexOf(">"));
//			if (input.indexOf(tag) < input.lastIndexOf(tag))
//			{
//				return true;
//			}
//		}
		if (input.contains("<P>") || input.contains("<BR>"))
		{
			return true;
		}
		if (input.contains("HREF") && !input.contains("="))
		{
			return false;
		}
		if (input.indexOf(">") < input.lastIndexOf(">") && input.indexOf("<") < input.lastIndexOf("<"))
		{
			return true;
		}
		return false;
	}
	
	public boolean userNameChecker(String currentinput)
	{
		if(currentinput == null || currentinput.length() == 0 || !currentinput.substring(0, 1).equals("@"))
		{
			return false;
		}
		for(int i = 1; i < currentinput.length(); i++)
		{
			if(currentinput.substring(i, i + 1).equals("@"))
			{
				return false;
			}
		}
		return true;
	}
	
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		for(String item : cuteAnimalMemes)
		{
			if(input.toLowerCase().contains(item)) 
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (String item: shoppingList)	
		{		
			if (shoppingItem.indexOf(item) >= 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		if(genre.toLowerCase().equals("documentary") || genre.toLowerCase().equals("thriller"))
		{
			return true;
		}
		return false;
	}

	public boolean quitChecker(String exitString)
	{	
//		if(exitString.equalsIgnoreCase("null"))
//		{
//			return false;
//		}
		if (exitString !=null && exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}

		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
