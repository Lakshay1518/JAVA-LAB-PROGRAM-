class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

// Father class
class Father {
    int age;

    public Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be less than 0");
        }
        this.age = age;
    }
}

// Son class inheriting from Father
class Son extends Father {
    int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge); // Call Father's constructor
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be less than 0");
        }
        if (sonAge >= fatherAge) {
            throw new IllegalArgumentException("Son's age cannot be greater than or equal to Father's age");
        }
        this.sonAge = sonAge;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Father father = new Father(40); // Valid age
            Son son = new Son(40, 20);      // Valid father and son ages

            System.out.println("Father's age: " + father.age);
            System.out.println("Son's age: " + son.sonAge);
        } catch (WrongAgeException e) {
            System.err.println("Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
