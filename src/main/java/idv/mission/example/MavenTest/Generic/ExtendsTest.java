package idv.mission.example.MavenTest.Generic;

import java.util.ArrayList;

/**
 * https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
 * 
 * You can't add any object to List<? extends T> 
 * because you can't guarantee what kind of List it is really pointing to, 
 * so you can't guarantee that the object is allowed in that List. 
 * The only "guarantee" is that you can only read from it 
 * and you'll get a T or subclass of T.
 * 上界通配符（Upper Bounds Wildcards）
 * 因為沒辦法知道 <? extends T> 的，到底確切的是指哪個 class，所以絕對沒辦法直接add物件進該List
 */
public class ExtendsTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        Q q = new Q();
        aTest(a, b, c, q);
        bTest(a, b, c, q);
        cTest(a, b, c, q);
    }

    public static void aTest(A a, B b, C c, Q q) {
        ArrayList<? extends A> listAA = new ArrayList<A>();
        ArrayList<? extends A> listAB = new ArrayList<B>();
        ArrayList<? extends A> listAC = new ArrayList<C>();

        // listAA.add(a); // Error
        // listAA.add(b); // Error
        // listAA.add(c); // Error
        // listAA.add(q); // Error

        // listAB.add(a); // Error
        // listAB.add(b); // Error
        // listAB.add(c); // Error
        // listAB.add(q); // Error

        // listAC.add(a); // Error
        // listAC.add(b); // Error
        // listAC.add(c); // Error
        // listAC.add(q); // Error
    }

    public static void bTest(A a, B b, C c, Q q) {
        ArrayList<? extends B> listBB = new ArrayList<B>();
        ArrayList<? extends B> listBC = new ArrayList<C>();

        // listBB.add(a); // Error
        // listBB.add(b); // Error
        // listBB.add(c); // Error
        // listBB.add(q); // Error

        // listBC.add(a); // Error
        // listBC.add(b); // Error
        // listBC.add(c); // Error
        // listBC.add(q); // Error
    }

    public static void cTest(A a, B b, C c, Q q) {
        ArrayList<? extends C> listCC = new ArrayList<C>();
        // listCC.add(a); // Error
        // listCC.add(b); // Error
        // listCC.add(c); // Error
        // listCC.add(q); // Error
    }

}