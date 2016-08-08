import com.google.copybara.testing.SkylarkTestExecutor;
  private String url;
  private String fetch;
  private String push;

  private SkylarkTestExecutor skylark;


    url = "file://" + repoGitDir;
    skylark = new SkylarkTestExecutor(options, Git.class);
  public void errorIfUrlMissing() throws ConfigValidationException {
    skylark.evalFails(
        "git.destination(\n"
        + "    fetch = 'master',\n"
        + "    push = 'master',\n"
        + ")",
        "missing mandatory positional argument 'url'");
  }

  @Test
  public void errorIfFetchMissing() throws ConfigValidationException {
    skylark.evalFails(
        "git.destination(\n"
            + "    url = 'file:///foo',\n"
            + "    push = 'master',\n"
            + ")",
        "missing mandatory positional argument 'fetch'");
  }

  @Test
  public void errorIfPushMissing() throws ConfigValidationException {
    skylark.evalFails(
        "git.destination(\n"
            + "    url = 'file:///foo',\n"
            + "    fetch = 'master',\n"
            + ")",
        "missing mandatory positional argument 'push'");
    return evalDestination();
    return evalDestination();
  }

  private GitDestination evalDestination()
      throws ConfigValidationException {
    return skylark.eval("result",
        String.format("result = git.destination(\n"
            + "    url = '%s',\n"
            + "    fetch = '%s',\n"
            + "    push = '%s',\n"
            + ")", url, fetch, push));
    fetch = "testPullFromRef";
    push = "testPushToRef";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "testPullFromRef";
    push = "testPushToRef";
    fetch = "pullFromBar";
    push = "pushToFoo";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "refs_for_master";