class Twitter {

    // Tweet object → stores tweetId and the time it was posted
    public static class Tweet {
        int id; // tweet id
        int time; // global timestamp to maintain order

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    // follower → followees mapping
    // Key = user, Value = people this user follows
    private final Map<Integer, Set<Integer>> follows;

    // user → list of tweets they posted (in chronological order)
    private final Map<Integer, List<Tweet>> tweets;

    // Global timer to keep tweets ordered
    private int timestamp;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    // User posts a new tweet
    public void postTweet(int userId, int tweetId) {
        // Create tweet list if user posts for the first time
        tweets.putIfAbsent(userId, new ArrayList<>());

        // Add new tweet with increasing timestamp
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    // Retrieve 10 most recent tweet IDs in the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        // Max heap to get most recent tweet first
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                (a, b) -> (b.time - a.time)); // descending by time

        // Ensure user follows themselves so their own tweets appear
        follows.putIfAbsent(userId, new HashSet<>());
        follows.get(userId).add(userId);

        // For every person the user follows
        for (int followeeId : follows.get(userId)) {
            // If that person has tweets
            if (tweets.containsKey(followeeId)) {
                // Add all their tweets into heap
                // (Brute force merge of tweet lists)
                for (Tweet tweet : tweets.get(followeeId)) {
                    maxHeap.offer(tweet);
                }
            }
        }

        // Extract at most 10 most recent tweets
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            feed.add(maxHeap.poll().id);
            count++;
        }

        return feed;
    }

    // followerId starts following followeeId
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    // followerId stops following followeeId
    public void unfollow(int followerId, int followeeId) {
        // Cannot unfollow yourself (Twitter rule)
        if (follows.containsKey(followerId) && followeeId != followerId) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
