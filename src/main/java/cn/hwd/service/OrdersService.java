package cn.hwd.service;

import cn.hwd.domain.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll(int page,int size);

    Orders findById(int ordersId);
}
