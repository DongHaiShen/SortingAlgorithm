/**
 * @Author sdh
 * @Date Created in 2019/4/2 16:06
 * @description
 */

/**
 * 选择排序
 * <p>
 * 思想：
 * 1、每次循环都从还未排序的部分中找出最小（最大）元素；
 * 2、然后放到已排序部分的末尾；
 * 3、重复上述步骤直至所有元素均被处理
 */
public class SelectionSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
        {
            return;
        }

        selectionSort(sourceArray);
    }

    /**
     * @param arr
     */
    public void selectionSort(int[] arr)
    {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++)
        {
            minIndex = i;

            // 从还未排序的部分中找出最小元素
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            // 若该最小元素不在已排序部分的末尾，则交换位置
            if (minIndex != i)
            {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
