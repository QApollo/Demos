package com.qualogy.cawa.rest;

import com.qualogy.cawa.assemblers.ContentAssembler;
import com.qualogy.cawa.resources.ContentResource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/content")
public class ContentEndpoint {
  private ContentResource contentResource = new ContentResource();
  private ContentAssembler contentAssembler = new ContentAssembler();

  @GET
  @Produces("application/json")
  public Response getAll() {
    List<Content> temp = contentAssembler.assemble(contentResource.getAllContent());
    return Response.ok(temp).build();
  }

  @GET
  @Produces("application/json")
  @Path("/{id}")
  public Response getContentByID(@PathParam("id") int id) {
    Content temp = contentAssembler.assemble(contentResource.getContentByID(id));
    return Response.ok(temp).build();
  }

  @GET
  @Produces("text/plain")
  @Path("/{id}/plain")
  public Response getContentByIDPlain(@PathParam("id") int id) {
    Content temp = contentAssembler.assemble(contentResource.getContentByID(id));
    return Response.ok(temp).build();
  }
}
