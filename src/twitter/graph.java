package twitter;

import java.util.*;

/**
 * Created by nagabharan on 13-Oct-16.
 */
public class graph {
    static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges,
                                      int targetUser, int minLikeThreshold) {

        List<Integer> tweetIDs = new ArrayList<Integer>();

        HashMap<Integer, ArrayList<Integer>> UserGraph = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> LikedTweets = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < followGraph_edges.length; i++) {
            int user = followGraph_edges[i][0];
            int followers = followGraph_edges[i][1];
            if (!UserGraph.containsKey(user))
                UserGraph.put(user, new ArrayList<Integer>());
            UserGraph.get(user).add(followers);
        }

        for (int i = 0; i < likeGraph_edges.length; i++) {
            int tweet = likeGraph_edges[i][1];
            int user = likeGraph_edges[i][0];
            if (!LikedTweets.containsKey(tweet))
                LikedTweets.put(tweet, new ArrayList<Integer>());
            LikedTweets.get(tweet).add(user);
        }

        TreeMap<Integer, Integer> tweets = new TreeMap<>();

        if (UserGraph.containsKey(targetUser)) {
            Iterator<Integer> it = UserGraph.get(targetUser).iterator();

            while (it.hasNext()) {
                int user = it.next();
                for (Map.Entry<Integer, ArrayList<Integer>> e : LikedTweets.entrySet()) {
                    int tweetID = e.getKey();
                    List<Integer> likedBy = e.getValue();
                    if (likedBy.contains(user) && likedBy.size() >= minLikeThreshold) {
                        if (!tweets.containsKey(tweetID)) {
                            tweets.put(tweetID, 1);
                        } else {
                            tweets.put(tweetID, tweets.get(tweetID) + 1);
                        }
                    }
                }
            }
        }


        int[] res = new int[tweets.size()];
        if (tweets.size() == 0)
            return res;
        else {
            int i = 0;
            for (Map.Entry e : tweets.entrySet()) {
                res[i] = (int) e.getKey();
                i++;
            }
            return res;
        }
    }
}
