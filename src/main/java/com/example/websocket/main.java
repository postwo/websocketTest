package com.example.websocket;

import com.example.websocket.vo.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class main {


    List<Room> roomList = new ArrayList<Room>();
    static int roomNumber = 0;

    @GetMapping("/chat")
    public ModelAndView chat() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("thymeleaf/chat");
        return mv;
    }

    /*
     * 방 페이지
     * @return
     */
    @GetMapping("/room")
    public ModelAndView room() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("thymeleaf/room");
        return mv;
    }

    /*
     * 방 생성하기
     * @param params
     * @return
     */
    //방의 정보를 담아둘 List<Room>컬랙션을 생성
    @PostMapping("/createRoom")
    public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
        String roomName = (String) params.get("roomName");
        System.out.println(params);
        if(roomName != null && !roomName.trim().equals("")) {
            Room room = new Room();
            room.setRoomNumber(++roomNumber);
            room.setRoomName(roomName);
            roomList.add(room);
        }
        return roomList;
    }

    /*
     * 방 정보가져오기
     * @param params
     * @return
     */
    //방의 정보를 담아둘 List<Room>컬랙션을 생성
    @GetMapping("/getRoom")
    public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
        return roomList;
    }

    /*
     * 채팅방
     * @return
     */
    @GetMapping("/moveChating")
    public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
        ModelAndView mv = new ModelAndView();
        int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

        List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
        if(new_list != null && new_list.size() > 0) {
            mv.addObject("roomName", params.get("roomName"));
            mv.addObject("roomNumber", params.get("roomNumber"));
            mv.setViewName("thymeleaf/chat");
        }else {
            mv.setViewName("thymeleaf/room");
        }
        return mv;
    }
}



