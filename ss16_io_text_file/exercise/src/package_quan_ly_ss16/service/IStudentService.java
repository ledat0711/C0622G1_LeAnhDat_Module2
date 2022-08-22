package package_quan_ly_ss16.service;

public interface IStudentService {
    void addStudent() throws Exception;

    void displayAllStudent();

    void removeStudent();

    void updateStudent() throws Exception;

    void findStudentByID();

    void findStudentByName();

    void sortStudentByNameUseLambda1();

    void sortStudentByNameUseLambda2();

    void sortStudentByPointUseLambda1();

    void sortStudentByPointUseLambda2();
}
