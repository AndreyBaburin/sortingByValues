package com.andrey_baburin.services;

import com.andrey_baburin.domain.Value;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class Calculation {
    private Value value;

    public Value createPost(String text) {
        this.value = new Value(text);
        return value;
    }

    public Value updatePost(String word) {
        return createPost(word);
    }

    public void delete (){
        value = null;
    }

    public List<Map.Entry<Character, Integer>> convertAndSort() {
        Map<Character, Integer> map = new TreeMap<>();
        char[] chArray = value.getIncomingValue().toCharArray();
        for (Character c : chArray) {
            if (map.containsKey(c)) {
                int currentCount = map.get(c);
                map.put(c, ++currentCount);
            } else {
                map.put(c, 1);
            }
        }
        List<Map.Entry<Character, Integer>> valuesList = new ArrayList(map.entrySet());
        Collections.sort(valuesList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return valuesList;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }


}
