package az.ada.mediamingle.controller;

import az.ada.mediamingle.model.dto.ForumDto;
import az.ada.mediamingle.service.impl.ForumServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forums")
@RequiredArgsConstructor
public class ForumController {
    private final ForumServiceImpl forumService;

    @PostMapping("/create")
    public ResponseEntity<ForumDto> createForum(@RequestBody ForumDto forumDto, @RequestParam Integer createdById) {
        ForumDto createdForum = forumService.createForum(forumDto, createdById);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdForum);
    }

    @PutMapping("/edit/{forumId}")
    public ResponseEntity<ForumDto> editForum(@PathVariable Integer forumId, @RequestBody ForumDto forumDto) {
        ForumDto editedForum = forumService.editForum(forumId, forumDto);
        return ResponseEntity.ok(editedForum);
    }

    @DeleteMapping("/delete/{forumId}")
    public ResponseEntity<Void> deleteForum(@PathVariable Integer forumId) {
        forumService.deleteForum(forumId);
        return ResponseEntity.noContent().build();
    }
}