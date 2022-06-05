package com.example.firebasekayit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntRegEx {
    private String result;
    private int temp1;
    final private String[] array = {"bas, kulak, burun"};
    public void calculate(String[] compiler){
        for(String input : compiler){
            Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);

            for(String compare : array){
                Matcher matcher = pattern.matcher(compare);
                if(matcher.find()){
                    temp1++;
                }
            }
        }
        if(temp1 >= 2){
            result = "KBB ye görünün";
        }
        else{
            result = "";
        }
        temp1 = 0;

    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTemp1() {
        return temp1;
    }

    public void setTemp1(int temp1) {
        this.temp1 = temp1;
    }
}
