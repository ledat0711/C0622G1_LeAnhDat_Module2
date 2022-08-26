package package_quan_ly_ss19.service;

import java.io.IOException;

public interface IStudentService {
    void addStudent() throws Exception;

    void writeNewAndDisplayAllStudent() throws IOException;

    void removeStudent() throws IOException;

    void updateStudent() throws Exception;

    void findStudentByID();

    void findStudentByName();

    void sortStudentByNameUseLambda1() throws IOException;

    void sortStudentByNameUseLambda2() throws IOException;

    void sortStudentByPointUseLambda1() throws IOException;

    void sortStudentByPointUseLambda2() throws IOException;
}
