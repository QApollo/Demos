package com.qualogy.cawa.dao;

import java.time.LocalDateTime;

public class ContentDTO {
  private int id;
  private String header;
  private int votes;
  private LocalDateTime date;
  private String secretCode;
  private String fileName;
  private String thumbnailName;


 public ContentDTO(int id, String header, int votes, LocalDateTime date, String secretCode, String fileName) {
    this.id = id;
    this.header = header;
    this.votes = votes;
    this.date = date;
    this.secretCode = secretCode;
    this.fileName = fileName;
    if(fileName != null) {
      this.thumbnailName = fileName +"_thumbnail";
    }
  }

  public int getId() {
    return id;
  }

  private void setId(int id) {
    this.id = id;
  }

  public String getHeader() {
    return header;
  }

  private void setHeader(String header) {
    this.header = header;
  }

  public int getVotes() {
    return votes;
  }

  private void setVotes(int votes) {
    this.votes = votes;
  }

  public LocalDateTime getDate() {
    return date;
  }

  private void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getSecretCode() {
    return secretCode;
  }

  private void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }

  public String getFileName() {
    return fileName;
  }

  private void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getThumbnailName() {
    return thumbnailName;
  }

  private void setThumbnailName(String thumbnailName) {
    this.thumbnailName = thumbnailName;
  }

}
