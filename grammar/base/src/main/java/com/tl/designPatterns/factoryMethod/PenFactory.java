package com.tl.designPatterns.factoryMethod;

import com.tl.designPatterns.factoryMethod.base.Factory;
import com.tl.designPatterns.factoryMethod.base.Product;

/**
 * Created by tianlei on 2018/9/13
 */
public class PenFactory extends Factory {

    @Override
    public Product create() {
        return new PenProduct();
    }

}
