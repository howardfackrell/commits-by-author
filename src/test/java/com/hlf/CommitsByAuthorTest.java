package com.hlf;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Created by howard.fackrell on 9/4/15.
 */
public class CommitsByAuthorTest {

    @Test
    public void testTheApp() {

        String[] args = {"-from", "release_15_8_1"};
        CommitsByAuthor.main(args);

        assertTrue(true);
    }
}
