/**
 * @Author sdh
 * @Date Created in 2019/4/3 11:07
 * @description
 */
public class CountingSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
        {
            return;
        }

        countingSort(sourceArray);
    }

    /**
     * @param arr
     */
    public void countingSort(int[] arr)
    {
        int maxValue = getMaxValue(arr);
        int[] bucket = new int[maxValue + 1];

        for (int val : arr)
        {
            bucket[val]++;
        }

        int curArrIndex = 0;
        for (int i = 0; i < bucket.length; i++)
        {
            while (bucket[i] > 0)
            {
                arr[curArrIndex++] = i;
                bucket[i]--;
            }
        }
    }

    /**
     * @param arr
     * @return
     */
    public int getMaxValue(int[] arr)
    {
        int maxValue = arr[0];
        for (int val : arr)
        {
            if (val > maxValue)
            {
                maxValue = val;
            }
        }
        return maxValue;
    }
}
