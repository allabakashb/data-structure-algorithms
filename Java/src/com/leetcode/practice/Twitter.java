package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Twitter {

	int index = 0;

	class User {
		int userId;
		Set<Integer> followers = new HashSet<>();
		Set<Tweet> tweets = new TreeSet<>((t1, t2) -> t2.ind - t1.ind);

		User(int userId) {
			this.userId = userId;
		}
	}

	class Tweet {
		int ind = ++index;
		int id;
		int userId;
		Tweet(int id, int userId) {
			this.id = id;
			this.userId = userId;
		}
	}

	Map<Integer, User> map;

	/** Initialize your data structure here. */
	public Twitter() {
		map = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		User user = getUser(userId);
		Tweet tweet = new Tweet(tweetId, userId);
		user.tweets.add(tweet);
		for (int follower : user.followers) {
			map.get(follower).tweets.add(tweet);
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        User user = getUser(userId);
        int i = 0;
        for (Tweet tweet: user.tweets) {
            ++i;
            newsFeed.add(tweet.id);
            if (i == 10) break;
        }
        return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if (followerId == followeeId) return;
        User follower =  getUser(followerId);
        User followee =  getUser(followeeId);
        followee.followers.add(followerId);
        for (Tweet tweet: followee.tweets) {
        	if (tweet.userId == followee.userId) {
        		follower.tweets.add(tweet);
        	}
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if (followerId == followeeId) return;
        User follower =  getUser(followerId);
        User followee =  getUser(followeeId);
        followee.followers.remove(followerId);
        for (Tweet tweet: followee.tweets) {
        	if (tweet.userId == followee.userId) {
        		follower.tweets.remove(tweet);
        	}
        }
    }
    
    private User getUser(int userId) {
        User user;
        if (map.containsKey(userId)) {
            user =  map.get(userId);
        } else {
            user = new User(userId);
            map.put(userId, user);
        }
        return user;
    }

	public static void main(String[] args) {
		
		String ops = "[\"Twitter\",\"postTweet\",\"follow\",\"follow\",\"getNewsFeed\",\"postTweet\",\"getNewsFeed\",\"getNewsFeed\",\"unfollow\",\"getNewsFeed\",\"getNewsFeed\",\"unfollow\",\"getNewsFeed\",\"getNewsFeed\"]";
		String vals = "[[],[1,5],[1,2],[2,1],[2],[2,6],[1],[2],[2,1],[1],[2],[1,2],[1],[2]]";
		create(ops, vals);
	}
	
	public static void create(String ops, String vals) {
		Twitter twitter = new Twitter();
//		JSONArray opsArray = new JSONArray(ops);
//		JSONArray valsArray = new JSONArray(vals);
//		for (int i = 1; i < opsArray.length(); i++) {
//			String op = opsArray.getString(i);
//			JSONArray valArr = valsArray.getJSONArray(i);
//			if (op.equals("postTweet")) {
//				twitter.postTweet(valArr.getInt(0), valArr.getInt(1));
//			} else if (op.equals("follow")) {
//				twitter.follow(valArr.getInt(0), valArr.getInt(1));
//			} else if (op.equals("getNewsFeed")) {
//				List<Integer> newsFeed = twitter.getNewsFeed(valArr.getInt(0));
//				StringBuilder ans = new StringBuilder();
//				newsFeed.forEach((str)-> ans.append(str).append(","));
//				System.out.println(ans.toString());
//			} else {
//				twitter.unfollow(valArr.getInt(0), valArr.getInt(1));
//			}
//		}
	}

}
