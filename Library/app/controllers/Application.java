package controllers;

import java.util.List ;

import play.*;
import play.mvc.*;
import play.data.* ;

import views.html.*;

import models.Book ;

public class Application extends Controller {

    /**
     * Index
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    /**
     * Create a book
     */
    public Result create() {
        return ok(create.render(Form.form(Book.class))) ;
    }
    
    /**
     * Save the book created
     */
    public Result save() {
        Form<Book> bookForm = Form.form(Book.class).bindFromRequest();
        
        if (bookForm.hasErrors()) {
            return Results.badRequest(create.render(bookForm));
        }
        
        Book b = bookForm.get() ;
        b.save() ;
        
        return ok(save.render(b)) ;
    }
    
    /**
     * Liste de livres
     */
    public Result all() {
        List<Book> liste = Book.find.all() ;
        
        return ok(all.render(liste)) ;
    }
    
    public Result delete(Long id) {
        Book.find.ref(id).delete();
        return redirect(routes.Application.all()) ;
    }
    
    public Result show(Long id) {
        Book b = Book.find.byId(id);
        return ok(show.render(b)) ;
    }
    
}
