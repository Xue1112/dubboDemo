package com.itheima.spi.jdk;

import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description
 * @author: ts
 * @create:2021-05-26 14:29
 */
public class JavaSpiTest {

    @Test
    public void testSayHello() {
        //创建一个 ServiceLoader对象，
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        //serviceLoader.forEach(Robot::sayHello);


        //获取服务下的所有实例信息集合
        Iterator<Robot> iterator = serviceLoader.iterator();

        /**
         * 循环创建所有服务实例并执行对应方法
         */
        while (iterator.hasNext()) {
            /**
             * 获取一个服务实例
             */
            Robot robot = iterator.next();
            //调用实例方法
            robot.sayHello();
        }
        // serviceLoader.forEach(Robot::sayHello);
    }
}
