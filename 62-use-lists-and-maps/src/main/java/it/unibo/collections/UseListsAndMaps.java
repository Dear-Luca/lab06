package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    final static long AFRICA = 1_110_635_000L;
    final static long AMERICAS = 972_005_000L;
    final static long ANTARTICA = 0L;
    final static long ASIE = 4_287_230_000L;
    final static long EUROPE = 742_452_000L;
    final static long OCEANIA = 38_304_000L;
    final static int START_INDEX = 1000;
    final static int END_INDEX = 2000;
    final static int ELEMENTS_TO_ADD = 100_000;
    final static int TIMES_TO_READ = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        final List<Integer> arrayList = new ArrayList<>();

        for (int i = START_INDEX; i < END_INDEX; i++) {
            arrayList.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> linkedList = new LinkedList<>(arrayList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        int tmp = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.set(arrayList.size() - 1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for (Integer element : arrayList) {
            System.out.println(element);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();

        for (int i = 0; i < ELEMENTS_TO_ADD; i++) {
            arrayList.add(0, i);
        }

        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Converting "
                        + arrayList.size()
                        + " ints to String and inserting them in a ARRAYLIST took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        time = System.nanoTime();
        for (int i = 0; i < ELEMENTS_TO_ADD; i++) {
            linkedList.add(0, i);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Converting "
                        + linkedList.size()
                        + " ints to String and inserting them in a LINKEDLIST took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();

        for (int i = 0; i < TIMES_TO_READ; i++) {
            arrayList.get(arrayList.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Converting "
                        + arrayList.size()
                        + " ints to String and inserting them in a ARRAYLIST took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        time = System.nanoTime();

        for (int i = 0; i < TIMES_TO_READ; i++) {
            linkedList.get(linkedList.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Converting "
                        + linkedList.size()
                        + " ints to String and inserting them in a LINKEDLIST took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> map = new HashMap<>();
        map.put("Africa", AFRICA);
        map.put("Americas", AMERICAS);
        map.put("Antartica", ANTARTICA);
        map.put("Asie", ASIE);
        map.put("Europe", EUROPE);
        map.put("Oceania", OCEANIA);

        /*
         * 8) Compute the population of the world
         */
        long count = 0L;
        for (Long val : map.values()) {
            count += val;
        }
        System.out.println(count);
    }
}
