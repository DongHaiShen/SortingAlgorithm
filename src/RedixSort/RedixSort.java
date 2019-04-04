import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/4/3 14:56
 * @description
 */

/**
 * 基数排序
 * <p>
 * 思想：
 * 1、基数排序可看成是将待排序元素拆分成多个关键字进行排序；
 * 2、若以元素位数为关键字，则从最低位开始，以该位上的值进行计数排序（若为 10 进制则设 10个桶）；
 * 3、从低到高在下一位上重复上述步骤，直至所有元素的最高位
 */
public class RedixSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
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
        // 找出最大值并计算最大值的位数
        int maxDigit = getMaxDigit(arr);
        int mod = 10, div = 1;

        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());

        // 从最低位到最高位
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10)
        {
            // 把所有元素根据该位上的值分发到对应的桶
            for (int j = 0; j < arr.length; j++)
            {
                int num = (arr[j] % mod) / div;
                bucketList.get(num).add(arr[j]);
            }

            // 按照顺序依次输出，对每一位上的排序可看成是计数排序
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
