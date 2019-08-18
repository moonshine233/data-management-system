package cn.hwd.dao;

import cn.hwd.domain.Member;
import cn.hwd.domain.Orders;
import cn.hwd.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.hwd.dao.ProductDao.findById"))
    })
    public List<Orders> findAll();


    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.hwd.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "cn.hwd.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.hwd.dao.TravellerDao.findByOrdersId"))
    })
    public Orders findById(int ordersId);
}
