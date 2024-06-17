//1. Create a class 'Animal' with a method 'sound'. Create subclasses 'Dog' and 'Cat' that override the
//'sound' method to print a dog bark and a cat meow respectively.
    class Animal1 {
         void sound(){
        System.out.println("Animal make sound");
    }
    static class Dog extends Animal1{
        @Override
        void sound()

        {
            System.out.println("Dog Bark");
        }
    }
    static class Cat extends Animal1{
        @Override
        void sound()

        {
            System.out.println("Cat Meow");
        }
    }
}
 class main{
    public static void main(String[] args) {
        Animal1 a=new Animal1();
        Animal1.Dog d=new Animal1.Dog();
        Animal1.Cat c=new Animal1.Cat();
        a.sound();
        d.sound();
        c.sound();
    }

}