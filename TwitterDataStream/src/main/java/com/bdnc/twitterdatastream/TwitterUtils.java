/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.twitterdatastream;

import java.util.ArrayList;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 *
 * @author jjmacagnan
 */
public class TwitterUtils {

    //Editáveis por aplicativo
    private static final String TOKEN = "2523832008-juBESZO3Wb2BunRunXdvTXE9tEAoK2f6qNsk9RP";
    private static final String TOKENSECRET = "dKMnfKYqFitx27amRDQghym3CqoocSgLbjqMgSBUbXiLr";
    private static final String CONSUMERKEY = "esOKcRuIBFqLkeTDlneeIleAl";
    private static final String CONSUMERSECRET = "PLnlLKwq54oZHaNibRwvHSse5YAASORYcWJSlUvUeDo8YzK93s";

    //Site para redirecinamento de tweets
    private static final String TWEETLINK = "https://twitter.com/tweet/status/";

    public static Twitter twitter = null;

    public static Twitter createTwitter() {
        if (twitter == null) {
            twitter = TwitterFactory.getSingleton();
            AccessToken accessToken = new AccessToken(TOKEN, TOKENSECRET);
            twitter.setOAuthConsumer(CONSUMERKEY, CONSUMERSECRET);
            twitter.setOAuthAccessToken(accessToken);
        }
        return twitter;
    }

    public static ArrayList<Tweet> search(Twitter twitter, String queryString, int tweetCount) {
        try {
            Query query = new Query(queryString);
            query.setCount(tweetCount);
            QueryResult result = twitter.search(query);
            ArrayList<Tweet> tweets = new ArrayList<>();
            for (twitter4j.Status status : result.getTweets()) {
                int id = (int) status.getId();
                String user = status.getUser().getName();
                String text = status.getText();
                String image = status.getUser().getProfileImageURL();
                boolean isRetweeted = status.isRetweeted();
                String link = TWEETLINK + status.getId(); // Cria URL para o tweet na web.
                Tweet tweet = new Tweet(id, user, text, image, link, isRetweeted);
                tweets.add(tweet);
            }
            return tweets;
        } catch (TwitterException e) {
            System.out.println("Erro no twitter");
            e.printStackTrace();
            return new ArrayList<Tweet>();
        } catch (NullPointerException e) {
            System.out.println("Provavelmente Twitter nulo sendo passado para o método search.");
            e.printStackTrace();
            return new ArrayList<Tweet>();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de log.");
            e.printStackTrace();
            return new ArrayList<Tweet>();
        }
    }
}
