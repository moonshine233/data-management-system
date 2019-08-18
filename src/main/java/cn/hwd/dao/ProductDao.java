package cn.hwd.dao;

import cn.hwd.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductDao {

    @Select("select * from product where id=#{id}")
    public Product findById(Integer id);

    @Select("select * from product")
    public List<Product> findAll();

    @Insert("insert into product(productNum,productName,cityName,departureTime,productDesc,productStatus,productPrice) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productDesc},#{productStatus},#{productPrice})")
    void save(Product product);

}
