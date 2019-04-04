/**
 * @Author sdh
 * @Date Created in 2019/4/3 15:18
 * @description
 */

/**
 * 希尔排序
 * <p>
 * 思想：
 * 1、希尔排序也称为"缩小增量排序"，与插入排序相比，它会优先比较距离较远的元素；
 * 2、先将待排序数组按照增量分成多个子序列；
 * 3、然后对每个子序列进行插入排序；
 * 4、不断缩小增量值直至每个子序列中只包含一个元素
 */
public class ShellSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
        {
            return;
        }

        shellSort(sourceArray);
    }

    /**
     * @param arr
     * @return
     */
    public void shellSort(int[] arr)
    {
        // 一般可设初始增量值为数组长度的一半
        int gap = arr.length / 2;
        int cur = arr[0];

        // 循环直至增量变为最小值1，即最后一次对整个数组做直接插入排序
        while (gap > 0)
        {
            // 可以看成是把插入排序中的 1 改为 gap
            // 即针对的是以 gap 为增量的子序列
            for (int i = gap; i < arr.length; i++)
            {
                cur = arr[i];
                int preIndex = i - gap;

                while (preIndex >= 0 && cur < arr[preIndex])
                {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = cur;
            }

            // 每完成一次增量就减少为原来的一半
            gap /= 2;
        }
    }
}
