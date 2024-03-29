/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
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
package com.github.keven.problem37;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pedro Vicente Gómez Sánchez.
 */
public class PathCalculatorTest {

  private PathCalculator pathCalculator;

  @Before public void setUp() {
    pathCalculator = new PathCalculator();
  }

  @Test(expected = IllegalArgumentException.class) public void shouldNotAcceptNullPaths() {
    pathCalculator.calculate(null, null, null);
  }

  @Test public void shouldCalculatePath() {
    String finalPath = pathCalculator.calculate("/usr/bin/mail", "../../../etc/xyz", "../abc");

    assertEquals("/etc/abc/", finalPath);
  }
}
