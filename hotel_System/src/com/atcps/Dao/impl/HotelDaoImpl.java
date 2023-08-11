package com.atcps.Dao.impl;

import com.atcps.Dao.HotelDao;
import com.atcps.Entity.Hotel;

import java.util.List;

public class HotelDaoImpl extends BaseDao implements HotelDao {

    @Override
    public List<Hotel> queryHotel() {
        String sql = "select id ,hotel_name , hotel_price , hotel_location , hotel_photo from hotel_hotel";
        return queryforList(Hotel.class ,sql);
    }

    @Override
    public Hotel queryHotelById(int id) {
        String sql = "select id,hotel_name,hotel_price,hotel_location from hotel_hotel where id = ?";
        return queryForOne(Hotel.class , sql,id);
    }

    @Override
    public int updateHotel(Hotel hotel) {
        String sql = "update hotel_hotel set hotel_name=? , hotel_price=? , hotel_location=? ,hotel_photo=? where id = ?";
        return update(sql, hotel.getHotel_name() ,hotel.getHotel_price() ,hotel.getHotel_location(),hotel.getHotel_photo(),hotel.getId());
    }

    public int deleteHotel(int id ){
        String sql = "delete from hotel_hotel where id =?";
        return update(sql,id);
    }

    @Override
    public int add(Hotel hotel) {
        String sql = "insert into hotel_hotel(hotel_name,hotel_price,hotel_location,hotel_photo) values(?,?,?,?)";
        return update(sql,hotel.getHotel_name(),hotel.getHotel_price(),hotel.getHotel_location(),hotel.getHotel_photo());
    }
}
