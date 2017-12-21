package com.example.daan.project;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daan on 21.12.17.
 */

public interface AsyncResponse {
    void onTaskCompleted(HashMap<String,String> response);
}
