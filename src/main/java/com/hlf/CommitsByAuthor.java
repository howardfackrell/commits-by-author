package com.hlf;

import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Hello world!
 *
 */
public class CommitsByAuthor
{
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("from", true, "last release branch name, ie. release_15_8_1");
        options.addOption("to", true, "current release branch name, ie. release_15_9_1.  defaults to 'HEAD'");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
            assertRequiredOptions(cmd);
        } catch (Exception exception) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("commitsbyauthor", options);
            System.exit(1);
        }

        String from = cmd.getOptionValue("from");
        String to = cmd.hasOption("to") ? cmd.getOptionValue("to") : "HEAD";

        List<Commit> commits = new CommitSource().getCommits(from, to);
        List<String> commitsByAuthor = new CommitFormatter().format(commits);

        System.out.println(StringUtils.join(commitsByAuthor, "\n"));
    }

    private static void assertRequiredOptions(CommandLine cmd) {
        if ( ! cmd.hasOption("from")) throw new RuntimeException("Missing argument 'from'");
    }

}
