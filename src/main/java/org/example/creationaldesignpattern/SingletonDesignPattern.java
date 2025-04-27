package org.example.creationaldesignpattern;

import java.util.List;
import java.util.stream.IntStream;

public class SingletonDesignPattern {
    public static void main(String[] args) {
        List<ProductRepository> instances = IntStream.range(0, 10)
                .parallel()
                .mapToObj(i -> {
                    try {
                        return ProductRepository.getInstance(); //change here for different method calls
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        ProductRepository firstInstance = instances.get(0);

        boolean allMatch = instances.stream().allMatch(instance -> instance == firstInstance);

        System.out.println("All threads got the same instance: " + allMatch);
    }

}

class ProductRepository {
    //class instance field
    private static volatile ProductRepository productRepo; // volatile ensures visibility

    //private constructor. so that no client can directly instantiate.
    private ProductRepository() {}

    public static ProductRepository getInstance() throws InterruptedException {
        if (productRepo == null) { //first check to ensure instance has been not initialized yet
            synchronized (ProductRepository.class) { //locking
                Thread.sleep(100);
                if (productRepo == null) { //second check to insure double not any other thread creates the instance again.
                    productRepo = new ProductRepository();
                }
            }
        }
        return productRepo;
    }

    //another approach would be at method level locking, if possible.
    public static synchronized ProductRepository getProductRepo() throws InterruptedException {
        if (productRepo == null) { //second check to insure double not any other thread creates the instance again.
            Thread.sleep(100);
            productRepo = new ProductRepository();
        }
        return productRepo;
    }

    public static ProductRepository getInstanceInconsistency() throws InterruptedException {
        if (productRepo == null) {
            Thread.sleep(100);
            productRepo = new ProductRepository();
        }
        return productRepo;
    }
}
