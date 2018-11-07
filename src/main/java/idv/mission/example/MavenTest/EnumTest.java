package idv.mission.example.MavenTest;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(MyEnum.two.ordinal());
    }
}

enum MyEnum {
    one, two;
}