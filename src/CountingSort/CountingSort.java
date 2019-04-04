/**
 * @Author sdh
 * @Date Created in 2019/4/3 11:07
 * @description
 */

/**
 * 计数排序
 * <p>
 * 思想：
 * 1、先找出待排序元素中的最大值 max，然后定义 max + 1个桶，每个桶用于记录该桶对应元素出现的次数；
 * 2、将所有元素依次放入对应的桶中；
 * 3、不同的桶之间可事先保证有序，因此只需按桶的顺序依次输出元素；
 * 4、对于每个桶，其中存储的数字 n 表示需要输出 n 个该桶对应的元素
 */
public class CountingSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
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
        // 找出最大值并确定桶的个数
        int maxValue = getMaxValue(arr);
        int[] bucket = new int[maxValue + 1];

        // 该循环将所有待排元素放入对应的桶内
        for (int val : arr)
        {
            bucket[val]++;
        }

        // 按照顺序依次输出
        int curArrIndex = 0;
        for (int i = 0; i < bucket.length; i++)
        {
            // 每个桶根据其记录的元素出现次数，输出对应个该元素
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
