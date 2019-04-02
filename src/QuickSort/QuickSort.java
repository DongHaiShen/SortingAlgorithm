/**
 * @Author sdh
 * @Date Created in 2019/4/2 12:13
 * @description
 */
public class QuickSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
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
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
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
        int pivot = arr[left];

        while (left < right)
        {
            while (left < right && arr[right] >= pivot)
            {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= pivot)
            {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = pivot;
        return left;
    }
}

