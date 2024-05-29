public class Mytest{
    public static void main(String args[]){
        A a = new A();
        System.out.println(a.i);
        a.print();

        B b = new B();
        System.out.println(b.i);
        b.print();

        A c = new B();
        System.out.println(c.i);
        c.print();
    }
}
class A{
    int i = 10;
    void print(){
        System.out.println("I am Father!");
    }
}
class B extends A{
    int i = 100;
    void print(){
        System.out.println("I am Child");
    }
}