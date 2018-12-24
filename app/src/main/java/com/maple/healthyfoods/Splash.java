package com.maple.healthyfoods;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.support.constraint.Constraints.TAG;

public class Splash extends Activity {
    public static final String TIME_SERVER = "time-a.nist.gov";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        TextView textView = (TextView) findViewById(R.id.text_view);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink);
        // textView.startAnimation(animation);

        ShimmerFrameLayout container =
                (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        container.startShimmer();
        container.setScrollBarFadeDuration(1500);
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(Splash.this,Prelogin.class);
                startActivity(login);
            }
        },3500);*/

        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String dateToStr = format.format(today);
        System.out.println("dadi" + dateToStr);
        /*  System.out.println("dadi" + getCurrentNetworkTime());*/

        Date currentTime = Calendar.getInstance().getTime();




    }

    public static long getCurrentNetworkTime() {
        NTPUDPClient timeClient = new NTPUDPClient();
        long returnTime = 0;
        try {
            InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();   //server time
            Date time = new Date(returnTime);
            Log.d(TAG, "Time from " + TIME_SERVER + ": " + time);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //long returnTime = timeInfo.getReturnTime();   //local device time


        return returnTime;
    }
}
