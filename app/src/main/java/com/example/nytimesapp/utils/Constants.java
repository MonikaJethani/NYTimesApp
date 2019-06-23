package com.example.nytimesapp.utils;

public class Constants {

    public static final String BASE_URL = "https://api.nytimes.com/svc/";
    public static final String RESULTS = "results";
    public static final String TITLE = "title";
    public static final String DATE_PUBLISHED = "published_date";

    public static final String API_KEY = "PKqtvgg8CdzPu2rAWq6Bzg3aYLHmXsCQ";
    public static final String API_KEY_STRING = "api-key="+API_KEY;

    public static final String SEARCH_ENDPOINT = "topstories/v2/";
    public static final String MOST_SHARED_ENDPOINT = "mostpopular/v2/shared/1/facebook.json?"+API_KEY_STRING;
    public static final String MOST_VIEWED_ENDPOINT = "mostpopular/v2/viewed/7.json?"+API_KEY_STRING;
    public static final String MOST_EMAILED_ENDPOINT = "mostpopular/v2/emailed/7.json?"+API_KEY_STRING;

    public static final String SEARCH_API = "search";
    public static final String MOST_VIEWED_API = "most viewed";
    public static final String MOST_EMAILED_API = "most emailed";
    public static final String MOST_SHARED_API = "most shared";

    public static final String SEARCH_QUERY = "q";
    public static final String API_TO_CALL = "api_to_call";

}
