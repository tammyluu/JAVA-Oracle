import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<LibraryItem> libraryItemList = new ArrayList<>();
    private List<BorrowRecord> borrowRecords = new ArrayList<>();
    public void  addLibraryItem(LibraryItem libraryItem) {
        libraryItemList.add(libraryItem);
        System.out.println(libraryItem.getDetail());

    }
    public void listAvailableItems() {
        System.out.println("List of available items: ");
        for (LibraryItem libraryItem : libraryItemList) {
            boolean isBorrowed = borrowRecords.stream().anyMatch(record -> record.getItemId() == libraryItem.getId());
            if (isBorrowed) {
                System.out.println(libraryItem.getDetail());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }


}