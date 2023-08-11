package com.atcps.web;

import com.atcps.Entity.Hotel;
import com.atcps.service.HotelService;
import com.atcps.service.impl.HotelServiceImpl;
import com.atcps.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HotelServlet extends BaseServlet{
    private HotelService hotelService = new HotelServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hotel hotel =WebUtil.copyParamToBean(req.getParameterMap(),new Hotel());
        System.out.println("新酒店信息：" + hotel);
        hotelService.addHotel(hotel);
        resp.sendRedirect(req.getContextPath() + "/hotelServlet?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtil.parseInt(req.getParameter("id"),0);
        hotelService.deleteHotel(id);
        resp.sendRedirect(req.getContextPath() + "/hotelServlet?action=list");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改数据
        System.out.println(req.getParameterMap());
        Hotel hotel = WebUtil.copyParamToBean(req.getParameterMap(),new Hotel());
        System.out.println(hotel);
        hotelService.updateHotel(hotel);
        //重定向
        resp.sendRedirect(req.getContextPath() + "/hotelServlet?action=list" );

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hotel> hotels =hotelService.queryHotel();
        System.out.println(hotels);
        req.setAttribute("hotels" , hotels);
        req.getRequestDispatcher("/page/manager/hotel_list_manager.jsp").forward(req,resp);
    }

    protected void getHotel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1");
        int id = WebUtil.parseInt(req.getParameter("id"),0);//获得要修改的数据的id值
        System.out.println("id= " + id);
        Hotel Listhotel = hotelService.queryHotelById(id);//根据查找的数据id找到对应的值
        System.out.println("Listhotel= " + Listhotel);
        req.setAttribute("Listhotel" , Listhotel);
        req.getRequestDispatcher("/page/manager/hotel_list_manager_messageChange.jsp").forward(req,resp);
    }

}
