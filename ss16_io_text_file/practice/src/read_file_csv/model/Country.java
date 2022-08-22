package read_file_csv.model;

public class Country {
    public static int numericalOrder;
    private int iD;
    private String code;
    private String name;

    public Country() {
    }

    public Country(int iD, String code, String name) {
        this.iD = iD;
        this.code = code;
        this.name = name;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        ++numericalOrder;
        return "Country " + numericalOrder + " {" +
                "iD='" + iD + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
