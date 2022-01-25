package com.test.solutions;

import com.test.solutions.beans.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageServiceImpl implements MessageService {

    @Override
    public Message sendMessage(String channelId, String senderId, String messageText) {
        Message incomingMessage = new Message(senderId, messageText);
        StorageService.addMessage(channelId, incomingMessage);
        return incomingMessage;
    }

    @Override
    public List<Message> receiveMessage(String channelId) {
        return StorageService.getMessageByChannelId(channelId);
    }
}
