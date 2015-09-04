package com.hlf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by howard.fackrell on 9/4/15.
 */
public class CommitTest {

    @Test
    public void  testCommitCreation() {
         String logLine = "2015-08-13|Cameron Shellum|Make connection closing more reliable";

        Commit commit = new Commit(logLine);

        assertEquals("Cameron Shellum",  commit.author);
    }

    @Test
    public void  testToString() {
        String logLine = "2015-08-13|Cameron Shellum|Make connection closing more reliable";

        Commit commit = new Commit(logLine);

        assertEquals("2015-08-13 Cameron Shellum Make connection closing more reliable",  commit.toString());
    }

    @Test
    public void testCreateWithNoCommitString() {
        Commit commit = new Commit("");
        assertEquals(null, commit.author);
    }
}
