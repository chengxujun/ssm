package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
@Select("select * from traveller where id in(selec travellerId from order_traveller where ordersId = #{ordersId}) ")
  List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
