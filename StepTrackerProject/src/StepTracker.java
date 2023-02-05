import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {

    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    int targetSteps = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void enteringSteps() {
        int month;
        int day;
        int steps;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца");
        month = scanner.nextInt();
        System.out.println("Введите номер дня");
        day = scanner.nextInt();
        System.out.println("Введите количество шагов");
        steps = scanner.nextInt();
        MonthData stepsData = monthToData.get(month);
        stepsData.setStepsDay(day, steps);
        monthToData.replace(month, stepsData);
    }

    public void printingStatistics() {
        System.out.println("Введите номер месяца");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int[] stepsData;
        stepsData = monthToData.get(month).getStepsDay();
        for (int i = 0; i < stepsData.length; i++) {
            System.out.print((i + 1) + " день: " + stepsData[i] + "; ");
        }
        System.out.println();
        System.out.println("Среднее количество шагов за месяц: " + Converter.averageValue(stepsData) + " шагов.");
        System.out.println("За месяц пройдено: " + Converter.distanceInKm(stepsData) + " километров.");
        System.out.println("Сожжено: " + Converter.burnedKilocalories(stepsData) + " килокалорий.");
        System.out.println("Лучшая серия: " + Converter.bestRange(stepsData, targetSteps) + " дней.");
    }

    public void changeGoal() {
        int newGoal;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новую цель по количеству шагов в день");
        newGoal = scanner.nextInt();
        if (newGoal >= 0) {
            targetSteps = newGoal;
            System.out.println("Цель по шагам изменена на " + targetSteps);
        } else System.out.println("Цель по шагам не может быть отрицательной!");
    }

    private class MonthData {
        int[] stepsDay = new int[30];

        public MonthData() {
            Arrays.fill(stepsDay, 0);
        }

        public void setStepsDay(int day, int steps) {
            stepsDay[day - 1] = steps;
        }

        public int[] getStepsDay() {
            return stepsDay;
        }
    }

    private static class Converter {
        private static final int CENTIMETERS_IN_STEP = 75;
        private static final int METERS_IN_KILOMETER = 1000;
        private static final int CALORIES_IN_STEP = 50;
        private static final int CALORIES_IN_KILOCALORIES = 1000;

        static int monthSum(int[] array) {
            int result = 0;
            for (int i : array) {
                result += i;
            }
            return result;
        }

        static int averageValue(int[] array) {
            return (int) (Converter.monthSum(array) / 30.0);
        }

        static double distanceInKm(int[] array) {
            return (Converter.monthSum(array) * CENTIMETERS_IN_STEP / (double) METERS_IN_KILOMETER / 100);
        }

        static int burnedKilocalories(int[] array) {
            return (int) (Converter.monthSum(array) * CALORIES_IN_STEP / (double) CALORIES_IN_KILOCALORIES);
        }

        static int bestRange(int[] array, int goal) {
            int counter = 0;
            int result = 0;
            for (int j : array) {
                if (j > goal) {
                    counter++;
                } else {
                    if (counter > result) {
                        result = counter;
                        counter = 0;
                    }
                }
            }
            return result;
        }
    }
}