package az.ada.mediamingle.service;

import az.ada.mediamingle.model.dto.ReplyDto;


public interface ReplyService {
   public ReplyDto createReply(Integer forumId, ReplyDto replyDto,Integer createdById);
   public ReplyDto editReply(Integer replyId, ReplyDto replyDto);
   public void deleteReply(Integer replyId);
}
