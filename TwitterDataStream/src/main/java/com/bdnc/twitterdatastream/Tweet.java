/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.twitterdatastream;

/**
 *
 * @author mlsobrinho
 */
public class Tweet {

    int id;
    String user;
    String text;
    String image;
    String link;
    boolean isRetweeted;

    public Tweet(int id, String user, String text, String image, String link, boolean isRetweeted) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.image = image;
        this.link = link;
        this.isRetweeted = isRetweeted;
    }
}
