package cn.hwd.service.impl;

import cn.hwd.dao.OrdersDao;
import cn.hwd.domain.Orders;
import cn.hwd.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) {

        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(int ordersId) {
        Orders orders=ordersDao.findById(ordersId);
        return orders;
    }
}
