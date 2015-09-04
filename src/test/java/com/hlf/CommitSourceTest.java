package com.hlf;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by howard.fackrell on 9/4/15.
 */
public class CommitSourceTest {

    @Test
    public void getCommitsTest() {
        List<Commit> commits = new CommitSource().getCommits("", "");

        assertEquals(1, commits.size());

    }
}
