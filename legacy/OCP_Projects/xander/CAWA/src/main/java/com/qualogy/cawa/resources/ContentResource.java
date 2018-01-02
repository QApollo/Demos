package com.qualogy.cawa.resources;

import com.qualogy.cawa.dao.ContentDTO;
import com.qualogy.cawa.dao.ContentDao;

import java.util.List;

public class ContentResource {
 private ContentDao contentDao = new ContentDao();

  public List<ContentDTO> getAllContent(){
    return contentDao.getAllContent();
  }

  public ContentDTO getContentByID(int id){
    return contentDao.getContentByID(id);
  }
}
