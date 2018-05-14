package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		
		//Test 1: if the genre is technical -- return false
		Bookmark bookmark = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.TECHNICAL, 4.3);
		boolean isKidFriendlyEligible = bookmark.isKidFriendlyEligible();
		assertFalse("for genre is TECHNICAL return false", isKidFriendlyEligible);
		
		//Test 2: if the genre is self-help -- return false
		bookmark = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
		isKidFriendlyEligible = bookmark.isKidFriendlyEligible();
		assertFalse("for genre is SELF_HELP return false", isKidFriendlyEligible);
		
		//Test 3: if genre is fiction return true
		bookmark = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.FICTION, 4.3);
		isKidFriendlyEligible = bookmark.isKidFriendlyEligible();
		assertTrue("for genre is FICTION return true", isKidFriendlyEligible);
		
		//Test 4:
		
		//Test 5:
		
	}

}
