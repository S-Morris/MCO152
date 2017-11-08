import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
//Authors Reuven Markov and Shmuel Morris
public class LinkedListListInterfaceTests {
    LinkedList<Integer> list, list2;
    @Before
    public void setUpLinkedList(){
        list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list2 = new LinkedList<>();

    }

    @Test
    public void containsAllTestWithFullLists(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(2);
        testList.add(5);
        testList.add(3);

        boolean containsAll = list.containsAll(testList);

        assertThat(containsAll, is(true));

    }
    @Test
    public void containsAllTestWithEmptyLists(){
        LinkedList<Integer> testList = new LinkedList<>();

        boolean containsAll = list2.containsAll(testList);

        assertThat(containsAll, is(true));

    }

    @Test
    public void containsAllTestOnFullFromEmpty(){
        LinkedList<Integer> testList = new LinkedList<>();

        boolean containsAll = list.containsAll(testList);

        assertThat(containsAll, is(true));

    }
    @Test
    public void containsAllTestWithStuff(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(2);
        testList.add(5);
        testList.add(3);

        boolean containsAll = list2.containsAll(testList);

        assertThat(containsAll, is(false));

    }
    @Test
    public void equalsRIGHT(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        assertThat(list.equals(testList), is(true));
    }
    @Test
    public void testIfNullsEqual(){
        LinkedList<Integer> testList1 = new LinkedList<>();
        LinkedList<Integer> testList2 = new LinkedList<>();
        testList1.add(null);
        testList2.add(null);

        assertThat(testList1.equals(testList2), is(true));

    }
    @Test
    public void hashcodeRIGHT(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        assertThat(testList.hashCode(), is(equalTo(list.hashCode())));
    }
    @Test
    public void hashcodeTestWrongOrder(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        testList.add(3);
        testList.add(5);
        assertThat(testList.hashCode(), is(not(equalTo(list.hashCode()))));
    }

    @Test
    public void isEmptyTestWithEmpty(){
        assertThat(list2.isEmpty(), is(true));
    }

    @Test
    public void isEmptyTestWithNonEmpty(){
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void isEmptyTestWithNull(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(null);
        assertThat(testList.isEmpty(), is(false));
    }
    @Test
    public void iteratorEmptyCollectionHasNextFalse(){
        Iterator testIter = list2.iterator();

        assertThat(testIter.hasNext(),is(false));

    }
    @Test (expected = NoSuchElementException.class)
    public void iteratorEmptyCollectionNext(){
        Iterator testIter = list2.iterator();
        testIter.next();
    }

    @Test
    public void listIteratorEmptyCollectionHasNextFalse(){
        ListIterator testListIter = list2.listIterator();

        assertThat(testListIter.hasNext(), is(false));
    }
    @Test (expected = NoSuchElementException.class)
    public void listIteratorEmptyCollectionNext(){
        ListIterator testListIter = list2.listIterator();
        testListIter.next();
    }
    @Test
    public void removeAllRIGHT(){
       boolean isEmpty = list.removeAll(list);

       assertThat(list.size(), is(0));
    }
    @Test (expected = NullPointerException.class)
    public void removeAllFromNullList(){
            LinkedList<Integer> testList = null;

            testList.removeAll(testList);
    }
    @Test
    public void retainAllRIGHT(){
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(2);
        testList.add(3);
        testList.add(4);
        list.retainAll(testList);
        assertThat(list.containsAll(testList), is(true));
    }
    @Test
    public void retainAllTestIfRemoved(){

        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(2);
        testList.add(3);
        testList.add(4);
        list.retainAll(testList);
        assertThat(list.contains(1), is(false));

    }

    @Test
    public void sublistRIGHT(){

        list.subList(1,3).clear();

        assertThat(list.size(), is(3));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void sublistTestForOutOfBounds(){
        list.subList(-1,3);

    }
}

