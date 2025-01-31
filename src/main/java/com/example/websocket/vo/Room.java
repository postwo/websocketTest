package com.example.websocket.vo;

public class Room { //방의 정보를 담아둘 Room객체를 생성

    int roomNumber;
    String roomName;

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", roomName=" + roomName + "]";
    }
}
