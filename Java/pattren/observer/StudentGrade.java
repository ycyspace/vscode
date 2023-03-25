package pattren.observer;

import java.util.HashSet;
import java.util.Set;

public class StudentGrade extends ObserveredSubject<StudentGrade>{
    private int chinese;
    private int math;
    private int english;
    private String id;
    public int getChinese() {
        return chinese;
    }
    public int getMath() {
        return math;
    }
    public int getEnglish() {
        return english;
    }
    public String getId() {
        return id;
    }
    public StudentGrade(int chinese, int math, int english, String id, String name) {
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Set<Observer<StudentGrade>> getObservers() {
        return observers;
    }
    private String name;
    {
        observers = new HashSet<>();
        subject = this;
    }
    public StudentGrade() {
        //TODO Auto-generated constructor stub
    }
    @Override
    void notifyAllObservers() {
        // TODO Auto-generated method stub
        for(Observer<StudentGrade> observer : observers){
            observer.update(this);
        }
    }
    
    public void setChinese(int chinese) {
        this.chinese = chinese;
        notifyAllObservers();
    }
    public void setMath(int math) {
        this.math = math;
        notifyAllObservers();
    }
    public void setEnglish(int english) {
        this.english = english;
        notifyAllObservers();
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }


    
}
