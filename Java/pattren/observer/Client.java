package pattren.observer;


public class Client {
    public static void main(String[] args) {
        StudentGrade studentGrade = new StudentGrade(77, 80, 71, "2023", "小明");
        MathTeacher mathTeacher = new MathTeacher();
        mathTeacher.subscribe(studentGrade);
        ChineseTeacher chineseTeacher = new ChineseTeacher();
        chineseTeacher.subscribe(studentGrade);
        Parent parent = new Parent();
        parent.subscribe(studentGrade);
        chineseTeacher.unsubscribe(studentGrade);
        // studentGrade.notifyAllObservers();
        studentGrade.setChinese(100);
    }
}
