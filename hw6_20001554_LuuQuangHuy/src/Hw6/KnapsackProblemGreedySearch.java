package Hw6;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class KnapsackProblemGreedySearch {

    static class Item {
        int value;
        int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            double v1 = (double) o1.value / o1.weight;
            double v2 = (double) o2.value / o2.weight;
            return Double.compare(v2, v1);
        }
    }

    static int knapsackGreedy(List<Item> items, int capacity) {
        items.sort(new ItemComparator());

        int weight = 0;
        int value = 0;

        for (Item item : items) {
            if (weight + item.weight <= capacity) {
                weight += item.weight;
                value += item.value;
            } else {
                int remainingCapacity = capacity - weight;
                value += (int) (remainingCapacity * ((double) item.value / item.weight));
                break;
            }
        }

        return value;
    }

    public static void main(String[] args) {
        Random random = new Random();

        int n = 10; // số lượng đồ vật
        int capacity = 50; // khối lượng tối đa của balo
        List<Item> items = new ArrayList<>();

        // Tạo mảng ngẫu nhiên cho giá trị và khối lượng đồ vật
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100);
            int weight = random.nextInt(capacity);
            items.add(new Item(value, weight));
        }

        System.out.println("Giá trị của các đồ vật: " + items.stream().map(item -> item.value).toArray());
        System.out.println("Khối lượng của các đồ vật: " + items.stream().map(item -> item.weight).toArray());
        System.out.println("Khối lượng tối đa của balo: " + capacity);

        int maxValue = knapsackGreedy(items, capacity);
        System.out.println("Giá trị tối đa có thể đem đi: " + maxValue);
    }
}

