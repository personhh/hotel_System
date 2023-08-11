package com.atcps.service;

import com.atcps.Entity.Hotel;

import java.util.List;

public interface HotelService {

    public List<Hotel> queryHotel();

    public Hotel queryHotelById(int id );

    public int updateHotel(Hotel hotel);

    public int deleteHotel(int id);

    public int addHotel(Hotel hotel);
}
