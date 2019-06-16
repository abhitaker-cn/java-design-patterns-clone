/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
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
package com.iluwatar.command;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ShrinkSpellTest {


    @InjectMocks
    ShrinkSpell shrinkSpell;

    @Test
    public void executeTest() {
        shrinkSpell.oldSize = Size.SMALL;

        Target expectedTarget = new Goblin();
        shrinkSpell.execute(expectedTarget);

        assertEquals(Size.NORMAL, shrinkSpell.oldSize);
        assertEquals(Size.SMALL, expectedTarget.getSize());
        assertEquals(expectedTarget, shrinkSpell.target);

    }

    @Test
    public void undoTest() {
        shrinkSpell.oldSize = Size.SMALL;
        shrinkSpell.target = new Goblin();

        shrinkSpell.undo();

        assertEquals(Size.NORMAL, shrinkSpell.oldSize);
        assertEquals(Size.SMALL, shrinkSpell.target.getSize());

    }
}