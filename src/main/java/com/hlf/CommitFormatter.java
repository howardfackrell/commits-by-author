package com.hlf;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by howard.fackrell on 9/4/15.
 */
public class CommitFormatter {

    public List<String> format(List<Commit> commits) {

        Map<String, List<Commit>> commitsByAuthor = groupByAuthor(commits);

        List<String> authorFormattedCommits = formatCommitsForAuthors(commitsByAuthor);

        return authorFormattedCommits;
    }

    Map<String, List<Commit>> groupByAuthor(List<Commit> commits) {
        Map<String, List<Commit>> commitsByAuthor = new HashMap<String, List<Commit>>();

        for (Commit commit : commits) {
            if (!commitsByAuthor.containsKey(commit.author)) {
                commitsByAuthor.put(commit.author, new ArrayList<Commit>());
            }

            commitsByAuthor.get(commit.author).add(commit);
        }

        return commitsByAuthor;
    }

    String formatCommitsForAuthor(String author, List<Commit> commits) {
        StringBuilder sb = new StringBuilder();
        sb.append(author).append("\n");
        for(Commit commit : commits) {
            sb.append("\t").append(commit.date).append("\t").append(commit.message).append("\n");
        }

        return sb.toString();
    }

    private List<String> formatCommitsForAuthors(Map<String, List<Commit>> commitsByAuthor) {
        List<String> authorFormattedCommits = new ArrayList<String>();
        for (Map.Entry<String, List<Commit>> entry : commitsByAuthor.entrySet()) {
            String author = entry.getKey();
            List<Commit> commitsBy = entry.getValue();
            authorFormattedCommits.add(formatCommitsForAuthor(author, commitsBy));
        }
        return authorFormattedCommits;
    }
}
