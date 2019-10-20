package lambda_intro;

class AnotherClass {
    String doSomething() {
        System.out.println("\nThe AnotherClas class's name is : " + getClass().getSimpleName());
        return LambdaMain.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The Anonymous class's name is : " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");
    }

    String doSomething2() {
        UpperConcat upperConcat = ((s1, s2) -> {
            System.out.println("The lambda expression's class is : " + getClass().getSimpleName());
//            Lambda is treated like a nested block of code and it has the same scope as nested block
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        });

        System.out.println("\nThe AnotherClas class's name is : " + getClass().getSimpleName());
        return LambdaMain.doStringStuff(upperConcat, "String1", "String2");
    }

    String doSomething3() {
        final int i = 0;
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
//                    Q: Why local variable have to be declared as final when we use them within an anonymous class?
//                    Anw: Local variable needs to be final to be used in anonymous class
//                         because it does not belong to the anonymous class instance,
                    System.out.println("i (within anonymous class) =" + i);
                    return s1.toUpperCase() + s2.toUpperCase();
                }
            };
            System.out.println("\nThe AnotherClas class's name is : " + getClass().getSimpleName());
//            i++;
            System.out.println("i = " + i);
            return LambdaMain.doStringStuff(uc, "String1", "String2");
        }
    }

    String doSomething4() {
        int i = 0;

        UpperConcat upperConcat = (s1, s2) -> {
            System.out.println("The lambda expression's class is : " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("\nThe AnotherClas class's name is : " + getClass().getSimpleName());
        return LambdaMain.doStringStuff(upperConcat, "String1", "String2");

    }
}
