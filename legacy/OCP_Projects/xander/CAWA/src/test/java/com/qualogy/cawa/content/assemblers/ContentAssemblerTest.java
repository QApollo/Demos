package com.qualogy.cawa.content.assemblers;

import com.qualogy.cawa.assemblers.ContentAssembler;
import com.qualogy.cawa.dao.ContentDTO;
import com.qualogy.cawa.rest.Content;
import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContentAssemblerTest extends TestCase {
 private ContentAssembler testObject = new ContentAssembler();


  public void testContentListAssemble() {
    // Prepare
    List<ContentDTO> contentList = new ArrayList<>();
    List<Content> result;

    for(int i=0; i<5; i++ ) {
      contentList.add(new ContentDTO(i,"test",200, LocalDateTime.now(),"",""));
    }

    // Execute
    result = testObject.assemble(contentList);

    // Assert
    assertTrue(result.get(2).getId() == contentList.get(2).getId());
  }

  public void testContentAssemble() {
    //Prepare
    ContentDTO content = new ContentDTO(3,"test",200, LocalDateTime.now(),"","");
    Content result;

    //Execute
    result = testObject.assemble(content);

    //Assert
    assertTrue(result.getId() == content.getId());
  }
}
