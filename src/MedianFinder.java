import java.util.ArrayList;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 */
class MedianFinder {

    private int count;
    private ArrayList<Integer> list ;
    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        count++;
        if(list.size() == 0){
            list.add(num);
        }else {
            for (int i = 0; i < list.size(); i++) {
                if(num <= list.get(i)){
                    list.add(i,num);
                    return;
                }
            }
            list.add(num);
        }
//        list.add();
//        list.add(num);
        System.out.println("count: " + count);
    }

    public double findMedian() {
        if(count == 0){
            return 0;
        }

        if(count % 2 == 0){
            System.out.println(count/2);
            System.out.println(count/2 - 1);

            System.out.println( list.get(count/2 -1));
            System.out.println( list.get(count/2 ));
            System.out.println((list.get(count/2 - 1) + list.get(count/2 )) / 2.0);
            return (list.get(count/2 - 1) + list.get(count/2 )) / 2.0;
        }
        return list.get((count/2 ));
    }


    public static void main(String[] args) {

        ArrayList<Integer> ll = new ArrayList<>();
        System.out.println(ll.size());
        ll.add(3);
        ll.add(0,4);
ll.add(1,2);
        System.out.println(ll.toString());




//        MedianFinder m = new MedianFinder();
//        m.addNum(6);
//        m.addNum(2);
//        Double x = m.findMedian();
//        System.out.println(x);
//        m.addNum(3);
//        System.out.println(m.findMedian());

    }
}