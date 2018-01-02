package com.qualogy.cawa.content.dao;

import com.qualogy.cawa.dao.ContentDTO;
import com.qualogy.cawa.dao.ContentDao;
import junit.framework.TestCase;

public class ContentDaoTest extends TestCase {
  private ContentDao testObject = new ContentDao();

  public void testGetContentByID() {
    //Prepare
    ContentDTO result;
    int id = 4;

    //Execute
    result = testObject.getContentByID(id);

    //Assert
    assertTrue(id == result.getId());
  }

}
