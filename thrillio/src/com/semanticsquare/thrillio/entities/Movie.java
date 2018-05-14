package com.semanticsquare.thrillio.entities;

import java.util.Arrays;

import com.semanticsquare.thrillio.constants.MovieGenre;

public class Movie extends Bookmark {

	private int releaseYear;
	private String title;
	private String[] cast;
	private String[] directors;
	private String genre;

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getCast() {
		return cast;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public String[] getDirectors() {
		return directors;
	}

	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getImbdRaiting() {
		return imbdRaiting;
	}

	public void setImbdRaiting(double imbdRaiting) {
		this.imbdRaiting = imbdRaiting;
	}

	private double imbdRaiting;

	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", title=" + title + ", cast=" + Arrays.toString(cast)
				+ ", directors=" + Arrays.toString(directors) + ", genre=" + genre + ", imbdRaiting=" + imbdRaiting
				+ "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if(genre.equals(MovieGenre.THRILLERS)||genre.equals(MovieGenre.GAY_AND_LESBIAN)||genre.equals(MovieGenre.FOREGIN_THRILLERS)||genre.equals(MovieGenre.HORROR)||genre.equals(MovieGenre.SPORTS_AND_FITNESS))
			return false;
		return true;
	}
}
