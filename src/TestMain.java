import java.util.LinkedList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        MediaChain m = new MediaChain();
        m.printStr();
    }
}

abstract class Media {
    abstract void printStr();
}

class Book extends Media {
    @Override
    void printStr() {
        System.out.println("我是书");
    }
}

class Newspaper extends Media {
    @Override
    void printStr() {
        System.out.println("我是报纸");
    }
}

class Video extends Media {
    @Override
    void printStr() {
        System.out.println("我是视频");
    }
}

class MediaChain extends Media {

    private List<Media> mediaList = new LinkedList<>();

    public MediaChain() {
        mediaList.add(new Book());
        mediaList.add(new Video());
        mediaList.add(new Newspaper());
    }

    public void add(Media media) {
        mediaList.add(media);
    }

    public void remove(Media media){
        mediaList.remove(media);
    }

    @Override
    void printStr() {
        for (Media media : mediaList) {
            media.printStr();
        }
    }
}