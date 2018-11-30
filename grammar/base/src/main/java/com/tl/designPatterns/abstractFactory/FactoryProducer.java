package com.tl.designPatterns.abstractFactory;

import com.tl.designPatterns.abstractFactory.base.AbstractFactory;

/**
 * Created by tianlei on 2018/9/13
 */
public class FactoryProducer {

    public static String CAR = "car";
    public static String BIKE = "bike";


    public static AbstractFactory getFactory(String type) {
        try {

            String className = "";
            if (type.equals(CAR)) {
                return new BMCarFactory();
            } else if (type.equals(BIKE)){
                return new ForeverBikeFactory();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {

        FactoryProducer.getFactory(CAR).createCar().show();
        FactoryProducer.getFactory(BIKE).createBike().show();

    }
}
