package com.mycompany.mylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param element the element to add
     */
    public void addFirst(E element) {
        if (first == null) {
            first = new Node<>(element, null);
            last = first;
        } else {
            first = new Node<>(element, first);
        }
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     */
    @Override
    public void add(E element) {
        if (last == null) {
            last = new Node<>(element, null);
            first = last;
        } else {
            Node<E> newNode = new Node<>(element, null);
            last.nextNode = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if (index == size) {
            add(element);
            return;
        } else if (index == 0) {
            addFirst(element);
            return;
        } else {
            Node<E> slider = first;
            for (int i = 1; i < index; i++) {
                slider = slider.nextNode;
            }
            slider.nextNode = new Node<>(element, slider.nextNode);
        }
        size++;
    }

    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.data;
    }
    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException("List is empty");
        }
        return last.data;
    }

    @Override
    public void clear() {
        Node<E> cleaner = first;
        while (cleaner != null) {
            Node<E> next = cleaner.nextNode;
            cleaner.data = null;
            cleaner.nextNode = null;
            cleaner = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndexGet(index);
        Node<E> slider = first;
        for (int i = 0; i < index; i++) {
            slider = slider.nextNode;
        }
        return slider.data;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        Node<E> slider = first;
        if (element == null) {
            while (slider != null) {
                if (slider.data == null) {
                    return index;
                }
                slider = slider.nextNode;
                index++;
            }
        } else {
            while (slider != null) {
                if (slider.data == element) {
                    return index;
                }
                slider = slider.nextNode;
                index++;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndexGet(index);
        Node<E> slider = first;
        E data = slider.data;
        if (index == 0) {
            first = slider.nextNode;
            size--;
            return data;
        }
        if (index == size - 1) {
            for (int i = 1; i < index; i++) {
                slider = slider.nextNode;
            }
            data = slider.nextNode.data;
            slider.nextNode = null;
            last = slider;
            size--;
            return data;
        }
        for (int i = 1; i < index; i++) {
            slider = slider.nextNode;
        }
        data = slider.nextNode.data;
        slider.nextNode = slider.nextNode.nextNode;
        size--;
        return data;
    }

    @Override
    public E set(int index, E element) {
        checkIndexGet(index);
        Node<E> slider = first;
        for (int i = 0; i < index; i++) {
            slider = slider.nextNode;
        }
        E data = slider.data;
        slider.data = element;
        return data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        }
        Object[] result = array;
        int index = 0;
        Node<E> slider = first;
        while (slider != null) {
            result[index] = slider.data;
            slider = slider.nextNode;
            index++;
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> MyLinkedListIterator = new Iterator<>() {
            private Node<E> current = null;
            private Node<E> prev = null;
            private int currentIndex = -1;
            @Override
            public boolean hasNext() {
                return currentIndex < size - 1;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Going outside the list");
                }
                if (current == null && currentIndex == -1) {
                    current = first;
                    currentIndex++;
                    return current.data;
                }
                if (current == null && prev != null) {
                    current = prev.nextNode;
                }
                prev = current;
                current = current.nextNode;
                currentIndex++;
                return current.data;
            }

            @Override
            public void remove() {
                if (current == null) {
                    throw new IllegalStateException();
                }
                MyLinkedList.this.remove(currentIndex);
                currentIndex--;
                current = null;
            }
        };
        return MyLinkedListIterator;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index should be >= 0 and <= size");
    }

    private void checkIndexGet(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index should be >= 0 and < size");
    }

    private static class Node<E> {
        private E data;
        private Node<E> nextNode;

        public Node(E data, Node<E> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }
}

