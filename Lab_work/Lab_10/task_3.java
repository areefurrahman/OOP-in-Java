class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal{
    public void sound(){
        System.out.println("The dog bark");
    }
}
public class task_3 {
    public static void main(String[] args) {
        Animal myaimal = new Animal();
        myaimal.sound();

        Dog myDog = new Dog();
        myDog.sound();
    }
}
