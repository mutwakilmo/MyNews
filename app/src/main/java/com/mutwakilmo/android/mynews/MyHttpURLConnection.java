package com.mutwakilmo.android.mynews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mutwakil Mo on 20/02/2020
 */
public class MyHttpURLConnection {

    public static String startHttpRequest(String urlString) {

        StringBuilder stringBuilder = new StringBuilder();

        try {

            // -------------------------------------------------------------------------------------
            //   1 - Declare a URL Connection
            //  From an HTTP address contained in a String variable, we’re creating a URL object.
            //  This will enable us to open a connection of the type HttpURLConnection.
            // -------------------------------------------------------------------------------------

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // -------------------------------------------------------------------------------------
            //  2 - Open InputStream to connection
            //  We’re opening a channel to the URL in question, and retrieving the
            //  corresponding data stream via an InputStream.
            // -------------------------------------------------------------------------------------


            conn.connect();
            InputStream in = conn.getInputStream();


            // -------------------------------------------------------------------------------------
            //  3 - Download and decode the string response
            //  Lastly, we’re reading this raw data stream using a BufferedReader and
            //  converting it all line by line, using a StringBuilder, so that the end result
            //  is a String variable.
            // -------------------------------------------------------------------------------------
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (MalformedURLException exception) {

        } catch (IOException exception) {

        } catch (Exception e) {

        }

        return stringBuilder.toString();
    }

}