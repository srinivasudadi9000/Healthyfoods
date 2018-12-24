package com.maple.healthyfoods;

import org.apache.commons.net.time.TimeTCPClient;

import java.io.IOException;


public class GetTime {

    public static final void main(String[] args) {
        System.out.println("Hello dadi");
        try {
            System.out.println("Hello dadi try");
            TimeTCPClient client = new TimeTCPClient();
            try {
                System.out.println("Hello dadi inner try block");
                // Set timeout of 60 seconds
                client.setDefaultTimeout(60000);
                // Connecting to time server
                // Other time servers can be found at : http://tf.nist.gov/tf-cgi/servers.cgi#
                // Make sure that your program NEVER queries a server more frequently than once every 4 seconds
                client.connect("time.nist.gov");
                System.out.println(client.getDate());
            } finally {
                System.out.println("Hello dadi finnally");
                client.disconnect();
            }
        } catch (IOException e) {
            System.out.println("Hello dadi exception "+e.getMessage());
            e.printStackTrace();
        }
    }



}
