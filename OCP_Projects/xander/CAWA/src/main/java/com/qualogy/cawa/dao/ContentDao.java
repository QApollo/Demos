package com.qualogy.cawa.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContentDao {

  //TODO hookup an actual database and use non mock data
  private static List<ContentDTO> contentList = new ArrayList<>();
  static {
    for(int i = 1; i <= 5; i++) {
      contentList.add(buildContentDTO(i,"0"+i));
    }
  }

  public List<ContentDTO> getAllContent() {
    return contentList;
  }

  public ContentDTO getContentByID(int id) {
    for(ContentDTO content : contentList) {
      if(content.getId() == id){
       return content;
      }
    }
    return null;
  }

  private static ContentDTO buildContentDTO(int id, String fileName) {
    Random r = new Random();
    int randomVotes = r.nextInt(9999);
    return new ContentDTO(id,"Post "+id,50+randomVotes, LocalDateTime.now(),"secret", fileName);
  }
}

