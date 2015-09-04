package com.hlf;


import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by howard.fackrell on 9/4/15.
 */
public class CommitFormatterTest {

    @Test
    public void testEmptyCommitList() {
        List<Commit> commits = new ArrayList<Commit>();

        List<String> commitsByAuthor = new CommitFormatter().format(commits);

        assertEquals(0, commitsByAuthor.size());
    }


    @Test
    public void testSingleCommit() {
        List<Commit> commits = new ArrayList<Commit>();
        commits.add(new Commit("2015-08-18|Brendan Machado|EAS-28147 Allow CORPORATE but not *CORPORATE* billing code selection"));

        List<String> commitsByAuthor = new CommitFormatter().format(commits);

        assertEquals(1, commitsByAuthor.size());
    }

    @Test
    public void testMultipleCommits() {
        List<Commit> commits = new ArrayList<Commit>();
        commits.add(new Commit("2015-08-18|Brendan Machado|EAS-28147 Allow CORPORATE but not *CORPORATE* billing code selection"));
        commits.add(new Commit("2015-08-18|Brendan Machado|EAS-28111 Do some cool stuff in code"));

        List<String> commitsByAuthor = new CommitFormatter().format(commits);

        assertEquals(1, commitsByAuthor.size());
    }

}
