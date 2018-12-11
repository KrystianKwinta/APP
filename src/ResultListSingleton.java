import java.util.ArrayList;
import java.util.List;

public class ResultListSingleton {

    private static ResultListSingleton instance = null;
    private List<String> list;

    private ResultListSingleton() {
        list = new ArrayList<>();
    }

    public static ResultListSingleton getInstance() {
        if (instance == null) {
            instance = new ResultListSingleton();
        }
        return instance;
    }

    public List<String> getList() {
        return list;
    }

    public void addToResult(String el) {
        list.add(el);
    }

    public void clearResult() {
        list.clear();
    }

}