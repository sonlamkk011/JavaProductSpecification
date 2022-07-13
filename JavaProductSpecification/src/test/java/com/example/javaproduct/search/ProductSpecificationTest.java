package com.example.javaproduct.search;

import com.example.javaproduct.JavaProductApplication;
import com.example.javaproduct.entity.Product;
import com.example.javaproduct.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaProductApplication.class)
class ProductSpecificationTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void demoTest(){
        ProductSpecification filter02 = new ProductSpecification(new SearchCriteria("name", " =", "Mr.jarrod Von"));
        ProductSpecification filter01 = new ProductSpecification(new SearchCriteria("price", ">=", 10000));
        ProductSpecification filter03 = new ProductSpecification(new SearchCriteria("price", "<=", 1100000));
        List<Product> order = productRepository.findAll(filter01.and(filter03));
        System.out.println(order.size());
    }
}