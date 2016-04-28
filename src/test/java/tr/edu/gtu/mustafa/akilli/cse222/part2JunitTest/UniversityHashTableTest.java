package tr.edu.gtu.mustafa.akilli.cse222.part2JunitTest;

import junit.framework.TestCase;
import tr.edu.gtu.mustafa.akilli.cse222.part2.UniversityHashTable;

/**
 * Created by MustafaMonster on 28.04.2016.
 */
public class UniversityHashTableTest extends TestCase {

    public void testEquals() throws Exception {
       /* UniversityHashTable */
        UniversityHashTable universityHashTable = new UniversityHashTable("data500.txt");
        boolean result;

        /* print screen equals */
        if(universityHashTable.equals(2093,8220) == true)
            result = true;

        else
            result = false;

        assertEquals(true, result);

        /* print screen equals */
        if(universityHashTable.equals(4589,9430) == true)
            result = true;

        else
            result = false;

        assertEquals(true, result);

        /* print screen equals */
        if(universityHashTable.equals(1453,6645) == true)
            result = true;

        else
            result = false;

        assertEquals(false, result);
    }
}