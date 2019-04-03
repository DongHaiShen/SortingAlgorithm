import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/4/3 14:56
 * @description
 */
public class RedixSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
        {
            return;
        }

        redixSort(sourceArray);
    }

    /**
     * @param arr
     */
    public void redixSort(int[] arr)
    {
        int maxDigit = getMaxDigit(arr);
        int mod = 10, div = 1;

        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());

        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10)
        {
            for (int j = 0; j < arr.length; j++)
            {
                int num = (arr[j] % mod) / div;
                bucketList.get(num).add(arr[j]);
            }

            int curIndex = 0;
            for (int j = 0; j < bucketList.size(); j++)
            {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    arr[curIndex++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
    }

    /**
     * @param arr
     * @return
     */
    public int getMaxDigit(int[] arr)
    {
        int maxValue = getMaxValue(arr);
        int maxDigit = 0;

        while (maxValue != 0)
        {
            maxDigit++;
            maxValue /= 10;
        }
        return maxDigit;
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
