package az.ada.mediamingle.controller;

import az.ada.mediamingle.model.dto.ForumDto;
import az.ada.mediamingle.service.impl.ForumServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mediamingle/forums")
@RequiredArgsConstructor
@CrossOrigin
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
    @GetMapping
    public List<ForumDto> getAllForums(){
        return forumService.getAllForums();
    }
}