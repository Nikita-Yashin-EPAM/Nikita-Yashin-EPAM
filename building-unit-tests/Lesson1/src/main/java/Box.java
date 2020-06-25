import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Box<T extends Fruit> {

    public ArrayList<T> boxArrayList = new ArrayList<T>();

    public Box(ArrayList<T> boxArrayList) {
        this.boxArrayList = boxArrayList;
    }


    void addFruit(T t) {
        boxArrayList.add(t);
    }

    void removeFruit(T t) {
        boxArrayList.remove(t);
    }

    float getWeight() {
        if (boxArrayList != null && boxArrayList.size() > 0) {
            float sumWeight = 0;
            for (T t : boxArrayList) {
                sumWeight += t.weight;
            }
            return sumWeight;
        } else {
            throw new NoSuchElementException();
        }
    }

    boolean compareWeight(Box<T> box) {
        return box.getWeight() == this.getWeight();
    }

    void removeAll(Box<T> boxToRemoveElements, Box<T> boxToCollectElements) {
        for (T t : boxToRemoveElements.boxArrayList) {
            boxToCollectElements.boxArrayList.add(t);
            boxToRemoveElements.boxArrayList.remove(t);
        }
    }

}
