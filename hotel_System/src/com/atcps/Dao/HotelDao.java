package com.atcps.Dao;

import com.atcps.Entity.Hotel;

import java.util.List;


public interface HotelDao {
    public List<Hotel> queryHotel();
    public Hotel queryHotelById(int  id);
    public int updateHotel(Hotel hotel);
    public int deleteHotel(int id);
    public int add(Hotel hotel);
}
