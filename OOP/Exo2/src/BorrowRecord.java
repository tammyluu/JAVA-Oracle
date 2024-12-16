public class  BorrowRecord {
    private int itemId;
    private String borrowerName;
    private String borrowerDate;

    public BorrowRecord(int itemId, String borrowerName, String borrowerDate) {
        this.itemId = itemId;
        this.borrowerName = borrowerName;
        this.borrowerDate = borrowerDate;
    }

    public int getItemId() {
        return itemId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getBorrowerDate() {
        return borrowerDate;
    }
}
