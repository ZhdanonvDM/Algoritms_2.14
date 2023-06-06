package pro.sky;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntegerListImpl implements IntegerList {
    private Integer[] s = new Integer[10];


    public IntegerListImpl() {
        this.s = s;
    }


    private Integer[] sortInsertion() {
        Integer[] result = Arrays.copyOf(s, size());
        for (int i = 1; i < size(); i++) {
            Integer temp = result[i];
            int j = i;
            while (j > 0 && result[j - 1] >= temp) {
                result[j] = result[j - 1];
                j--;
            }
            result[j] = temp;
        }
        return result;
    }


    @Override
    public boolean contains(Integer item) {
        boolean check = false;
        for (int i = 0; i < size(); i++) {
            if (s[i].equals(item)) {
                check = true;
            }
        }
        return check;
    }
    @Override
    public boolean containsBinary (Integer element) {
        Integer[] arr = sortInsertion();
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }




    @Override
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new NullPointerException("Нельзя добавлять значение null");
        }
            Integer[] s2 = new Integer[size()+1];
            for (int i = 0; i < index; i++) {
                s2[i] = s[i];
            }
            s2[index] = item;
            for (int i = index; i < size(); i++) {
                s2[i+1] = s[i];
            }
            s = s2;
            return item;
    }

    @Override
    public Integer add(Integer item) {
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
            Integer[] s2 = new Integer[size1];
            for (int i = 0; i < size(); i++) {
                s2[i] = s[i];
            }
            s = s2;
            s[size()] = item;}
        return item;
    }


    @Override
    public Integer remove(Integer item) {
        if (indexOf(item) == -1) {
            throw new NoSuchElementException("В этом списке нет данного элемента");
        }
        remove(indexOf(item));
        return item;
    }


    @Override
    public Integer remove(int index) {
        if (index > size()-1 || index < 0) {
            throw new IndexOutOfBoundsException("В этом списке нет элемента с данным индексом");
        }
        Integer[] s2 = new Integer[s.length-1];
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
    public int indexOf(Integer item) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (s[i].equals(item)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int index = -1;
        for (int i = size()-1; i >= 0; i--) {
            if (s[i].equals(item)) {
                index = i;
            }
        }
        return index;
    }



    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer get(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("В этом списке нет элемента с данным индексом");
        }
        return s[index];
    }

    @Override
    public Integer[] toArray() {
        Integer[] s2 = new Integer[size()];
        for (int i = 0; i < size(); i++) {
            s2[i] = s[i];
        }
        return s2;
    }

    @Override
    public void clear() {
        s = new Integer[0];
    }
    @Override
    public Integer set(int index, Integer item) {
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
