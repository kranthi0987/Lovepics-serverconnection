package com.sanjay.lovepics.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.sanjay.lovepics.R;
import com.sanjay.lovepics.Splash;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by User on 1/13/2018.
 */

public class URLContent {
    Splash mMainActivity;
    String returnData;
    String address;

    public URLContent(Splash mMainActivity) {
        this.mMainActivity = mMainActivity;
    }


    public String getContent(String address) {
        this.address = address;
        processContent(address);
        return returnData;
    }

    private void processContent(String address) {

        try {

            if (!isNetworkAvailable(mMainActivity)) {
                throw new Exception("No internet connectivity.");
            }

            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(address));
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                InputStream ips = response.getEntity().getContent();
                BufferedReader buf = new BufferedReader(new InputStreamReader(ips, "UTF-8"));

                StringBuilder sb = new StringBuilder();
                String s;
                while (true) {
                    s = buf.readLine();
                    if (s == null || s.length() == 0)
                        break;
                    sb.append(s);

                }
                buf.close();
                ips.close();

                returnData = sb.toString();
            } else {
                throw new Exception();
            }

        } catch (Exception e) {

            makeAndShowDialogBox(e.getMessage()).show();
        }

    }

    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private AlertDialog makeAndShowDialogBox(String msg) {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(mMainActivity)

                .setCancelable(false)
                .setTitle(R.string.connectionerr)
                .setMessage(msg)

                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //whatever should be done when answering "YES" goes here
                        getContent(address);
                    }
                })//setPositiveButton
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //whatever should be done when answering "NO" goes here
                        mMainActivity.finish();
                    }
                })//setNegativeButton

                .create();

        return myQuittingDialogBox;
    }

}
