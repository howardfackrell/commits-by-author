package com.hlf;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by howard.fackrell on 9/3/15.
 */
public class CommitSource {

    public List<Commit> getCommits(String fromBranch, String toBranch) {
        //git log --no-merges --date=short --pretty=format:"%ad %an %s" release_14_2_1..HEAD
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.redirectErrorStream(true);

        processBuilder.command(
                "git", "log", "--no-merges", "--date=short", "--pretty=format:\"%ad|%an|%s\"", fromBranch+ ".."+ toBranch);

        System.out.println(StringUtils.join(processBuilder.command(), " "));
        List<Commit> commitList = new ArrayList<Commit>();
        try {
            Process process = processBuilder.start();

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = input.readLine()) != null) {
                commitList.add(new Commit(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return commitList;
    }
}
