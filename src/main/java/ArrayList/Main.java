package ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("After add: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2));

        list.add("4", 1);
        System.out.println("After add at index 1: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2) + ", " + list.get(3));

        System.out.println("Get element at index 2: " + list.get(2));

        String replaced = list.set("Replaced", 2);
        System.out.println("Replaced element at index 2: " + replaced);
        System.out.println("After set at index 2: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2) + ", " + list.get(3));

        String removed = list.remove(1);
        System.out.println("Removed element at index 1: " + removed);
        System.out.println("After remove at index 1: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2));

        System.out.println("List size: " + list.size()); // Ожидаем 3

        list.clear();
        System.out.println("After clear, list size: " + list.size());

        System.out.println("Is list empty? " + list.isEmpty());
    }
}