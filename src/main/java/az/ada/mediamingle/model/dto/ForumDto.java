package az.ada.mediamingle.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ForumDto {
    private Integer id;
    private String title;
    private String body;
    private UserDto createdBy;
    private List<ReplyDto> replies;
}
