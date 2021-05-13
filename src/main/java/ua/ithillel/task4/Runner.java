package ua.ithillel.task4;

public class Runner {

    public void run() {

        MyTestClass myTestClass = new MyTestClass();
        myTestClass.test();
        System.out.println("________________________");

        MyTestClass.MyStaticNested staticNestedClass = new MyTestClass.MyStaticNested();
        staticNestedClass.show();
        System.out.println("________________________");

        MyTestClass.MyInner myInner = myTestClass.new MyInner();
        myInner.show();
        System.out.println("________________________");

        myTestClass.testLocalClass();

    }
}
