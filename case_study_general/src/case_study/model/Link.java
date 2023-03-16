package case_study.model;

public enum Link {
    PATH_CUSTOMER("src/case_study/data/customer.csv"),
    PATH_EMPLOYEE("src/case_study/data/employee.csv"),
    PATH_VILLA("src/case_study/data/villa.csv"),
    PATH_HOUSE("src/case_study/data/house.csv"),
    PATH_ROOM("src/case_study/data/room.csv"),
    PATH_BOOKING("src/case_study/data/booking.csv"),
    PATH_CONTRACT("src/case_study/data/contract.csv");

    private final String path;

    Link(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
