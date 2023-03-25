package pattren.factory;

public class YoungPeopleFactory implements AbstructPeopleFactory{

    @Override
    public People createPeople() {
        // TODO Auto-generated method stub
        return new YoungPeople();
    }
    
}
