package az.ada.mediamingle.service;

import az.ada.mediamingle.model.dto.ForumDto;

public interface ForumService {
    public ForumDto createForum(ForumDto forumDto, Integer createdById);
    public ForumDto editForum(Integer forumId, ForumDto forumDto);

    public void deleteForum(Integer forumId);
}
