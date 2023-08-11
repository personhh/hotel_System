package com.atcps.service.impl;

import com.atcps.Dao.HotelDao;
import com.atcps.Dao.impl.HotelDaoImpl;
import com.atcps.Entity.Hotel;
import com.atcps.service.HotelService;

import java.util.List;

public class HotelServiceImpl implements HotelService {

    HotelDao hotelDao = new HotelDaoImpl();
    @Override
    public List<Hotel> queryHotel() {
        //让酒店全部罗列
        return hotelDao.queryHotel();
    }

   @Override
    public Hotel queryHotelById(int id ) {
        return hotelDao.queryHotelById(id);
    }

    @Override
    public int updateHotel(Hotel hotel) {
        return hotelDao.updateHotel(hotel);
    }

    @Override
    public int deleteHotel(int id) {
        return hotelDao.deleteHotel(id);
    }

    @Override
    public int addHotel(Hotel hotel) {
        return hotelDao.add(hotel);
    }
}
