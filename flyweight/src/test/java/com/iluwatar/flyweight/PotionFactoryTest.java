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
package com.iluwatar.flyweight;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PotionFactoryTest {
  Potion healingPotion, holyWaterPotion, invisibilityPotion, poisonPotion, strengthPotion;

  @Mock
  Map<PotionType, Potion> potions;

  @InjectMocks
  PotionFactory potionFactory;

  @Before
  public void setUp() {
    healingPotion = new HealingPotion();
    holyWaterPotion = new HolyWaterPotion();
    invisibilityPotion = new InvisibilityPotion();
    poisonPotion = new PoisonPotion();
    strengthPotion = new StrengthPotion();
  }

  @Test
  public void potionFactoryTest() {

    doReturn(null).when(potions).get(PotionType.HEALING);
    doReturn(null).when(potions).get(PotionType.HOLY_WATER);
    doReturn(null).when(potions).get(PotionType.INVISIBILITY);
    doReturn(null).when(potions).get(PotionType.POISON);
    doReturn(null).when(potions).get(PotionType.STRENGTH);

    Potion potion = potionFactory.createPotion(PotionType.HEALING);
    assertEquals(potion.getClass(), healingPotion.getClass());

    potion = potionFactory.createPotion(PotionType.HOLY_WATER);
    assertEquals(potion.getClass(), holyWaterPotion.getClass());

    potion = potionFactory.createPotion(PotionType.INVISIBILITY);
    assertEquals(potion.getClass(), invisibilityPotion.getClass());

    potion = potionFactory.createPotion(PotionType.POISON);
    assertEquals(potion.getClass(), poisonPotion.getClass());

    potion = potionFactory.createPotion(PotionType.STRENGTH);
    assertEquals(potion.getClass(), strengthPotion.getClass());
  }
}
