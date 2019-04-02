/**
 * @Author sdh
 * @Date Created in 2019/4/2 16:35
 * @description
 */
public class InsertionSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
        {
            return;
        }

        insertionSort(sourceArray);
    }

    /**
     * @param arr
     */
    public void insertionSort(int[] arr)
    {
        int cur = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            cur = arr[i];
            int preIndex = i - 1;

            while (preIndex >= 0 && cur < arr[preIndex])
            {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = cur;
        }
    }
}
