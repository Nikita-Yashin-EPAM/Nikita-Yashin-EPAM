package com.fast.solution;

import com.fast.solution.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class SolutionApplicationTests {
    ProductController mockito = Mockito.mock(ProductController.class);

    @Test
    void contextLoads() {
    }
    @Test
    public void mockProduct(){
        when(mockito.findAll()).thenReturn("products");
        System.out.println(mockito.findAll());
    }

}
