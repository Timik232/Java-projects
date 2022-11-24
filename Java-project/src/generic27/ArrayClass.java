package generic27;

public  class ArrayClass <E> {
    private E[] arr;
    public ArrayClass(E[] arr){
        this.arr = arr;
    }
    public void printArray(){
        for (E element: arr) {
            System.out.println(element);
        }
    }
}
