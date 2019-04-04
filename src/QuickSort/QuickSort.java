/**
 * @Author sdh
 * @Date Created in 2019/4/2 12:13
 * @description
 */

/**
 * 快速排序
 * <p>
 * 思想：
 * 1、先找出一个基准数，例如取第一个元素；
 * 2、利用左右两个指针，右指针从右往左找到一个小于基准数的元素，左指针从左往右找到一个大于基准数的元素；
 * 3、交换两个指针对应的元素，并重复该步骤，直至两个指针相遇；
 * 4、然后将基准值放入指针相遇的对应位置，此时小于基准值的元素都在其左边，大于基准值的元素都在其右边；
 * 5、对左右分区递归执行上述步骤，直到每个分区内只有一个元素
 */
public class QuickSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
        {
            return;
        }

        quickSort(sourceArray, 0, sourceArray.length - 1);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            // 根据基准值找到分区位置，且partition位置即为基准值的最终位置，不需要再排序
            int partition = partition(arr, left, right);

            // 递归处理左分区
            quickSort(arr, left, partition - 1);

            // 递归处理左分区
            quickSort(arr, partition + 1, right);
        }
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] arr, int left, int right)
    {
        // 取序列第一个元素为基准值
        int pivot = arr[left];

        // 不断执行直至左右指针相遇
        while (left < right)
        {
            // 右指针从右往左找到一个小于基准数的元素
            while (left < right && arr[right] >= pivot)
            {
                right--;
            }

            // 找到后直接赋值给左指针所在位置，此时右指针对应元素实际上是一个空位置
            arr[left] = arr[right];

            // 左指针从左往右找到一个大于基准数的元素
            while (left < right && arr[left] <= pivot)
            {
                left++;
            }

            // 同理找到后直接赋值给右指针所在位置
            arr[right] = arr[left];
        }

        // 当循环结束说明左右指针已经相遇，并且相遇的位置是一个空出的位置，
        // 将基准值放入该位置，并返回该位置的下标，为分区做准备
        arr[left] = pivot;
        return left;
    }
}

