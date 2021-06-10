package com.park.controller.api;

import com.alibaba.fastjson.JSON;
import com.park.pojo.Rent;
import com.park.service.RentService;
import com.park.util.MyTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class RentApi {
    @Autowired
    RentService rentService;


    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllRent",method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    public String getAllRent(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/upload/";
        List<Rent> rents = rentService.findAllRent();
        for (Rent rent:rents) {
            rent.setPark_img(basePath+rent.getPark_img());
        }
        String result = JSON.toJSONString(rents);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getRentById", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public String getRentById(@Param("id") Integer id,HttpServletRequest request){
        Rent rent = rentService.findRentById(id);
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/upload/";
        rent.setPark_img(basePath+rent.getPark_img());
        String result = JSON.toJSONString(rent);
        System.out.println(result);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/getRentByUid", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String getRentByUid(@Param("uid") String uid,HttpServletRequest request){
        List<Rent> rents = rentService.findRentByUid(uid);
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/upload/";
        for (Rent rent:rents) {
            rent.setPark_img(basePath+rent.getPark_img());
        }
        String result = JSON.toJSONString(rents);
        System.out.println(result);
        return result;
    }


    /*
        接受微信小程序发过来的图片，进行保存
    */
    @RequestMapping(value = "/uploadWxImg", method = RequestMethod.POST)
    public @ResponseBody Object uploadWxImg(@RequestParam("img") MultipartFile file, HttpServletRequest request)
            throws IllegalStateException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String name = file.getOriginalFilename();
        String imgAbsolutePath = MyTool.SaveImg(file, MyTool.getImg(), name);
        map.put("code", 0);
        map.put("message", "上传成功");
        map.put("data", name);
        System.out.println(map.toString());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/insertRent", method = RequestMethod.POST)
    public String insertRent(@RequestBody Map map){
        System.out.println("reparjson:"+map.toString());
        List<String> Pics = (List<String>) map.get("imageUrl");
        /*for (int i=0;i<Pics.size();i++){
            String imgName = Pics.get(i).substring(11);
            map.put("pic"+i,imgName);
        }*/
        Object object = Pics.get(0);
        String pictureUrl = "";
        if (null != object) {
            pictureUrl = pictureUrl.substring(pictureUrl.lastIndexOf("/")+1);
        }
        map.put("park_img",pictureUrl);
        map.remove("imageUrl");
        System.out.println(map.toString());
        int n = rentService.insertRent(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }


}
