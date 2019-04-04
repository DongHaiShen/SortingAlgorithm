/**
 * @Author sdh
 * @Date Created in 2019/4/2 13:36
 * @description
 */

/**
 * 归并排序
 * <p>
 * 思想：
 * 1、先将待排序数据不断拆分为左右两个子序列，直至子序列不可再拆分；
 * 2、然后将两个左右子序列进行合并，同时保证有序；
 * 3、重复上述拆分合并步骤直至完成排序
 */
public class MergeSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
        {
            return;
        }

        mergeSort(sourceArray, 0, sourceArray.length - 1);
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    public void mergeSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int mid = ((right - left) >> 1) + left;
            mergeSort(arr, left, mid); // 递归拆分左子序列
            mergeSort(arr, mid + 1, right); // 递归拆分右子序列
            merge(arr, left, mid, right); // 将左右子序列合并
        }
    }

    /**
     * 合并两个有序子序列
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int[] arr, int left, int mid, int right)
    {
        int[] mergeResult = new int[right - left + 1];
        int i = left, j = mid + 1, curIndex = 0;

        // 每次取出两个子序列中的最小值
        while (i <= mid && j <= right)
        {
            if (arr[i] < arr[j])
            {
                mergeResult[curIndex++] = arr[i++];
            }
            else
            {
                mergeResult[curIndex++] = arr[j++];
            }
        }

        // 记录左子序列中剩余的元素
        while (i <= mid)
        {
            mergeResult[curIndex++] = arr[i++];
        }

        // 记录右子序列中剩余的元素
        while (j <= right)
        {
            mergeResult[curIndex++] = arr[j++];
        }

        // 把结果复制回原数组
        for (int k = 0; k < mergeResult.length; k++)
        {
            arr[left + k] = mergeResult[k];
        }
    }
}
