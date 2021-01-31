import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU 缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 *
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lFUCache = new LFUCache(2);
 * lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lFUCache.get(1);      // 返回 1
 *                       // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 *                       // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lFUCache.get(2);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 *                       // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 *                       // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lFUCache.get(1);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 *                       // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lFUCache.get(4);      // 返回 4
 *                       // cache=[3,4], cnt(4)=2, cnt(3)=3
 *
 *
 * 提示：
 *
 * 0 <= capacity, key, value <= 104
 * 最多调用 105 次 get 和 put 方法
 *
 *
 * 进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？
 *
 * https://leetcode-cn.com/problems/lfu-cache/
 */
class LFUCache {

    private int cap;
    private int minTimes;
    private HashMap<Integer,Integer> map; //记录缓存值
    private HashMap<Integer,Integer> keyToTimes; //记录key的次数
    private HashMap<Integer, LinkedHashSet<Integer>> timesToKey; //


    public LFUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        keyToTimes = new HashMap<>();
        timesToKey = new HashMap<>();
        minTimes = 0;
    }

    public void updateKeyTimes(int key){
        System.out.println("updateKeyTimes:" + key);
        if(minTimes == 0){
            minTimes++;
        }
        if(keyToTimes.containsKey(key)){
            int times = keyToTimes.get(key);
            keyToTimes.put(key,times + 1);


            LinkedHashSet l = timesToKey.get(times);
            l.remove(key);
            if(l.isEmpty() && times == minTimes){
                minTimes++;
            }


            LinkedHashSet ll = timesToKey.get(times+1);
            if(ll == null){
                ll = new LinkedHashSet();
            }
            ll.add(key);
            timesToKey.put(times+1,ll);

        }else {
            keyToTimes.put(key, 1);

            LinkedHashSet ll = timesToKey.get(1);
            if(ll == null){
                ll = new LinkedHashSet();
            }
            ll.add(key);
            timesToKey.put(1,ll);
            minTimes = 1;

        }

        System.out.println("minTimes:"+minTimes);
        System.out.println("---------------------updateKeyTimes");
    }

    public int get(int key) {
        System.out.println("get:"+key );
        if(map.get(key) == null){
            return -1;
        }else {
            updateKeyTimes(key);

//            System.out.println("get:"+map.get(key));
            return map.get(key);
        }
    }

    public void put(int key, int value) {
        if(cap <= 0){
            return;
        }
        System.out.println("put:"+key + " "+value);
        if(map != null){
            if(map.get(key) != null){
                map.put(key,value);
                updateKeyTimes(key);
                return;
            }
            if(map.size() >= cap){

                LinkedHashSet minL = timesToKey.get(minTimes);

                Iterator<Integer> it = minL.iterator();
                Integer nx = it.next();
                minL.remove(nx);

                map.remove(nx);
                keyToTimes.remove(nx);
            }
        }
        map.put(key,value);
        updateKeyTimes(key);
        System.out.println("--------------------- put");

    }

    public void pint() {
        System.out.println("------------------------------");
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.printf("[" + key + ",  " + value + "]");
        }
        System.out.println(" ");

        Iterator it = keyToTimes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.printf("[" + key + ",  " + value + "]");
        }
        System.out.println(" ");

        Iterator it1 = timesToKey.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry entry = (Map.Entry) it1.next();
            Integer key = (Integer) entry.getKey();
            LinkedHashSet<Integer> value = (LinkedHashSet) entry.getValue();
            System.out.printf("[" + key + ":" );

            for (Integer i : value){
                System.out.printf(i+ " ");
            }
            System.out.printf("]");
            System.out.println(" ");

        }
        System.out.println(" ");

        System.out.println("minTimes:"+minTimes);
        System.out.println("------------------------------");
    }


    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(0);
        lFUCache.put(0, 0);   // cache=[1,_], cnt(1)=1
        lFUCache.get(0);


        lFUCache.pint();
        lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lFUCache.pint();
        lFUCache.get(1);      // 返回 1
        lFUCache.pint();
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        lFUCache.pint();
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lFUCache.get(2);      // 返回 -1（未找到）
        lFUCache.pint();
        lFUCache.get(3);      // 返回 3
        lFUCache.pint();


        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        lFUCache.pint();
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lFUCache.get(1);      // 返回 -1（未找到）
        lFUCache.pint();
        lFUCache.get(3);      // 返回 3
        lFUCache.pint();
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lFUCache.get(4);      // 返回 4
        lFUCache.pint();

        return;
    }


}

