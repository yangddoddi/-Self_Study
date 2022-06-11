package CollectionFramework.ArrayList;

import org.jetbrains.annotations.NotNull;

import java.util.*;

class MyArrayList<T> implements List {
    Object[] obj = null;
    int capacity = 0;
    int size = 0;

    MyArrayList() {
        this.capacity = 10;
        obj = new Object[10];
    }

    MyArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("유효하지 않은 값 :" + capacity);
        this.capacity = capacity;
        obj = new Object[capacity];
    }

    public void ensureCapacity(int capacity) {
        if (capacity - this.size > 0) {
            this.capacity = capacity;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean add(Object o) {
        this.obj[this.size++] = o;
        ensureCapacity(this.size+1);
        return true;
    }

    public Object get(int index) {
        if ( index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("범위 이탈");
        }
        return this.obj[index];
    }

    public Object remove(int index) {
        Object oldObj = null;
        if ( index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("범위 이탈");
        }
        oldObj = this.obj[index];
        if ( index != size-1 ) {
            System.arraycopy(this.obj, index+1, this.obj, index, size-index-1);
            size--;
        }
        return oldObj;
        // ArrayList에 용량보다 많은 객체를 추가하거나 중간에 값을 삭제하면 배열을 복사해야하므로 효율적이지 않다.
    }

    public boolean remove(Object o) {
        for (int i=0; i<this.obj.length; i++) {
            if (this.obj[i] == o) {
                remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean addAll(@NotNull Collection c) {
        return false;
    }

    public boolean addAll(int index, @NotNull Collection c) {
        return false;
    }

    public boolean retainAll(@NotNull Collection c) {
        return false;
    }

    public boolean removeAll(@NotNull Collection c) {
        return false;
    }

    public boolean containsAll(@NotNull Collection c) {
        return false;
    }

    public void trimToSize() {
        this.capacity = this.size;
    }

    public void setCapacity(int capacity) {
        if (this.capacity == capacity) { return; }
        if (capacity < size) { return; }
        Object[] newObj = new Object[capacity];
        System.arraycopy(this.obj,0,newObj,0,this.size);
        this.obj = newObj;
        this.capacity = capacity;
    }

    public void clear() {
        Arrays.fill(this.obj, null);
    }

    public Object[] toArray() {
        Object[] newArr = new Object[size];
        System.arraycopy(this.obj,0,newArr,0,size);
        return newArr;
    }

    @NotNull
    public Object[] toArray(@NotNull Object[] a) {
        return new Object[0];
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        for (Object obj : this.obj) {
            if ( obj == o ) return true;
        }
        return false;
     }

    @NotNull
    public Iterator iterator() {
        return null;
    }

    public boolean equals(Object o) {
        for (Object obj : this.obj) {
            if ( obj != o ) return false;
        }
        return true;
     }

     public Object set(int index, Object element) {
        if ( index > this.size+1 || index < 0 ) throw new IndexOutOfBoundsException();
        this.obj[index] = element;
        return this.obj;
     }

     public void add(int index, Object element) {
         if ( index > this.size+1 || index < 0 ) throw new IndexOutOfBoundsException();
         if ( index <= this.size ) {
             Object[] newObj = new Object[this.capacity+1];
             System.arraycopy(this.obj, 0, newObj, 0, index);
             newObj[index] = element;
             System.arraycopy(this.obj, index, newObj, index+1, this.size-index);
             this.obj = newObj;
         } else {
             this.obj[index] = element;
         }
         size++;
     }

     public int indexOf(Object o) {
        for(Object obj : this.obj) {
            if ( obj == o ) { return 1; }
        }
        return -1;
     }

     public int lastIndexOf(Object o) {
        for(int i=this.size; i>=0; i--) {
            if (this.obj[i] == o) {
                return 1;
            }
        }
        return -1;
     }

    @NotNull
    public ListIterator listIterator() {
        return null;
    }

    @NotNull
    public ListIterator listIterator(int index) {
        return null;
    }

    @NotNull
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public String toString() {
        Object[] newArr = new Object[this.size];
        for (int i=0; i<this.size; i++) {
            newArr[i] = this.obj[i];
        }
        return Arrays.toString(newArr);
     }
}

public class ArrayListEX {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(20);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        System.out.println(list.contains(2));

        list.set(2, 4);
        System.out.println(list);

        list.add(2, 5);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
    }
}
