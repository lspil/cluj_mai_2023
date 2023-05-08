package repositories;

import aspects.MyCustomAnnotation;

public class ProductRepository {

  @MyCustomAnnotation // @PreAuthorize
  public void sayHello() {
    System.out.println("HELLO!");
    this.sayCiao();
  }

  @MyCustomAnnotation  // @PreAuthorize
  public void sayCiao() {
    System.out.println("CIAO!");
  }
}
