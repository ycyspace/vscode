package pattren.observer;

public class ChineseTeacher implements Observer<StudentGrade> {

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
        System.out.println(String.format("语文老师订阅：姓名：%s,学号：%s,语文成绩：%s", observeredSubject.subject.getName(),
                observeredSubject.subject.getId(), observeredSubject.subject.getChinese()));
    }

}
