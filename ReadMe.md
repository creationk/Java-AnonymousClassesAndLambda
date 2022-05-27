#### What kind of interfaces can be converted to lambda expressions?
- The interfaces that contain only one abstract method can be converted to lambda expressions
- Such interfaes are called functional interface. A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit.

#### How to convert a functional interface implementation to lambda?
- First, identify the single abstract method in the interface. This is the method that would have been implemented using an Impl class typically
- Once the method is identified, identify the arguments to that method
- Convert the method to an anonymous class first =>
  ````
  DisplayService d = new DisplayServiceImpl();
  ````
  can be rewritten in a single line as 
  ````
  DisplayService d = new DisplayService() {
    @Override
    void display (String msg) {
        log.info(msg);
    }
  };
- Once the anonymous call is created, one by one remove the keywords that are implicit to the context
    - ````new DisplayService()```` can be removed as it is obvious from the variable ````d```` declaration that it is a ````DisplayService````
    - The curly braces ``{}`` enclosing the display service impl body can be removed as we do not have any other content other than the ````display()```` method implementation to follow
    - ````@Override void display```` can be removed as the interface has only one method to implement
    - The simplified method now looks like below
      ````
      DisplayService d = (String msg) {
        log.info(msg);
      };
      ````
    - Next, remove the ````String```` data type in the argument as it is implicit from the interface
    - Now add a -> to separate argument from the implementation. The ````{}```` can be kept if the method body spans across multiple lines
      ````
      DisplayService d = (msg) -> {log.info(msg);};
      ````
      or simply
      ````
      DisplayService d = msg -> log.info(msg);
      ````
#### How to convert a lambda expression to anonymous class?
- From the given lamda expression, identify the interface, argument(s), and method implementation
  ````
    DisplayService d = msg -> log.info(msg);
  ````
- Add back one by one the new keyword, method name, enclose the arguments within ````()```` if not already so, and make sure that the class body and method body are both enclosed within ````{}````
  ````
  DisplayService d = new DisplayService() {
    @Override
    display(String msg) {
        log.info(msg);
    }
  };
  ````


