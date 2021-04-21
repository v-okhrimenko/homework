import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCollectionTest {

    private StringCollectionObject stringCollectionObject;
    private final String sb = "Test string ";


    @Before
    public void setUp() {
        stringCollectionObject = new StringCollectionObject();
    }

    private StringCollectionObject fillStringCollection() {
        StringCollectionObject scO = new StringCollectionObject();
        for (int i = 0; i < 10; i++) {
            scO.add(sb + i);
        }
        return scO;
    }

    @Test
    public void addObjectTest() {
        int startIndex = 0;
        for (int i = 0; i < 100; i++) {
            assertTrue(stringCollectionObject.add(sb + i));
            assertFalse(stringCollectionObject.add(null));
            assertFalse(stringCollectionObject.add(1));
            assertTrue(stringCollectionObject.contain(sb + i));
            assertEquals(stringCollectionObject.size(), ++startIndex);
        }
    }

    @Test
    public void addObjectPositionTest() {
        int startIndex = 0;
        for (int i = 0; i < 100; i++) {
            assertTrue(stringCollectionObject.add(i, sb + i));
            assertFalse(stringCollectionObject.add(i, null));
            assertFalse(stringCollectionObject.add(i, 1));
            assertTrue(stringCollectionObject.contain(sb + i));
            assertEquals(stringCollectionObject.size(), ++startIndex);
        }
    }

    @Test
    public void containTest() {
        stringCollectionObject = fillStringCollection();
        assertTrue(stringCollectionObject.delete("Test string 3"));
        assertFalse(stringCollectionObject.contain("Test string 3"));
        assertTrue(stringCollectionObject.contain("Test string 2"));
        assertTrue(stringCollectionObject.contain("Test string 0"));
        assertFalse(stringCollectionObject.contain("Not this string"));
    }

    @Test
    public void deleteTest() {
        stringCollectionObject = fillStringCollection();
        assertFalse(stringCollectionObject.delete("not in list"));
        assertTrue(stringCollectionObject.delete(sb + 1));
        assertTrue(stringCollectionObject.delete(sb + 2));
        assertEquals(stringCollectionObject.size(), 8);
    }

    @Test
    public void getTest() {
        stringCollectionObject = fillStringCollection();
        assertEquals(sb + 1, stringCollectionObject.get(1));
        assertEquals(sb + 2, stringCollectionObject.get(2));
        assertEquals(sb + 3, stringCollectionObject.get(3));
        assertNull(stringCollectionObject.get(15));
    }

    @Test
    public void sizeTest() {
        stringCollectionObject = fillStringCollection();
        assertTrue(stringCollectionObject.delete(sb + 0));
        assertTrue(stringCollectionObject.delete(sb + 1));
        assertEquals(8, stringCollectionObject.size());
    }

    @Test
    public void clearTest() {
        stringCollectionObject = fillStringCollection();
        assertEquals(10, stringCollectionObject.size());
        assertTrue(stringCollectionObject.clear());
        assertEquals(0, stringCollectionObject.size());
    }

    @Test
    public void equalsTest() {
        stringCollectionObject = fillStringCollection();
        StringCollectionObject stringCollectionObject2 = fillStringCollection();
        StringCollectionObject stringCollectionObject3 = stringCollectionObject;

        assertFalse(stringCollectionObject.equals(stringCollectionObject2));
        assertTrue(stringCollectionObject.equals(stringCollectionObject3));
    }

    @Test
    public void addAll() {
        stringCollectionObject = new StringCollectionObject();
        String[] testStringArray = {"Kiev", "Odessa", "Lvov", "Kharkov", "Lutsk", "Poltava"};
        assertFalse(stringCollectionObject.addAll(null));
        assertTrue(stringCollectionObject.addAll(testStringArray));
        assertEquals(testStringArray.length, stringCollectionObject.size());

    }
}
