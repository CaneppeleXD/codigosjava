public class PlayingWithObjects {
    public static void main(String[] args) {
        PlayingWithObjects program = new PlayingWithObjects();
        program.run();
    }

    public void run(){
        Person p1 = new Person("jake");
        Person p2 = p1;
        p2 = new Person("johnny");
        System.out.println(p1.name);
    }

    public class Person{
        String name;
        
        public Person(String name){
            this.name = name;
        }
    }
}
