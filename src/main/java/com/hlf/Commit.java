package com.hlf;

/**
 * Created by howard.fackrell on 9/3/15.
 */
public class Commit {
    public String date;
    public String author;
    public String message;

    Commit(String logLine) {
        String parts[] = logLine.split("\\|");
        if (parts.length > 2)
            message = parts[2];
        if (parts.length > 1)
            author = parts[1];
        date = parts[0];
    }

    public String toString() {
        return date + " " + author + " " + message;
    }
}
