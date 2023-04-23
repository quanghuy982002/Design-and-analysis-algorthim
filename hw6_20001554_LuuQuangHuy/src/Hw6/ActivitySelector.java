package Hw6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ActivitySelector {

    public static void main(String[] args) {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9};

        ArrayList<Integer> selectedActivities = activitySelector(startTimes, endTimes);

        System.out.println("Selected activities: " + selectedActivities.toString());

        // Generate a random array of start times and end times
        int n = 10000;
        int[] randomStartTimes = new int[n];
        int[] randomEndTimes = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            randomStartTimes[i] = random.nextInt(10);
            randomEndTimes[i] = randomStartTimes[i] + random.nextInt(10) + 1;
        }

        // Print the random array of start times and end times
        System.out.println("Random start times: " + Arrays.toString(randomStartTimes));
        System.out.println("Random end times: " + Arrays.toString(randomEndTimes));

        // Time the activity selector algorithm with the random array
        long startTime = System.nanoTime();
        ArrayList<Integer> randomSelectedActivities = activitySelector(randomStartTimes, randomEndTimes);
        long endTime = System.nanoTime();

        // Print the selected activities and the elapsed time
        System.out.println("Random selected activities: " + randomSelectedActivities.toString());
        System.out.println("Elapsed time: " + (endTime - startTime) + " nanoseconds");
    }

    public static ArrayList<Integer> activitySelector(int[] startTimes, int[] endTimes) {
        ArrayList<Integer> selectedActivities = new ArrayList<>();
        selectedActivities.add(0); // add the first activity to selected activities

        int j = 0;
        for (int i = 1; i < startTimes.length; i++) {
            if (startTimes[i] >= endTimes[j]) {
                selectedActivities.add(i);
                j = i;
            }
        }

        return selectedActivities;
    }

}
