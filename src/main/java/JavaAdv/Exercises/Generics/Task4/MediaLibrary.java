package JavaAdv.Exercises.Generics.Task4;

import java.util.ArrayList;
import java.util.List;

public class MediaLibrary <T extends Media> {
    private List<T> mediaList;

    public MediaLibrary(List<T> mediaList) {
        this.mediaList = mediaList;
    }

    public MediaLibrary() {
        mediaList = new ArrayList<>();
    }

    public void add(T media){
        mediaList.add(media);
    }

    public void remove(T media){
        mediaList.remove(media);
    }

    public void printAll(){
        for (T media : mediaList) {
            System.out.println(media);
        }
    }

    public List<T> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<T> mediaList) {
        this.mediaList = mediaList;
    }
}
