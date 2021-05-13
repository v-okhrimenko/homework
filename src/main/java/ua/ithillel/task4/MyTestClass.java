package ua.ithillel.task4;

public class MyTestClass {

    private final int x = 1;
    private final int y = 2;

    public static class MyStaticNested {
        private static final int myStaticNestedX = 3;
        private static final int myStaticNestedY = 4;

        void show() {
            MyTestClass myTestClass = new MyTestClass();
            System.out.println("From MyStaticNested class:");
            System.out.println("Outer class variables " + myTestClass.x + " " + myTestClass.y);
            System.out.println("MyStaticNested class variables " + myStaticNestedX + " " + myStaticNestedY);

            MyTestClass.MyInner myInner = myTestClass.new MyInner();
            System.out.println("MyInner class variables " + myInner.myInnerX + " " + myInner.myInnerY);

            //local
        }
    }

    public class MyInner {
        private final int myInnerX = 5;
        private final int myInnerY = 6;

        void show() {
            System.out.println("From MyInner class:");
            System.out.println("Outer class variables " + x + " " + y);
            System.out.println("MyStaticNested class variables " + MyStaticNested.myStaticNestedX + " " + MyStaticNested.myStaticNestedY);
            System.out.println("MyInner class variables " + myInnerX + " " + myInnerY);

            //local

        }
    }

    public void testLocalClass() {
        class MyLocal {
            private final int myLocalX = 7;
            private final int myLocalY = 8;

            void show() {
                System.out.println("From MyLocal class:");
                System.out.println("Outer class variables " + MyTestClass.this.x + " " + MyTestClass.this.y);
                System.out.println("MyStaticNested class variables " + MyStaticNested.myStaticNestedX + " " + MyStaticNested.myStaticNestedY);

                MyTestClass.MyInner inner = new MyTestClass.MyInner();
                System.out.println("MyInner class variables " + inner.myInnerX + " " + inner.myInnerY);

                System.out.println("MyLocal class variables " + myLocalX + " " + myLocalY);
            }
        }
        MyLocal myLocal = new MyLocal();
        myLocal.show();

    }

    public void test() {
        System.out.println("Outer class variables " + MyTestClass.this.x + " " + MyTestClass.this.y);
        System.out.println("MyStaticNested class variables " + MyStaticNested.myStaticNestedX + " " + MyStaticNested.myStaticNestedY);

        MyTestClass.MyInner inner = new MyTestClass.MyInner();
        System.out.println("MyInner class variables " + inner.myInnerX + " " + inner.myInnerY);

        //local

    }
}
