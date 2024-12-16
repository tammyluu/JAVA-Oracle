public class Person {
    private String fullName;
    private int phoneNumber;
    private int compter = 1;

    public Person (){
        this.compter = compter++;
    }
    
    public Person ( String fullName, int phoneNumber ){
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }
    public String getFullname () {
        return fullName;
    }
    public void setFullName (){
        this.fullName = fullName;
    }
    public int getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (){
        this.phoneNumber = phoneNumber;
    }


}