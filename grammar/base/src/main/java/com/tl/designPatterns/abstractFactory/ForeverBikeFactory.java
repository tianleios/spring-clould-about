package com.tl.designPatterns.abstractFactory;

import com.tl.designPatterns.abstractFactory.base.AbstractBike;
import com.tl.designPatterns.abstractFactory.base.AbstractCar;
import com.tl.designPatterns.abstractFactory.base.AbstractFactory;

/**
 * Created by tianlei on 2018/9/13
 */
public class ForeverBikeFactory extends AbstractFactory {

    @Override
    public AbstractCar createCar() {
        return null;
    }

    @Override
    public AbstractBike createBike() {
        return new ForeverBike();
    }
}
