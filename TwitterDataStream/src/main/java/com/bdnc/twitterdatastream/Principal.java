/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.twitterdatastream;

import java.util.ArrayList;
import java.util.Arrays;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author mlsobrinho
 */
public class Principal {

    /*public static void main(String args[]) throws TwitterException {
        String tweetWords = "Java";
        int nTweets = 100;
        Twitter twitter = TwitterUtils.createTwitter();
        ArrayList<Tweet> data = TwitterUtils.search(twitter, tweetWords, nTweets);

        System.out.println(data.size());

        data.stream().map((tweet) -> {
            System.out.println(tweet.id);
            return tweet;
        }).map((tweet) -> {
            System.out.println(tweet.user);
            return tweet;
        }).map((tweet) -> {
            System.out.println(tweet.text);
            return tweet;
        }).map((tweet) -> {
            System.out.println(tweet.link);
            return tweet;
        }).map((tweet) -> {
            System.out.println(tweet.isRetweeted);
            return tweet;
        }).forEachOrdered((tweet) -> {
            System.out.println(tweet.image);
        });

    }*/

}
