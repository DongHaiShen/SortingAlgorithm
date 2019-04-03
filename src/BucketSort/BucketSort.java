import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author sdh
 * @Date Created in 2019/4/3 14:11
 * @description
 */
public class BucketSort implements Sortable
{
    public int bucketRange = 100;

    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
        {
            return;
        }

        bucketSort(sourceArray);
    }

    /**
     * @param arr
     */
    public void bucketSort(int[] arr)
    {
        int max = arr[0], min = arr[0];

        for (int val : arr)
        {
            if (val > max)
            {
                max = val;
            }
            if (val < min)
            {
                min = val;
            }
        }

        int bucketCount = (max - min) / bucketRange + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++)
        {
            bucketArr.add(new ArrayList<Integer>());
        }

        int bucketIndex = 0;
        for (int val : arr)
        {
            bucketIndex = (val - min) / bucketRange;
            bucketArr.get(bucketIndex).add(val);
        }

        for (ArrayList<Integer> bucket : bucketArr)
        {
            Collections.sort(bucket);
        }

        int curIndex = 0;
        for (ArrayList<Integer> bucket : bucketArr)
        {
            if (bucket.size() > 0)
            {
                for (int val : bucket)
                {
                    arr[curIndex++] = val;
                }
            }
        }
    }
}
