/**
 * @Author sdh
 * @Date Created in 2019/4/2 16:35
 * @description
 */

/**
 * 插入排序
 * <p>
 * 思想：
 * 1、首先默认第一个元素已经有序；
 * 2、取下一个元素，将其从后往前依次和已排序部分进行比较；
 * 3、如果该元素小于已排序元素就继续向前找，同时不断将已排序元素的位置向后移动；
 * 5、直到其大于某个已排序元素，则插入到该元素之后；
 * 6、重复上述步骤直至所有元素均被处理
 */
public class InsertionSort implements Sortable
{
    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
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

        // 因为默认第一个数的位置是正确的，所以i的起始值为1
        for (int i = 1; i < arr.length; i++)
        {
            cur = arr[i];

            // 从当前值的前一个位置开始比较
            int preIndex = i - 1;

            // 从后向前依次比较
            while (preIndex >= 0 && cur < arr[preIndex])
            {
                // 若当前值小于已排序的元素，则将该元素的位置向后移一位
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }

            // 直至找到合适位置插入
            arr[preIndex + 1] = cur;
        }
    }
}
