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
