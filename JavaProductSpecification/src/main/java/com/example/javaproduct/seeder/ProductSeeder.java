package com.example.javaproduct.seeder;

import com.example.javaproduct.entity.Product;
import com.example.javaproduct.repository.ProductRepository;
import com.example.javaproduct.util.NumberHelper;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;
    private static final int NUMBER_OF_PRODUCT = 100;
    private static ArrayList<Product> products;

    public void generate() {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("black");
        colors.add("yellow");
        colors.add("white");
        ArrayList<String> size = new ArrayList<>();
        size.add("xl");
        size.add("xs");
        size.add("m");
        ArrayList<String> gender = new ArrayList<>();
        gender.add("male");
        gender.add("female");
        gender.add("orther");
        Random random = new Random();
        Faker faker = new Faker();
        products = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
            Product obj = Product.builder()
                    .name(faker.name().name())
                    .description(faker.name().title())
                    .gender(gender.get(NumberHelper.numberRandom(0, gender.size() - 1)))
                    .color(colors.get(NumberHelper.numberRandom(0, colors.size() - 1)))
                    .size(size.get(NumberHelper.numberRandom(0, size.size() - 1)))
                    .price(NumberHelper.numberRandom(10000, 100000))
                    .status(NumberHelper.numberRandom(0, 1))
                    .createAt(LocalDateTime.now().minusDays(NumberHelper.numberRandom(1, 30)))
                    .build();
            products.add(obj);
        }
        productRepository.saveAll(products);

    }


    @Override
    public void run(String... args) throws Exception {
        generate();
    }
}
