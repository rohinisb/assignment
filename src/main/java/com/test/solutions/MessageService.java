package com.test.solutions;

import com.test.solutions.beans.Message;

import java.util.List;

public interface MessageService {

    public Message sendMessage (String channelId, String senderId, String messageText);

    public List<Message> receiveMessage (String channelId);
}
