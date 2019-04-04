/**
 * @Author sdh
 * @Date Created in 2019/4/2 14:24
 * @description
 */

/**
 * 冒泡排序
 * <p>
 * 思想：
 * 1、每次循环都从数组起始位开始，依次比较前后两个数，若后者大于前者则交换；
 * 2、则每循环一轮，就可以将当前最大的数移到数组的最后；
 * 3、总共循环 n-1 轮后完成排序
 */
public class BubbleSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
        {
            return;
        }

        bubbleSort(sourceArray);
    }

    /**
     * @param arr
     */
    public void bubbleSort(int[] arr)
    {
        // 用于记录本次循环是否发生了交换
        // 若没有发生交换说明已经有序，可以提前返回
        boolean isChange = false;

        // 实际只需循环length - 1次，因为只剩最后一个（即数组第一个数）时不用排序
        for (int i = 0; i < arr.length - 1; i++)
        {
            isChange = false;

            // 最后 i 个元素已经有序，可以不用再判断，因此到length - 1 - i
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isChange = true;
                }
            }

            if (!isChange)
            {
                return;
            }
        }
    }
}
