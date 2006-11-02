package com.intellij.localvcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

public abstract class TestCase extends Assert {
  protected LocalVcs vcs;
  protected Snapshot s;

  @Before
  public void setUp() {
    vcs = new LocalVcs();
    s = new Snapshot();
  }

  protected Path p(String name) {
    return new Path(name);
  }

  protected ChangeSet cs(Change... changes) {
    return new ChangeSet(Arrays.asList(changes));
  }

  @SuppressWarnings("unchecked")
  protected void assertElements(Object[] expected, Collection actual) {
    assertEquals(expected.length, actual.size());
    assertTrue(actual.containsAll(Arrays.asList(expected)));
  }

  protected void assertEntiesContents(String[] expectedContents,
                                      Collection<Entry> actualEntries) {
    List<String> actualContents = new ArrayList<String>();
    for (Entry rev : actualEntries) {
      actualContents.add(rev.getContent());
    }
    assertEquals(expectedContents, actualContents.toArray(new Object[0]));
  }
}
