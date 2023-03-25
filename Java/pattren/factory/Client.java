package pattren.factory;

public class Client {
    
        People people;
        
        public Client(AbstructPeopleFactory abstructPeopleFactory) {
            people = abstructPeopleFactory.createPeople();
        }
        public static void main(String[] args) {
            Client client = new Client(new OlderPeopleFactory());
            client.people.eat();
            client.people.sleep();
        }
    
}
