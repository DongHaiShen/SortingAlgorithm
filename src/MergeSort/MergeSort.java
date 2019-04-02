/**
 * @Author sdh
 * @Date Created in 2019/4/2 13:36
 * @description
 */
public class MergeSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
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
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int[] arr, int left, int mid, int right)
    {
        int[] mergeResult = new int[right - left + 1];
        int i = left, j = mid + 1, curIndex = 0;

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

        while (i <= mid)
        {
            mergeResult[curIndex++] = arr[i++];
        }

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
