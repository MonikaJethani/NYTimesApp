package com.example.nytimesapp.http;

import android.os.AsyncTask;

import com.example.nytimesapp.utils.Constants;
import com.example.nytimesapp.model.ArticleList;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NYTimesAsyncTask extends AsyncTask<String, Void, ArticleList> {

    NYTimesRequest request = null;

    public NYTimesAsyncTask(NYTimesRequest delegate) {
        this.request = delegate;
    }

    @Override
    protected ArticleList doInBackground(String... strings) {
        String result ="";
        HttpURLConnection urlConnection = null;
        try {
            URL url =  new URL(Constants.BASE_URL +strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            urlConnection.getInputStream()));
            String line="";

            while((line = bufferedReader.readLine()) != null) {
                result+=line;
            }
            JSONObject jsonObject = new JSONObject(result);
             return NYTimesJsonParser.getArticleList(jsonObject);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) { e.printStackTrace();}
        finally {
            urlConnection.disconnect();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArticleList articleList) {
        super.onPostExecute(articleList);
        request.onCompleted(articleList);
    }
}
