package model;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapacity(int minCapacity) {
        if (size() >= 0) {
            int newSize = elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public void add(E ElementInput) {
        if (size() == elements.length) {
            ensureCapacity(5);
        }
        elements[size++] = ElementInput;
    }

    public void add(int index, E elementInput) {
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = elementInput;
        size++;
    }

    public int size() {
        return size;
    }

    public E remove(int indexInput) {
        if (indexInput < 0 || indexInput > size) {
            throw new IndexOutOfBoundsException("Index: " + indexInput + ", Size " + indexInput);
        } else for (int i = indexInput; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        Object removeElement = elements[indexInput];
        elements[size - 1] = null;
        size--;
        return (E) removeElement;
    }

    public boolean contains(E ElementInput) {
        if (indexOf(ElementInput) != -1) {
            return true;
        }
        return false;
    }

    public int indexOf(E elementInput) {
        for (int i = 0; i < size; i++) {
            if (elementInput == elements[i]) {
                return i;
            }
        }
        return -1;
    }


    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public E clone() {
        Object[] cMyList = new Object[DEFAULT_CAPACITY];
        if (size() == elements.length) {
            ensureCapacity(5);
        }
        if (size() >= 0) System.arraycopy(elements, 0, cMyList, 0, size());
        return (E) Arrays.toString(cMyList);

    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", element=" + Arrays.toString(elements) +
                '}';
    }

}