package cn.hwd.service;

import cn.hwd.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<Product> findAll();

    void save(Product product);
}
