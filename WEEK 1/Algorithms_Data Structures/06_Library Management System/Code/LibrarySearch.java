public class LibrarySearch {

    // checks every book one by one, works regardless of order
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    // needs books sorted alphabetically by title first
    public static Book binarySearchByTitle(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = books[mid].title.compareTo(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
