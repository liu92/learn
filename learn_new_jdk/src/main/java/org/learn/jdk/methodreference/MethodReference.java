package org.learn.jdk.methodreference;

import java.util.ArrayList;

/**
 * 方法引用是为了进一步简化lambda表达式，通过类名或者实例名与方法名的组合来直接访问到类或者实例已经存在的方法或者构造方法。
 * 方法引用使用**::来定义，::**的前半部分表示类名或者实例名，后半部分表示方法名，如果是构造方法就使用NEW来表示。
 *
 *
 * @ClassName: MethodReference
 * @Description: 方法引用
 * @Author: lin
 * @Date: 2019/8/4 0:18
 * History:
 * @<version> 1.0
 */
public class MethodReference {
    /**
     * 静态方法引用：ClassName::methodName;
       实例上的实例方法引用：instanceName::methodName;
       超类上的实例方法引用：supper::methodName;
       类的实例方法引用：ClassName:methodName;
       构造方法引用Class:new;
       数组构造方法引用::TypeName[]::new
     */

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // Car::new 表示 调用默认的构造方法
            Car car = Car.create(Car::new);
            cars.add(car);
        }
        cars.forEach(Car::showCar);
    }


    @FunctionalInterface
    interface Factory<T> {
        T create();
    }


    static class Car {
        public void showCar() {
            System.out.println(this.toString());
        }

        public static Car create(Factory<Car> factory) {
            return factory.create();
        }


        public  Car(){}
        public  Car(int a){}
    }


}
