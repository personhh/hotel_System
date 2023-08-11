package com.atcps.web;

import com.atcps.Entity.Hotel;
import com.atcps.service.HotelService;
import com.atcps.service.impl.HotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClientHotelServlet extends BaseServlet{
    //前台类
    private HotelService hotelService = new HotelServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入前台");
        List<Hotel> hotels = hotelService.queryHotel();
        req.setAttribute("hotels" , hotels);
        req.getRequestDispatcher("/page/client/index.jsp").forward(req,resp);
    }
}
