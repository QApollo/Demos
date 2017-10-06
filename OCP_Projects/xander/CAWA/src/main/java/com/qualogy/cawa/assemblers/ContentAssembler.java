package com.qualogy.cawa.assemblers;

import com.qualogy.cawa.dao.ContentDTO;
import com.qualogy.cawa.rest.Content;

import java.util.ArrayList;
import java.util.List;

public class ContentAssembler {
  public List<Content> assemble(List<ContentDTO> input){
    List<Content> contentList = new ArrayList<>();

    for (ContentDTO contentDTO : input) {
      contentList.add(assemble(contentDTO));
    }

    return contentList;
  }

  public Content assemble(ContentDTO input){
    Content result  = new Content();

    result.setId(input.getId());
    result.setHeader(input.getHeader());

    // TODO How to format the date?
    result.setDate(input.getDate().toString());
    result.setVotes(input.getVotes());
    result.setFileName(input.getFileName());
    result.setThumbnailName(input.getThumbnailName());

    return result;
  }
}
