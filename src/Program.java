public class Program {
    public static void main(String[] args) {
        DynamicArray<Integer> intList = new DynamicArray<>();
        intList.add(10);
        intList.add(5);
        intList.add(4);
        intList.add(2);
        intList.add(3);
        intList.add(1);
        intList.add(7);
        intList.add(9);
        intList.add(6);
        intList.add(8);
        intList.add(5);
        System.out.print("Массив целых чисел: ");
        intList.printArray();
        intList.removeIndex(2);
        System.out.print("Массив после удаления элементов по индексу: ");
        intList.printArray();
        intList.removeData(5);
        System.out.print("Массив после удаления элементов по значению: ");
        intList.printArray();
        System.out.println("Минимальное значение в массиве: " + intList.getMin());
        System.out.println("Максимальное значение в массиве: " + intList.getMax());
        System.out.println("Сумма элементов в массиве: " + intList.getSum());
        System.out.println("Произведение элементов в массиве: " + intList.getProduct());
        System.out.println("Индекс элемента '1': " + intList.findIndex(1));
        System.out.println("Присутствует значение '11' в массиве: " + intList.contains(11));
        try {
            intList.bubbleSorting();
            System.out.print("Массив после пузырьковой сортировки: ");
            intList.printArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
