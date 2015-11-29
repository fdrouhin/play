package models ;

// https://www.playframework.com/documentation/2.5.x/JavaEbean pour la doc sur ebean modification de fichiers de conf
import java.util.*;
import java.util.Date ;

import javax.persistence.*;
import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

import play.data.validation.Constraints.* ;

/**
 * A book
 */
@Entity
public class Book extends Model {
   
   /**
    * Finder to get books
    */
    public static Finder<Long, Book> find = new Finder<Long,Book>(Book.class);
   
   /**
    * ID
    */
    @Id
    public Long id ;
   
    /**
     * Title of book
     */
    @Required
    public String title ;
    
    /**
     * Author
     */
    @Required
    public String author ;
    
    /**
     * TODO Jacket
     */

     /**
      * Date
      */
    private Date parutionDate ;
    
    /** 
     * Summary of book
     */ 
    public String summary ;
    
    /**
     * Favorite ?
     */
    public boolean favorite ;
    
}