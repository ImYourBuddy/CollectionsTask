package com.mycompany.mylist;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<DATA> implements ILinkedList<DATA> {
    private int size = 0;
    private Node<DATA> first;
    private Node<DATA> last;

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param element the element to add
     */
    public void addFirst(DATA element) {
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
    public void add(DATA element) {
        if (last == null) {
            last = new Node<>(element, null);
            first = last;
        } else {
            Node<DATA> newNode = new Node<>(element, null);
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
    public void add(int index, DATA element) {
        checkIndex(index);
        if (index == size) {
            add(element);
            return;
        } else if (index == 0) {
            addFirst(element);
            return;
        } else {
            Node<DATA> slider = first;
            for (int i = 1; i < index; i++) {
                slider = slider.nextNode;
            }
            slider.nextNode = new Node<>(element, slider.nextNode);
        }
        size++;
    }

    public DATA getFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.data;
    }
    public DATA getLast() {
        if (last == null) {
            throw new NoSuchElementException("List is empty");
        }
        return last.data;
    }

    @Override
    public void clear() {
        Node<DATA> cleaner = first;
        while (cleaner != null) {
            Node<DATA> next = cleaner.nextNode;
            cleaner.data = null;
            cleaner.nextNode = null;
            cleaner = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public DATA get(int index) {
        checkIndexGet(index);
        Node<DATA> slider = first;
        for (int i = 0; i < index; i++) {
            slider = slider.nextNode;
        }
        return slider.data;
    }

    @Override
    public int indexOf(DATA element) {
        int index = 0;
        Node<DATA> slider = first;
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
    public DATA remove(int index) {
        checkIndexGet(index);
        Node<DATA> slider = first;
        DATA data = slider.data;
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
    public DATA set(int index, DATA element) {
        checkIndexGet(index);
        Node<DATA> slider = first;
        for (int i = 0; i < index; i++) {
            slider = slider.nextNode;
        }
        DATA data = slider.data;
        slider.data = element;
        return data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DATA[] toArray() {
        DATA[] result = (DATA[]) Array.newInstance(first.data.getClass(), size);
        Node<DATA> slider = first;
        int index = 0;
        while (slider != null) {
            result[index] = slider.data;
            slider = slider.nextNode;
            index++;
        }
        return result;
    }

    @Override
    public String toString() {
        Iterator<DATA> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            DATA e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public Iterator<DATA> iterator() {
        Iterator<DATA> MyLinkedListIterator = new Iterator<>() {
            private Node<DATA> current = null;
            private Node<DATA> prev = null;
            private int currentIndex = -1;
            @Override
            public boolean hasNext() {
                return currentIndex < size - 1;
            }

            @Override
            public DATA next() {
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

    private static class Node<DATA> {
        private DATA data;
        private Node<DATA> nextNode;

        public Node(DATA data, Node<DATA> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }
}

