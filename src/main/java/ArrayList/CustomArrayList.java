package ArrayList;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    private Object[] array;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * constructor initializing array with default capacity.
     */
    public CustomArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    /**
     * adds element to the end of the list.
     *
     * @param element to add(can't be null).
     * @throws IllegalArgumentException if argument equals null.
     */
    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        ensureCapacity();
        array[size++] = element;
    }

    /**
     * adds element to the specified index.
     *
     * @param element to add(can't be null).
     * @param index   at which we add element.
     * @throws IllegalArgumentException  if argument equals null.
     * @throws IndexOutOfBoundsException if argument is out of bounds.
     */
    @Override
    public void add(T element, int index) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * changes element by index to new one.
     *
     * @param element element to set (can't be null).
     * @param index   of element to change.
     * @return changed element.
     * @throws IllegalArgumentException  if argument equals null.
     * @throws IndexOutOfBoundsException if argument is out of bounds.
     */
    @Override
    public T set(T element, int index) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T oldElement = (T) array[index];
        array[index] = element;
        return oldElement;
    }

    /**
     * returns element by index.
     *
     * @param index of element occurrence.
     * @return list's element by that index.
     * @throws IndexOutOfBoundsException if argument is out of bounds.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    /**
     * removes element by index and shifts all next elements to the left.
     *
     * @param index index of element to delete.
     * @return deleted element.
     * @throws IndexOutOfBoundsException if argument is out of bounds.
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removedElement;
    }

    /**
     * method that checks list's capacity and allows to increase capacity.
     */
    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = (array.length * 3) / 2 + 1;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    /**
     * returns list's size.
     *
     * @return size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * clears list.
     */
    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    /**
     * checks if list is empty.
     *
     * @return true if it's empty and false else.
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
