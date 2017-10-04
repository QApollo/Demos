package com.qualogy.CAWA.content.dao;

import com.qualogy.CAWA.dao.ContentDTO;
import com.qualogy.CAWA.dao.ContentDao;
import junit.framework.TestCase;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

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
