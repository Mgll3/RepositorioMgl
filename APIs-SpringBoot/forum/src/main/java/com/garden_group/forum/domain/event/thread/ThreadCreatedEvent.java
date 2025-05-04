package com.garden_group.forum.domain.event.thread;

import java.time.LocalDateTime;
import java.util.UUID;
import com.garden_group.forum.domain.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ThreadCreatedEvent extends Event {
    private final UUID id;
    private final String title;
    private final String content;
    private final UUID authorId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final boolean isVisible;
}
