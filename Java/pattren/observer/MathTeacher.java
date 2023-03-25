package pattren.observer;

public class MathTeacher implements Observer<StudentGrade> {

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
        System.out.println(String.format("数学老师订阅：学号：%s, 姓名：%s, 数学成绩：%d", observeredSubject.subject.getId(),
                observeredSubject.subject.getName(), observeredSubject.subject.getMath()));
    }

}
