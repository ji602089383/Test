package op;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author jicai 2022-10-17
 */
public class Test1 {

    //-XX:-RestrictContended
    public static void main(String[] args) throws Exception {
//        testPointer(new op.Pointer());
//        LongAdder longAdder = new LongAdder();
//        longAdder.add(1L);
        Pointer pointer = new Pointer();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 将字段的访问权限设置为true
        field.setAccessible(true);
        // 因为theUnsafe字段在Unsafe类中是一个静态字段，所以通过Field.get()获取字段值时，可以传null获取
        Unsafe unsafe = (Unsafe) field.get(null);
        Field field1 = pointer.getClass().getDeclaredField("x1");
        System.out.println(unsafe.objectFieldOffset(field1));
        Field field2 = pointer.getClass().getDeclaredField("x2");
        System.out.println(unsafe.objectFieldOffset(field2));

    }

}
