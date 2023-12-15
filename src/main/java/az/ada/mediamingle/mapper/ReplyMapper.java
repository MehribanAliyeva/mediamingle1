package az.ada.mediamingle.mapper;

import az.ada.mediamingle.model.dto.ReplyDto;
import az.ada.mediamingle.model.entity.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReplyMapper {
    ReplyMapper INSTANCE = Mappers.getMapper(ReplyMapper.class);

    ReplyDto replyToReplyDto(Reply reply);
    List<ReplyDto> repliesToReplyDtos(List<Reply> replies);
    Reply replyDtoToReply(ReplyDto replyDto);
}