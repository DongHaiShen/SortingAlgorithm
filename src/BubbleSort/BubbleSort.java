/**
 * @Author sdh
 * @Date Created in 2019/4/2 14:24
 * @description
 */
public class BubbleSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
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

        for (int i = 0; i < arr.length; i++)
        {
            isChange = false;

            // 最后 i 个元素已经有序，可以不用再判断
            for (int j = 0; j < arr.length - i - 1; j++)
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
