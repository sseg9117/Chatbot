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
		this.title = "    ";
		this.genre = "G";
		this.ratingMPAA = "G";
		this.review = "This is the best movie evaar! XD";
		this.length = 120;
		this.releaseDate = releaseDate;
		this.starScore = 9.99;
		this.length = 10;
		this.setTitle(title);
		
	}

	public Movie(String string)
	{
		
	}
/**
 * gets all the contructures you initalized up top
 * @return sets them to what you want
 */
	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getRatingMPAA()
	{
		return ratingMPAA ;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return length;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
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
		this.ratingMPAA = "G";
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
		this.releaseDate = releaseDate;
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
