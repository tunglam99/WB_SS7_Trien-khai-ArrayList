import java.util.Arrays;

public class MyList<E> {
    private int size=0;
    private final int DEFAULT_CAPACITY =10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size){
        this.size=size;
    }

    private void ensureCapacity(int minCapa) {
        elements = Arrays.copyOf(elements,minCapa);
    }


    public void add(int index, E element) {
        if (size == DEFAULT_CAPACITY) {
            ensureCapacity(size * 2);
        }
        if (index > size) {
            elements[size++] = element;
        } else {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    public E remove(int index){
        if (index>size||index<0){
            throw new IndexOutOfBoundsException("Index:" +index+", size" +index);
        }else {
            E temp = (E) elements[index];
            for (int i= index;i<size;i++){
                elements[i] = elements[i+1];
            }
            size--;
            return temp;
        }
    }

    public int size() {
        return this.size;
    }

    public MyList clone() {
        return this;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public boolean add(E e) {
        if (!contains(e)) {
            add(size+1, e);
            return true;
        } else return false;
    }

    public E get(int i) {
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        System.out.println("Danh sach da bi xoa");
    }

}
