/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

  private Glob destinationFiles;
    destinationFiles = new Glob(ImmutableList.of("**"));
  private void process(Destination.Writer writer, DummyReference originRef)
    processWithBaseline(writer, originRef, /*baseline=*/ null);
  private void processWithBaseline(Destination.Writer writer, DummyReference originRef,
    processWithBaselineAndConfirmation(writer, originRef, baseline,
  private void processWithBaselineAndConfirmation(Destination.Writer writer,
    TransformResult result = TransformResults.of(workdir, originRef);
    WriterResult destinationResult = writer.write(result, console);
    process(
        destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("origin_ref"));
    processWithBaselineAndConfirmation(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("origin_ref"),
    processWithBaselineAndConfirmation(
        destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("origin_ref1"),
    processWithBaselineAndConfirmation(
        destination().newWriter(destinationFiles),
        new DummyReference("origin_ref2"),
    processWithBaselineAndConfirmation(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("origin_ref"),
    process(destinationFirstCommit().newWriter(destinationFiles), ref);
    process(destination().newWriter(destinationFiles), ref);
    destinationFiles = new Glob(ImmutableList.of("**"), ImmutableList.of("excluded"));
    process(destination().newWriter(destinationFiles), new DummyReference("origin_ref"));
    process(destination().newWriter(destinationFiles), new DummyReference("origin_ref"));
    process(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("origin_ref"));
    process(destination().newWriter(destinationFiles), new DummyReference("origin_ref"));
    Destination.Writer writer = destinationFirstCommit().newWriter(destinationFiles);
    assertThat(writer.getPreviousRef(DummyOrigin.LABEL_NAME)).isNull();
    process(writer, new DummyReference("first_commit"));
    writer = destination().newWriter(destinationFiles);
    assertThat(writer.getPreviousRef(DummyOrigin.LABEL_NAME)).isEqualTo("first_commit");
    process(writer, new DummyReference("second_commit"));
    writer = destination().newWriter(destinationFiles);
    assertThat(writer.getPreviousRef(DummyOrigin.LABEL_NAME)).isEqualTo("second_commit");
    process(writer, new DummyReference("third_commit"));
    process(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("first_commit"));
    assertThat(destination().newWriter(destinationFiles).getPreviousRef(DummyOrigin.LABEL_NAME))
    process(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("first_commit"));
    destination().newWriter(destinationFiles).getPreviousRef(DummyOrigin.LABEL_NAME);
    process(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("first_commit").withTimestamp(1414141414));
    process(destination().newWriter(destinationFiles),
        new DummyReference("second_commit").withTimestamp(1515151515));
    process(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("first_commit").withTimestamp(1414141414));
    process(destination().newWriter(destinationFiles),
        new DummyReference("second_commit").withTimestamp(1414141490));
    process(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("first_commit").withTimestamp(1414141414));
    process(destination().newWriter(destinationFiles),
        new DummyReference("second_commit").withTimestamp(1414141490));
    process(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("first_commit"));
    process(destinationFirstCommit().newWriter(destinationFiles),
        new DummyReference("first_commit"));
    process(destinationFirstCommit().newWriter(destinationFiles), firstCommit);
    destinationFiles = new Glob(ImmutableList.of("**"), ImmutableList.of("excluded.txt"));
    process(destination().newWriter(destinationFiles), new DummyReference("ref"));
    destinationFiles = new Glob(ImmutableList.of("**"), ImmutableList.of("**/HEAD"));
    process(destination().newWriter(destinationFiles), new DummyReference("ref"));
    process(destinationFirstCommit().newWriter(destinationFiles), ref);
    process(destination().newWriter(destinationFiles), ref);
    processWithBaseline(destination().newWriter(destinationFiles), ref, firstCommit);
    process(destinationFirstCommit().newWriter(destinationFiles), ref);
    process(destination().newWriter(destinationFiles), ref);
    processWithBaseline(destination().newWriter(destinationFiles), ref, firstCommit);
  public void processWithBaselineSameFileNoConflict() throws Exception { 
    process(destinationFirstCommit().newWriter(destinationFiles), ref);
    process(destination().newWriter(destinationFiles), ref);
    processWithBaseline(destination().newWriter(destinationFiles), ref, firstCommit);
    Destination.Writer writer = destinationFirstCommit().newWriter(destinationFiles);
    WriterResult result =
        writer.write(TransformResults.of(workdir, new DummyReference("ref1")), console);

  private void checkSubmoduleInDestination() throws Exception {
    fetch = "master";
    push = "master";

    GitRepository submodule = GitRepository.initScratchRepo(/*verbose=*/true, System.getenv());

    Files.write(submodule.getWorkTree().resolve("foo"), new byte[] {1});
    submodule.simpleCommand("add", "foo");
    submodule.simpleCommand("commit", "-m", "dummy commit");

    Path scratchTree = Files.createTempDirectory("GitDestinationTest-scratchTree");
    GitRepository scratchRepo = repo().withWorkTree(scratchTree);
    scratchRepo.simpleCommand("submodule", "add", "file://" + submodule.getWorkTree(), "submodule");
    scratchRepo.simpleCommand("commit", "-m", "commit submodule");

    Files.write(workdir.resolve("test42"), new byte[] {42});
    Destination.Writer writer = destination().newWriter(destinationFiles);
    WriterResult result = writer.write(
        TransformResults.of(workdir, new DummyReference("ref1")),
        console);
    assertThat(result).isEqualTo(WriterResult.OK);

    GitTesting.assertThatCheckout(repo(), "master")
        .containsFiles(".gitmodules", "submodule");
  }

  @Test
  public void submoduleInDestination_negativeDestinationFilesGlob() throws Exception {
    destinationFiles =
        new Glob(ImmutableList.of("**"), ImmutableList.of(".gitmodules", "submodule"));
    checkSubmoduleInDestination();
  }

  @Test
  public void submoduleInDestination_positiveDestinationFilesGlob() throws Exception {
    destinationFiles = new Glob(ImmutableList.of("test42"));
    checkSubmoduleInDestination();
  }