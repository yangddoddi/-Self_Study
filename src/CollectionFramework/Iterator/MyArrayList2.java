package CollectionFramework.Iterator;

import CollectionFramework.ArrayList.MyArrayList;

import java.util.Iterator;

public class MyArrayList2<T> extends MyArrayList<T> implements Iterator<T> {
    int cursor = 0;
    int lastRet = -1;

    public MyArrayList2(int capacity) {
        super(capacity);
    }

    public MyArrayList2() {
        this(10);
    }

    public String toString() {
        String str = "";
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            if ( cursor != size()-1 ) { // cursor가 마지막이라면 쉼표 x
            str = str + it.next() + ", "; }
            else {
                str += it.next();
            }
        }
        return "[" + str + "]";
    }

    public Iterator<T> iterator() {
        cursor = 0;
        lastRet = -1;
        return this;
    }

    public boolean hasNext() {
        return cursor != size();
    }

    public T next() {
        if (cursor > size()) {
            throw new IllegalStateException();
        }
        T next = (T)get(cursor);
        lastRet = cursor++; // next()를 호출하면 lastRet은 cursor이 이전에 가르키던 데이터를 가르킨다.
        return next;
    }

    public void remove() {
        if (lastRet == -1) {
            throw new IllegalStateException();
        }
        remove(get(lastRet));
        lastRet = -1; // next가 선행되지 않는다면 remove를 불가능한 상태로.
        cursor--;
    }
}
