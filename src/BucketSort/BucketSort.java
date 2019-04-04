/**
 * @Author sdh
 * @Date Created in 2019/4/3 14:11
 * @description
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * 基数排序、计数排序和桶排序实际上都利用了桶的概念，但在对桶的使用方法上有区别：
 * <p>
 * 基数排序：根据键值每一位上的数字来确定对应的桶；
 * 计数排序：每个桶只存储单种键值（键值相同可放到一个桶中）；
 * 桶排序：每个桶存储一定范围内的键值，当每个桶只对应一种键值时，即为计数排序
 */

/**
 * 桶排序
 * <p>
 * 思想：
 * 1、先定义若干数量的桶，然后利用一个映射函数，将所有元素放入对应的桶内；
 * 2、不同桶内的元素可能已经有序，例如第一个桶内的元素都小于第二个桶；
 * 3、但每个桶内的元素仍是乱序，需要再利用各类排序方法进行排序（如快排、归并、插入，甚至继续用桶排序）；
 * 4、最后将桶内元素按顺序依次输出即可
 */
public class BucketSort implements Sortable
{

    // 每个桶存储的键值范围，如 1~100
    public int bucketRange = 100;

    @Override
    public void sort(int[] sourceArray)
    {
        if (sourceArray == null || sourceArray.length < 1)
        {
            return;
        }

        bucketSort(sourceArray);
    }

    /**
     * @param arr
     */
    public void bucketSort(int[] arr)
    {
        int max = arr[0], min = arr[0];

        // 找出最大最小值
        for (int val : arr)
        {
            if (val > max)
            {
                max = val;
            }
            if (val < min)
            {
                min = val;
            }
        }

        // 根据键值范围和每个桶存储键值范围，确定总的桶数
        int bucketCount = (max - min) / bucketRange + 1;

        // 用嵌套集合来模拟桶排序，其中外层集合表示桶，内层集合表示桶内的元素
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++)
        {
            bucketArr.add(new ArrayList<Integer>());
        }

        // 该循环表示：将所有待排元素通过某种映射函数放入对应的桶内
        int bucketIndex = 0;
        for (int val : arr)
        {
            // 此处映射关系为：元素处于哪个桶管理的范围内
            bucketIndex = (val - min) / bucketRange;
            bucketArr.get(bucketIndex).add(val);
        }

        // 该循环表示：对于所有的元素个数大于1的桶，对其桶内元素进行排序
        for (ArrayList<Integer> bucket : bucketArr)
        {
            if (bucket.size() > 1)
            {
                // 此处具体的排序方式可自行选择，这里为了方便采用集合类自带的排序方法
                Collections.sort(bucket);
            }
        }

        // 按照顺序依次输出每个桶内的元素，外层循环针对不同桶，内层循环针对桶内元素
        int curIndex = 0;
        for (ArrayList<Integer> bucket : bucketArr)
        {
            if (bucket.size() > 0)
            {
                for (int val : bucket)
                {
                    arr[curIndex++] = val;
                }
            }
        }
    }
}
