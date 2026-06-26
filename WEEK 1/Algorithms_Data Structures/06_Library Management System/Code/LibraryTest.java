public class LibraryTest {

	public static void main(String[] args) {

		// unsorted catalog, used for linear search
		Book[] unsorted = {
			new Book(3, "The Hobbit", "J.R.R. Tolkien"),
			new Book(1, "Clean Code", "Robert Martin"),
			new Book(4, "1984", "George Orwell"),
			new Book(2, "Atomic Habits", "James Clear")
		};

		// same books sorted alphabetically by title, needed for binary search
		Book[] sorted = {
			new Book(4, "1984", "George Orwell"),
			new Book(2, "Atomic Habits", "James Clear"),
			new Book(1, "Clean Code", "Robert Martin"),
			new Book(3, "The Hobbit", "J.R.R. Tolkien")
		};

		Book result1 = LibrarySearch.linearSearchByTitle(unsorted, "1984");
		System.out.println("Linear search result: " + result1);

		Book result2 = LibrarySearch.binarySearchByTitle(sorted, "Clean Code");
		System.out.println("Binary search result: " + result2);

		Book result3 = LibrarySearch.binarySearchByTitle(sorted, "Dune");
		System.out.println("Binary search result: " + result3);
	}
}
