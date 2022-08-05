package student_package;

public class Student {
    private String name="John";
    private String className = "C02";
    public Student (){
    }
    public void setName (String Name){
        this.name = Name;
    }
    public void setClassName(String className){
        this.className = className;
    }
    public String getName(){
        return this.name;
    }
    public String getClassName(){
        return this.className;
    }
}
