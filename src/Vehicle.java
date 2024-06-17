//2. Create a class 'Vehicle' with a method 'fuel'. Implement subclasses 'Car' and 'Bike' that override
//the 'fuel' method to print the type of fuel used by them.
class vehiclecall{
    public static void main(String[] args) {
        car c=new car();
        byke b=new byke();
        c.fuel();
        b.fuel();
    }
}
class Vehicle {
    void fuel() {
        System.out.println("fuel");
    }
}
    class car extends Vehicle {
    @Override
        void fuel() {
            System.out.println("Car fuel");
        }
    }
        class byke extends Vehicle {
            @Override
            void fuel() {
                System.out.println("Byke fuel");
            }

        }

