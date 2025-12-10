package pr28zad4;

import java.util.Hashtable;
import java.util.Map;

public class StudentTest {
    public static void main(String[] args) {
        Map<String, Student> map = new Hashtable<>();
        Student st = new Student(0, "Alex", 18);
        map.put("Alex", st);
        System.out.println(map.get("Alex"));
        System.out.println(map.get("A1" + "ex"));
        System.out.println(map.get(st.getName()));

        String s = "a";
        s = s.toUpperCase() + "lex";
        System.out.println(map.get(s));
    }
}
