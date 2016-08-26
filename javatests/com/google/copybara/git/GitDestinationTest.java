import com.google.copybara.util.Glob;
    skylark.evalFails(""
            + "git.destination(\n"
            + "    fetch = 'master',\n"
            + "    push = 'master',\n"
            + ")",
        new Glob(ImmutableList.of("**"), excludedDestinationPaths));
  @Test
  public void processEmptyDiff() throws Exception {
    console = new TestingConsole().respondYes();
    fetch = "master";
    push = "master";
    Files.write(workdir.resolve("test.txt"), "some content".getBytes());
    processWithBaselineAndConfirmation(destinationFirstCommit(), new DummyReference("origin_ref1"),
        /*baseline=*/null, /*askForConfirmation=*/true);

    thrown.expect(EmptyChangeException.class);
    // process empty change. Shouldn't ask anything.
    processWithBaselineAndConfirmation(destination(), new DummyReference("origin_ref2"),
        /*baseline=*/null, /*askForConfirmation=*/true);
  }

    String change = git("--git-dir", repoGitDir.toString(), "show", "HEAD");
    // Validate that we really have pushed the commit.
    assertThat(change).contains("test summary");
    System.out.println(change);
        .matchesNext(MessageType.PROGRESS, "Git Destination: Creating a local commit")
        // Validate that we showed the confirmation
        .matchesNext(MessageType.INFO, "(?m)(\n|.)*test summary(\n|.)+"
            + "index 0000000\\.\\.f0eec86\n"
            + "\\+\\+\\+ b/test.txt\n"
            + "@@ -0,0 \\+1 @@\n"
            + "\\+some content\n"
            + "\\\\ No newline at end of file\n")
  @Test
  public void processEmptyCommitWithExcludes() throws Exception {
    fetch = "master";
    push = "master";
    Files.write(workdir.resolve("excluded"), "some content".getBytes());
    repo().withWorkTree(workdir).simpleCommand("add", "excluded");
    repo().withWorkTree(workdir).simpleCommand("commit", "-m", "first commit");

    Files.delete(workdir.resolve("excluded"));

    excludedDestinationPaths = ImmutableList.of("excluded");
    thrown.expect(EmptyChangeException.class);
    thrown.expectMessage("empty change");
    process(destination(), new DummyReference("origin_ref"));
  }

        .withAuthor(new Author("Foo Bar", "foo@bar.com"))