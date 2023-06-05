package pro.sky;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringListImpl s = new StringListImpl();
        StringListImpl s2 = new StringListImpl();
        fillBase(s);
        s.add("3");
        s.add("4");
        printStringList(s);


/*        fillBase(s);
//        fillBase(s2);
        System.out.println(s.remove("3"));
        printStringList(s);*/
//        StringListImpl s2 = s;
//        fillBase(s2);
//        s2.add("6");
/*        printStringList(s2);
        System.out.println(s2.equals(s));*/
//        printStringList(s2);
//        System.out.println(s2.equals(s));


/*        fillBase(s);
        System.out.println(s.isEmpty());*/
/*        fillBase(s);
        System.out.println(s.size());*/


//      Тестирование ArrayList
/*      List<String> al = new ArrayList<>();
      s.add("1");
      al.clear();
        System.out.println(al);
        System.out.println(al.size());*/




//       al.isEmpty();
/*        al.add(null);
        al.add("1");
        al.add(null);
        al.add("2");
        System.out.println(al.size());*/


/*        fillBase(s);
        printStringList(s);
        System.out.println(s.contains("8"));*/
//        printStringList(s);

/*        System.out.println(s.indexOf("5"));
        System.out.println(s.lastIndexOf("5"));*/

//      Тестирование remove (int index, String item)
/*      printStringList(s);
        s.remove(2);
        printStringList(s);*/


//      Тестирование метода (int index, String item)
/*        printStringList(s);
        System.out.println();
        s.add(3, "7");
        s.add(4, "8");
        printStringList(s);*/






//      Тестирование clear
/*        String[] test = s.toArray();
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
        System.out.println();
        s.clear();
        test = s.toArray();
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }*/

//      Метод вывод StringList на экран

    }

    public static void printStringList(StringListImpl s) {
//        test = s.toArray();
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
        System.out.println();
    }
    public static void fillBase (StringListImpl s) {
        s.add("1");
        s.add("3");
/*        s.add("2");
        s.add("4");
        s.add("5");
        s.add("6");*/
//        s.add(2, null);
//        s.set(3, null);
    }



}