package com.example.gunz.files;

import com.example.gunz.message.Message;
import com.example.gunz.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository  extends JpaRepository<Message, Long> {
    @Query(value = "Select * from message m where m.id = ?1",nativeQuery = true)
    public Message findMessageIdNumber(@Param("id") int id);
}
