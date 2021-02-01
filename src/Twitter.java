import java.util.*;

/**
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 * https://leetcode-cn.com/problems/design-twitter/
 */
class Twitter {

    public int id;
    HashMap<Integer,LinkedList<Post>> posts;
    HashMap<Integer, HashSet<Integer>> follows;

    /** Initialize your data structure here. */
    public Twitter() {
        id = 0;
        posts = new HashMap<>();
        follows = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Post post = new Post(++id,tweetId);
        if(posts.containsKey(userId)){
            LinkedList<Post> userPosts = posts.get(userId);
            userPosts.addFirst(post);
            if(userPosts.size() == 11){
                userPosts.remove(10);
            }
        }else {
            LinkedList<Post> postList = new LinkedList<>();
            postList.addFirst(post);
            posts.put(userId,postList);
        }

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        HashSet followUserIds = follows.get(userId);

        LinkedList<Integer> data = new LinkedList<>();
        LinkedList<Post> userPosts = posts.get(userId);

        if(followUserIds == null){ //没有关注者
            if(userPosts == null){ //自己没有发twitter
                return data;
            }
            if(userPosts != null){
                for (int i = 0; i < userPosts.size(); i++) {
                    data.add(userPosts.get(i).postId);
                }
            }
            return data;
        }else{
            LinkedList<Post> postList = new LinkedList<>();

            Iterator<Integer> it = followUserIds.iterator();
            while (it.hasNext()) {
                int uid = it.next();
                if(uid != userId){
                    LinkedList<Post> userPostss = posts.get(uid);
                    if(userPostss != null){
                        for (int i = 0; i < userPostss.size(); i++) {
                            postList.add(userPostss.get(i));
                        }
                    }
                }
            }
            if(userPosts != null){
                for (int i = 0; i < userPosts.size(); i++) {
                    postList.add(userPosts.get(i));
                }
            }

            Collections.sort(postList, new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    if(o1.id > o2.id){
                        return -1;
                    }
                    return 1;
                }
            });
            for (int i = 0; i < postList.size(); i++) {
                data.add(postList.get(i).postId);
                if(data.size() == 10){
                    return data;
                }
            }
        }

        return data;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)){
            HashSet<Integer> followUserIds = follows.get(followerId);
            followUserIds.add(followeeId);
        }else {
            HashSet<Integer> followUserIds = new HashSet<>();
            followUserIds.add(followeeId);
            follows.put(followerId,followUserIds);
        }

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)){
            HashSet<Integer> followUserIds = follows.get(followerId);
            followUserIds.remove(followeeId);
        }
    }

}

class Post{
    int id;
    int postId;

    public Post(int id,int postId){
        this.id = id;
        this.postId = postId;
    }
}