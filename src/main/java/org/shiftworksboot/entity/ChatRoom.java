package org.shiftworksboot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "chatroom")
@Getter @Setter
@ToString
public class ChatRoom {

    @Id
    @Column(name = "room_id")
    private String roomId;

    @Column(name = "room_name")
    private String roomName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    private Chat lastchat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public static ChatRoom createChatRoom() {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        return chatRoom;
    }
}
