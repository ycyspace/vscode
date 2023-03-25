package pattren.observer;

public class Parent implements Observer<StudentGrade>{

    @Override
    public void subscribe(ObserveredSubject<StudentGrade> observeredSubject) {
        // TODO Auto-generated method stub
        observeredSubject.observers.add(this);
        
    }

    @Override
    public void unsubscribe(ObserveredSubject<StudentGrade> observeredSubject) {
        // TODO Auto-generated method stub
        observeredSubject.observers.remove(this);
        
    }

    @Override
    public void update(ObserveredSubject<StudentGrade> observeredSubject) {
        // TODO Auto-generated method stub
        System.out.println(String.format("家长订阅：语文成绩：%s,数学成绩：%s,英语成绩：%s", observeredSubject.subject.getChinese(),observeredSubject.subject.getMath(),observeredSubject.subject.getEnglish()));
        
    }
    
}
