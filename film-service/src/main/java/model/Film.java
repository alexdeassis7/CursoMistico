package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query = "SELECT f FROM Film f")
public class Film implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfilm;
	
	private int duration;
	private String genre;
	private String name;
	private int year;
	private String director;
	private float rating;
	private String summary;
	private String urlimg;
	private String urltrailer;
	private String reviews;

	public Film() {
	}

	public int getIdfilm() {
		return idfilm;
	}

	public void setIdfilm(int idfilm) {
		this.idfilm = idfilm;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUrlimg() {
		return urlimg;
	}

	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

	public String getUrltrailer() {
		return urltrailer;
	}

	public void setUrltrailer(String urltrailer) {
		this.urltrailer = urltrailer;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	
}
