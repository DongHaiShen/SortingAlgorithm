/**
 * @Author sdh
 * @Date Created in 2019/4/3 15:18
 * @description
 */
public class ShellSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null && sourceArray.length < 1)
        {
            return;
        }

        shellSort(sourceArray);
    }

    /**
     * @param arr
     * @return
     */
    public void shellSort(int[] arr)
    {
        int gap = arr.length / 2;
        int cur = arr[0];

        while (gap > 0)
        {
            for (int i = gap; i < arr.length; i++)
            {
                cur = arr[i];
                int preIndex = i - gap;

                while (preIndex >= 0 && cur < arr[preIndex])
                {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = cur;
            }
            gap /= 2;
        }
    }
}
