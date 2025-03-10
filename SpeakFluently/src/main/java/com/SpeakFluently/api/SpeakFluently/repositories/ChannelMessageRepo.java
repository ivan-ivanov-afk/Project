package com.SpeakFluently.api.SpeakFluently.repositories;

import com.SpeakFluently.api.SpeakFluently.entities.ChannelMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChannelMessageRepo extends JpaRepository<ChannelMessage, Integer> {
    List<ChannelMessage> findByReceiverChannelId(int channelId);
}