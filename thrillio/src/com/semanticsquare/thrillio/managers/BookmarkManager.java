package com.semanticsquare.thrillio.managers;

import java.net.MalformedURLException;

import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.WebLink;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {

	}

	public static BookmarkManager getInstance() {
		return instance;

	}

	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();

	}

	public void saveUserbookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);

		if(bookmark instanceof WebLink)
		{
			try { 
				String url = ((WebLink)bookmark).getUrl();
				if(!url.endsWith(".pdf")) {
						String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
									
				itry (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
					String line;
					int count = 0;
					while ((line = br.readLine()) != null) {
						data[count] = line;
						count++;
					}Ff(webpage != null) {
					IOUtil.write(webpage,bookmark.getId());
				}
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}
		
		
		
		dao.saveUserbookmark(userBookmark);
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre,
			double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;

	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imbdRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImbdRaiting(imbdRating);

		return movie;

	}

	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setHost(host);
		weblink.setUrl(url);

		return weblink;
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", Marked by: " + user.getEmail()
				+ " bookmark: " + bookmark.getTitle());

	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared: " + bookmark.getClass());

		if (bookmark instanceof Book) {
			System.out.println(((Book) bookmark).getItemData());
		} else if (bookmark instanceof WebLink) {
			System.out.println(((WebLink) bookmark).getItemData());
		}
		System.out.println("Shared by: " + user.getEmail());
	}

}
