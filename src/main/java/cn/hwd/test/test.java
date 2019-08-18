package cn.hwd.test;

import cn.hwd.domain.Product;
import cn.hwd.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = ac.getBean("productService", ProductService.class);
        List<Product> list = productService.findAll();
        for (Product product :
                list) {
            System.out.println(product);
        }
    }
}
