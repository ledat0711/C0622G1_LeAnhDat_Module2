package candidate_package;

/*Bài 1:
Xây dựng lớp Candidate (Thí sinh) gồm các thuộc tính:
 mã, tên, ngày tháng năm sinh, điểm thi Toán, Văn, Anh
 và các phương thức cần thiết.

Xây dựng lớp TestCandidate để kiểm tra lớp trên:
– Nhập vào n thí sinh (n do người dùng nhập)
– In ra thông tin về các thí sinh có tổng điểm lớn hơn 15
*/
public class Candidate {
    private String studentID;
    private String name;
    private String dateOfBirth;
    private int mathScore;
    private int literatureScore;
    private int englishScore;
    private int sum = mathScore + literatureScore + englishScore;

    public Candidate() {
    }

    public void setiD(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfBirth() {
        return dateOfBirth;
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
        return englishScore;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
