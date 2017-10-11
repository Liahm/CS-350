import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MergeSortTest {
    @Test
    public void testInOrder() //Test that it sorts
    {
        MergeSort A = new MergeSort();
        Integer [] TestArray = new Integer[] {1,3,2};
        Integer [] CorrectArray = new Integer[] {1,2,3};
        MergeSort.mergeSort(TestArray);
        assertTrue(CompareArrays(TestArray, CorrectArray));
    }

    private boolean CompareArrays(Integer[] testArray, Integer[] correctArray) {
        boolean b = true;
        if (testArray != null && correctArray != null){
            if (testArray.length != correctArray.length){
                b = false;
            } else {
                for (int i = 0; i < correctArray.length; i++) {
                    if (testArray[i] != correctArray[i]) {
                        b = false;
                    }
                }
            }
        }else{
            b = false;
        }
        return b;
    }

    @Test
    public void testNotOrder() //Negative test
    {
        Integer [] TestArray = new Integer[] {1,2,3,4,5};
        Integer [] CorrectArray = new Integer[] {1,3,2,4,5};
        MergeSort.mergeSort(TestArray);
        assertTrue(!CompareArrays(TestArray, CorrectArray));
    }


}
