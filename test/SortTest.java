import java.util.Arrays;
import java.util.Random;

/**
 * @Author sdh
 * @Date Created in 2019/4/2 12:28
 * @description
 */
public class SortTest
{
    public static void main(String[] args)
    {
        int sizeForResultTest = 10;
        int smallSizeForTimeTest = 10000;
        int bigSizeForTimeTest = 10000000;

        int lowerBound = 0;
        int upperBound = 100000;

        // 使用少量数据查看排序结果是否正确
        testAllSortResult(generateData(sizeForResultTest, lowerBound, upperBound));

        // 使用大量数据测试排序时间
        // 针对不同复杂度算法使用不同数据量
        testAllFastSortTime(generateData(bigSizeForTimeTest, lowerBound, upperBound));
        testAllSlowSortTime(generateData(smallSizeForTimeTest, lowerBound, upperBound));
    }

    /**
     * @param arr
     */
    public static void testAllSortResult(int[] arr)
    {
        int dataSize = arr.length;

        System.out.println("测试数据量大小为：" + dataSize);
        testSortResult(new BubbleSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new SelectionSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new InsertionSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new ShellSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new HeapSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new QuickSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new MergeSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new CountingSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new BucketSort(), Arrays.copyOf(arr, dataSize));
        testSortResult(new RedixSort(), Arrays.copyOf(arr, dataSize));
    }

    /**
     * @param arr
     */
    public static void testAllFastSortTime(int[] arr)
    {
        int dataSize = arr.length;

        System.out.println("测试数据量大小为：" + dataSize);
        testSortTime(new ShellSort(), Arrays.copyOf(arr, dataSize));
        testSortTime(new HeapSort(), Arrays.copyOf(arr, dataSize));
        testSortTime(new QuickSort(), Arrays.copyOf(arr, dataSize));
        testSortTime(new MergeSort(), Arrays.copyOf(arr, dataSize));
        testSortTime(new CountingSort(), Arrays.copyOf(arr, dataSize));
        testSortTime(new BucketSort(), Arrays.copyOf(arr, dataSize));
        testSortTime(new RedixSort(), Arrays.copyOf(arr, dataSize));
        System.out.println();
    }

    /**
     * @param arr
     */
    public static void testAllSlowSortTime(int[] arr)
    {
        int dataSize = arr.length;

        testSortTime(new BubbleSort(), Arrays.copyOf(arr, dataSize));
        testSortTime(new SelectionSort(), Arrays.copyOf(arr, dataSize));
        testSortTime(new InsertionSort(), Arrays.copyOf(arr, dataSize));
        System.out.println();
    }

    /**
     * @param sortAlgorithm
     * @param arr
     */
    public static void testSortResult(Sortable sortAlgorithm, int[] arr)
    {
        System.out.println(sortAlgorithm.getClass().toString().substring(6) + " 排序前：");
        printArray(arr);

        sortAlgorithm.sort(arr);

        System.out.println(sortAlgorithm.getClass().toString().substring(6) + " 排序后：");
        printArray(arr);

        System.out.println();
    }

    /**
     * @param sortAlgorithm
     * @param arr
     */
    public static void testSortTime(Sortable sortAlgorithm, int[] arr)
    {
        long startTime = System.currentTimeMillis();
        sortAlgorithm.sort(arr);
        long endTime = System.currentTimeMillis();

        System.out.println(sortAlgorithm.getClass().toString().substring(6)
                + " 排序时间为：  " + (endTime - startTime) / 1000.0 + "s");
    }

    /**
     * @param dataSize
     * @return
     */
    public static int[] generateData(int dataSize, int lowerBound, int upperBound)
    {
        int[] result = new int[dataSize];

        Random rand = new Random();
        for (int i = 0; i < dataSize; i++)
        {
            result[i] = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
        }

        return result;
    }

    /**
     * @param arr
     */
    public static void printArray(int[] arr)
    {
        for (int val : arr)
        {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
