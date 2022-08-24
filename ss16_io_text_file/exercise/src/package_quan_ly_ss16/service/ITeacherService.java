package package_quan_ly_ss16.service;

import java.io.IOException;

public interface ITeacherService {
    void addTeacher();

    void writeNewAndDisplayAllTeacher() throws IOException;

    void removeTeacher() throws IOException;

    void updateTeacher() throws IOException;

    void findTeacherByID();

    void printResultTeacherFoundByName();

    void sortTeacherByNameAscending() throws IOException;
}
