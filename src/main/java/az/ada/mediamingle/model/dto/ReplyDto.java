package az.ada.mediamingle.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ReplyDto {
    private Integer id;
    private String body;
    private UserDto createdBy;
    private ForumDto forum;
}
