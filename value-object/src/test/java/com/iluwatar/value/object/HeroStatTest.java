/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.value.object;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.junit.Before;

/**
 * Unit test for HeroStat.
 */
@RunWith(MockitoJUnitRunner.class)
public class HeroStatTest {
  int strength, intelligence, luck;
  HeroStat heroStat;

  @Before
  public void setUp() {
    strength = 1;
    intelligence = 2;
    luck = 3;
    heroStat = HeroStat.valueOf(strength, intelligence, luck);
  }

  @Test
  public void testGets() {
    assertThat(heroStat.getStrength(), is(strength));
    assertThat(heroStat.getIntelligence(), is(intelligence));
    assertThat(heroStat.getLuck(), is(luck));
  }

  @Test
  public void testToString() {
    assertThat(heroStat.toString(), is("HeroStat [strength=" + strength + ", intelligence=" + intelligence
            + ", luck=" + luck + "]"));
  }

  @Test
  public void testHash() {
    assertThat(heroStat.hashCode(), is(31807));
  }

  @Test
  public void testEquals() {
    assertThat(heroStat.equals(heroStat), is(true));
    assertThat(heroStat.equals(null), is(false));
    assertThat(heroStat.equals(int.class), is(false));
    assertThat(heroStat.equals(HeroStat.valueOf(strength, intelligence+1, luck)), is(false));
    assertThat(heroStat.equals(HeroStat.valueOf(strength, intelligence, luck+1)), is(false));
    assertThat(heroStat.equals(HeroStat.valueOf(strength+1, intelligence, luck)), is(false));
    assertThat(heroStat.equals(HeroStat.valueOf(strength, intelligence, luck)), is(true));
  }

}
