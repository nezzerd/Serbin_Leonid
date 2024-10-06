package ArrayList;

public interface CustomList<T> {
    /**
     * adds element to the end of the list.
     *
     * @param element to add(can't be null).
     * @throws IllegalArgumentException if argument equals null.
     */
    void add(T element);

    /**
     * adds element to the specified index.
     *
     * @param element to add(can't be null).
     * @param index   at which we add element.
     * @throws IllegalArgumentException  if argument equals null.
     * @throws IndexOutOfBoundsException if argument is out of bounds.
     */
    void add(T element, int index);

    /**
     * changes element by index to new one.
     *
     * @param element element to set (can't be null).
     * @param index   of element to change.
     * @return changed element.
     * @throws IllegalArgumentException  if argument equals null.
     * @throws IndexOutOfBoundsException if argument is out of bounds.
     */
    T set(T element, int index);

    /**
     * returns element by index.
     *
     * @param index of element occurrence.
     * @return list's element by that index.
     * @throws IndexOutOfBoundsException if argument is out of bounds.
     */
    T get(int index);

    /**
     * removes element by index and shifts all next elements to the left.
     *
     * @param index index of element to delete.
     * @return deleted element.
     * @throws IndexOutOfBoundsException if argument is out of bounds.
     */
    T remove(int index);
}
