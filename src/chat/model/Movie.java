package chat.model;

import java.time.LocalDate;

public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	public Movie(String title, String genre, String ratingMPAA, String review, int length, LocalDate releaseDate, double starScore)
	{
		this.title = "";
		this.genre = genre;
		this.ratingMPAA = ratingMPAA;
		this.review = "This is the best movie evaar! XD";
		this.length = 120;
		this.releaseDate = releaseDate;
		this.starScore = 9.99;
		this.setTitle(title);
		
	}

	public Movie(String string)
	{

	}

	public String getTitle()
	{
		this.title = "Title of movie";
		return title;
	}

	public String getGenre()
	{
		this.genre = "some genre";
		return genre;
	}

	public String getRatingMPAA()
	{
		this.ratingMPAA = "G";
		return ratingMPAA ;
	}

	public String getReview()
	{
		this.review = "This was very good";
		return review;
	}

	public int getLength()
	{
		this.length = 120;
		return length;
	}

	public LocalDate getReleaseDate()
	{
		return null;
	}

	public double getStarScore()
	{
		this.starScore = 9.99;
		return starScore;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
		
	}

	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
	}

	public void setReview(String review)
	{
		this.review = review;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = null;
	}

	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	public String toString()
	{
		String description = "Hi this is a movie";
		return description;
	}
}
