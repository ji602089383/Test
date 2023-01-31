package op;

import java.util.ArrayList;

/**
 * @author jicai 2023-01-11
 */
public class Paixu {

    public static void main(String[] args) {
//        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
//
//
//        for (int i = 0 ; i < array.length - 1;  i ++){
//            for (int j = 0; j < array.length - i -1; j ++){
//                int one = array[j];
//                int two = array[j + 1];
//                if(one > two){
//                    array[j] = two;
//                    array[j + 1] = one;
//                }
//            }
//        }
//
//        for (int i = 0 ; i < array.length;  i ++){
//            System.out.println(array[i]);
//        }

        ArrayList<A> arrayList = new ArrayList<>();
        arrayList.add(new B());
        arrayList.add(new C());
        for (int i = 0 ; i < arrayList.size(); i ++){

            System.out.println(arrayList.get(i).toString());
        }

        A a  = new A();
        System.out.println(a.a);

    }

}
