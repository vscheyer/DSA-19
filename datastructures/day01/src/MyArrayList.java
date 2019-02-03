public class MyArrayList {
    private Cow[] elems;
    private Cow[] newElems;
    private int size;

    // TODO: Runtime: O(N)
    public MyArrayList() {
        elems = new Cow[10]; //should we use Cow datatype in place of int?
    }

    // TODO: Runtime: O(N)
    public MyArrayList(int capacity) {
        elems = new Cow[capacity];
    }

    // TODO: Runtime: O(1)*
    public void add(Cow c) {
        if (size == elems.length) {
            Cow[] newElems = new Cow[elems.length*2];
            System.arraycopy(elems, 0, newElems,
                    0, size);
            elems = newElems;
        }
        elems[size] = c;
        size++;
    }

    // TODO: Runtime: O(1) ---> How to make this with O(1) time complexity?
    public int size() {
        return size;
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) throws IndexOutOfBoundsException {
        if (index < size) {
//        if (elems[index] instanceof Cow) {
            return elems[index];
        } else {
            throw new IndexOutOfBoundsException("This sucks");
        }
    }

    // TODO: Runtime: O(N)
    public Cow remove(int index) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException("This sucks");
        }
        if (elems.length/4 > size) {
            Cow[] newElems = new Cow[elems.length/4];
            System.arraycopy(elems, 0, newElems,
                    0, size);
            elems = newElems;
        }
        for (int i = index; i < size-1; i++) {
            elems[i] = elems[i+1];
        }
        size--;
        return elems[index];
    }

    // TODO: Runtime: O(N)
    public void add(int index, Cow c) {
        if (index > size) {
            throw new IndexOutOfBoundsException("This sucks");
        }
        if (size == elems.length) {
            Cow[] newElems = new Cow[elems.length*2];
            System.arraycopy(elems, 0, newElems,
                    0, size);
            elems = newElems;
        }
        for (int i=size-1; i>index; i--) {
            elems[i] = elems[i-1];
        }
        elems[index] = c;
        size++;
    }
}