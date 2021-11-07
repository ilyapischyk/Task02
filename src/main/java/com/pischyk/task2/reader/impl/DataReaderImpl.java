package com.pischyk.task2.reader.impl;

import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {
    private final static Logger logger = LogManager.getLogger();

    public ArrayList<String> readFile(String path) throws CustomException{
        logger.info("Reading file");
        ArrayList<String> lines = null;
        Path pathFile = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(pathFile)){
            lines = lineStream.collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            logger.error("Readind was failed");
        }
        return lines;
    }
}
