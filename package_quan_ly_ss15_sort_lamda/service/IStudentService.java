package package_quan_ly_ss15.service;

public interface IStudentService {
    void addStudent() throws Exception;

    void displayAllStudent();

    void removeStudent();

    void updateStudent() throws Exception;

    void findStudentByID();

    void findStudentByName();

    void sortStudentByName();
}
