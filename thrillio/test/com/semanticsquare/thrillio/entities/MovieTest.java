package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {

		// Test 1:for genre HORROR - isKidFriendlyEligible should return False
		Bookmark bookmark = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		boolean isKidFriendlyEligible = bookmark.isKidFriendlyEligible();
		assertFalse("For Horror genre - isKidFriendlyEligible should return False", isKidFriendlyEligible);
		// Test 2: False
		bookmark = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.GAY_AND_LESBIAN,
				8.5);
		isKidFriendlyEligible = bookmark.isKidFriendlyEligible();
		assertFalse("for Gay_and_Lesbian genre - isKidFriendlyEligible should return False", isKidFriendlyEligible);
		// Test 3: for Foreign_Thrillers -isKidFriendlyEligible should return FALSE
		bookmark = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.FOREGIN_THRILLERS,
				8.5);
		isKidFriendlyEligible = bookmark.isKidFriendlyEligible();
		assertFalse("for genre Foreign_Thrillers -isKidFriendlyEligible should return FALSE\n" + 
				"", isKidFriendlyEligible);
		// Test 4: 
		bookmark = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		isKidFriendlyEligible = bookmark.isKidFriendlyEligible();
		assertFalse("for Thriller genre - isKidFriendlyEligible should return False", isKidFriendlyEligible);
		
		
		// Test 5:

	}

}
