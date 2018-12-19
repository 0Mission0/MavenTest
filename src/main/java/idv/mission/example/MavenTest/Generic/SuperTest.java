package idv.mission.example.MavenTest.Generic;

import java.util.ArrayList;

/**
 * https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
 * 下界通配符（Lower Bounds Wildcards）
 * <? super A> 只有可能是 <A>，向下相容的關係，可以放 A B C三種物件
 * <? super C> 有可能是 <A> <B> <C> 因為無法確定到底是哪種 ArrayList，所以只淮放C物件
 */
public class SuperTest {
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
        ArrayList<? super A> listAA = new ArrayList<A>();
        listAA.add(a);
        listAA.add(b);
        listAA.add(c);
        // listAA.add(q); // Error
    }

    public static void bTest(A a, B b, C c, Q q) {
        ArrayList<? super B> listBA = new ArrayList<A>();
        ArrayList<? super B> listBB = new ArrayList<B>();

        // listBA.add(a); // Error
        listBA.add(b);
        listBA.add(c);
        // listBA.add(q); // Error

        // listBB.add(a); // Error
        listBB.add(b);
        listBB.add(c);
        // listBB.add(q); // Error
    }

    public static void cTest(A a, B b, C c, Q q) {
        ArrayList<? super C> listCA = new ArrayList<A>();
        ArrayList<? super C> listCB = new ArrayList<B>();
        ArrayList<? super C> listCC = new ArrayList<C>();

        // listCA.add(a); // Error
        // listCA.add(b); // Error
        listCA.add(c);
        // listCA.add(q); // Error

        // listCB.add(a); // Error
        // listCB.add(b); // Error
        listCB.add(c);
        // listCB.add(q); // Error

        // listCC.add(a); // Error
        // listCC.add(b); // Error
        listCC.add(c);
        // listCC.add(q); // Error
    }

}
