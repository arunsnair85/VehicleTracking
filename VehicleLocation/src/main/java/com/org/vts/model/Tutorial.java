package com.org.vts.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Tutorial.
 */
//@Table
public class Tutorial {
  
  /** The id. */
  //@PrimaryKey
  private UUID id;

  /** The title. */
  private String title;
  
  /** The description. */
  private String description;
  
  /** The published. */
  private boolean published;

  /**
   * Instantiates a new tutorial.
   */
  public Tutorial() {

  }

  /**
   * Instantiates a new tutorial.
   *
   * @param id the id
   * @param title the title
   * @param description the description
   * @param published the published
   */
  public Tutorial(UUID id, String title, String description, boolean published) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.published = published;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Gets the title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title.
   *
   * @param title the new title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Checks if is published.
   *
   * @return true, if is published
   */
  public boolean isPublished() {
    return published;
  }

  /**
   * Sets the published.
   *
   * @param isPublished the new published
   */
  public void setPublished(boolean isPublished) {
    this.published = isPublished;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
  }
}
