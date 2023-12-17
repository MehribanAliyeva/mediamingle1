package az.ada.mediamingle.mapper;

import az.ada.mediamingle.model.dto.ForumDto;
import az.ada.mediamingle.model.dto.ReplyDto;
import az.ada.mediamingle.model.entity.Forum;
import az.ada.mediamingle.model.entity.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ForumMapper {
    private final UserMapper userMapper;

    public ForumDto forumToForumDto(Forum forum) {
        if (forum == null) {
            return null;
        }

        ForumDto forumDto = new ForumDto();
        forumDto.setId(forum.getId());
        forumDto.setTitle(forum.getTitle());
        forumDto.setBody(forum.getBody());
        forumDto.setCreatedBy(userMapper.userEntityToDto(forum.getCreatedBy()));
        List<ReplyDto> replyDtos = mapRepliesToReplyDtos(forum.getReplies());
        forumDto.setReplies(replyDtos);
        System.out.println(forumDto);
        return forumDto;
    }

    public List<ForumDto> forumsToForumDtos(List<Forum> forums) {
        return forums.stream()
                .map(this::forumToForumDto)
                .collect(Collectors.toList());
    }

    private List<ReplyDto> mapRepliesToReplyDtos(List<Reply> replies) {
        return replies != null? replies.stream()
                .map(reply -> new ReplyDto(reply.getId(),
                        reply.getBody(),
                        userMapper.userEntityToDto(reply.getCreatedBy()),
                        forumToForumDto(reply.getForum())))
                .collect(Collectors.toList()):Collections.emptyList();
    }

    public Forum forumDtoToForum(ForumDto forumDto) {
        if (forumDto == null) {
            return null;
        }

        Forum forum = new Forum();
        forum.setId(forumDto.getId());
        forum.setTitle(forumDto.getTitle());
        forum.setBody(forumDto.getBody());
        forum.setCreatedBy(userMapper.userDtoToEntity(forumDto.getCreatedBy()));
        List<Reply> replies = mapReplyDtosToReplies(forumDto.getReplies());
        forum.setReplies(replies);

        return forum;
    }

    private List<Reply> mapReplyDtosToReplies(List<ReplyDto> replyDtos) {
        return replyDtos != null
                ? replyDtos.stream()
                .map(replyDto -> new Reply(replyDto.getId(),
                        userMapper.userDtoToEntity(replyDto.getCreatedBy()),
                        replyDto.getBody(),
                        forumDtoToForum(replyDto.getForum())))
                .collect(Collectors.toList())
                : Collections.emptyList();
    }
}