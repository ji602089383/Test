package op;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;
import sun.rmi.runtime.Log;

/**
 * @author jicai 2022-12-20
 */
public class Test4 {

    public static void main(String[] args) {
//        HashMap<Integer, Integer> hashMap = new HashMap();
//        hashMap.put(1, null);
//        hashMap.putIfAbsent(1, 1);
//        for (int i = 1; i < 20; i ++){
//            hashMap.put(i,i);
//        }


//        System.out.println( 126 & 2 );
//        System.out.println( 123 & 1 );
//        System.out.println( 123 & 0 );

//        & 的特殊性是 什么数 & a 的结果都不会大于a

        ArrayList<String> arrayList = new ArrayList<>();
        int[] asd = new int[]{1,2,3,4};
        Arrays.parallelPrefix(asd, Integer::sum);
//        Arrays.parallelPrefix();
        double s2 = Math.log10(8) / Math.log10(2);
        System.out.println(s2);
        LinkedList<String> linkedList = new LinkedList<>();
        // 任何数 & 0  都等于0
        // 任何数 ^ 0 都等于自己
//        System.out.println(123 ^ 0);

//        op.MyList test = new op.MyList();
//        op.MyList test3 = new op.MyList();
//        System.out.println( test3 == test);
//        System.out.println( test.equals(test3));

    }

}
