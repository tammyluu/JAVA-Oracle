package selectivePackage;

public class House {
    private String houseName;
    private String houseType;

    public House(String houseName, String houseType) {
        this.houseName = houseName;
        this.houseType = houseType;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Override
    public String toString() {
        return "House{" + "houseName='" + houseName + '\'' + ", houseType='" + houseType + '\'' + '}';
    }
}
