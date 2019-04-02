/**
 * @Author sdh
 * @Date Created in 2019/4/2 16:06
 * @description
 */
public class SelectionSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
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

            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            if (minIndex != i)
            {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
