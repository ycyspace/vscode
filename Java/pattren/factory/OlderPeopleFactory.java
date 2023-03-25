package pattren.factory;

public class OlderPeopleFactory implements AbstructPeopleFactory{

    @Override
    public People createPeople() {
        // TODO Auto-generated method stub
        return new OlderPeople();
    }
    
}
