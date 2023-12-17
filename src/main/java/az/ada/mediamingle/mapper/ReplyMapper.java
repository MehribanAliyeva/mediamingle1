package az.ada.mediamingle.mapper;

import az.ada.mediamingle.model.dto.ReplyDto;
import az.ada.mediamingle.model.entity.Reply;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReplyMapper {

    public ReplyDto replyToReplyDto(Reply reply) {
        if (reply == null) {
            return null;
        }

        ReplyDto replyDto = new ReplyDto();
        replyDto.setBody(reply.getBody());
        return replyDto;
    }

    public List<ReplyDto> repliesToReplyDtos(List<Reply> replies) {
        return replies.stream()
                .map(this::replyToReplyDto)
                .collect(Collectors.toList());
    }
    public Reply replyDtoToReply(ReplyDto replyDto) {
        if (replyDto == null) {
            return null;
        }

        Reply reply = new Reply();
        reply.setBody(replyDto.getBody());
        return reply;
    }
}