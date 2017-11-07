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
		
		buildVerbs();
		buildShoppingList();
		buildMovieList();
		buildQuestions();
		buildCuteAnimals();
		getCurrentTime();
		buildChatbotResponse();
		

	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
	}
	
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
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protien");
		shoppingList.add("slug bait");
		shoppingList.add("gross things");
	}
	
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
		
	}
	
	public String processConversation(String input)
	
	{
		String chatbotResponse = "";
		chatbotResponse += "you said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	private String buildChatbotResponse()
	{
		String response ="I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".";
		
		random = (int) (Math.random() * questions.length);
		response += questions [random];
		
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
		return false;
	}
	
	public boolean userNameChecker(String currentinput)
	{
		boolean hasUsername = false;
		if(currentinput.indexOf(this.getUsername()) > -1);
			{
				hasUsername =true;
			}
		return hasUsername;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (String item: shoppingList)	
			
		if (shoppingItem i= null
		{
			return true;
		}
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{	
		if (exitString.equalsIgnoreCase("quit"))
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
		return null;
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
		return null;
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
