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