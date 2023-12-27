package library;

import book.AnyBook;

public class LibraryManagement {

	// LibraryManagement that manages library's methods.
	// Searches for the queries.
	private Library library;
	public LibraryManagement() {
		library = new Library();
		library.initializeLibrary();
	}
	
	public void queries() {
		// method that answers all the queries.
		library.printAllBooks();
		AnyBook historyOfArt = library.searchBook("History of Art", "book");
		AnyBook animalFarm = library.searchBook("Animal Farm");
		
		System.out.println();
		if(historyOfArt != null) {
			System.out.print("Exists. ");
			library.print(historyOfArt);
		}else
			System.out.println("Does not exist.");
		if(animalFarm != null) {
			System.out.print("Exists. ");
			library.print(animalFarm);
		}else
			System.out.println("Does not exist.");
		
	}
}
