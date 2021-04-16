import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCollectionTest {
    private StringCollectionObject stringCollectionObject;

    @Before
    public void initArray() {
        stringCollectionObject = new StringCollectionObject();
    }

    @Test
    public void addObject() {
        String sb = "Test string ";
        int startIndex = 0;
        for (int i = 0; i < 100; i++) {
            startIndex++;
            Assert.assertTrue(stringCollectionObject.add(sb + i));
            Assert.assertFalse(stringCollectionObject.add(null));
            Assert.assertFalse(stringCollectionObject.add(1));
            Assert.assertTrue(stringCollectionObject.contain(sb + i));
            Assert.assertEquals(stringCollectionObject.size(), startIndex);
        }
    }

    @Test
    public void addObjectPosition() {
        String sb = "Test string with index ";
        int startIndex = 0;
        for (int i = 0; i < 100; i++) {
            startIndex++;
            Assert.assertTrue(stringCollectionObject.add(i, sb + i));
            Assert.assertFalse(stringCollectionObject.add(i, null));
            Assert.assertFalse(stringCollectionObject.add(i, 1));
            Assert.assertTrue(stringCollectionObject.contain(sb + i));
            Assert.assertEquals(stringCollectionObject.size(), startIndex);
        }
    }

    @Test
    public void contain() {
        Assert.assertTrue(stringCollectionObject.add("Test string 0"));
        Assert.assertTrue(stringCollectionObject.add("Test string 1"));
        Assert.assertTrue(stringCollectionObject.add("Test string 2"));
        Assert.assertTrue(stringCollectionObject.add("Test string 3"));
        Assert.assertTrue(stringCollectionObject.add("Test string 4"));
        Assert.assertTrue(stringCollectionObject.delete("Test string 3"));
        Assert.assertTrue(stringCollectionObject.contain("Test string 2"));
        Assert.assertTrue(stringCollectionObject.contain("Test string 0"));
        Assert.assertFalse(stringCollectionObject.contain("Not this string"));
        Assert.assertFalse(stringCollectionObject.contain("Test string 3"));
    }

    @Test
    public void delete() {
        Assert.assertFalse(stringCollectionObject.delete("not in list"));
        String sb = "Test string ";
        int startIndex = 0;
        for (int i = 0; i < 10; i++) {
            startIndex++;
            Assert.assertTrue(stringCollectionObject.add(sb + i));
            Assert.assertEquals(stringCollectionObject.size(), startIndex);
        }

        for (int i = 0; i < 10; i++) {
            startIndex--;
            Assert.assertTrue(stringCollectionObject.delete(sb + i));
            Assert.assertEquals(stringCollectionObject.size(), startIndex);
        }
    }

    @Test
    public void get() {
        String sb = "Get string ";
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(stringCollectionObject.add(sb + i));
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(sb + i, stringCollectionObject.get(i));
        }
    }

    @Test
    public void size() {
        for (int i = 0; i < 8; i++) {
            Assert.assertTrue(stringCollectionObject.add(String.valueOf(i)));
        }
        Assert.assertTrue(stringCollectionObject.delete("1"));
        Assert.assertTrue(stringCollectionObject.delete("2"));
        Assert.assertEquals(6, stringCollectionObject.size());
    }

    @Test
    public void clear() {
        for (int i = 0; i < 15; i++) {
            Assert.assertTrue(stringCollectionObject.add(String.valueOf(i)));
        }
        Assert.assertEquals(15, stringCollectionObject.size());
        Assert.assertTrue(stringCollectionObject.clear());
        Assert.assertEquals(0, stringCollectionObject.size());
    }

    @Test
    public void equals() {
        stringCollectionObject.add("1");
        stringCollectionObject.add("2");
        stringCollectionObject.add("3");
        stringCollectionObject.add("4");
        stringCollectionObject.add("5");

        StringCollectionObject stringCollectionObject3 = stringCollectionObject;
        StringCollectionObject stringCollectionObject2 = new StringCollectionObject();
        stringCollectionObject2.add("1");
        stringCollectionObject2.add("2");
        stringCollectionObject2.add("3");
        stringCollectionObject2.add("4");
        stringCollectionObject2.add("5");

        Assert.assertFalse(stringCollectionObject.equals(stringCollectionObject2));
        Assert.assertTrue(stringCollectionObject.equals(stringCollectionObject3));
    }
}
