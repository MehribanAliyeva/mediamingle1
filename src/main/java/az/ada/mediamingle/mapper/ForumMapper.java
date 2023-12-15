package az.ada.mediamingle.mapper;

import az.ada.mediamingle.model.dto.ForumDto;
import az.ada.mediamingle.model.entity.Forum;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ForumMapper {
    ForumMapper INSTANCE = Mappers.getMapper(ForumMapper.class);

    ForumDto forumToForumDto(Forum forum);
    List<ForumDto> forumsToForumDtos(List<Forum> forums);
    Forum forumDtoToForum(ForumDto forumDto);
}
