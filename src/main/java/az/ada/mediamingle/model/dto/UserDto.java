package az.musicapp.musicappdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    List<PlaylistDto> playlists;
    private Boolean isOnFreeTrial;
}
