/**
 * @Author sdh
 * @Date Created in 2019/4/3 15:18
 * @description
 */
public class HeapSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
        {
            return;
        }

        heapSort(sourceArray);
    }

    /**
     * @param arr
     * @return
     */
    public void heapSort(int arr[])
    {
        int length = arr.length;

        buildMaxHeap(arr, length);

        while (length > 0)
        {
            swap(arr, 0, length - 1);
            length--;
            adjustHeap(arr, 0, length);
        }
    }

    /**
     * @param arr
     * @param len
     */
    public void buildMaxHeap(int[] arr, int len)
    {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--)
        {
            adjustHeap(arr, i, len);
        }
    }

    /**
     * @param arr
     * @param i
     * @param len
     */
    public void adjustHeap(int[] arr, int i, int len)
    {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;

        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (left < len && arr[left] > arr[maxIndex])
        {
            maxIndex = left;
        }

        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (right < len && arr[right] > arr[maxIndex])
        {
            maxIndex = right;
        }

        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置
        if (maxIndex != i)
        {
            swap(arr, i, maxIndex);
            adjustHeap(arr, maxIndex, len);
        }
    }

    /**
     * @param arr
     * @param i
     * @param j
     */
    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
