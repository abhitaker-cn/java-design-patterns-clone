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
package com.iluwatar.collectionpipeline;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImperativeProgrammingTest {

    private List<Car> cars = CarFactory.createCars();

    @Test
    public void testGetModelsAfter2000UsingFor() {
        List<String> models = ImperativeProgramming.getModelsAfter2000(cars);
        assertEquals(Arrays.asList("Avenger", "Wrangler", "Focus", "Cascada"), models);
    }


    @Test
    public void testGetGroupingOfCarsByCategory() {
        Map<Category, List<Car>> modelsExpected = new HashMap<>();
        modelsExpected.put(Category.CONVERTIBLE, Arrays.asList(new Car("Buick", "Cascada", 2016, Category.CONVERTIBLE),
                new Car("Chevrolet", "Geo Metro", 1992, Category.CONVERTIBLE)));
        modelsExpected.put(Category.SEDAN, Arrays.asList(new Car("Dodge", "Avenger", 2010, Category.SEDAN),
                new Car("Ford", "Focus", 2012, Category.SEDAN)));
        modelsExpected.put(Category.JEEP, Arrays.asList(new Car("Jeep", "Wrangler", 2011, Category.JEEP),
                new Car("Jeep", "Comanche", 1990, Category.JEEP)));

        Map<Category, List<Car>> modelsImperative = ImperativeProgramming.getGroupingOfCarsByCategory(cars);

        assertEquals(modelsExpected, modelsImperative);
    }

    @Test
    public void testGetSedanCarsOwnedSortedByDate() {
        Person john = new Person(cars);
        List<Car> modelsExpected = Arrays.asList(new Car("Dodge", "Avenger", 2010, Category.SEDAN),
                new Car("Ford", "Focus", 2012, Category.SEDAN));

        List<Car> modelsImperative = ImperativeProgramming.getSedanCarsOwnedSortedByDate(Arrays.asList(john));

        assertEquals(modelsExpected, modelsImperative);
    }
}
