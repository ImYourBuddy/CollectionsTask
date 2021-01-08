package com.mycompany.mylist;

public interface ILinkedList<E> extends Iterable<E> {
    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     */
    void add(E element);

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    void add(int index, E element);

    /**
     * Removes all of the elements from this list.
     */
    void clear();

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    E get(int index);

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int indexOf(E element);

    /**
     * Removes the element at the specified position in this list.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    E remove(int index);

    /**
     * Replaces the element at the specified position in this list with the specified element
     * @param index  index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    E set(int index, E element);

    /**
     * Returns the number of elements in this list.
     * @return
     */
    int size();

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     * @return an array containing all of the elements in this list in proper sequence.
     */
    E[] toArray();

    @Override
    String toString();


}
