/*
 * Copyright 2000-2014 JetBrains s.r.o.
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
package com.jetbrains.python.commandInterface.commandsWithArgs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Command
 * TODO: add args
 *
 * @author Ilya.Kazakevich
 */
public final class Command {
  @NotNull
  private final String myName;
  @NotNull
  private final List<Argument> myArguments = new ArrayList<Argument>();
  @Nullable
  private final String myHelp;

  /**
   * @param help help text
   * @param name      command name
   * @param arguments command arguments
   */
  public Command(@NotNull final String name, @Nullable final String help, @NotNull final Argument... arguments) {
    this(name, help, Arrays.asList(arguments));
  }

  /**
   * @param help help text
   * @param name      command name
   * @param arguments command arguments
   */
  public Command(@NotNull final String name, @Nullable final String help, @NotNull final Collection<Argument> arguments) {
    myName = name;
    myArguments.addAll(arguments);
    myHelp = help;
  }

  /**
   * @return command name
   */
  @NotNull
  String getName() {
    return myName;
  }

  /**
   * @return command arguments
   */
  @NotNull
  List<Argument> getArguments() {
    return Collections.unmodifiableList(myArguments);
  }

  @Nullable
  public String getHelp() {
    return myHelp;
  }
}
