package com.pischyk.task2.repository.impl;

import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.repository.Specification;
import com.pischyk.task2.service.impl.FindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseLiesOnXYSpecification implements Specification {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean specified(Pyramid pyramid) {
        boolean result = false;
        try {
            result = new FindServiceImpl().baseLiesOnXY(pyramid);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
        return result;
    }
}
