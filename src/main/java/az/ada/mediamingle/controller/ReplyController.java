package az.ada.mediamingle.controller;

import az.ada.mediamingle.model.dto.ReplyDto;
import az.ada.mediamingle.service.impl.ReplyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
@CrossOrigin
public class ReplyController {
    private final ReplyServiceImpl replyService;

    @PostMapping("/create/{forumId}")
    public ResponseEntity<ReplyDto> createReply(@PathVariable Integer forumId, @RequestBody ReplyDto replyDto, @RequestParam Integer createdById) {
        ReplyDto createdReply = replyService.createReply(forumId, replyDto, createdById);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReply);
    }

    @PutMapping("/edit/{replyId}")
    public ResponseEntity<ReplyDto> editReply(@PathVariable Integer replyId, @RequestBody ReplyDto replyDto) {
        ReplyDto editedReply = replyService.editReply(replyId, replyDto);
        return ResponseEntity.ok(editedReply);
    }

    @DeleteMapping("/delete/{replyId}")
    public ResponseEntity<Void> deleteReply(@PathVariable Integer replyId) {
        replyService.deleteReply(replyId);
        return ResponseEntity.noContent().build();
    }
}