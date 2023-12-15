package az.ada.mediamingle.service.impl;

import az.ada.mediamingle.mapper.ForumMapper;
import az.ada.mediamingle.mapper.ReplyMapper;
import az.ada.mediamingle.mapper.UserMapper;
import az.ada.mediamingle.model.dto.ReplyDto;
import az.ada.mediamingle.model.entity.Forum;
import az.ada.mediamingle.model.entity.Reply;
import az.ada.mediamingle.model.entity.User;
import az.ada.mediamingle.repo.ForumRepository;
import az.ada.mediamingle.repo.ReplyRepository;
import az.ada.mediamingle.repo.UserRepository;
import az.ada.mediamingle.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ForumRepository forumRepository;
    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;
    private final ForumMapper forumMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public ReplyDto createReply(Integer forumId, ReplyDto replyDto, Integer createdById) {
        Optional<Forum> forum = forumRepository.findById(forumId);
        Reply reply = replyMapper.replyDtoToReply(replyDto);
        Optional<User> user = userRepository.findById(createdById);
        if(forum.isPresent()&& user.isPresent()){
            reply.setCreatedBy(user.get());
            replyRepository.save(reply);
            forum.get().getReplies().add(reply);
            forumRepository.save(forum.get());
        }else{
            throw new IllegalStateException("Issue creating a reply");
        }
        return replyDto;
    }

    @Override
    public ReplyDto editReply(Integer replyId, ReplyDto replyDto) {
        Optional<Reply> existingReply = replyRepository.findById(replyId);
        if(existingReply.isPresent()){
            BeanUtils.copyProperties(replyDto,existingReply);
            replyRepository.save(existingReply.get());
        }else{
            throw new IllegalStateException(String.format("Reply with id %d does not exist", replyId));
        }
        return replyDto;
    }

    @Override
    public void deleteReply(Integer replyId) {
       replyRepository.deleteById(replyId);
    }
}
