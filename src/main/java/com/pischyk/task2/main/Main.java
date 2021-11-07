package com.pischyk.task2.main;

import com.pischyk.task2.creator.PyramidRepositoryCreator;
import com.pischyk.task2.creator.PyramidWarehouseCreator;
import com.pischyk.task2.entity.Point;
import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.entity.PyramidValues;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.observer.Observer;
import com.pischyk.task2.observer.impl.PyramidObserver;
import com.pischyk.task2.parser.impl.StringPointParserImpl;
import com.pischyk.task2.reader.impl.DataReaderImpl;
import com.pischyk.task2.repository.PyramidRepository;
import com.pischyk.task2.warehouse.PyramidWareHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Main {
    private final static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CustomException {
        DataReaderImpl dataReader = new DataReaderImpl();
        ArrayList<String> arrayList = null;
        try {
            arrayList = dataReader.readFile("./src/main/resources/data/data.txt");
        } catch (CustomException e) {
            logger.error("File isn't correct");
        }
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        ArrayList<double[]> list = new ArrayList<>();
        for (String s : arrayList
        ) {
            try {
                double[] temp = stringPointParser.parsePointsForPyramid(s);
                list.add(temp);
            } catch (CustomException e) {
                e.printStackTrace();
            }

        }
        try {
            PyramidRepositoryCreator.createRepository(list);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        PyramidWarehouseCreator.createWarehouse(PyramidRepository.getInstance());
        PyramidWareHouse pyramidWareHouse = PyramidWareHouse.getInstance();
        PyramidRepository pyramidRepository = PyramidRepository.getInstance();
        PyramidValues pyramidValues = pyramidWareHouse.get(1);
        System.out.println(pyramidValues);
        Observer observer = new PyramidObserver();
        Pyramid pyramid = pyramidRepository.getPyramid(0);
        pyramid.attach(observer);
        pyramid.setTopPoint(new Point(0,0,6.0));
        pyramidValues = pyramidWareHouse.get(1);
        System.out.println(pyramidValues);
    }
}
