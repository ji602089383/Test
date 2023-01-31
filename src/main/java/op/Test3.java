package op;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jicai 2022-12-20
 */
public class Test3 extends AbstractMap<Integer,Integer> {

    public Test3(){
        super();
    }

    @Override
    public Set<Entry<Integer, Integer>> entrySet() {
        HashSet<Entry<Integer, Integer>> hashSet = new HashSet();
        hashSet.add(new SimpleEntry<>( 1,1));
        hashSet.add(new SimpleEntry<>( 41,2));
        hashSet.add(new SimpleEntry<>( 31,3));
        hashSet.add(new SimpleEntry<>( 21,4));
        hashSet.add(new SimpleEntry<>( 21,5));
        return hashSet;
    }

}
