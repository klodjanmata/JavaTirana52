package JavaAdv.Exercises.Generics;

import java.util.HashMap;

public class Pair<T, S> {
    private T firstObject;
    private S secondObject;

    public Pair(T firstObject, S secondObject){
        this.firstObject = firstObject;
        this.secondObject = secondObject;
    }

    public Pair<T, S> getNewPair(){
        return new Pair<>(this.firstObject, this.secondObject);
    }

    public void setNewPair(Pair<T, S> newPair){
        this.firstObject = newPair.getFirstObject();
        this.secondObject = newPair.getSecondObject();
    }

    public Pair(){}

    public T getFirstObject() {
        return firstObject;
    }

    public S getSecondObject(){
        return secondObject;
    }

    public void setFirstObject(T object){
        this.firstObject = object;
    }

    public void setSecondObject(S object){
        this.secondObject = object;
    }
}
