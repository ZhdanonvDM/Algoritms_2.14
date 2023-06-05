package pro.sky;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StringListImpl implements StringList{
    private String[] s = new String[2];


    public StringListImpl() {
        this.s = s;
    }


    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("Нельзя добавлять значение null");
        }
            String[] s2 = new String[size()+1];
            for (int i = 0; i < index; i++) {
                s2[i] = s[i];
            }
            s2[index] = item;
            for (int i = index; i < s.length; i++) {
                s2[i+1] = s[i];
            }
            s = s2;
            return item;
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException("Нельзя добавлять значение null");
        }
        if (size() != s.length) {
            for (int i = 0; i < s.length; i++) {
                if (s[i] == null) {
                    s[i] = item;
                    return item;
                }
            }
        } else {
            int size1 = size()+1;
            String[] s2 = new String[size1];
            for (int i = 0; i < size(); i++) {
                s2[i] = s[i];
            }
            s = s2;
            s[size()] = item;}
        return item;
    }


    @Override
    public String remove(String item) {
        if (indexOf(item) == -1) {
            throw new NoSuchElementException("В этом списке нет данного элемента");
        }
        remove(indexOf(item));
        return item;
    }


    @Override
    public String remove(int index) {
        if (index > size()-1 || index < 0) {
            throw new IndexOutOfBoundsException("В этом списке нет элемента с данным индексом");
        }
        String[] s2 = new String[s.length-1];
        for (int i = 0; i < index; i++) {
            s2[i] = s[i];
        }
        for (int i = index; i < s.length-1; i++) {
            s2[i] = s[i+1];
        }
        s = s2;
        return get(index);
    }

    @Override
    public boolean contains(String item) {
        boolean check = false;
        for (int i = 0; i < size(); i++) {
            if (s[i].equals(item)) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (s[i].equals(item)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        for (int i = size()-1; i >= 0; i--) {
            if (s[i].equals(item)) {
                index = i;
            }
        }
        return index;
    }



    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(otherList.toArray(), s);
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }



    @Override
    public String get(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("В этом списке нет элемента с данным индексом");
        }
        return s[index];
    }

    @Override
    public String[] toArray() {
        String[] s2 = new String[size()];
        for (int i = 0; i < size(); i++) {
            s2[i] = s[i];
        }
        return s2;
    }

    @Override
    public void clear() {
        s = new String[0];
    }
    @Override
    public String set(int index, String item) {
        if (index > size()-1 || index < 0) {
            throw new IndexOutOfBoundsException("В этом списке нет элемента с данным индексом");
        }
        s[index] = item;
        return item;
    }
    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                size = i+1;
            }
        }
        return size;
    }

}
