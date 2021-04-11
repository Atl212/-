package 继承和多态;

import java.util.Scanner;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Atl212
 * @Date 2021/4/8 10:27
 * @Version 1.0
 **/
class Person {
    protected String name;
    protected int age;
    protected String gender; // true: male

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;

        if (gender) {
            this.gender = "Male";
        }
        else {
            this.gender = "Female";
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", name, gender, age);
    }
}

class Student extends Person {
    protected String stuID;
    protected int chinese;
    protected int math;
    protected int english;

    public Student(String name, int age, boolean gender,
                   String stuID, int chinese, int math, int english) {
        super(name, age, gender);

        this.stuID = stuID;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public double averagePoint(){
        return (math + chinese + english) * 1.0 / 3;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s",
                stuID, name, gender, age, averagePoint());
    }
}

class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student s[] = new Student[3];

        // s[0] = new Student("Alice", 20, false, "100", 90, 80, 70);
        // s[1] = new Student("Bob", 21, true, "101", 60, 70, 80);
        // s[2] = new Student("Carter", 22, true, "102", 90, 92, 100);
        for (int i = 0; i < s.length; ++i) {

            String name = sc.next();
            int age = sc.nextInt();
            boolean gender = sc.nextBoolean();

            String stuID = sc.next();
            int chinese = sc.nextInt();
            int math = sc.nextInt();
            int english = sc.nextInt();

            s[i] = new Student(name,age,gender,stuID,chinese,math,english);
        }
        sc.close();

        for (int i = 0; i < s.length; ++i) {
            System.out.println(s[i]);
        }
    }
}
