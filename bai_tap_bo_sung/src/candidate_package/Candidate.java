/*Bài 1:
Xây dựng lớp Candidate (Thí sinh) gồm các thuộc tính:
 mã, tên, ngày tháng năm sinh, điểm thi Toán, Văn, Anh
 và các phương thức cần thiết.

Xây dựng lớp TestCandidate để kiểm tra lớp trên:
– Nhập vào n thí sinh (n do người dùng nhập)
– In ra thông tin về các thí sinh có tổng điểm lớn hơn 15
*/
package candidate_package;

public class Candidate {
    private String studentID;
    private String name;
    private String birthDay;
    private int mathScore;
    private int literatureScore;
    private int englishScore;

    public Candidate() {
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public void setLiteratureScore(int literatureScore) {
        this.literatureScore = literatureScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getLiteratureScore() {
        return literatureScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getSum() {
        return this.mathScore + this.literatureScore + this.englishScore;
    }
}
