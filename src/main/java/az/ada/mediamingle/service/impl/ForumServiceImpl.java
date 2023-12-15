package az.ada.mediamingle.service.impl;

import az.ada.mediamingle.mapper.ForumMapper;
import az.ada.mediamingle.model.dto.ForumDto;
import az.ada.mediamingle.model.entity.Forum;
import az.ada.mediamingle.model.entity.User;
import az.ada.mediamingle.repo.ForumRepository;
import az.ada.mediamingle.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ForumService {
    private final ForumRepository forumRepository;
    private final UserRepository userRepository;
    private final ForumMapper forumMapper;

    public ForumDto createForum(ForumDto forumDto, Integer createdById){
      Forum forum = forumMapper.forumDtoToForum(forumDto);
      Optional<User> createdBy = userRepository.findById(createdById);
      createdBy.ifPresent(forum::setCreatedBy);
      return forumDto;
    }
    public ForumDto editForum(Integer forumId, ForumDto forumDto){
        Optional<Forum> existingForum = forumRepository.findById(forumId);
        if(existingForum.isPresent()){
            BeanUtils.copyProperties(forumDto, existingForum);
        }
        return forumDto;
    }
}
