package lambda_intro;

import java.util.ArrayList;
import java.util.List;

public class LambdaMain {
    public static void main(String[] args) {
        new Thread(new Lambda_intro()).start();
        new Thread(() -> System.out.println("Hi from the Runnable.")).start();
        new Thread(() -> {
            System.out.println("Hi from the Runnable.");
            System.out.println("LIne 2");
            System.out.format("This is line %d\n", 3);
        }).start();

//       >>>>>>>>>>>>>>>>>>>
//        Functional interfaces has exactly one abstract method
//        i.e. functional interface is lambda expression used with interface that contain only one method.

//        Note that instances of functional interfaces can be created with
//        lambda expressions, method references, or constructor references.
//        <<<<<<<<<<<<<<<<<<


        System.out.println("==============================");

        Employee justyna = new Employee("Justyna Łąk", 28);
        Employee robert = new Employee("Robert Prus", 32);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee snow = new Employee("Snow White", 23);

        List<Employee> employees = new ArrayList<>();
        employees.add(justyna);
        employees.add(robert);
        employees.add(tim);
        employees.add(snow);


//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
//      this is the same
//        Collections.sort(employees, Comparator.comparing(Employee::getName));

        System.out.println("\nThe employee variable is effectively final");
//        That's enhanced for loop
        for (Employee employee : employees) {
            System.out.println(employee.getName());
//            The employee variable is effectively final. Which mean, that for each iteration of the for loop, a new local variable is created
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

        System.out.println("\n***************************");
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

//        This is the same
        System.out.println("\n**********Another way of printing employee's names and ages");
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        String funnyText = doStringStuff(new UpperConcat() {
//                                             @Override
//                                             public String upperAndConcat(String s1, String s2) {
//                                                 return s1.toUpperCase() + s2.toUpperCase();
//                                             }
//                                         },
//                employees.get(0).getName(), employees.get(1).getName());
//        System.out.println("++++++++++++++\n" +
//                funnyText + "\n");

//        UpperConcat upperConcat = (String s1, String s2) -> (s1.toUpperCase() + s2.toUpperCase());

//        ==========================
//        UpperConcat upperConcat = (s1, s2) -> (s1.toUpperCase() + s2.toUpperCase());
//        String funnyNames = doStringStuff(upperConcat, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println("++++++++++++++\n" + funnyNames + "\n");
//
        UpperConcat upperConcat = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String funnyNames = doStringStuff(upperConcat, employees.get(0).getName(), employees.get(1).getName());
        System.out.println("++++++++++++++\n" + funnyNames + "\n");

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println("++++++>>>>>>1<<<<<<<++++++++\n" + s + "\n");

        String s2 = anotherClass.doSomething2();
        System.out.println("++++++>>>>>>2<<<<<<<++++++++\n" + s2 + "\n");

        String s3 = anotherClass.doSomething3();
        System.out.println("++++++>>>>>>3<<<<<<<++++++++\n" + s3 + "\n");

        String s4 = anotherClass.doSomething4();
        System.out.println("++++++>>>>>>4<<<<<<<++++++++\n" + s4 + "\n");

    }


    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}
