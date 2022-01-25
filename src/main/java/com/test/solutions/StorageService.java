package com.test.solutions;

import com.test.solutions.beans.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageService {

    public static Map<String, List<Message>> messageAudit = new HashMap<>();

    public static void addMessage(String channelId, Message message) {
        messageAudit.putIfAbsent(channelId, new ArrayList<>());
        messageAudit.get(channelId).add(message);
    }

    public static List<Message> getMessageByChannelId(String channelId) {
        return messageAudit.get(channelId);
    }
}
