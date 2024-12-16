public class Magazine  extends LibraryItem{
    private int issueNumber;


    public Magazine(int id, String title, int publicationYear, int issueNumber) {
        super(id, title, publicationYear);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber=" + issueNumber +
                '}';
    }
}
