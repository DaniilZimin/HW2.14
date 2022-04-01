package com.company;

import com.company.exception.AddNullException;
import com.company.exception.OutOfRangeException;
import com.company.exception.RemovingNonExistingElementException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    public String[] strings;
    int size = 0;

    public StringListImpl() {
        this.strings = new String[10];
    }

    @Override
    public String add(String item) {
        checkItem(item);
        increaseArray();
        strings[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkItem(item);
        increaseArray();
        if (index < 0 || index > size) {
            throw new OutOfRangeException("Выход за пределы фактического количества элементов");
        }

        if (strings[index] != null) {
            System.arraycopy(strings, index, strings, index + 1, size - index);
        }
        strings[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkItem(item);
        checkIndex(index);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(item)) {
                return remove(i);
            }
        }
        throw new RemovingNonExistingElementException("Удаление не существующего элемента");
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String s = strings[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(strings, index + 1, strings, index, size - 1 - index);
        }
        size--;
        return s;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return strings[index];
    }

    @Override
    public boolean equals(String[] otherList) {
        checkItem(otherList[0]);
        if (strings.length != otherList.length) {
            return false;
        }
        return Arrays.equals(strings, otherList);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            strings[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] copy = new String[size];
        copy = Arrays.copyOf(strings, size);
        return copy;
    }

    private void checkItem(String item) {
        if (item == null) {
            throw new AddNullException("Добавление пустого элемента");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new OutOfRangeException("Выход за пределы фактического количества элементов");
        }
    }

    private void increaseArray() {
        if (size >= strings.length) {
            strings = Arrays.copyOf(strings, strings.length * 2);
        }
    }
}
