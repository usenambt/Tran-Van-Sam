package repository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepositoryImpl implements DictionaryRepository {
    private static Map<String, String> dictionary ;
    static {
        dictionary=new HashMap<>();
        dictionary.put("hello", "Xin chao");
        dictionary.put("how", "The nao");
        dictionary.put("book", "Quyen vo");
        dictionary.put("computer", "May tinh");
    }

    @Override
    public String search(String string) {
        String result = dictionary.get(string);
        if(result!=null){
            return result;
        } else {
            return null;
        }

    }
}