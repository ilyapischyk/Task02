package com.pischyk.task2.reader;

import com.pischyk.task2.exception.CustomException;

import java.util.ArrayList;

public interface DataReader {
    public ArrayList<String> readFile(String path) throws CustomException;
}
