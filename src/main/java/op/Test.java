package op;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author jicai 2022-10-17
 */
public class Test {

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
        Field field1 = pointer.getClass().getDeclaredField("x");
        System.out.println(unsafe.objectFieldOffset(field1));
        Field field2 = pointer.getClass().getDeclaredField("y");
        System.out.println(unsafe.objectFieldOffset(field2));
        Field field10 = pointer.getClass().getDeclaredField("x7");
        System.out.println(unsafe.objectFieldOffset(field10));
        Field field9 = pointer.getClass().getDeclaredField("x6");
        System.out.println(unsafe.objectFieldOffset(field9));
        Field field8 = pointer.getClass().getDeclaredField("x5");
        System.out.println(unsafe.objectFieldOffset(field8));
        Field field7 = pointer.getClass().getDeclaredField("x4");
        System.out.println(unsafe.objectFieldOffset(field7));
        Field field6 = pointer.getClass().getDeclaredField("x3");
        System.out.println(unsafe.objectFieldOffset(field6));
        Field field5 = pointer.getClass().getDeclaredField("x2");
        System.out.println(unsafe.objectFieldOffset(field5));
        Field field4 = pointer.getClass().getDeclaredField("x1");
        System.out.println(unsafe.objectFieldOffset(field4));

        Field fieldy1 = pointer.getClass().getDeclaredField("y1");
        System.out.println(unsafe.objectFieldOffset(fieldy1));
        Field fieldy2 = pointer.getClass().getDeclaredField("y2");
        System.out.println(unsafe.objectFieldOffset(fieldy2));
        Field fieldy3 = pointer.getClass().getDeclaredField("y3");
        System.out.println(unsafe.objectFieldOffset(fieldy3));
        Field fieldy4 = pointer.getClass().getDeclaredField("y4");
        System.out.println(unsafe.objectFieldOffset(fieldy4));
        Field fieldy5 = pointer.getClass().getDeclaredField("y5");
        System.out.println(unsafe.objectFieldOffset(fieldy5));

    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

}
